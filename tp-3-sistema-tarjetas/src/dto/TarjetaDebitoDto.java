package dto;

public class TarjetaDebitoDto {
    private String nombreCliente;
    private String dniCliente;
    private String numeroTarjeta;
    private float porcentajeIVA;

    public TarjetaDebitoDto(String nombreCliente, String dniCliente, String numeroTarjeta, float porcentajeIVA) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.porcentajeIVA = porcentajeIVA;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public float getPorcentajeIVA() {
        return porcentajeIVA;
    }
}