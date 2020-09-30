package mySokoban;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private SokobanMap sMap;
	public MyPanel(SokobanMap m) {
		sMap=m;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(sMap.level<=SokobanMap.LEVEL_MAX) {
			Image img=Toolkit.getDefaultToolkit().getImage("images/background.png");
			g.drawImage(img, 0, 0, sMap.width*Box.WIDTH,sMap.height*Box.HEIGHT,this);
			for(int i:sMap.myMap.keySet()) {
				Box box=sMap.myMap.get(i);
				if(box!=null) {
					int type=box.getType();
					img=Toolkit.getDefaultToolkit().getImage("images/"+type+".png");
					g.drawImage(img, (box.x-1)*Box.WIDTH, (box.y-1)*Box.HEIGHT, Box.WIDTH, Box.HEIGHT, this);
				}
			}
			Box box=sMap.player;
			img=Toolkit.getDefaultToolkit().getImage("images/"+box.getType()+".png");
			g.drawImage(img, (box.x-1)*Box.WIDTH, (box.y-1)*Box.HEIGHT, Box.WIDTH, Box.HEIGHT, this);
		}
		else {
			Image img=Toolkit.getDefaultToolkit().getImage("images/win.png");
			g.drawImage(img, 0, 0, sMap.width*Box.WIDTH,sMap.height*Box.HEIGHT,this);
		}
	}
}
