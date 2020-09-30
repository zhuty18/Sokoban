package mySokoban;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.*;

import sun.security.action.PutAllAction;

public class MainFrame extends JFrame implements KeyListener{
	SokobanMap myMap;
	MyPanel mPanel;
	JMenuBar menubar;
	JMenu menu1,menu2,menu3,menu4;
	JMenuItem item1,item2,item3,item4,item5;
	
	MainFrame(String s){
		super();
		myMap=new SokobanMap();
		mPanel=new MyPanel(myMap);
		Container con=getContentPane();
		this.add(mPanel);
		this.addKeyListener(this);
		setTitle(s);
		setSize(myMap.width*BoxPanel.WIDTH+30,myMap.height*BoxPanel.HEIGHT+30);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) ((screenSize.getWidth()-getWidth())/2),(int) ((screenSize.getHeight()-getHeight())/2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		/*menubar=new JMenuBar();
		menu1=new JMenu("文件(F)");
		menu1.setMnemonic('F');
		menu2=new JMenu("编辑(E)");
		menu2.setMnemonic('F');
		menu3=new JMenu("查看(V)");
		menu3.setMnemonic('V');
	
		menu4=new JMenu("打开(O)");
		menu4.setMnemonic('O');
	
	
		item2=new JMenuItem("保存",new ImageIcon("save.gif"));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		item3=new JMenuItem("复制",new ImageIcon("copy.gif"));
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		item4=new JMenuItem("停止",new ImageIcon("stop.gif"));
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK));
		item5=new JMenuItem("刷新",new ImageIcon("Snew.gif"));
		item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
	
	
		menu1.add(menu4);
		menu4.add(new JMenuItem("打开x",new ImageIcon("open.gif")));
		menu4.add(new JMenuItem("打开y",new ImageIcon("open.gif")));
		menu1.addSeparator();
		menu1.add(item2);
		menu2.add(item3);
		menu3.add(item4);
		menu3.add(item5);
	
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
	
	
		setJMenuBar(menubar);*/
		validate();
	}
	public void makeMove(char dir) {
		System.out.println(dir);
		myMap.makeMove(dir);
		myMap.printMat();
		mPanel.repaint();
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
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {}
}
