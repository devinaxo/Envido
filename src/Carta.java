
public class Carta {
	private String palo;
	private int valor;
	
		public Carta(String palo, int valor) {
			this.palo = palo;
			this.valor = valor;
		}
		public String toString() {
			String nombre = "";
			switch(valor) {
			case 1:
				nombre = "As";
				break;
			case 2:
				nombre = "Dos";
				break;
			case 3:
				nombre = "Tres";
				break;
			case 4:
				nombre = "Cuatro";
				break;
			case 5:
				nombre = "Cinco";
				break;
			case 6:
				nombre = "Seis";
				break;
			case 7:
				nombre = "Siete";
				break;
			case 10:
				nombre = "Diez";
				break;
			case 11:
				nombre = "Once";
				break;
			case 12:
				nombre = "Doce";
				break;
			}
			return nombre+" de "+palo;
		}
		public String getPalo() {
			return palo;
		}
		public void setPalo(String palo) {
			this.palo = palo;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		
}
