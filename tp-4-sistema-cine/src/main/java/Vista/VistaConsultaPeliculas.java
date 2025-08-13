package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import Controller.PeliculasController;
import Modelo.Pelicula;
import Modelo.TipoGenero;

public class VistaConsultaPeliculas extends JFrame {

    private final JComboBox<TipoGenero> cboGenero = new JComboBox<>(TipoGenero.values());
    private final JButton btnBuscar = new JButton("Buscar");
    private final JTable tabla = new JTable();

    public VistaConsultaPeliculas() {
        super("Películas por género");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5,5));

        JPanel norte = new JPanel();
        norte.add(new JLabel("Género:"));
        norte.add(cboGenero);
        norte.add(btnBuscar);
        add(norte, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> cargarTabla());
        setVisible(true);
    }

    private void cargarTabla() {
        TipoGenero genero = (TipoGenero) cboGenero.getSelectedItem();
        List<Pelicula> lista = PeliculasController.getInstance().getPeliculasPorGenero(genero);

        DefaultTableModel m = new DefaultTableModel(
                new String[] { "Título", "Duración (min)", "Director" }, 0);

        for (Pelicula p : lista)
            m.addRow(new Object[] { p.getNombrePelicula(), p.getDuracionEnMinutos(), p.getDirector() });

        tabla.setModel(m);
    }

    public static void mostrarVentana() { new VistaConsultaPeliculas(); }
}