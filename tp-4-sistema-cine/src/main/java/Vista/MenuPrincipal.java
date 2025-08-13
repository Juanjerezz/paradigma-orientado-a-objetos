package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        super("Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton btnRegFuncion  = new JButton("Registrar función");
        JButton btnRegPelicula = new JButton("Registrar película");
        JButton btnConsulta    = new JButton("Consultar películas por género");
        JButton btnReporte     = new JButton("Reporte: top recaudación");

        panel.add(btnRegFuncion);
        panel.add(btnRegPelicula);
        panel.add(btnConsulta);
        panel.add(btnReporte);

        add(panel);


        btnRegFuncion.addActionListener(e -> new VistaRegistro());
        btnRegPelicula.addActionListener(e -> VistaRegistroPelicula.mostrarVentana());
        btnConsulta.addActionListener(e -> VistaConsultaPeliculas.mostrarVentana());
        btnReporte.addActionListener(e -> VistaReporteRecaudacion.mostrarVentana());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::new);
    }
}