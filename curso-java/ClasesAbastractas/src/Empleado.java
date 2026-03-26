public class Empleado extends Persona {
	
	public Empleado(String nombre, double sueldo, int año, int mes, int dia) {
		
		super(nombre);
		
		this.sueldo = sueldo;
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		id = idSiguiente;
		idSiguiente++;
	}

	/*@Override
	public String toString() {
		return "ID: " + id
				+ "\nSueldo: " + sueldo
				+ "\nAlta de contrato: "
				+ getAltaContrato()
				+ "\n\n";
	}*/

	public void aumentarSueldo(double porcentaje) {
		double aumento = (sueldo * porcentaje) / 100;

		sueldo += aumento;
	}
	
	public int getId() {
		return id;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public String getAltaContrato() {
		return dia + "/" + mes + "/" + año;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void setFecha(int año, int mes, int dia) {
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}

	@Override
	public String dameDescripcion() {
		return "ID: "+id+"\nSueldo: "+sueldo+"\nNombre: "+getNombre();
	}
	
	private double sueldo;
	private int dia, mes, año, id;
	public static int idSiguiente = 1;
}
