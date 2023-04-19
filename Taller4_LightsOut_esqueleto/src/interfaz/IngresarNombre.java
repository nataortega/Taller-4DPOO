package interfaz;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;
@SuppressWarnings("serial")
public class IngresarNombre extends JFrame implements ActionListener {

	public JButton binicio;
	public JTextField t;
	public String nombreJugador;



	public static void main(String[] args) {
		FlatLightLaf.install();
		new IngresarNombre();

	}
	public IngresarNombre()
	{
		this.setTitle("Sign in!");
		JLabel l = new JLabel("Ingrese su nombre para iniciar el juego");

		binicio = new JButton("Iniciar");
		binicio.addActionListener(this);

		t = new JTextField(16);
		t.addActionListener(this);

		JPanel p = new JPanel();
		JLabel imagen = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("./data/LightsOutlogo.png").getImage().getScaledInstance(250, 350, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);

		p.add(imagen);
		p.add(l);
		p.add(t);
		p.add(binicio);

		add(p);

		setSize(400, 500);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == binicio)
		{
			nombreJugador = t.getText();
			new VentanaPrincipal(nombreJugador);
			this.dispose();
		}


	}
}
