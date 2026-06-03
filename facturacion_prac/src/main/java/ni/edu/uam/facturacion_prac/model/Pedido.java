package ni.edu.uam.facturacion_prac.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

@Entity @Getter @Setter
@View(extendsView = "super.DEFAULT",
        members = "factura{ factura }")
@View(name = "SinClienteNiFactura",
        members = "anyo, numero, fecha;"
        + "detalles;"
        + "observaciones"
)
public class Pedido extends DocumentoComercial
{
    @ManyToOne
    @ReferenceView("SinClienteNiFactura")
    Factura factura;

}
