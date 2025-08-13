package Controller;

import Controller.FuncionController;
import Controller.PeliculasController;
import Controller.VentasController;
import Modelo.Funcion;
import Modelo.TipoGenero;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {

    PeliculasController peliculasController;
    FuncionController funcionController;
    VentasController ventasController;

    @BeforeEach
    void setUp() {
        peliculasController = PeliculasController.getInstance();
        funcionController = FuncionController.getInstance();
        ventasController = VentasController.getInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void altaPeliculaYFuncionTest() {
        peliculasController.registrarPelicula(102, "Avatar", TipoGenero.Terror, 150, "James Cameron");
        assertNotNull(peliculasController.getByTitulo("Avatar"));

        funcionController.RegistrarFuncion(
                999,
                "Avatar",
                new Date(),
                "22:00",
                5
        );

        boolean encontrada = funcionController.getFunciones().stream()
                .anyMatch(f -> f.getPelicula().getNombrePelicula().equals("Avatar"));

        assertTrue(encontrada, "La función con la película 'Avatar' debería existir.");
    }

    @Test
    void otraPeliculaYFuncionTest() {
        peliculasController.registrarPelicula(103, "Interestelar", TipoGenero.Drama, 169, "Christopher Nolan");
        assertNotNull(peliculasController.getByTitulo("Interestelar"));

        funcionController.RegistrarFuncion(
                998,
                "Interestelar",
                new Date(),
                "21:30",
                7
        );

        boolean encontrada = funcionController.getFunciones().stream()
                .anyMatch(f -> f.getPelicula().getNombrePelicula().equals("Interestelar"));

        assertTrue(encontrada, "La función con la película 'Interestelar' debería existir.");
    }
}