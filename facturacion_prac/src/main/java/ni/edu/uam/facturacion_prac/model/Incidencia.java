package ni.edu.uam.facturacion_prac.model;


import lombok.*;

public class Incidencia
{
    @Getter @Setter
    int cantidad;
    @Getter @Setter
    int precio;
    public int getImporte() {
        return cantidad * precio;
    }
}


