package mvc.modelo;

public class Modelo {
	private int numero1, numero2, resultado;

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * método que hará la operación
	 * 
	 * no recibirá ningún parametro, ya que,
	 * vamos a tomarlo de las propiedades
	 * @return
	 */
	public int multiplicar() {
		this.resultado = this.numero1 * this.numero2;
		return resultado;
	}
	
	// falta la conexión entre vista y modelo, la cual es el controlador
}
