import java.util.ArrayList;
import java.util.Random;

public class Jugador {
	private String name;
	private ArrayList<Carta> cartas;
		
		public Jugador() {
			String[] nombres = {"Juan","Nico","Rocio","Rafa","Andres","Khalid","Hector","Papito Envido","Sonic"};
			Random rand = new Random();
			this.name = nombres[rand.nextInt(nombres.length)];
			this.cartas = new ArrayList<>();
		}
		public Jugador(String nombre) {
			this.name = nombre;
			this.cartas = new ArrayList<>();
		}
		 public void recibirCarta(Carta carta) {
		        this.cartas.add(carta);
		    }
		 public void removerCarta() {
			 this.cartas.remove(this.cartas.size()-1);
		 }
		    public ArrayList<Carta> getMano() {
		        return this.cartas;
		    }

		    public String getNombre() {
		        return this.name;
		    }
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
}
