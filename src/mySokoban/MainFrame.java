package mySokoban;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame {
	SokobanMap myMap;
	JMenuBar menubar;
	JMenu menu1,menu2,menu3,menu4;
	JMenuItem item1,item2,item3,item4,item5;
	
	MainFrame(String s){
		myMap=new SokobanMap();
		setTitle(s);
		setSize(400,300);
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
}
