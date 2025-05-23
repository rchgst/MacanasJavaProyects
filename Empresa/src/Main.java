public class Main {
    public static void main(String[] args){
        Empleado[] empleados = new Empleado[5];
        for(int i = 0; i < empleados.length;i++){
            int random = (int)(Math.random() * 2);
            if(random == 0)
                empleados[i] = new Secretario("Julian", 45019858, "Castañares", 7, 387554009, 1000000, "Oficina", 40040, 2023, 8, 23, 12, 0);
            else
                empleados[i] = new Vendedor("Maik", 40234, "Huayco", 1, 21323, 500000, 34234, "0AF234F", "Ford", "1", 2025, 5, 1, 12,0);
        }
        //Prueba para mostrar los datos de los empleados
        for(int i = 0; i < empleados.length;i++){
            System.out.println(empleados[i].toString()); //Polimorfismo
        }

        //Prueba para aumento de sueldo segun cargos
        for(int i = 0; i < empleados.length;i++){
            empleados[i].aumentarSalario(); //Polimorfismo
            System.out.println(empleados[i].toString());
        }
    }
}