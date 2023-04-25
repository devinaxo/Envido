import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;

public class Juego {
	private Mazo mazo;
	private ArrayList<Jugador> jugadores;
	private Jugador jugadorActivo;
	
		public Juego() {
			this.mazo = new Mazo();
			this.jugadores = new ArrayList<>();
		}
		public void agregarUsuario(Jugador player1) {
			this.jugadores.add(player1);
		}
		public void agregarJugador() {
			this.jugadores.add(new Jugador());
		}
		
		public void iniciarJuego() {
			
			boolean Confirm = true, cantaEnvido;
			Random rand = new Random();
			int envido, probabilidad, env1, env2, rondas = 1;
			
			do {
				this.mazo = new Mazo();
				this.mazo.shuffle();
				for (Jugador jugador : this.jugadores) {
		            jugador.recibirCarta(this.mazo.repartir());
		            jugador.recibirCarta(this.mazo.repartir());
		            jugador.recibirCarta(this.mazo.repartir());
		        }
				cantaEnvido = false;
				if((rondas % 2 != 1)) {
					this.jugadorActivo = this.jugadores.get(1);
				}else {
					this.jugadorActivo = this.jugadores.get(0);
				}
				JOptionPane.showMessageDialog(null,"<---RONDA NRO "+rondas+"--->\nTurno de: "+this.jugadorActivo.getName());
				if(this.jugadorActivo == this.jugadores.get(0)) { //jugador activo es el usuario
					JOptionPane.showMessageDialog(null,"En mano: "+this.jugadores.get(0).getMano());
					envido = JOptionPane.showConfirmDialog(null,"¿Desea cantar envido?\nEnvido: "+calcularEnvido(jugadorActivo)); //0 = yes, 1 = no, 2 = cancel
					if(envido == 0) { //usuario canta envido
						cantaEnvido = true;
						probabilidad = rand.nextInt(10) + 1;
						if(calcularEnvido(this.jugadores.get(1)) < 12 || probabilidad <= 4) { //mentir o jugar
							JOptionPane.showMessageDialog(null,""+this.jugadores.get(1).getName()+" aceptó tu Envido!");
							env1 = calcularEnvido(this.jugadorActivo);
							env2 = calcularEnvido(this.jugadores.get(1));
							if(env1 > env2) {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(1).getName()+": "+env2+"\nGanaste!");
							}
							else if(env1 == env2) {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(1).getName()+": "+env2+"\nEmpate.");
							}else {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(1).getName()+": "+env2+"\nPerdiste...");
							}
						}else if(calcularEnvido(this.jugadores.get(1)) == 12 || probabilidad > 4) { //pasar
							JOptionPane.showMessageDialog(null,""+this.jugadores.get(1).getName()+" rechazó el envido...");
						}
					}else if(envido == 1) { //usuario no cantó envido
						JOptionPane.showMessageDialog(null,"Pasaste de turno.");
					}else {
						Confirm = false;
					}
				}
				if(this.jugadorActivo != this.jugadores.get(0) && cantaEnvido != true) { //jugador activo no es el usuario
					probabilidad = rand.nextInt(10) + 1;
					if(probabilidad >= 5) { //canta envido
						JOptionPane.showMessageDialog(null,"En mano: "+this.jugadores.get(0).getMano());
						envido = JOptionPane.showConfirmDialog(null,""+this.jugadorActivo.getName()+" ha cantado Envido! ¿Aceptas?\nEnvido: "+calcularEnvido(this.jugadores.get(0))); //0 = yes, 1 = no, 2 = cancel
						if(envido == 0) { //usuario acepta envido
							env1 = calcularEnvido(this.jugadorActivo);
							env2 = calcularEnvido(this.jugadores.get(0));
							if(env1 < env2) {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(0).getName()+": "+env2+"\nGanaste!");
							}
							else if(env1 == env2) {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(0).getName()+": "+env2+"\nEmpate.");
							}else {
								JOptionPane.showMessageDialog(null, "Envido de "+this.jugadorActivo.getName()+": "+env1+"\nEnvido de "+this.jugadores.get(0).getName()+": "+env2+"\nPerdiste...");
							}
						}
						if(envido == 1) { //usuario no acepta envido
							JOptionPane.showMessageDialog(null, "No aceptaste el envido...");
						}
						
					}else { //no canta envido
						JOptionPane.showMessageDialog(null,""+this.jugadorActivo.getName()+" ha pasado de turno.");
					}
				}
				
				
				int respuesta = JOptionPane.showConfirmDialog(null,"¿Quiere jugar una ronda nueva?"); //0 = yes, 1 = no, 2 = cancel
				if(respuesta == 0) {
					for(Jugador jugador : this.jugadores){
				           jugador.removerCarta();
				           jugador.removerCarta();
				           jugador.removerCarta();
					}
					rondas++;
				}else {
					Confirm = false;
				}
			}while(Confirm != false);
			JOptionPane.showMessageDialog(null, "Gracias por probar este humilde juego.\nHa jugado "+rondas+" rondas.");
		}
		public int calcularEnvido(Jugador player1) {
			Mazo test = new Mazo();
			int envido = test.calcularEnvido(player1);
			return envido;
		}
}
