package interfaz;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class PanelDerecha extends JPanel{
	
	private VentanaPrincipal padre;

	public JButton Nuevo;
	public JButton Reiniciar;
	public JButton Top_10;
	public JButton CambiarJugador;

	public PanelDerecha(VentanaPrincipal papa)
	{

		this.padre = papa;
		
		GridLayout layout = new GridLayout(4, 1);
		this.setLayout(layout);
		Border border = BorderFactory.createTitledBorder("Menu");
		this.setBorder(border);
		
		Nuevo = new JButton("Nuevo");
		Reiniciar = new JButton("Reiniciar");
		Top_10 = new JButton("Top 10");
		CambiarJugador = new JButton("Cambiar jugador");

		Nuevo.addActionListener(padre);
		Reiniciar.addActionListener(padre);
		Top_10.addActionListener(padre);
		CambiarJugador.addActionListener(padre);

		this.add(Nuevo);
		this.add(Reiniciar);
		this.add(Top_10);
		this.add(CambiarJugador);
	}
	

}
