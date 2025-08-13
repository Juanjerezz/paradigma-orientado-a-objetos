package Dto;

public class VentaDto
{
    private int ventaID;
    //private String fchVenta;
    private FuncionDTO funDTO;

    public VentaDto(FuncionDTO funDTO, int ventaID)
    {
        this.ventaID = ventaID;
        this.funDTO = funDTO;
    }

    public FuncionDTO getFuncion()
    {
        return funDTO;
    }
    public int getVentaID()
    {
        return ventaID;
    }


    public String toString()
    {
        return "venta n°" + ventaID + " " + funDTO;
    }


}