import Vista.JAltaTarjetaDebito;
import Vista.JAltaTarjetaCredito;
import Vista.JAltaConsumo;
import Vista.JCalcularConsumoReal;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Sistema de Gestión de Tarjetas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 120);
        setLayout(new FlowLayout());

        JButton debitoBtn = new JButton("Alta Tarjeta Débito");
        JButton creditoBtn = new JButton("Alta Tarjeta Crédito");
        JButton consumoBtn = new JButton("Alta Consumo");
        JButton calcularBtn = new JButton("Calcular Consumo Real");
        JButton salirBtn = new JButton("Salir");

        debitoBtn.addActionListener(e -> new JAltaTarjetaDebito());
        creditoBtn.addActionListener(e -> new JAltaTarjetaCredito());
        consumoBtn.addActionListener(e -> new JAltaConsumo());
        calcularBtn.addActionListener(e -> new JCalcularConsumoReal());
        salirBtn.addActionListener(e -> System.exit(0));

        add(debitoBtn);
        add(creditoBtn);
        add(consumoBtn);
        add(calcularBtn);
        add(salirBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}