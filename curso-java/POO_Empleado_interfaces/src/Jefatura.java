class Jefatura extends Empleado implements Jefes {

	private double incentivo;

	public Jefatura(String nombre, double sueldo, int año, int mes, int dia) {
		super(nombre, sueldo, año, mes, dia);
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	public double getSueldo() {
		double sueldoJefe = super.getSueldo();
		return sueldoJefe + incentivo;
	}

	@Override
	public String tomarDecisiones(String decision) {
		
		return "Un miembro de la direccion ha tomado la decision de: " + decision;
	}

	@Override
	public double setBonus(double gratificacion) {
		
		double prima=2000;
		
		return Trabajadores.base+prima+gratificacion;
	}

}