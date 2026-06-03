package ni.edu.uam.facturacion_prac.model;

import java.time.*;
import java.util.Collection;
import javax.persistence.*;

import ni.edu.uam.facturacion_prac.calculadores.CalculadorSiguienteNumeroParaAnyo;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@Entity @Getter @Setter
@View(members=
        "anyo, numero, fecha;" +
                "datos{" +
                "cliente;" +
                "detalles;" +
                "observaciones"+
                "}"
)
abstract public class DocumentoComercial extends Identificable
{
    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length=6)
    @DefaultValueCalculator(value= CalculadorSiguienteNumeroParaAnyo.class,
            properties=@PropertyValue(name="anyo")
    )
    int numero;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple")
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad, precioPorUnidad, importe")
    Collection<Detalle> detalles;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;

}
