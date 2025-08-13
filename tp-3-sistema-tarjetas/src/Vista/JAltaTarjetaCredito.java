package Vista;

import Controller.TarjetasController;
import dto.TarjetaCreditoDto;

import javax.swing.*;
import java.awt.*;

public class JAltaTarjetaCredito extends JFrame {

    private JTextField nombreClienteField, dniClienteField, numeroField, porcentajeInteresField;
    private TarjetasController controller;

    public JAltaTarjetaCredito() {
        setTitle("Alta Tarjeta Crédito");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre del cliente:"));
        nombreClienteField = new JTextField();
        add(nombreClienteField);

        add(new JLabel("DNI del cliente:"));
        dniClienteField = new JTextField();
        add(dniClienteField);

        add(new JLabel("Número de tarjeta:"));
        numeroField = new JTextField();
        add(numeroField);

        add(new JLabel("Porcentaje de interés (%):"));
        porcentajeInteresField = new JTextField();
        add(porcentajeInteresField);

        JButton guardarBtn = new JButton("Guardar");
        JButton cancelarBtn = new JButton("Cancelar");

        add(guardarBtn);
        add(cancelarBtn);

        guardarBtn.addActionListener(e -> guardarTarjeta());
        cancelarBtn.addActionListener(e -> dispose());

        controller = TarjetasController.getInstance();

        setVisible(true);
    }

    private void guardarTarjeta() {
        if (nombreClienteField.getText().trim().isEmpty() ||
                dniClienteField.getText().trim().isEmpty() ||
                numeroField.getText().trim().isEmpty() ||
                porcentajeInteresField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
            return;
        }

        float porcentajeInteres;
        try {
            porcentajeInteres = Float.parseFloat(porcentajeInteresField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El porcentaje de interés debe ser un número válido.");
            return;
        }

        TarjetaCreditoDto dto = new TarjetaCreditoDto(
                nombreClienteField.getText().trim(),
                dniClienteField.getText().trim(),
                numeroField.getText().trim(),
                porcentajeInteres
        );

        int respuesta = controller.darAltaTarjetaCredito(dto);
        if (respuesta == -1) {
            JOptionPane.showMessageDialog(this, "Error: el cliente no existe.");
        } else {
            JOptionPane.showMessageDialog(this, "Tarjeta de crédito creada correctamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JAltaTarjetaCredito::new);
    }
}