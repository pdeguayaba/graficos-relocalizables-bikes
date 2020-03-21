/*
 * Edwin J. Estrella Ayala
 * A00549508
 * Graficas por Computadoras - COMP 3600 (70858)
 * Asignación - Gráficos Relocalizabes
 */

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Bicicleta {
	//P         P0   P1   P2   P3   P4   P5   P6   P7   P8   P9  P10  P11  P12  P13  P14  P15  P16  P17  P18  P19  P20  P21  P22  P23  P24  P25  P26  P27  P28  P29  P30  P31  P32  P33  P34  P35  P36                                            
	int x[] = {300, 325, 300, 325, 312, 231, 296, 231, 296, 263, 338, 403, 338, 403, 371, 303, 322, 303, 322, 312, 247, 280, 247, 280, 264, 354, 387, 354, 387, 371, 312, 362, 264, 312, 350, 364, 357};
	int y[] = {300, 300, 309, 309, 304, 334, 334, 399, 399, 365, 334, 334, 399, 399, 365, 356, 356, 375, 375, 365, 349, 349, 382, 382, 365, 349, 349, 382, 382, 365, 316, 316, 365, 365, 305, 286, 296};
	Color sitColor = new Color(185, 122, 87);
	Color intWheelColor = Color.GREEN;
	Color outWheelColor = Color.RED;
	Color pedalera = Color.GRAY;
	Color marco = Color.BLACK;
	
	Bicicleta() {
		 /* Default Constructor */
	}

	public Bicicleta(int[] x, int[] y, Color sitColor, Color intWheelColor, Color outWheelColor) {
		super();
		this.x = x;
		this.y = y;
		setSitColor(sitColor);
		setIntWheelColor(intWheelColor);
		setOutWheelColor(outWheelColor);
	}
	
	Bicicleta(int dx, int dy, Color sitColor, Color intWheelColor, Color outWheelColor) {
		setPosition(dx, dy);
		setSitColor(sitColor);
		setIntWheelColor(intWheelColor);
		setOutWheelColor(outWheelColor);
	}
	
	void draw(Graphics2D g) {
		g.setColor(marco);
//		/* Sillin */
//		g.drawOval(x[0], y[0], (x[1] - x[0]), (y[2] - y[0]));
		g.drawLine(x[4], y[4], x[19], y[19]);
		
		/* Manublio */
		g.drawLine(x[34], y[34], x[35], y[35]);
		g.drawLine(x[36], y[36], x[29], y[29]);
		
//		/* Rueda Trasera */
//		g.drawOval(x[5], y[5], (x[6] - x[5]), (y[7] - y[5]));
//		g.drawOval(x[20], y[20], (x[21] - x[20]), (y[22] - y[20]));
		
//		/* Rueda Frontal */
//		g.drawOval(x[10], y[10], (x[11] - x[10]), (y[12] - y[10]));
//		g.drawOval(x[25], y[25], (x[26] - x[25]), (y[27] - y[25]));
		
//		/* Pedalera */
//		g.drawOval(x[15], y[15], (x[16] - x[15]), (y[17] - y[15]));
		
		/* Marco */
		/* Horizontal */
		g.drawLine(x[30], y[30], x[31], y[31]);
		g.drawLine(x[32], y[32], x[33], y[33]);
		/* Diagonal */
		g.drawLine(x[32], y[32], x[30], y[30]);
		g.drawLine(x[33], y[33], x[31], y[31]);
	}
	
	void fill(Graphics2D g) {
		/* Sillin */
		g.setColor(sitColor);
		g.fillOval(x[0], y[0], (x[1] - x[0]), (y[2] - y[0]));
		
		/* Ruedas Exterior */
		g.setColor(outWheelColor);
		g.fillOval(x[5], y[5], (x[6] - x[5]), (y[7] - y[5]));
		g.fillOval(x[10], y[10], (x[11] - x[10]), (y[12] - y[10]));
		
		/* Ruedas Interior */
		g.setColor(intWheelColor);
		g.fillOval(x[20], y[20], (x[21] - x[20]), (y[22] - y[20]));
		g.fillOval(x[25], y[25], (x[26] - x[25]), (y[27] - y[25]));
		
		g.setColor(pedalera);
		g.fillOval(x[15], y[15], (x[16] - x[15]), (y[17] - y[15]));
	}
	
	void setPosition(int dx, int dy) {
		for (int i = 0; i < x.length; i++) {
			x[i] = x[i] + dx;
			y[i] = y[i] + dy;
		}
	}
	
	void moveDown(int dy) {
		for (int i = 0; i < x.length; i++) {
			y[i] = y[i] + dy;
		}
	}
	
	public Color getSitColor() {
		return sitColor;
	}

	public void setSitColor(Color sitColor) {
		this.sitColor = sitColor;
	}

	public Color getIntWheelColor() {
		return intWheelColor;
	}

	public void setIntWheelColor(Color intWheelColor) {
		this.intWheelColor = intWheelColor;
	}

	public Color getOutWheelColor() {
		return outWheelColor;
	}

	public void setOutWheelColor(Color outWheelColor) {
		this.outWheelColor = outWheelColor;
	}
}

class GraphicComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		/* Aqui se muestra el funcionamiento del Constructor por defecto */
		Bicicleta bici1 = new Bicicleta();
		bici1.draw(g2);
		bici1.fill(g2);
		
		/* Se crea una bicicleta con el Constructor por defecto
		 * Se le cambia la posicion con el metodo setPosition()
		 * Se le cambian los colores del asiento, y  el interior de la rueda
		 * utilizando los metodos setSitColor() y setIntWheelColor() respectivamente. 
		 */
		Bicicleta bici2 = new Bicicleta();
		bici2.setPosition(180, -50);
		bici2.setSitColor(Color.CYAN);
		bici2.setIntWheelColor(Color.YELLOW);
		bici2.draw(g2);
		bici2.fill(g2);
		
		/* Se crea una bicicleta con el Constructor por parametros
		 * se le envia las coordenadas en donde se quiere poner la bicicleta
		 * y los colores del asiento, ruedas interiores y ruedas interiores.
		 */
		Color brown = new Color(185, 122, 87);
		Bicicleta bici3 = new Bicicleta(115, 100, Color.BLACK, Color.BLUE, brown);
		bici3.draw(g2);
		bici3.fill(g2);
		
		Bicicleta bici4 = new Bicicleta(350, 0, Color.MAGENTA, Color.GREEN, Color.BLUE);
		bici4.draw(g2);
		bici4.fill(g2);
		
	}
}

class DynamicBicicleta {
	public static void main(String[] args) {
		JFrame marco = new JFrame("Marco");
		marco.setSize(1600, 900);
		marco.setTitle("Graficos Relocalizables");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		GraphicComponent grafico = new GraphicComponent();
		marco.add(grafico);
	}
}
