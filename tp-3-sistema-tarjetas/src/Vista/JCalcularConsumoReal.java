package Vista;

import Controller.TarjetasController;

import javax.swing.*;
import java.awt.*;

public class JCalcularConsumoReal extends JFrame {

    private JTextField numeroTarjetaField, mesField, anioField;
    private TarjetasController controller;

    public JCalcularConsumoReal() {
        setTitle("Calcular Consumo Real");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Número de tarjeta:"));
        numeroTarjetaField = new JTextField();
        add(numeroTarjetaField);

        add(new JLabel("Mes:"));
        mesField = new JTextField();
        add(mesField);

        add(new JLabel("Año:"));
        anioField = new JTextField();
        add(anioField);

        JButton calcularBtn = new JButton("Calcular");
        JButton cancelarBtn = new JButton("Cancelar");

        add(calcularBtn);
        add(cancelarBtn);

        controller = TarjetasController.getInstance();

        calcularBtn.addActionListener(e -> calcular());
        cancelarBtn.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void calcular() {
        if (numeroTarjetaField.getText().trim().isEmpty() ||
                mesField.getText().trim().isEmpty() ||
                anioField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
            return;
        }

        try {
            int mes = Integer.parseInt(mesField.getText().trim());
            int anio = Integer.parseInt(anioField.getText().trim());
            String numeroTarjeta = numeroTarjetaField.getText().trim();

            float resultado = controller.calcularConsumoReal(mes, anio, numeroTarjeta);

            if (resultado == -1) {
                JOptionPane.showMessageDialog(this, "Tarjeta no encontrada.");
            } else {
                JOptionPane.showMessageDialog(this, "Consumo real: $" + resultado);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mes y año deben ser números enteros válidos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JCalcularConsumoReal::new);
    }
}