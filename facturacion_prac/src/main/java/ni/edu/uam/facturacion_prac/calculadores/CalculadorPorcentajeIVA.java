package ni.edu.uam.facturacion_prac.calculadores;
import ni.edu.uam.facturacion_prac.util.PreferenciasFacturacion;
import org.openxava.calculators.*; // Para usar 'ICalculator'

public class CalculadorPorcentajeIVA
{
    public Object calculate() throws Exception {
        return PreferenciasFacturacion.getPorcentajeIVADefecto();
    }
}
