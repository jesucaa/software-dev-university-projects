import javax.swing.JOptionPane;

public class UsoPersona {
	
	public static void main(String[] args) {
		
		Persona[] personas = new Persona[3];
		
		String nombreEmpleado = JOptionPane.showInputDialog("Ingresa el nombre del empleado: ");
		personas[0] = new Empleado(nombreEmpleado, 30000, 2020, 05, 12);
		
		String nombreEmpleado2 = JOptionPane.showInputDialog("Ingresa el nombre del empleado: ");
		personas[1] = new Empleado(nombreEmpleado2, 30000, 2020, 05, 12);
		
		String nombreAlumno = JOptionPane.showInputDialog("Ingresa el nombre del alumno: ");
		String nombreCarrera = JOptionPane.showInputDialog("Ingresa el nombre de la carrera: ");
		 
		personas[2] = new Alumno(nombreAlumno, nombreCarrera);
		
		for (Persona p : personas)
			System.out.println(p.dameDescripcion()+"\n");
	}
	
}
