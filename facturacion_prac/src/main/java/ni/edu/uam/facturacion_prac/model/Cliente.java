package ni.edu.uam.facturacion_prac.model;

import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;

//Primer paso
@Entity
@Getter @Setter
public class Cliente
{
    @Id
    @Column(length=6)
    int numero;

    @Column(length=50)
    @Required
    String nombre;
}
