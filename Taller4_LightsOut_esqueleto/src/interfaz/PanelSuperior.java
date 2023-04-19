package interfaz;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel {
	private VentanaPrincipal padre;

	public JRadioButton easy;
	public JRadioButton medium;
	public JRadioButton hard;

	public JComboBox<String> cb;

	public PanelSuperior(VentanaPrincipal papa)
	{

		this.padre = papa;
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		Border border = BorderFactory.createTitledBorder("Opciones de juego");
		this.setBorder(border);

		JLabel lbl = new JLabel("Tamaño:");
		lbl.setAlignmentX(LEFT_ALIGNMENT);
		this.add(lbl);

		String[] opciones = { "4x4", "6x6", "8x8", "10x10", "12x12", "14x14" };

		cb = new JComboBox<String>(opciones);
		cb.setMaximumSize(getPreferredSize());
		cb.setAlignmentX(LEFT_ALIGNMENT);

		cb.addActionListener(padre);

		this.add(cb);

		JLabel dificultadLbl = new JLabel("Dificultad: ");
		this.add(dificultadLbl);

		easy = new JRadioButton("Fácil", true); 
		medium = new JRadioButton("Medio", false);
		hard = new JRadioButton("Difícil", false);

		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);

		easy.addActionListener(padre);
		medium.addActionListener(padre);
		hard.addActionListener(padre);

		this.add(easy);
		this.add(medium);
		this.add(hard);
	}

}
