package Modelos;

import java.util.ArrayList;

public abstract class Tarjeta {
    private Cliente cliente;
    private ArrayList<Consumo> consumos;
    private String numeroTarjeta;

    public void agregarConsumo(Consumo c) {
        if (consumos == null) {
            consumos = new ArrayList<>();
        }
        consumos.add(c);
    }
    // En Tarjeta.java
    public abstract float calcularConsumoReal(int mes, int año);

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(ArrayList<Consumo> consumos) {
        this.consumos = consumos;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
