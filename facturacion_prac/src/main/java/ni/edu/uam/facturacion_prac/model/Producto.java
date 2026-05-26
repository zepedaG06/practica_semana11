package ni.edu.uam.facturacion_prac.model;
import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity @Getter @Setter
public class Producto
{
    @Id @Column(length=9)
    int numero;

    @Column(length=50) @Required
    String descripcion;

}
