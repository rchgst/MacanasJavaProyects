public class Control {
    private int turno;
    private boolean flujo;
    private Carta pozo;
    private int cantJugadores;
    private boolean flujoPozo;
    private int contadorDeLLamadas;

    public Control(int turno, boolean flujo, Carta pozo, int cantJugadores,boolean flujoPozo) {
        this.turno = turno;
        this.flujo = flujo;
        this.pozo = pozo;
        this.cantJugadores = cantJugadores;
        this.flujoPozo = flujoPozo;
        contadorDeLLamadas=0;
    }

    public boolean igualColor(Carta carta1, Carta carta2) {
        return carta1.getColor() == carta2.getColor();
    }

    public boolean igualNumero(Carta carta1, Carta carta2) {
        if (carta1 instanceof CartaComun && carta2 instanceof CartaComun)
            return ((CartaComun) carta1).getNum() == ((CartaComun) carta2).getNum();
        return false;
    }

    public boolean igualHabilidad(Carta carta1, Carta carta2) {
        if (carta1 instanceof CartaEspecial && carta2 instanceof CartaEspecial)
            return ((CartaEspecial) carta1).getHabilidad() == ((CartaEspecial) carta2).getHabilidad();
        return false;
    }

    public void setColorPozo(int color) {
        if (pozo instanceof CartaEspecial) {
            int hab = ((CartaEspecial) pozo).getHabilidad();
            if (hab == 3 || hab == 4) {
                pozo.setColor(color);
            }
        }
    }

    private boolean esCartaEspecialConHabilidad(int habilidad) {
        return pozo instanceof CartaEspecial && ((CartaEspecial) pozo).getHabilidad() == habilidad;
    }

    public boolean pozoNegro() {
        return esCartaEspecialConHabilidad(3) || esCartaEspecialConHabilidad(4);
    }

    public boolean pozoReverse() {
        return esCartaEspecialConHabilidad(0);
    }

    public void cambioFlujo() {
        if(flujo)
            flujo=false;
        else
            flujo=true;
    }

    public void siguienteTurno() {
        if(flujo)
            ++turno;
        else
            --turno;
    }

    public boolean pozoBlock() {
        return esCartaEspecialConHabilidad(1);
    }

    public void ajusteTurno() {
        if (turno >= cantJugadores)
            turno -= cantJugadores;
        else if (turno < 0)
            turno += cantJugadores;
    }

    public boolean pozoAdd() {
        return esCartaEspecialConHabilidad(2) || esCartaEspecialConHabilidad(3);
    }

    public int cuantoSuma() {
        if(pozo instanceof CartaEspecial){
            int hab = ((CartaEspecial) pozo).getHabilidad();
            if (hab == 2) return 2;
            if (hab == 3) return 4;
        }
        return 0;
    }

    public Carta getPozo() {
        return pozo;
    }

    public int getTurno(){
        return turno;
    }

    public boolean validaJugada(Carta carta){
        return this.igualColor(pozo,carta) || this.igualNumero(pozo,carta) || this.igualHabilidad(pozo,carta)||carta instanceof CartaEspecial && ((CartaEspecial) carta).getHabilidad()==3||carta instanceof CartaEspecial && ((CartaEspecial) carta).getHabilidad()==4;
    }

    public void setPozo(Carta carta){
        this.pozo = carta;
    }

    public boolean getFlujopozo(){
        return flujoPozo;
    }

    public void setContadorDeLLamadas(int valor){
        this.contadorDeLLamadas = valor;
    }

    public void setFlujoPozo(){
        if(pozo instanceof CartaEspecial && contadorDeLLamadas<2){
            int hab=((CartaEspecial) pozo).getHabilidad();
            if(hab!=4){
                ++contadorDeLLamadas;
                if(flujoPozo)
                    flujoPozo = false;
                else
                    flujoPozo = true;
            }
        }
        if(!(pozo instanceof CartaEspecial) && contadorDeLLamadas>=2)
            contadorDeLLamadas=0;
    }

}
