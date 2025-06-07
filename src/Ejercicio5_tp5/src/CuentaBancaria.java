public class CuentaBancaria {
    private int numero;
    private String titular;
    private double saldo;
    private int maxExtr, cantExtr;

    public CuentaBancaria(int n, String t, int max) {
        numero = n;
        titular = t;
        saldo = 0;
        maxExtr = max;
        cantExtr = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean extraer(double monto) {
        if (monto > saldo)
            return false;
        else {
            if (cantExtr != maxExtr) {
                saldo -= monto;
                cantExtr += 1;
                return true;
            } else {
                System.out.println("Llegó al límite máximo de extracciones");
                return false;
            }
        }
    }

    public void mostrarDatos() {
        System.out.print("Número de cuenta: " + numero);
        System.out.println("        Titular: " + titular);
        System.out.println("Saldo: " + getSaldo());
    }
}
