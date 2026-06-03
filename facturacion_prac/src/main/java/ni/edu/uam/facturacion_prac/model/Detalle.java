package ni.edu.uam.facturacion_prac.model;
import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.Depends;
import org.openxava.annotations.Stereotype;

import java.math.BigDecimal;


@Embeddable @Getter @Setter

public class Detalle
{
    int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;

    @Stereotype("DINERO")
    @Depends("producto.numero, cantidad")
    public BigDecimal getImporte()
    {
        if(producto == null || producto.getPrecio() == null) return BigDecimal.ZERO;
        return new BigDecimal(cantidad).multiply(producto.getPrecio());
    }
}
