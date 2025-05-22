public class Main {
    public static void main(String[] args) {
        int[][] datosFoto = {
                {0, 57, 76, 0, 0, 0, 114, 152},
                {95, 247, 114, 0, 0, 0, 38, 57},
                {38, 114, 38, 133, 57, 0, 190, 0},
                {0, 0, 76, 255, 76, 19, 152, 0},
                {0, 0, 133, 228, 114, 171, 190, 76},
                {95, 0, 114, 190, 114, 76, 152, 0}
        };

        Fotografia f = new Fotografia(datosFoto);
        char[][] estrellas = f.tablaDeEstrella();
        f.imprimir(estrellas);
    }
}
