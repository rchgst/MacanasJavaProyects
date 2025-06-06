import java.util.ArrayList;
public class testColectivos {
    public static void main(String[] args) {
        Hibrido coleHibrido = new Hibrido(45,1200000,IElectrico.ALTO_VOLTAJE,150,2);
        ColectivoDiesel coleDiesel = new ColectivoDiesel(50,1000000,200,2);
        ColectivoElectrico colElectrico = new ColectivoElectrico(55,900000,IElectrico.BAJO_VOLTAJE);
        ArrayList<Colectivo>colectivos = new ArrayList<Colectivo>();
        colectivos.add(coleHibrido);
        colectivos.add(coleDiesel);
        colectivos.add(colElectrico);
        double nivelContaminacion = 0;
        int ID = 0;
        double v = 0;
        for(int i=0;i<colectivos.size();i++){
            if(colectivos.get(i) instanceof IDiesel)
                nivelContaminacion = ((IDiesel) colectivos.get(i)).getNivelContaminacion();
            if(colectivos.get(i) instanceof IElectrico)
                v = ((IElectrico) colectivos.get(i)).getVoltaje();
            ID = colectivos.get(i).getID();
            System.out.println("el nivel de contaminacion es: "+nivelContaminacion+" el ID es: "+ID);
        }
    }
}