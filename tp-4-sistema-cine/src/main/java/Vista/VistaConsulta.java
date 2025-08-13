package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modelo.TipoGenero;

public class VistaConsulta extends JFrame
{
    private JLabel l1;
    private JPanel panel;
    private JComboBox<TipoGenero> generos;
    private JButton ejecutar,salir,registrar;

    public VistaConsulta()
    {
        super("Funciones por genero");
        panel = new JPanel();
        l1 = new JLabel("Seleccione un género");
        generos = new JComboBox<>(TipoGenero.values());
        ejecutar = new JButton("Consultar");
        salir = new JButton("Salir");
        registrar = new JButton("Registrar");
        this.add(panel);
        this.setSize(300, 300);
        panel.add(l1);panel.add(generos);panel.add(ejecutar);panel.add(registrar);panel.add(salir);

        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                dispose();
            }

        });

        generos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if(generos.getSelectedIndex() == -1)
                {
                    ejecutar.setEnabled(false);
                }
                else
                {
                    ejecutar.setEnabled(true);
                }
            }

        });
        ejecutar.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                dispose();
                pasarAVistaListado((TipoGenero) generos.getSelectedItem());
            }

        });

        registrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                new VistaRegistro();
                dispose();

            }

        });

        setVisible(true);
    }

    protected void pasarAVistaListado(TipoGenero selectedItem)
    {
        // TODO Auto-generated method stub
        VistaListado.mostrarVentana(selectedItem);
    }

    public static void mostrarVentana()
    {
        VistaConsulta v = new VistaConsulta();
        v.setVisible(true);
        v.setResizable(false);
        v.setLocationRelativeTo(null);
    }
}
