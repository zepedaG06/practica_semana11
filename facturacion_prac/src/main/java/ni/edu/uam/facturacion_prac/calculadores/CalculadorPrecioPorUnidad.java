package ni.edu.uam.facturacion_prac.calculadores;

import ni.edu.uam.facturacion_prac.model.Producto;
import org.openxava.calculators.*;
import lombok.*;
import static org.openxava.jpa.XPersistence.*;

public class CalculadorPrecioPorUnidad implements ICalculator {

    @Getter @Setter
    int numeroProducto;

    @Override
    public Object calculate() throws Exception {
        Producto producto = getManager()
                .find(Producto.class, numeroProducto);
        return producto.getPrecio();
    }

}
