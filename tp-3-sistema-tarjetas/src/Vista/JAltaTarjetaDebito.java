package Vista;

import Controller.TarjetasController;
import dto.TarjetaDebitoDto;

import javax.swing.*;
import java.awt.*;

public class JAltaTarjetaDebito extends JFrame {

    private JTextField nombreClienteField, dniClienteField, numeroField, porcentajeIVAField;
    private TarjetasController controller;

    public JAltaTarjetaDebito() {
        setTitle("Alta Tarjeta Débito");
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

        add(new JLabel("Porcentaje IVA:"));
        porcentajeIVAField = new JTextField();
        add(porcentajeIVAField);

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
                porcentajeIVAField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
            return;
        }

        float porcentajeIVA;
        try {
            porcentajeIVA = Float.parseFloat(porcentajeIVAField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Porcentaje IVA debe ser un número válido.");
            return;
        }

        TarjetaDebitoDto dto = new TarjetaDebitoDto(
                nombreClienteField.getText().trim(),
                dniClienteField.getText().trim(),
                numeroField.getText().trim(),
                porcentajeIVA
        );

        int respuesta = controller.darAltaTarjetaDebito(dto);
        if (respuesta == -1) {
            JOptionPane.showMessageDialog(this, "Error: el cliente no existe.");
        } else {
            JOptionPane.showMessageDialog(this, "Tarjeta de débito creada correctamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JAltaTarjetaDebito::new);
    }
}