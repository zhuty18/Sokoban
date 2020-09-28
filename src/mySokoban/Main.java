package mySokoban;

import java.util.Scanner;

public class Main {
	public static void main(String... argv) {
		//MainFrame win=new MainFrame("数独游戏");
		SokobanMap myMap=new SokobanMap();
		myMap.printMat();
		Scanner cin=new Scanner(System.in);
		while(true) {
			char k=cin.next().charAt(0);
			if(k=='u'||k=='d'||k=='l'||k=='r') {
				myMap.makeMove(k);
				myMap.printMat();
			}
			else if(k=='q') {
				break;
			}
		}
	}
}
