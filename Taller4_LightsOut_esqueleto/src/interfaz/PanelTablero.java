package interfaz;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel implements MouseListener {
	private VentanaPrincipal padre;
    private int[][] cantidades;
    private int largo;
    private boolean[][] tablero;
    public int cantidadJugadas;



    public PanelTablero(VentanaPrincipal padre){
        setSize(600,600);
        this.padre = padre;
        this.addMouseListener(this);
    }

    public void nuevoPanel(Tablero tableroC){
        this.removeAll();
        this.tablero = tableroC.darTablero();
        this.largo = tablero.length;
        this.cantidades = new int[largo][largo];
        cantidadJugadas = 1;
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        actulizarPanel();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
        int sdisx = (getWidth()-la*largo)/2;
        int disy = (getHeight()-la*largo)/2;
        
		//ImageIcon imageIcon = new ImageIcon(new ImageIcon("./data/luz.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
        for (int i = 0; i < largo; i++) {
            int disx = sdisx;
            for (int ii = 0; ii < largo; ii++) {
                
                Color colorCaja;
                if (tablero[i][ii]) {
                    
                    colorCaja= Color.YELLOW;
                    //tablero[i][ii].setIcon(imageIcon);
                }else{
                    colorCaja= Color.BLUE;
                }

                //g2d.setPaint(gp);
                g2d.setPaint(colorCaja);
                g2d.fillRoundRect(disx,disy,la,la,20,20);
                
                //g2d.setColor(colorT);
                g2d.drawString(String.valueOf(cantidades[i][ii]),disx +(int)(la*0.1),disy+(int)(la*0.1));

                disx += la;
            }
            disy += la;
        }
    }
    public void actulizarPanel(){
        repaint();
    }
@Override
    public void mouseClicked(MouseEvent e) {
         int click_x = e.getX();
         int click_y = e.getY();
         int[] casilla = convertirCoordenadasACasilla(click_x, click_y);

         cantidades[casilla[0]][casilla[1]]++;
         padre.Jugar(casilla[0], casilla[1]);
         cantidadJugadas +=1;
         
         repaint();
    }

	private int[] convertirCoordenadasACasilla(int x, int y)
	{

		int ladoTablero = tablero.length; int altoPanelTablero = getHeight(); int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero; int anchoCasilla = anchoPanelTablero / ladoTablero; int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

}
