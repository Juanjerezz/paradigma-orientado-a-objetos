package Modelos;

public class TarjetaCredito extends Tarjeta {
    private float porcentajeInteres;

    public TarjetaCredito(String numeroTarjeta, Cliente cliente, float porcentajeInteres) {
        setNumeroTarjeta(numeroTarjeta);
        setCliente(cliente);
        this.porcentajeInteres = porcentajeInteres;
    }

    public float calcularConsumoReal(int mes, int año) {
        float total = 0f;

        for (Consumo c : getConsumos()) {
            if (c.getMes() == mes && c.getAño() == año) {
                total += c.getMonto();
            }
        }

        // Se aplica interés al total
        return total * (1 + porcentajeInteres / 100f);
    }

    public float getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(float porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }
}