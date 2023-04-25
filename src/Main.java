import javax.swing.JOptionPane;

// ==UserScript==
// @name         Juego del Envido
// @version      0.1
// @description  Se trata de una simple versión acortada del Truco, donde se reparten cartas y solo se puede cantar envido.
// @author       Ignacio García

public class Main {

	public static void main(String[] args) {
		Juego ENVIDO = new Juego();
		String name = JOptionPane.showInputDialog("Ingrese su nombre: ");
		ENVIDO.agregarUsuario(new Jugador(name));
		ENVIDO.agregarJugador();
		ENVIDO.iniciarJuego();
	}

}
