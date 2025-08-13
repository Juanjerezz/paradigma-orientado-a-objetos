package dto;

public class TarjetaCreditoDto {
    private String nombreCliente;
    private String dniCliente;
    private String numeroTarjeta;
    private float porcentajeInteres;

    public TarjetaCreditoDto(String nombreCliente, String dniCliente, String numeroTarjeta, float porcentajeInteres) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.porcentajeInteres = porcentajeInteres;
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

    public float getPorcentajeInteres() {
        return porcentajeInteres;
    }
}
