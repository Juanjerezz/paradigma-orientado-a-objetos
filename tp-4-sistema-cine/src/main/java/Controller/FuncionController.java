package Controller;

import java.util.*;

import Modelo.Entrada;
import Modelo.Funcion;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.TipoGenero;
import Modelo.TipoProyeccion;

import Dto.*;

/**
 *
 */
public class FuncionController {

    private List<Funcion> funciones;

    private static FuncionController instancia;
    /**
     * constructor
     */
    private FuncionController() {
        funciones = new ArrayList<Funcion>();
        cargaDeDatos();
    }

    // singleton controller

    public static FuncionController getInstance()
    {
        if(instancia == null)
            instancia = new FuncionController();
        return instancia;
    }

    /**
     *
     */
    private void cargaDeDatos()
    {
        // TODO implement here
        Funcion funcion1 = new Funcion(new Date(), 1, "11:00", new ArrayList<>(), new Sala(0, null, 0),
                new Pelicula(TipoGenero.Terror, "Steven Spielberg", 120, "Tiburón", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion1);

        // Ejemplo 2: Romance, 3D
        Funcion funcion2 = new Funcion(new Date(), 2, "13:30", new ArrayList<>(), new Sala(1, null, 0),
                new Pelicula(TipoGenero.Romance, "Baz Luhrmann", 143, "Moulin Rouge!", TipoProyeccion.TresD, new ArrayList<>(), null));
        funciones.add(funcion2);

        // Ejemplo 3: Drama, 3DMax
        Funcion funcion3 = new Funcion(new Date(), 3, "16:00", new ArrayList<>(), new Sala(2, null, 0),
                new Pelicula(TipoGenero.Drama, "Martin Scorsese", 179, "El Lobo de Wall Street", TipoProyeccion.TresDMax, new ArrayList<>(), null));
        funciones.add(funcion3);

        // Ejemplo 4: Biográfica, 4D
        Funcion funcion4 = new Funcion(new Date(), 4, "18:45", new ArrayList<>(), new Sala(3, null, 0),
                new Pelicula(TipoGenero.Biografica, "James Marsh", 123, "La Teoría del Todo", TipoProyeccion.CuatroD, new ArrayList<>(), null));
        funciones.add(funcion4);

        // Ejemplo 5: Suspenso, 2D
        Funcion funcion5 = new Funcion(new Date(), 5, "21:15", new ArrayList<>(), new Sala(4, null, 0),
                new Pelicula(TipoGenero.Suspenso, "Alfred Hitchcock", 118, "Psicosis", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion5);

        // Ejemplo 6: Drama, 3D
        Funcion funcion6 = new Funcion(new Date(), 6, "12:45", new ArrayList<>(), new Sala(5, null, 0),
                new Pelicula(TipoGenero.Drama, "Francis Ford Coppola", 175, "El Padrino", TipoProyeccion.TresD, new ArrayList<>(), null));
        funciones.add(funcion6);

        // Ejemplo 7: Romance, 2D
        Funcion funcion7 = new Funcion(new Date(), 7, "15:15", new ArrayList<>(), new Sala(6, null, 0),
                new Pelicula(TipoGenero.Romance, "Joe Wright", 127, "Orgullo y Prejuicio", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion7);

        // Ejemplo 8: Terror, 3DMax
        Funcion funcion8 = new Funcion(new Date(), 8, "17:30", new ArrayList<>(), new Sala(7, null, 0),
                new Pelicula(TipoGenero.Terror, "John Carpenter", 91, "Halloween", TipoProyeccion.TresDMax, new ArrayList<>(), null));
        funciones.add(funcion8);

        // Ejemplo 9: Biográfica, 4D
        Funcion funcion9 = new Funcion(new Date(), 9, "20:00", new ArrayList<>(), new Sala(8, null, 0),
                new Pelicula(TipoGenero.Biografica, "Milos Forman", 159, "Amadeus", TipoProyeccion.CuatroD, new ArrayList<>(), null));
        funciones.add(funcion9);

        // Ejemplo 10: Suspenso, 3D
        Funcion funcion10 = new Funcion(new Date(), 10, "22:30", new ArrayList<>(), new Sala(9, null, 0),
                new Pelicula(TipoGenero.Suspenso, "David Fincher", 158, "Seven", TipoProyeccion.TresD, new ArrayList<>(), null));
        funciones.add(funcion10);

        // Ejemplo 11: Drama, 2D
        Funcion funcion11 = new Funcion(new Date(), 11, "10:30", new ArrayList<>(), new Sala(10, null, 0),
                new Pelicula(TipoGenero.Drama, "Frank Darabont", 142, "Sueños de Libertad", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion11);

        // Ejemplo 12: Romance, 3DMax
        Funcion funcion12 = new Funcion(new Date(), 12, "13:00", new ArrayList<>(), new Sala(11, null, 0),
                new Pelicula(TipoGenero.Romance, "James Cameron", 194, "Titanic", TipoProyeccion.TresDMax, new ArrayList<>(), null));
        funciones.add(funcion12);

        // Ejemplo 13: Terror, 4D
        Funcion funcion13 = new Funcion(new Date(), 13, "15:45", new ArrayList<>(), new Sala(12, null, 0),
                new Pelicula(TipoGenero.Terror, "William Friedkin", 122, "El Exorcista", TipoProyeccion.CuatroD, new ArrayList<>(), null));
        funciones.add(funcion13);

        // Ejemplo 14: Biográfica, 2D
        Funcion funcion14 = new Funcion(new Date(), 14, "18:15", new ArrayList<>(), new Sala(13, null, 0),
                new Pelicula(TipoGenero.Biografica, "Oliver Stone", 189, "JFK", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion14);

        // Ejemplo 15: Suspenso, 3D
        Funcion funcion15 = new Funcion(new Date(), 15, "21:00", new ArrayList<>(), new Sala(14, null, 0),
                new Pelicula(TipoGenero.Suspenso, "Jonathan Demme", 118, "El Silencio de los Inocentes", TipoProyeccion.TresD, new ArrayList<>(), null));
        funciones.add(funcion15);

        // Ejemplo 16: Drama, 3DMax
        Funcion funcion16 = new Funcion(new Date(), 16, "14:30", new ArrayList<>(), new Sala(15, null, 0),
                new Pelicula(TipoGenero.Drama, "Quentin Tarantino", 154, "Pulp Fiction", TipoProyeccion.TresDMax, new ArrayList<>(), null));
        funciones.add(funcion16);

        // Ejemplo 17: Romance, 4D
        Funcion funcion17 = new Funcion(new Date(), 17, "17:00", new ArrayList<>(), new Sala(16, null, 0),
                new Pelicula(TipoGenero.Romance, "Rob Reiner", 111, "Cuando Harry Conoció a Sally", TipoProyeccion.CuatroD, new ArrayList<>(), null));
        funciones.add(funcion17);

        // Ejemplo 18: Terror, 2D
        Funcion funcion18 = new Funcion(new Date(), 18, "19:30", new ArrayList<>(), new Sala(17, null, 0),
                new Pelicula(TipoGenero.Terror, "Stanley Kubrick", 116, "El Resplandor", TipoProyeccion.DosD, new ArrayList<>(), null));
        funciones.add(funcion18);

        // Ejemplo 19: Biográfica, 3D
        Funcion funcion19 = new Funcion(new Date(), 19, "22:15", new ArrayList<>(), new Sala(18, null, 0),
                new Pelicula(TipoGenero.Biografica, "Clint Eastwood", 137, "Million Dollar Baby", TipoProyeccion.TresD, new ArrayList<>(), null));
        funciones.add(funcion19);

        // Ejemplo 20: Suspenso, 3DMax
        Funcion funcion20 = new Funcion(new Date(), 20, "11:45", new ArrayList<>(), new Sala(19, null, 0),
                new Pelicula(TipoGenero.Suspenso, "Christopher Nolan", 148, "Memento", TipoProyeccion.TresDMax, new ArrayList<>(), null));
        funciones.add(funcion20);
    }

    /**
     * @param funcionID
     * @return
     */
    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
        int asientos = -1;
        return asientos;
    }

    /**
     * @param fchFuncion
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int peliculaMasVista() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int diaDeLaSemanaConMenorVentas() {
        // TODO implement here
        return 0;
    }

    public List<Funcion> buscarPeliculaPorFuncion(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaID() == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }

    public List<Funcion> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<Funcion> resultado = new ArrayList<>();
        for (Funcion f : funciones)
            if (f.getPelicula().getGeneroID() == genero)
                resultado.add(f);
        return resultado;
    }

    public Funcion getFuncionById(int funcionID)
    {
        for(Funcion f : funciones)
        {
            if(f.getFuncionID() == funcionID)
                return f;
        }
        return null;
    }
    public List<Funcion> getFunciones() {
        return funciones;
    }
    public void RegistrarFuncion(int funcionID, Pelicula pelicula, Date fecha, String horario, Sala sala, List<Entrada> entradas) {
        Funcion funcion = new Funcion(fecha, funcionID, horario, entradas, sala, pelicula);
        funciones.add(funcion);
    }
    public void RegistrarFuncion(int funcionID,
                                 String tituloPelicula,
                                 Date fecha,
                                 String horario,
                                 int nroSala) {

        Pelicula peli = PeliculasController.getInstance().getByTitulo(tituloPelicula);
        if (peli == null)
            throw new IllegalArgumentException("Primero cargá la película \"" + tituloPelicula + "\".");

        Sala sala = new Sala(nroSala, null, 0);
        Funcion nueva = new Funcion(fecha, funcionID, horario,
                new ArrayList<>(), sala, peli);
        funciones.add(nueva);
    }
}