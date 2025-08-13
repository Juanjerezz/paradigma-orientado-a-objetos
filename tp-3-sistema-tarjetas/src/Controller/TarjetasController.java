package Controller;

import Modelos.*;
import dto.ConsumoDto;
import dto.TarjetaCreditoDto;
import dto.TarjetaDebitoDto;

import java.util.ArrayList;
import java.util.List;

public class TarjetasController {

    private static TarjetasController INSTANCE =null;

    private List<Cliente> clientes = null;
    private List<Tarjeta> tarjetas = null;

    private TarjetasController() {
        this.clientes = new ArrayList<>();
        this.tarjetas = new ArrayList<>();
    }

    public static synchronized TarjetasController getInstance(){
        if(INSTANCE == null){
            INSTANCE = new TarjetasController();
        }
        return INSTANCE;
    }

    public int crearConsumo(ConsumoDto dto) {
        for (Tarjeta t : tarjetas) {
            if (t.getNumeroTarjeta().equals(dto.getNumeroTarjeta())) {
                // transformar DTO en objeto Consumo real
                int mes = Integer.parseInt(dto.getMes());
                int año = Integer.parseInt(dto.getAño());
                float monto = Float.parseFloat(dto.getMonto());
                String nombreEstablecimiento = dto.getNombreEstablecimiento();
                String numeroTarjeta = dto.getNumeroTarjeta();

                Consumo nuevoConsumo = new Consumo(mes, año, nombreEstablecimiento, monto, numeroTarjeta);
                t.agregarConsumo(nuevoConsumo);
                return 0;
            }
        }
        return -1; // tarjeta no encontrada
    }
    public float calcularConsumoReal(int mes, int año, String numeroTarjeta) {
        for (Tarjeta t : tarjetas) {
            if (t.getNumeroTarjeta().equals(numeroTarjeta)) {
                return t.calcularConsumoReal(mes, año);
            }
        }
        return -1f; // Tarjeta no encontrada
    }

    public int darAltaTarjetaDebito(TarjetaDebitoDto dto) {
        for (Tarjeta t : tarjetas) {
            if (t.getNumeroTarjeta().equals(dto.getNumeroTarjeta())) {
                return -1; // Ya existe una tarjeta con ese número
            }
        }

        int dni = Integer.parseInt(dto.getDniCliente());
        Cliente cliente = new Cliente(dto.getNombreCliente(), dni);
        TarjetaDebito tarjeta = new TarjetaDebito(dto.getNumeroTarjeta(), cliente, dto.getPorcentajeIVA());
        tarjetas.add(tarjeta);
        clientes.add(cliente);
        return 0; // Alta exitosa
    }

    public int darAltaTarjetaCredito(TarjetaCreditoDto dto) {
        for (Tarjeta t : tarjetas) {
            if (t.getNumeroTarjeta().equals(dto.getNumeroTarjeta())) {
                return -1; // Ya existe una tarjeta con ese número
            }
        }

        int dni = Integer.parseInt(dto.getDniCliente());
        Cliente cliente = new Cliente(dto.getNombreCliente(), dni);
        Tarjeta tarjeta = new TarjetaCredito(dto.getNumeroTarjeta(), cliente, dto.getPorcentajeInteres());
        tarjetas.add(tarjeta);
        clientes.add(cliente);
        return 0; // Alta exitosa
    }
}