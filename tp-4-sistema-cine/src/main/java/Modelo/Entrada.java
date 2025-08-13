package Modelo;
import java.util.*;

/**
 *
 */
public class Entrada {

    private float precio;

    private int nroAsiento;

    public Funcion funcion;

    /**
     * Default constructor
     */
    public Entrada(int nroAsiento, Funcion funcion, float precio) {
        this.funcion = funcion;
        this.nroAsiento = nroAsiento;
        this.precio = precio;
    }


    public float getPrecio() {
        return precio;
    }




    public int getFuncionID() {
        // TODO implement here
        return 0;
    }

    /**
     *
     */
    public void getPeliculaID() {
        // TODO implement here
    }

}