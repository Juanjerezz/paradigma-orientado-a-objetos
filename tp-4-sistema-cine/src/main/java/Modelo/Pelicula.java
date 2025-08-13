package Modelo;
import java.util.*;

/**
 *
 */
public class Pelicula
{
    private TipoGenero generoID;
    private String nombrePelicula;
    private int peliculaID;
    private static int idIncrmental = 0;
    private int duracionEnMinutos;
    private String director;
    private List<String> actores;
    private TipoProyeccion tipo;
    private CondicionesDescuento condicionesDescuento;

    /**
     * Default constructor
     */
    public Pelicula(TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {

        this.actores = actores;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;
        this.condicionesDescuento = descuento;
        idIncrmental++;
        this.peliculaID = idIncrmental;

    }

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public void setGeneroID(TipoGenero generoID) {
        this.generoID = generoID;
    }



    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public int getPeliculaID() {
        // TODO implement here
        return peliculaID;
    }
    public String getNombrePelicula()
    {
        return nombrePelicula;
    }

    @Override
    public String toString() {
        return nombrePelicula + " (" + director + ")";
    }

}