public class Test {
    public static void main(String[] args){
        Matriz m = new Matriz(3,3);
        m.CargaMatriz();

        for(int i=0;i<m.matriz.length;i++){
            System.out.println("");
            for(int j=0;j<m.matriz[0].length;j++){
                System.out.print(m.getelemento(i,j)+"\n");
            }
        }
        m.determineMayor();
        System.out.println("La fila con mayor venta es: "+m.posicionFila);
    }
    
}
