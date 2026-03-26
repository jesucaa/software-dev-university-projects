class Empleado implements Trabajadores {
	private String nombre;
	private double sueldo;
	private int dia, mes, año, id;
	public static int idSiguiente = 1;

	public Empleado() {

	}

	public Empleado(String nombre, double sueldo, int año, int mes, int dia) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		id = idSiguiente;
		idSiguiente++;
	}
	
	@Override
	public double setBonus(double gratificacion) {
		
		return Trabajadores.base+gratificacion;
	}

	@Override
	public String toString() {
		return "ID: " + id
				+ "\nNombre: " + nombre
				+ "\nSueldo: " + sueldo
				+ "\nAlta de contrato: "
				+ getAltaContrato()
				+ "\n\n";
	}

	public void aumentarSueldo(double porcentaje) {
		double aumento = (sueldo * porcentaje) / 100;

		sueldo += aumento;
	}

	public String getNombre() {
		return this.nombre;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void setFecha(int año, int mes, int dia) {
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}

}