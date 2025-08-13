package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

import Controller.VentasController;
import Modelo.Pelicula;

public class VistaReporteRecaudacion extends JFrame {

    public VistaReporteRecaudacion() {
        super("Películas – Mayor recaudación");
        setSize(500, 350);
        setLocationRelativeTo(null);

        DefaultTableModel m = new DefaultTableModel(
                new String[] { "Puesto", "Título", "Recaudación" }, 0);

        int puesto = 1;
        for (Map.Entry<Pelicula, Float> e :
                VentasController.getInstance().topPeliculasPorRecaudacion(10)) {
            m.addRow(new Object[]{puesto++, e.getKey().getNombrePelicula(), e.getValue()});
        }

        add(new JScrollPane(new JTable(m)), BorderLayout.CENTER);
        setVisible(true);
    }

    public static void mostrarVentana() { new VistaReporteRecaudacion(); }
}