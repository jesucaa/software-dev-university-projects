class Main {
	public static void main(String[] args) {

		Empleado[] empleados = new Empleado[4];

		Jefatura jefe = new Jefatura("Jesuuca", 3000, 2000, 01, 01);

		empleados[0] = jefe; // Polimorfismo en acción. Principio de sustitución
		empleados[1] = new Jefatura("Maria", 20000, 1999, 5, 26);
		empleados[2] = new Empleado("Jesus Mendoza", 1200, 2000, 05, 15);
		empleados[3] = new Empleado("Eder Bernal", 3000, 2000, 12, 04);

		for (Empleado e : empleados)
			e.aumentarSueldo(5);

		Jefatura[] jefeFinanzas = new Jefatura[2];

		for (int i = 0; i < 2; i++) {
			jefeFinanzas[i] = (Jefatura) empleados[i];
			jefeFinanzas[i].setIncentivo(0.20);
		}

		for (Empleado e : empleados) {
			System.out.println("ID: " + e.getId()
					+ "\nNombre: " + e.getNombre()
					+ "\nSueldo: " + e.getSueldo()
					+ "\nAlta de contrato: " + e.getAltaContrato());
			System.out.println();
		}
		
		System.out.println(jefeFinanzas[0].tomarDecisiones("subir el sueldo a los empleados\n"));
		System.out.println("Bonus del Empleado "+empleados[2].getNombre()+": "+empleados[2].setBonus(1500)
				+ "\nBonus del Jefe "+jefeFinanzas[0].getNombre()+": "+jefeFinanzas[0].setBonus(2500));
	}
}