package mySokoban;

import java.util.HashMap;

public class SokobanMap {
	int level;
	int width;
	int height;
	HashMap<Integer, Box> myMap;
	Box player;
	
	public SokobanMap() {
		myMap=new HashMap<>();
		Box.sMap=this;
		level=0;
		loadGame(level);
	}
	
	private boolean loadGame(int index) {
		width=10;
		height=10;
		myMap.clear();
		player=new Player(1, 1);
		setBoxAt(10, 10, Box.numDoor);
		setBoxAt(5, 5, Box.numSquare);
		setBoxAt(5, 6, Box.numSquare);
		return true;
	}
	
	public boolean makeMove(char dir) {
		if(player.move(dir)) {
			if(getBoxAt(player.x, player.y)!=null&&getBoxAt(player.x, player.y).getType()==Box.numDoor) {
				gameWin();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	protected Box getBoxAt(int x,int y) {
		return myMap.get(location(x, y));
	}
	
	protected void moveBox(int x,int y,char dir) {
		Box box=getBoxAt(x, y);
		//BoxPanel bp=new BoxPanel(box);
		switch(dir) {
			case 'u':
				box.y=box.y-1;
				myMap.put(location(x, y),null);
				myMap.put(location(x, y-1),box);
				break;
			case 'd':
				box.y=box.y+1;
				myMap.put(location(x, y),null);
				myMap.put(location(x, y+1),box);
				break;
			case 'l':
				box.x=box.x-1;
				myMap.put(location(x, y),null);
				myMap.put(location(x-1, y),box);
				break;
			case 'r':
				box.x=box.x+1;
				myMap.put(location(x, y),null);
				myMap.put(location(x+1, y),box);
				break;
		}
		//Thread thread=new Thread(bp);
		//thread.start();
	}
	
	protected void movePlayer(char dir) {
		//BoxPanel bp=new BoxPanel(player);
		switch(dir) {
			case 'u':
				player.y=player.y-1;
				break;
			case 'd':
				player.y=player.y+1;
				break;
			case 'l':
				player.x=player.x-1;
				break;
			case 'r':
				player.x=player.x+1;
				break;
		}
		//Thread thread=new Thread(bp);
		//thread.start();
	}
	
	protected void removeBox(int x,int y) {
		myMap.put(location(x, y), null);
	}
	
	protected void gameWin() {
		System.out.println("Pass");
		//TODO
	}
	
	private int location(int x,int y) {
		return (x-1)*height+y-1;
	}
	
	private void setBoxAt(int x,int y,int t) {
		Box b=null;
		switch(t){
			case Box.numDoor:
				b=new Door(x, y);
				break;
			case Box.numSquare:
				b=new Square(x, y);
				break;
		}
		myMap.put(location(x,y), b);
	}
	
	public void printMat() {
		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {
				Box box=getBoxAt(i+1, j+1);
				int t=9;
				if(box!=null) {
					t=box.getType();
				}
				else if(i+1==player.x&&j+1==player.y) {
					t=0;
				}
				System.out.print(t);
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}
}
