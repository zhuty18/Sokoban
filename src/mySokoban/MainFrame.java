package mySokoban;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class MainFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	SokobanMap myMap;
	MyPanel mPanel;
	
	MainFrame(String s){
		super();
		myMap=new SokobanMap();
		mPanel=new MyPanel(myMap);
		this.add(mPanel);
		this.addKeyListener(this);
		setTitle(s);
		setSize(myMap.width*Box.WIDTH+16,myMap.height*Box.HEIGHT+39);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((screenSize.getWidth()-getWidth())/2),(int) ((screenSize.getHeight()-getHeight())/2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	public void makeMove(char dir) {
		myMap.makeMove(dir);
		mPanel.repaint();
	}
	
	public void resetLevel() {
		myMap.reload();
		mPanel.repaint();
	}
	
	public void getHelp() {
		String message="WASD/方向键移动\nR重置进程\nH打开帮助页面";
		JOptionPane.showMessageDialog(this, message, "Tips", JOptionPane.PLAIN_MESSAGE);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			makeMove('u');
			break;
		case KeyEvent.VK_UP:
			makeMove('u');
			break;
		case KeyEvent.VK_A:
			makeMove('l');
			break;
		case KeyEvent.VK_LEFT:
			makeMove('l');
			break;
		case KeyEvent.VK_S:
			makeMove('d');
			break;
		case KeyEvent.VK_DOWN:
			makeMove('d');
			break;
		case KeyEvent.VK_D:
			makeMove('r');
			break;
		case KeyEvent.VK_RIGHT:
			makeMove('r');
			break;
		case KeyEvent.VK_R:
			resetLevel();
			break;
		case KeyEvent.VK_H:
			getHelp();
			break;
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {}
}
