public class Main {
    public static void main(String[] args) {
        double[][] mat = {
                {28.16,32.18,38.89,44.92,48.27},
                {54.98,59.67,64.37,70.40,75.09},
                {91,18,97.89,101.91,108.21,115.32},
                {134.10,160.91,187.73,214.55,268.16}
        };
        TablaDeSueldos sueldos = new TablaDeSueldos(mat);

        System.out.println("la tabla de sueldos resulta: " + sueldos);

        System.out.println("el promedio de sueldo de un garado es : " + sueldos.promedioGrado(0));

        System.out.println("la diferencia del mayor pago y menor pago de un grado es: " + sueldos.diferenciaDePago(0));

        System.out.println("aumenta el sueldo de un grado entero: \n");
        sueldos.aumentoGrado(0,50);
        System.out.println(sueldos);

    }
}