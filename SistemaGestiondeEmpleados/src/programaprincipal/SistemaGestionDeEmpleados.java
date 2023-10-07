package programaprincipal;

import empleados.Empleado;
import empleados.EmpleadoTiempoCompleto;
import empleados.EmpleadoTiempoParcial;

/**
 *
 * @author Jesús del Carmen Mendoza Mendoza
 */
public class SistemaGestionDeEmpleados {
    public static void main(String[] args) {
        EmpleadoTiempoCompleto empleadoTC1 = new EmpleadoTiempoCompleto("Mikkel", 1, 
            2000.0, 160);
        EmpleadoTiempoParcial empleadoTP1 = new EmpleadoTiempoParcial("Alejandro", 2, 
            5000.0, 15);
        System.out.println(empleadoTC1 +"\n"+ empleadoTP1);

        // Polimorfismo
        Empleado empleadoCompleto = new EmpleadoTiempoCompleto("Jesus", 3, 
            1500, 200);
        System.out.println(empleadoCompleto.toString()); // info del empleado con toString()
        System.out.println("Salario del empleado " + empleadoCompleto.getNombre() 
            + ": $" + empleadoCompleto.calcularSalario() + ", más Incentivo: $"
            + ((EmpleadoTiempoCompleto) empleadoCompleto).calcularIncentivo());

        System.out.println();

        Empleado empleadoParcial = new EmpleadoTiempoParcial("Luis", 4, 
            2000, 15);
        System.out.println(empleadoParcial.toString()); // info del empleado con toString()
        System.out.println("Salario del empleado " + empleadoParcial.getNombre() 
            + ": $" + empleadoParcial.calcularSalario() + ", más Incentivo: $"
            + ((EmpleadoTiempoParcial) empleadoParcial).calcularIncentivo());
    }
}
