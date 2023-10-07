package empleados;

import interfaz.IEmpleado;

/**
 *
 * @author Jesús del Carmen Mendoza Mendoza
 */
public class EmpleadoTiempoParcial extends Empleado implements IEmpleado {
    private int horasPorSemana;
    
    public EmpleadoTiempoParcial(String nombre, int id, double salario, 
            int horasPorSemana) {
        super(nombre, id, salario);
        this.horasPorSemana = horasPorSemana;
    }
    
    public double calcularSalario() {
        double salarioSemanal = getSalario() * horasPorSemana;
        return salarioSemanal;
    }

    @Override
    public double calcularIncentivo() {
        double incentivo = getSalario() * 0.3;
        return incentivo;
    }

    @Override
    public String toString() {
        return "{nombre: " + getNombre()
        + ", id: " + getId() + ", salario: " 
        + getSalario() + ", Horas por semana: " 
        + this.horasPorSemana + '}';
    }
}
