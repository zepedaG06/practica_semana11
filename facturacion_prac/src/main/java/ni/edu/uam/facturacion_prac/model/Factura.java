package ni.edu.uam.facturacion_prac.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity @Getter @Setter
public class Factura extends DocumentoComercial
{
    @OneToMany(mappedBy = "factura")
    Collection<Pedido> pedidos;
}
