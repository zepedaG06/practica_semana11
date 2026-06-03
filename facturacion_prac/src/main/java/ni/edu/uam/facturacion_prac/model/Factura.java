package ni.edu.uam.facturacion_prac.model;
import lombok.*;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity @Getter @Setter
@View(extendsView = "super.DEFAULT",
        members = "pedidos{ pedidos }")
@View(name = "SinClienteNiFactura",
        members = "anyo, numero, fecha;"
                + "detalles;"
                + "observaciones"
)
public class Factura extends DocumentoComercial
{
    @OneToMany(mappedBy = "factura")
    @CollectionView("SinClienteNiFactura")
    Collection<Pedido> pedidos;
}
