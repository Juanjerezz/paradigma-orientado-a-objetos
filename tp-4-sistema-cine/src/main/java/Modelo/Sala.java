package Modelo;
import java.util.*;

/**
 *
 */
public class Sala
{

    private int salaID;
    private String denominacion;
    private int asientos;

    /**
     * Default constructor
     */
    public Sala(int salaID, String denominacion, int asientos) {
        this.asientos = asientos;
        this.denominacion = denominacion;
        this.salaID = salaID;
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
    public int getSalaID() {
        // TODO implement here
        return salaID;
    }

    /**
     * @return
     */
    public int getAsientos() {
        return this.asientos;
    }

}