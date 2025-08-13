package Controller;
import java.util.*;
import java.util.stream.*;

import Modelo.*;

import Dto.*;


/**
 *
 */
public class VentasController {

    private List<Venta> ventas;
    // controlador singleton
    private static VentasController instance;

    private FuncionController funcionController;
    /**
     * constructor
     */

    private VentasController()
    {
        ventas = new ArrayList<Venta>();
        funcionController = FuncionController.getInstance();
        cargaDeDatos();
    }
    // singleton getInstance
    public static VentasController getInstance()
    {
        if(instance == null)
            instance = new VentasController();
        return instance;
    }



    /**
     * @param funcionID
     * @return
     */
    public float recaudacionPorFuncion(int funcionID) {
        // TODO implement here
        return 0.0f;
    }


    public List<Venta> getVentas()
    {
        return ventas;
    }

    public void setVentas(List<Venta> ventas)
    {
        this.ventas = ventas;
    }
    /**
     * Caso de secuencia a desarrollar
     * @param peliculaID
     * @return
     */
    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones)
        {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(Objects.nonNull(venta))
            {
                totalrecuadado=+venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
        return totalrecuadado;
    }

    /**
     * @param tipoTarjeta
     * @return
     */
    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    /**
     *
     */
    public Combo comboMasVendido() {
        // TODO implement here
        return null;
    }

    private Venta buscarVentaPorFuncion(Funcion funcion){
        for (Venta venta:getVentas()) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    /**
     * View a desarrollar
     *
     * @param genero
     * @return
     */
    public List<VentaDto> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDto> ventaDtos = new ArrayList<>();
        List<Funcion> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if(funciones.isEmpty()){
            return ventaDtos;
        }
        for (Funcion funcion:funciones)
        {
            if(funcion.getPelicula().getGeneroID().equals(genero))
            {
                Venta venta = buscarVentaPorFuncion(funcion);
                if(Objects.nonNull(venta))
                {
                    ventaDtos.add(modelVentaToDto(venta));
                }
            }
        }
        return ventaDtos;
    }

    public VentaDto modelVentaToDto(Venta venta)
    {
        return new VentaDto(modelFuncionToDto(venta.getFuncion()),venta.getVentaID());
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion)
    {
        return new FuncionDTO(funcion);
    }

    public Funcion getFuncionById(int funcionID)
    {
        Funcion buscada = funcionController.getFuncionById(funcionID);
        return buscada;
    }

    public List<Map.Entry<Pelicula, Float>> topPeliculasPorRecaudacion(int topN) {
        Map<Pelicula, Float> acumulado = new HashMap<>();

        for (Venta v : ventas) {
            Pelicula p = v.getFuncion().getPelicula();
            float monto = v.calcularMontoDeLaVentaPorFuncionCombos();
            acumulado.merge(p, monto, Float::sum);
        }

        return acumulado.entrySet()
                .stream()
                .sorted(Map.Entry.<Pelicula, Float>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    private void cargaDeDatos()
    {
        Venta venta1 = new Venta(1, new Date(), null, getFuncionById(1)); // ID 1 (Tiburón)
        ventas.add(venta1);
        Venta venta2 = new Venta(2, new Date(), null, getFuncionById(8)); // ID 8 (Halloween)
        ventas.add(venta2);
        Venta venta3 = new Venta(3, new Date(), null, getFuncionById(13)); // ID 13 (El Exorcista)
        ventas.add(venta3);
        Venta venta4 = new Venta(4, new Date(), null, getFuncionById(18)); // ID 18 (El Resplandor)
        ventas.add(venta4);
        Venta venta5 = new Venta(5, new Date(), null, getFuncionById(20)); // ID 20 (Memento)
        ventas.add(venta5);
        Venta venta6 = new Venta(6, new Date(), null, getFuncionById(3)); // ID 3 (El Lobo de Wall Street)
        ventas.add(venta6);
        Venta venta7 = new Venta(7, new Date(), null, getFuncionById(6)); // ID 6 (El Padrino)
        ventas.add(venta7);
        Venta venta8 = new Venta(8, new Date(), null, getFuncionById(11)); // ID 11 (Sueños de Libertad)
        ventas.add(venta8);
        Venta venta9 = new Venta(9, new Date(), null, getFuncionById(16)); // ID 16 (Pulp Fiction)
        ventas.add(venta9);
        Venta venta10 = new Venta(10, new Date(), null, getFuncionById(19)); // ID 19 (Million Dollar Baby)
        ventas.add(venta10);
    }


}