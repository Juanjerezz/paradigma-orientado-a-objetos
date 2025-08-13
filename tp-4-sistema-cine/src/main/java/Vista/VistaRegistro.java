package Vista;

import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Funcion;
import Modelo.Entrada;
import Controller.FuncionController;
import Controller.PeliculasController;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VistaRegistro extends JFrame {
    private JTextField ID;
    private JComboBox<Pelicula> comboPeliculas;
    private JTextField fecha;
    private JTextField horario;
    private JTextField sala;
    private JButton btnAgregarFuncion;
    private JButton btnFinalizar;

    private static FuncionController controlador = FuncionController.getInstance();

    public VistaRegistro() {
        setTitle("Registro de Función");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("ID:"));
        ID = new JTextField();
        add(ID);

        add(new JLabel("Película:"));
        comboPeliculas = new JComboBox<>(PeliculasController.getInstance().getPeliculas().toArray(new Pelicula[0]));
        add(comboPeliculas);

        add(new JLabel("Fecha (dd/MM/yyyy):"));
        fecha = new JTextField();
        add(fecha);

        add(new JLabel("Hora:"));
        horario = new JTextField();
        add(horario);

        add(new JLabel("Sala:"));
        sala = new JTextField();
        add(sala);

        btnAgregarFuncion = new JButton("Agregar Función");
        add(btnAgregarFuncion);
        btnAgregarFuncion.addActionListener(e -> validarFormulario());

        btnFinalizar = new JButton("Finalizar");
        add(btnFinalizar);
        btnFinalizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Carga finalizada");
            dispose();
        });

        setVisible(true);
    }

    private void validarFormulario() {
        if (ID.getText().trim().isEmpty()
                || fecha.getText().trim().isEmpty()
                || horario.getText().trim().isEmpty()
                || sala.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        try {
            int funcionID = Integer.parseInt(ID.getText().trim());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaFuncion = formatoFecha.parse(fecha.getText().trim());
            int numeroSala = Integer.parseInt(sala.getText().trim());

            Pelicula peliSeleccionada = (Pelicula) comboPeliculas.getSelectedItem();

            controlador.RegistrarFuncion(funcionID, peliSeleccionada, fechaFuncion, horario.getText(),
                    new Sala(numeroSala, null, 0), new ArrayList<>()); // entradas vacías por ahora

            JOptionPane.showMessageDialog(this, "Función agregada con éxito");
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID y Sala deben ser números válidos");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha debe tener el formato dd/MM/yyyy");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar función: " + ex.getMessage());
        }
    }

    private void limpiar() {
        ID.setText("");
        fecha.setText("");
        horario.setText("");
        sala.setText("");
        comboPeliculas.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaRegistro::new);
    }
}