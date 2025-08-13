package Modelo;
import java.util.*;

/**
 *
 */
public class Funcion {

    private Pelicula pelicula;
    private int funcionID;
    private String horario;
    private Date fecha;
    private List<Entrada> entradas;
    private Sala sala;

    /**
     * Default constructor
     */
    public Funcion(Date fecha, int funcionID, String horario, List<Entrada> entradas, Sala sala, Pelicula pelicula) {

        this.funcionID = funcionID;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.horario = horario;
        this.sala = sala;
        this.entradas = entradas;



    }

    public Pelicula getPelicula()
    {
        return pelicula;
    }




    public List<Entrada> getEntradas() {
        return entradas;
    }

    /**
     * @return
     */
    public int getSalaID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getPeliculaID() {
        // TODO implement here
        if(Objects.nonNull(getPelicula()))
        {
            return getPelicula().getPeliculaID();
        }
        return 0;
    }

    /**
     *
     */
    public int getCantidadAsientosDisponibles() {

        return 0;
        // TODO implement here
    }

    /**
     * @return
     */
    public int getFuncionID() {

        return this.funcionID;
    }

    /**
     *
     */
    public Date getFecha() {
        return fecha;
        // TODO implement here
    }

    public float calcularMontoPorEntradaDeLaPelicula(){
        float total = 0.0f;
        for (Entrada entrada:getEntradas())
        {
            total = total+ (entrada.getPrecio() -
                    (entrada.getPrecio()*pelicula.getCondicionesDescuento().getDescuento()));
        }
        return total;
    }

    public String getHorario()
    {
        return horario;
    }

}