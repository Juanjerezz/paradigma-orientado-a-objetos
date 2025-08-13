package Vista;

import javax.swing.*;
import java.awt.*;
import Modelo.TipoGenero;
import Controller.PeliculasController;

public class VistaRegistroPelicula extends JFrame {

    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtDuracion;
    private JTextField txtDirector;
    private JComboBox<TipoGenero> cboGenero;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    private final PeliculasController controller = PeliculasController.getInstance();

    public VistaRegistroPelicula() {
        setTitle("Registrar Película");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Duración (min):"));
        txtDuracion = new JTextField();
        add(txtDuracion);

        add(new JLabel("Director:"));
        txtDirector = new JTextField();
        add(txtDirector);

        add(new JLabel("Género:"));
        cboGenero = new JComboBox<>(TipoGenero.values());
        add(cboGenero);

        btnRegistrar = new JButton("Registrar");
        add(btnRegistrar);
        btnRegistrar.addActionListener(e -> registrarPelicula());

        btnCancelar = new JButton("Cancelar");
        add(btnCancelar);
        btnCancelar.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void registrarPelicula() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String titulo = txtTitulo.getText().trim();
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            String director = txtDirector.getText().trim();
            TipoGenero genero = (TipoGenero) cboGenero.getSelectedItem();

            if (titulo.isEmpty() || director.isEmpty())
                throw new IllegalArgumentException("Título y director no pueden estar vacíos.");

            controller.registrarPelicula(id, titulo, genero, duracion, director);

            JOptionPane.showMessageDialog(this, "Película registrada con éxito.");
            limpiar();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID y duración deben ser numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void limpiar() {
        txtId.setText("");
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtDirector.setText("");
        cboGenero.setSelectedIndex(0);
    }

    public static void mostrarVentana() {
        new VistaRegistroPelicula();
    }
}