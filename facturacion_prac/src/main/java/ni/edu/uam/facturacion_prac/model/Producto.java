package ni.edu.uam.facturacion_prac.model;
import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;
import java.math.BigDecimal;

//Paso de 2 de la leccion 1
@Entity @Getter @Setter
public class Producto
{
    @Id @Column(length=9)
    int numero;
    @ManyToOne(
            fetch=FetchType.LAZY,
            optional=true)
    @DescriptionsList
    Categoria categoria;

    @Money
    BigDecimal precio;

    @Files
    @Column(length=32)
    String fotos;

    @TextArea
    String observaciones;

    @Embedded
    Direccion direccion;
}
