package Modelos;

public class Consumo {
    private int mes;
    private int año;
    private String nombreEstablecimiento;
    private float monto;
    private String numeroTarjeta;

    public Consumo(int mes, int año, String nombreEstablecimiento, float monto, String numeroTarjeta) {
        this.mes = mes;
        this.año = año;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.monto = monto;
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
