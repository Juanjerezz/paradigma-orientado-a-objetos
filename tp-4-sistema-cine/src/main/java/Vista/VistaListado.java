package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Dto.VentaDto;
import Controller.VentasController;
import Modelo.TipoGenero;

public class VistaListado extends JFrame {
    private JTable tabla;
    private JButton volver, salir;

    public VistaListado(TipoGenero tipo) {
        super("Funciones por género");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Crear el modelo de tabla
        String[] columnas = {"Funcion ID", "Horario", "Película"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Obtener ventas
        List<VentaDto> ventas = VentasController.getInstance().funcionesVendidasPorGenero(tipo);
        for (VentaDto venta : ventas) {
            modelo.addRow(new Object[]{
                    venta.getFuncion().getFuncionID(),
                    venta.getFuncion().getHorario(),
                    venta.getFuncion().getNombrePelicula()
            });
        }

        // Crear tabla y scroll
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();
        volver = new JButton("Volver");
        salir = new JButton("Salir");
        panelBotones.add(volver);
        panelBotones.add(salir);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VistaConsulta.mostrarVentana();
            }
        });

        // Acción salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void mostrarVentana(TipoGenero tipo) {
        VistaListado v = new VistaListado(tipo);
        v.setResizable(false);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
}




