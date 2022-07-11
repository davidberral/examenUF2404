package modelo;

public class Hora {

	private int hora;
	private int minutos;
	private int segundos;
	
	
	public Hora() {
		this.hora=0;
		this.minutos=0;
		this.segundos=00;
	}
	
	
	public static boolean valida(int hora, int minutos, int segundos) {
		if (hora >=0 && hora<24 && minutos >=0 && minutos <60
				&& segundos>=0 && segundos <60) {
			return true;
		} else {
			return false;
		}
	}


	public Hora(int hora, int minutos, int segundos) {
		setHora(hora,minutos,segundos);
	}
	
	public Hora(Hora h) {
		setHora(h.hora,h.minutos,h.segundos);
	}


	public int getHora() {
		return hora;
	}


	public int getMinutos() {
		return minutos;
	}


	public int getSegundos() {
		return segundos;
	}
	
	public void setHora(int hora, int minutos, int segundos) {
		if (valida(hora,minutos,segundos)) {
			this.hora = hora;
			this.minutos = minutos;
			this.segundos = segundos;
		} else {
			this.hora=0;
			this.minutos=0;
			this.segundos=0;
		}
	}


	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", this.hora,this.minutos,this.segundos);
	}
	
	
	public int aSegundos() {
		return this.hora*60*60+this.minutos*60+this.segundos;
	}
	
	public void deSegundos (int segundos) {
		int resto = segundos%(86400);
		int sgs = resto%60;
		resto= resto/60;
		
		int min = resto%60;
		int h = resto/60;
		this.setHora(h, min, sgs);
	}
	
	public int segundosEntre(Hora h) {
		return Math.abs(this.aSegundos()-h.aSegundos());
	}
	
	
	
	
}
