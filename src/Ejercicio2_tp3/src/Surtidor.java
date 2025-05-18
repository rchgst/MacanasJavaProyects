public class Surtidor {

    private int cargaMAx;
    private int ultraDiesel;
    private int euroDiesel;
    private int naftaSuper;
    private int naftaInfinia;

    public Surtidor(){
        this.cargaMAx = 20000;
        this.ultraDiesel = this.cargaMAx;
        this.euroDiesel = this.cargaMAx;
        this.naftaSuper = this.cargaMAx;
        this.naftaInfinia = this.cargaMAx;
    }

    public void llenarDepositoUDiesel(){
        this.ultraDiesel = this.cargaMAx;
    }
    public void llenarDepositoEDiesel(){
        this.euroDiesel = this.cargaMAx;
    }
    public void llenarDepositoNSuper(){
        this.naftaSuper = this.cargaMAx;
    }
    public void llenarDepositoInfinia() {
        this.naftaInfinia = this.cargaMAx;
    }

    public void cargarUDiesel(int litros){

        if(this.ultraDiesel >= litros)
            this.ultraDiesel -= litros;
        else{
            System.out.println("el surtidor esta vacio, se cargaron los ultimos: "+this.ultraDiesel +"litros");
            this.ultraDiesel = 0;
        }
    }

    public void cargarEDiesel(int litros){

        if(this.euroDiesel >= litros)
            this.euroDiesel -= litros;
        else{
            System.out.println("el surtidor esta vacio, se cargaron los ultimos: "+this.euroDiesel +"litros");
            this.euroDiesel = 0;
        }
    }

    public void cargarNSuper(int litros){

        if(this.naftaSuper >= litros)
            this.naftaSuper -= litros;
        else{
            System.out.println("el surtidor esta vacio, se cargaron los ultimos: "+this.naftaSuper +"litros");
            this.naftaSuper = 0;
        }
    }

    public void cargarInfinia(int litros){

        if(this.naftaInfinia >= litros)
            this.naftaInfinia -= litros;
        else{
            System.out.println("el surtidor esta vacio, se cargaron los ultimos: "+this.naftaInfinia +"litros");
            this.naftaInfinia = 0;
        }
    }

    public int getCantUDiesel() {
        return this.ultraDiesel;
    }

    public int getCantEDiesel() {
        return this.euroDiesel;
    }

    public int getCantNSuper() {
        return this.naftaSuper;
    }

    public int getCantInfinia() {
        return this.naftaInfinia;
    }



}
