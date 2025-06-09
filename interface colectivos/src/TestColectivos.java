import java.util.ArrayList;

public class TestColectivos {
    public static void main(String[] args) {
        ArrayList<Colectivo> linea1 = new ArrayList<>();
        ColectivoDiesel bondi1A = new ColectivoDiesel(50, 1000000, 200, 2);
        Hibrido bondi1B = new Hibrido(45, 1200000, IElectrico.ALTO_VOLTAJE, 150, 2);
        ColectivoElectrico bondi1C = new ColectivoElectrico(55, 900000, IElectrico.BAJO_VOLTAJE);
        linea1.add(bondi1A);
        linea1.add(bondi1B);
        linea1.add(bondi1C);
        for (int i = 0; i < linea1.size(); i++) {
            Colectivo analizado = linea1.get(i);
            System.out.println("ID DEL COLECTIVO: " + analizado.getID());
            if (analizado instanceof ColectivoElectrico)
                System.out.println("NIVEL DE CONTAMINACION: 0.0\nVOLTAJE: " + ((ColectivoElectrico) analizado).getVoltaje());
            else {
                double v;
                if (analizado instanceof Hibrido)
                    v = (((Hibrido) analizado).getNivelContaminacion());
                else
                    v = ((ColectivoDiesel) analizado).getNivelContaminacion();
                System.out.println("NIVEL DE CONTAMINACION: " + v);
            }
        }
    }
}