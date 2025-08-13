package Controller;

import java.util.*;
import java.util.stream.Collectors;

import Modelo.*;

public class PeliculasController {

    private final List<Pelicula> peliculas = new ArrayList<>();
    private static PeliculasController instance;

    private PeliculasController() {
        // demo
        peliculas.add(
                new Pelicula(
                        TipoGenero.Suspenso,              // género
                        "El Resplandor",                  // título
                        146,                              // duración
                        "Stanley Kubrick",                // director
                        TipoProyeccion.DosD,
                        new ArrayList<>(),                // reparto
                        null));                           // descuento
    }

    public static PeliculasController getInstance() {
        if (instance == null) instance = new PeliculasController();
        return instance;
    }
    public void registrarPelicula(int id, String titulo, TipoGenero genero, int duracion, String director) {
        boolean existe = peliculas.stream()
                .anyMatch(p -> p.getNombrePelicula().equalsIgnoreCase(titulo));
        if (existe) throw new IllegalArgumentException("Ya existe una película con ese título.");

        Pelicula p = new Pelicula(
                genero, director, duracion,
                titulo, TipoProyeccion.DosD,
                new ArrayList<>(), null);

        peliculas.add(p);
    }

    public List<Pelicula> getPeliculasPorGenero(TipoGenero genero) {
        return peliculas.stream()
                .filter(p -> p.getGeneroID() == genero)
                .collect(Collectors.toList());
    }

    public Pelicula getByTitulo(String titulo) {
        return peliculas.stream()
                .filter(p -> p.getNombrePelicula().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}