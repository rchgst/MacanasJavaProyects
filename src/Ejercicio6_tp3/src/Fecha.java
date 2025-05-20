
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
    public class Fecha {
        LocalDate fecha;

        public Fecha() {
            this.fecha = LocalDate.now();
        }

        public Fecha(int anio, int mes, int dia) {
            this.fecha = LocalDate.of(anio, mes, dia);
        }

        public int comparaFechas(LocalDate otra) {
            return this.fecha.compareTo(otra);
        }


        @Override
        public String toString() {
            DateTimeFormatter formato=DateTimeFormatter.ofPattern("'Fecha: 'dd/MM/yyyy");
            return this.fecha.format(formato);
        }
    }

