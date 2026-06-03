package ni.edu.uam.facturacion_prac.model;

import javax.persistence.*;
import lombok.*;

@Entity @Getter @Setter
public class Pedido extends DocumentoComercial
{
    @ManyToOne
    Factura factura;

}
