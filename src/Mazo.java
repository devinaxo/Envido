import java.util.ArrayList;
import java.util.Collections;

public class Mazo{
	private ArrayList<Carta> cartas;
	
		public Mazo() {
			this.cartas = new ArrayList<>();
			for(int i = 1; i<=7; i++) {
				this.cartas.add(new Carta("Espada", i));
				this.cartas.add(new Carta("Copa", i));
				this.cartas.add(new Carta("Oro", i));
				this.cartas.add(new Carta("Basto", i));
			}
			for(int i = 10; i<=12; i++) {
				this.cartas.add(new Carta("Espada", i));
				this.cartas.add(new Carta("Copa", i));
				this.cartas.add(new Carta("Oro", i));
				this.cartas.add(new Carta("Basto", i));
			}
		}
		public void shuffle() {
			Collections.shuffle(this.cartas);
		}
		public Carta repartir() {
			return this.cartas.remove(0);
		}
		public int calcularEnvido(Jugador player) {
			int envido1 = 0, envido2 = 0, envido3 = 0, envido4 = 0;
			if(player.getMano().get(0).getPalo().equals(player.getMano().get(1).getPalo())) {
				envido1 = (player.getMano().get(0).getValor() + player.getMano().get(1).getValor()) + 20;
				if(player.getMano().get(0).getValor() >= 10|| player.getMano().get(1).getValor() >= 10) {
					envido1 -= 10;
				}
			}
			else if(player.getMano().get(1).getPalo().equals(player.getMano().get(2).getPalo())) {
				envido2 = (player.getMano().get(1).getValor() + player.getMano().get(2).getValor()) + 20;
				if(player.getMano().get(1).getValor() >= 10|| player.getMano().get(2).getValor() >= 10) {
					envido2 -= 10;
				}
			}
			else if(player.getMano().get(0).getPalo().equals(player.getMano().get(2).getPalo())) {
				envido3 = (player.getMano().get(0).getValor() + player.getMano().get(2).getValor()) + 20;
				if(player.getMano().get(0).getValor() >= 10|| player.getMano().get(2).getValor() >= 10) {
					envido3 -= 10;
				}
			}else {
				envido4 = 0;
				for(int i = 0; i<player.getMano().size(); i++) {
					if(envido4 < player.getMano().get(i).getValor() && player.getMano().get(i).getValor() < 10) {
						envido4 = player.getMano().get(i).getValor();
					}
				}
			}
			int max = Math.max(Math.max(envido1, envido2), Math.max(envido3, envido4));
			return max;
			
		}
}
