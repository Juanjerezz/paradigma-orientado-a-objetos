package dto;

public class ConsumoDto {
    private String mes;
    private String año;
    private String nombreEstablecimiento;
    private String monto;
    private String numeroTarjeta;

    public ConsumoDto(String mes, String año, String nombreEstablecimiento, String monto, String numeroTarjeta) {
        this.mes = mes;
        this.año = año;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.monto = monto;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
