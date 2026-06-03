package ni.edu.uam.facturacion_prac.model;
import javax.persistence.*;
import lombok.*;
import ni.edu.uam.facturacion_prac.calculadores.CalculadorPrecioPorUnidad;
import org.openxava.annotations.*;

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
        if(precioPorUnidad == null) return BigDecimal.ZERO;
        return new BigDecimal(cantidad).multiply(precioPorUnidad);
    }
    @DefaultValueCalculator(value= CalculadorPrecioPorUnidad.class,
            properties=@PropertyValue(name="numeroProducto", from="producto.numero")
    )
    @Stereotype("DINERO")
    BigDecimal precioPorUnidad;
}
