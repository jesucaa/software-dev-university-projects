package empleados;

import interfaz.IEmpleado;

/**
 *
 * @author Jesús del Carmen Mendoza Mendoza
 */
public class EmpleadoTiempoCompleto extends Empleado implements IEmpleado {
    private int horasTrabajadas;
    
    public EmpleadoTiempoCompleto(String nombre, int id, double salario,
            int horasTrabajadas) {
        super(nombre, id, salario);
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public double calcularSalario() {
        double salarioMensual = this.getSalario() * 4 ;
        return salarioMensual;
    }

    @Override
    public double calcularIncentivo() {
        double incentivo = getSalario() * 0.5;
        return incentivo;
    }

    @Override
    public String toString() {
        return "{nombre: " + getNombre()
        + ", id: " + getId() + ", salario: " 
        + getSalario() + ", Horas trabajadas: " 
        + this.horasTrabajadas + '}';
    }
}
