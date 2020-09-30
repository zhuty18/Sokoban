package mySokoban;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BoxPanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	final static int WIDTH=50;
	final static int HEIGHT=WIDTH;
	private Box box;
	int x0,y0,xt,yt;
	int x,y;
	
	BoxPanel(Box b){
		box=b;
		x0=(box.x-1)*WIDTH;
		y0=(box.y-1)*HEIGHT;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int type=box.getType();
		Image img=Toolkit.getDefaultToolkit().getImage("images/"+type+".png");
		g.drawImage(img, x, y, WIDTH, HEIGHT, null);
	}

	@Override
	public void run() {
		xt=(box.x-1)*WIDTH;
		yt=(box.y-1)*HEIGHT;
		for(int i=0;i<10;i++) {
			x=(x0*i+xt*(9-i))/9;
			y=(y0*i+yt*(9-i))/9;
			this.repaint();
			try {
				wait(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
