package Modelo;
import java.util.*;

/**
 *
 */
public class Sucursal
{

    private int sucursalID;
    private String denominacion;
    private String direccion;
    private List<Sala> salas;

    /**
     * Default constructor
     */
    public Sucursal(int sucursalID, String denominacion, String direccion, ArrayList<Sala> sala) {
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.sucursalID = sucursalID;
        this.salas = sala;
    }



    /**
     * @return
     */
    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

}