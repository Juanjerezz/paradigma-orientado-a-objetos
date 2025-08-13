package Controller;
import java.util.*;

import Modelo.Sucursal;


/**
 *
 */
public class SucursalController {

    /**
     * Default constructor
     */

    private List<Sucursal> sucursal;
    // singleton
    private static SucursalController instance;

    private SucursalController()
    {
        sucursal = new ArrayList<Sucursal>();
        sucursal.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }
    public static SucursalController getInstance()
    {
        if(instance == null)
            instance = new SucursalController();
        return instance;
    }

    /**
     * @param id
     * @param denom
     * @param dir
     */
    public void agregarSucursal(int id, String denom, String dir) {
        // TODO implement here
    }

    /**
     * @param idSucursal
     * @param salaID
     * @param denom
     * @param nroasientos
     */
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos)
    {
        // TODO implement here
    }

}