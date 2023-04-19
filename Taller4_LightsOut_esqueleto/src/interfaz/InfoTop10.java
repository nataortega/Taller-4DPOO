package interfaz;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;
@SuppressWarnings("serial")
public class InfoTop10 extends JFrame{
	public Top10 losTop10 = null;

	public boolean esVisible = false;

	public InfoTop10(Top10 cola)
	{
		this.losTop10 = cola;
		setTitle("Top 10");
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		setSize(300, 500);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				changeVisibility(); 
			}
		});

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(1, 1));

		JLabel header = new JLabel();
		header.setVisible(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(header);
		panel.add(headerPanel);

		String lista10 = "";
		int contador = 1;
		for (RegistroTop10 i : losTop10.darRegistros())
		{
			lista10 += contador + "    ";
			lista10 += i.darNombre() + "    ";
			lista10 += i.darPuntos();
			lista10 += ",";
			contador++;
		}

		String[] arrayLista = lista10.split(",");

		JList<String> listaTop10 = new JList<String>(arrayLista);
		listaTop10.setVisibleRowCount(10);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listaTop10.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		listaTop10.setFixedCellHeight(50);

		JScrollPane scrollPane = new JScrollPane(listaTop10);
		scrollPane.setPreferredSize(new Dimension(300, 300));

		panel.add(scrollPane);

		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(esVisible); 
		this.revalidate();
	}

	public void changeVisibility()
	{
		this.esVisible = !esVisible;
		this.setVisible(esVisible);
	}

}
