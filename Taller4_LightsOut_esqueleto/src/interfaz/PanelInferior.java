package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel{

	private VentanaPrincipal padre; 

	public JLabel cantidadJugadas;
	public JLabel nombreJugador;

	public PanelInferior(VentanaPrincipal papa)
	{
		this.padre = papa;

		GridLayout layout = new GridLayout(0, 4, 10, 0);
		this.setLayout(layout);

		Border borderPrincipal = BorderFactory.createTitledBorder("Información de la jugada actual");
		this.setBorder(borderPrincipal);

		Border borde = BorderFactory.createLineBorder(Color.MAGENTA, 2);
		Border otroborde = BorderFactory.createLineBorder(Color.PINK, 2);

		JLabel jugadasLabel = new JLabel("Jugadas");
		add(jugadasLabel);
		cantidadJugadas = new JLabel("0");
		cantidadJugadas.setBorder(borde);
		add(cantidadJugadas);

		JLabel jugadorLabel = new JLabel("Jugador");
		add(jugadorLabel);
		nombreJugador = new JLabel("Null");
		nombreJugador.setBorder(otroborde);
		add(nombreJugador);
	}

}
