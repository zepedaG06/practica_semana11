package ni.edu.uam.facturacion_prac.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Incidencia
{
    int numero;
    String descripcion;

    public String getDescripcion() {
        if (descripcion == null) return "Todavía sin descripción";
        return descripcion;
    }
}
