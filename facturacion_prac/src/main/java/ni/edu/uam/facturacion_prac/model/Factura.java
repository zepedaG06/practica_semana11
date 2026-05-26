package ni.edu.uam.facturacion_prac.model;

import java.time.*;
import javax.persistence.*;

import ni.edu.uam.facturacion_prac.calculadores.CalculadorSiguienteNumeroParaAnyo;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@Entity @Getter @Setter

public class Factura
{
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length=6)
    @DefaultValueCalculator(value= CalculadorSiguienteNumeroParaAnyo.class,
            properties=@PropertyValue(name="anyo")
    )
    int numero;
    @ManyToOne(fetch=FetchType.LAZY, optional=false) //
    Cliente cliente;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;

}
