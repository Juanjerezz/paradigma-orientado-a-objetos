package Dto;
import Modelo.Funcion;

public class FuncionDTO {

    private int funcionID;
    private String horario;
    private String nombrePelicula;

    public FuncionDTO(Funcion funcion)
    {
        this.funcionID = funcion.getFuncionID();
        this.horario = funcion.getHorario();
        this.nombrePelicula = funcion.getPelicula().getNombrePelicula();
    }

    public int getFuncionID() {
        return funcionID;
    }

    public String getHorario() {
        return horario;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    @Override
    public String toString() {
        return "Funcion ID=" + funcionID + ", horario=" + horario + ", nombrePelicula=" + nombrePelicula;
    }




}

