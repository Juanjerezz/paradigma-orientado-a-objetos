package Modelo;
import java.util.*;

/**
 *
 */
public class Venta
{

    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    private Funcion funcion;
    private TarjetaDescuento tarjetaDescuento;

    /**
     * Default constructor
     */
    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion) {
        this.combos = combos;
        this.funcion = funcion;
        this.fchVenta = fchVenta;
        this.ventaID = ventaID;
    }



    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }



    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    public void setTarjetaDescuento(TarjetaDescuento tarj)
    {
        this.tarjetaDescuento = tarj;
    }


    /**
     * @return
     */
    public int getFuncionID() {
        // TODO implement here
        return funcion.getFuncionID();
    }

    /**
     * @return
     */
    public float getTotal() {
        // TODO implement here
        return 0.0f;
    }

    /**
     *
     */
    public int getPeliculaID() {
        // TODO implement here
        return funcion.getPeliculaID();
    }

    /**
     * @return
     */
    public TipoTarjeta getTipoTarjeta() {
        // TODO implement here
        return tarjetaDescuento.getTipoTarjeta();
    }

    /**
     *
     */
    public List<Combo> getCombos() {
        return combos != null ? combos : new ArrayList<>();
    }

    public int getVentaID()
    {
        return ventaID;
    }

    public float calcularMontoPorComboDeVenta() {
        float total = 0.0f;
        for (Combo combo : getCombos()) {
            float descuento = CondicionesDescuento.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta());
            total += combo.getPrecio() - (combo.getPrecio() * descuento);
        }
        return total;
    }


    public float calcularMontoDeLaVentaPorFuncionCombos()
    {
        return funcion.calcularMontoPorEntradaDeLaPelicula()+calcularMontoPorComboDeVenta();
    }


}