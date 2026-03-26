public class Alumno extends Persona {

	public Alumno(String nombre, String carrera) {
		super(nombre);
		this.carrera = carrera;
	}
	
	@Override
	public String dameDescripcion() {
		return "Nombre del alumno: "+getNombre()+"\nCarrera: "+carrera;
	}
	
	String carrera;
	
}
