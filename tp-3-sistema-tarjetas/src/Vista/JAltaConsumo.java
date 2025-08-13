package Vista;

import Controller.TarjetasController;
import dto.ConsumoDto;

import javax.swing.*;
import java.awt.*;


public class JAltaConsumo extends JFrame {

    private JTextField nombreEstablecimientoField, mesField, añoField, montoField, numeroTarjetaField;
    private TarjetasController tarjetasController;

    public JAltaConsumo() {
        setTitle("Formulario de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2)); // 5 campos + 2 botones

        add(new JLabel("MES:"));
        mesField = new JTextField();
        add(mesField);

        add(new JLabel("AÑO:"));
        añoField = new JTextField();
        add(añoField);

        add(new JLabel("MONTO:"));
        montoField = new JTextField();
        add(montoField);

        add(new JLabel("NOMBRE DE ESTABLECIMIENTO:"));
        nombreEstablecimientoField = new JTextField();
        add(nombreEstablecimientoField);

        add(new JLabel("Número de tarjeta:"));
        numeroTarjetaField = new JTextField();
        add(numeroTarjetaField);

        // Botones
        JButton enviarBtn = new JButton("Guardar");
        JButton cancelarBtn = new JButton("Cancelar");

        add(enviarBtn);
        add(cancelarBtn);

        enviarBtn.addActionListener(e -> validarFormulario());

        cancelarBtn.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void validarFormulario() {
        String mesTexto = mesField.getText().trim();
        if (mesTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo MES no puede estar vacío.");
            return;
        }
        try {
            Integer.parseInt(mesTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "¡Error! El mes debe ser un número (por ejemplo, 1 para enero).");
            return;
        }

        if (añoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo AÑO no puede estar vacío.");
            return;
        }

        if (montoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo MONTO no puede estar vacío.");
            return;
        }

        if (nombreEstablecimientoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo NOMBRE DE ESTABLECIMIENTO no puede estar vacío.");
            return;
        }
        // una vez t.odo verificado, se crea el dto
        ConsumoDto dto = new ConsumoDto(
                mesField.getText(),
                añoField.getText(),
                nombreEstablecimientoField.getText(),
                montoField.getText(),
                numeroTarjetaField.getText()
        );
        tarjetasController = TarjetasController.getInstance(); // se obtiene la instancia
        int respuesta = tarjetasController.crearConsumo(dto); // se le pasa el dto a la funcion para que la procese
        if (respuesta == -1) {
            JOptionPane.showMessageDialog(this,
                    "No se ha podido encontrar la tarjeta para crear el consumo.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Formulario enviado correctamente.");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JAltaConsumo::new);
    }
}

