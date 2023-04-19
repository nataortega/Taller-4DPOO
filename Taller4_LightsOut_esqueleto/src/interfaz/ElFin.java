package interfaz;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ElFin extends JFrame implements ActionListener{
	private VentanaPrincipal ventana;
	public JButton empezar;
	public JButton salir;
	
	
	public ElFin(int jugadas, int puntaje, VentanaPrincipal ventana)
	{
		this.ventana = ventana;
		this.setTitle("¡Ganaste!");
		GridLayout layout = new GridLayout(5,1);
		setLayout(layout);
		
		
		JLabel texto1 = new JLabel("Fin del juego!");
		JLabel texto2 = new JLabel("Ha terminado el juego en: " + jugadas + " jugadas.");
		JLabel texto3 = new JLabel("Su puntaje ha sido: " + puntaje + " puntos.");
		
		empezar = new JButton("Volver a empezar");
		empezar.setMinimumSize(new Dimension(100, 20));
		empezar.addActionListener(this);
		salir = new JButton("Salir");
		salir.setMinimumSize(new Dimension(100, 20));
		salir.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout());
		
		panel.add(empezar);
		panel.add(salir);
		add(texto1);
		add(texto2);
		add(texto3);
		add(panel);
		
		setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == empezar)
		{
			//Ingresa un nuevo nombre si reinicia
			new IngresarNombre();
			this.dispose();
			try
			{
				this.ventana.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			this.ventana.dispose();
		}
		//Cerrar ventana
		else if(e.getSource()==salir)
		{
			try
			{
				this.ventana.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			System.exit(0);
			this.dispose();
		}
		
	}


}
