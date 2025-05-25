public class Main {
    public static void main(String[] args) {
        double[][] mat = {
                {28.16,32.18,38.89,44.92,48.27},
                {54.98,59.67,64.37,70.40,75.09},
                {91,18,97.89,101.91,108.21,115.32},
                {134.10,160.91,187.73,214.55,268.16}
        };
        ProduccionCereales produccion = new ProduccionCereales(mat);

        System.out.println("la tabla de cosechas resulta: " + produccion);

        System.out.println("el promedio anual de cosecha de un tipo es : " + produccion.promedioAnual(0));

        System.out.println("la canidad de meses con mejor cosecha al promedio es: " + produccion.cantMejoresCosechas(0));

        System.out.println("la cantidad de meses con peor cosecha al promedio es: " + produccion.cantPeoresCosechas(0));

    }
}