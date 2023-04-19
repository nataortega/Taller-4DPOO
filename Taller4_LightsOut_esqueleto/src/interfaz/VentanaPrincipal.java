package interfaz;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {
	private Tablero tablero;
	public PanelSuperior arriba;
	public PanelInferior abajo;
	public PanelDerecha derecha;
	public PanelTablero tablerito;

	public JButton Nuevo;
	public JButton Reiniciar;
	public JButton Top_10;
	public JButton CambiarJugador;

	public JRadioButton easy;
	public JRadioButton medium;
	public JRadioButton hard;

	public JComboBox<String> cb;
	public Integer size = 4;
	public Integer dificultad = 3;

	public InfoTop10 ventanaTop10;
	public static Top10 top10;
	public JLabel cantidadJugadas;

	/*
	 * CONSTRUCTOR
	 */
	public VentanaPrincipal(String nombreJugador)
	{
		tablero = new Tablero(size);
		setLayout(new BorderLayout());
		pack();
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(true);

		setSize(800, 700);

		/*
		 * Window listener para cuando se cierre la ventana.
		 */
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					salvarTop10();
				} catch (FileNotFoundException e1)
				{
					System.err.println("\nNo se encontró el archvio.\n");
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1)
				{
					System.err.println("\nUnsupportedEncoding!\n");
					e1.printStackTrace();
				}
			}
		});

		/*
		 * Se cargan los top 10
		 * 
		 * luego se crea la ventana de los top 10
		 */
		top10 = new Top10();
		this.cargarTop10();
		ventanaTop10 = new InfoTop10(top10);

		// Panel de arriba
		arriba = new PanelSuperior(this);
		add(arriba, BorderLayout.NORTH);

		abajo = new PanelInferior(this);
		abajo.nombreJugador.setText(nombreJugador);
		add(abajo, BorderLayout.SOUTH);

		derecha = new PanelDerecha(this);
		add(derecha, BorderLayout.EAST);

		tablerito = new PanelTablero(this);

		add(tablerito, BorderLayout.CENTER);

		int PanelX = (getWidth() - tablerito.getWidth() - getInsets().left - getInsets().right) / 2;
		int PanelY = (getHeight() - tablerito.getHeight() - getInsets().top - getInsets().bottom) / 2;

		tablerito.setLocation(PanelX, PanelY);

		setLocationRelativeTo(null);
		setVisible(true);

		nuevoJuego();

	}

	/**
	 * Se inicia un nuevo juego.
	 */

	public void nuevoJuego()
	{

		abajo.cantidadJugadas.setText("0");
		tablero = new Tablero(size);
		tablero.desordenar(dificultad);
		tablerito.nuevoPanel(tablero);

	}

	/**
	 * Se cargan los top 10 del archivo en data.
	 */
	public void cargarTop10()
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		top10.cargarRecords(archivoFile);
	}

	/**
	 * Se guarda el top10 en el CSV.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("static-access")
	public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		this.top10.salvarRecords(archivoFile);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		// Botones panel de la derecha

		Nuevo = derecha.Nuevo;
		Reiniciar = derecha.Reiniciar;
		Top_10 = derecha.Top_10;
		CambiarJugador = derecha.CambiarJugador;

		// Botones panel superior

		easy = arriba.easy;
		medium = arriba.medium;
		hard = arriba.hard;

		cb = arriba.cb;

		// Acciones del panel de la derecha

		if (e.getSource() == Nuevo)
		{
			nuevoJuego();
		}
		else if (e.getSource() == Reiniciar)
		{
			tablero.reiniciar();
			tablerito.nuevoPanel(tablero);
		}
		else if (e.getSource() == Top_10)
		{
			ventanaTop10.changeVisibility();
		}
		else if (e.getSource() == CambiarJugador)
		{
			new IngresarNombre();
		}

		// Acciones del panel superior
		else if (e.getSource() == easy)
		{
			dificultad = 5;
			nuevoJuego();
		}
		else if (e.getSource() == medium)
		{
			dificultad = 10;
			nuevoJuego();
		}
		else if (e.getSource() == hard)
		{
			dificultad = 20;
			nuevoJuego();
		}
		else if (e.getSource() == cb)
		{
			String selectedSize = (String) cb.getSelectedItem();
			if (selectedSize.equals("4x4"))
			{
				size = 4;
				nuevoJuego();
			}
			else if (selectedSize.equals("6x6"))
			{
				size = 6;
				nuevoJuego();
			}
			else if (selectedSize.equals("8x8"))
			{
				size = 8;
				nuevoJuego();
			}
			else if (selectedSize.equals("10x10"))
			{
				size = 10;
				nuevoJuego();
			}
			else if (selectedSize.equals("12x12"))
			{
				size = 12;
				nuevoJuego();
			}
			else if (selectedSize.equals("14x14"))
			{
				size = 14;
				nuevoJuego();
			}
		}
	}

	public void Jugar(int i, int j)
	{
		tablero.jugar(i, j);
		Integer cantidad = tablerito.cantidadJugadas;
		abajo.cantidadJugadas.setText(cantidad.toString());

		int puntaje = tablero.calcularPuntaje();
		int jugadas = Integer.parseInt(abajo.cantidadJugadas.getText());

		if (tablero.tableroIluminado() == true)
		{
			if (top10.esTop10(puntaje))
			{
				top10.agregarRegistro(abajo.nombreJugador.getText(), puntaje);
			}
			new ElFin(jugadas, puntaje, this);
		}

	}

}
