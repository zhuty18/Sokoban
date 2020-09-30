package mySokoban;

public abstract class Box extends Thread {
	static final int numFloor=-1;
	static final int numPlayer=0;
	static final int numDoor=1;
	static final int numSquare=2;
	static final int numWall=3;
	static final int numHole=4;
	static final int numFill=5;
	static SokobanMap sMap;
	int x,y;
	Box(int i,int j){
		x=i;
		y=j;
	}
	protected abstract int getType();
	protected boolean move(char dir) {return false;}
	protected void fill() {}
}

class Player extends Box{
	
	Player(int i, int j) {
		super(i, j);
	}
	
	@Override
	protected int getType() {
		return Box.numPlayer;
	}
	
	@Override
	protected boolean move(char dir) {
		int xt=x,yt=y;
		switch (dir) {
			case 'u':
				yt--;
				break;
			case 'd':
				yt++;
				break;
			case 'l':
				xt--;
				break;
			case 'r':
				xt++;
				break;
		}
		if(xt<1||xt>sMap.width||yt<1||yt>sMap.height) {
			return false;
		}
		else {
			Box box=sMap.getBoxAt(xt,yt);
			if(box==null) {
				sMap.movePlayer(dir);
				return true;
			}
			else if(box.getType()==Box.numSquare) {
				if(box.move(dir)) {
					sMap.movePlayer(dir);
					return true;
				}
				else {
					return false;
				}
			}
			else if(box.getType()==Box.numDoor||box.getType()==Box.numFill) {
				sMap.movePlayer(dir);
				return true;
			}
			else {
				return false;
			}
		}
	}
}

class Square extends Box{

	Square(int i, int j) {
		super(i, j);
	}

	@Override
	protected int getType() {
		return Box.numSquare;
	}
	
	@Override
	protected boolean move(char dir) {
		int xt=x,yt=y;
		switch (dir) {
		case 'u':
			yt--;
			break;
		case 'd':
			yt++;
			break;
		case 'l':
			xt--;
			break;
		case 'r':
			xt++;
			break;
		}
		if(xt<1||xt>sMap.width||yt<1||yt>sMap.height) {
			return false;
		}
		else {
			Box box=sMap.getBoxAt(xt,yt);
			if(box==null) {
				sMap.moveBox(x, y, dir);
				return true;
			}
			else if(box.getType()==Box.numHole) {
				box.fill();
				sMap.removeBox(x,y);
				return true;
			}
			else {
				return false;
			}
		}
	}	
}

class Door extends Box{

	Door(int i, int j) {
		super(i, j);
	}
	
	@Override
	protected int getType() {
		return Box.numDoor;
	}
	
}

class Wall extends Box{

	Wall(int i, int j) {
		super(i, j);
	}

	@Override
	protected int getType() {
		return Box.numWall;
	}

}

class Hole extends Box{
	private boolean filled;
	
	Hole(int i,int j){
		super(i, j);
		filled=false;
	}

	@Override
	protected int getType() {
		if(filled) {
			return Box.numFill;
		}
		else {
			return Box.numHole;
		}
	}
	
	@Override
	protected void fill() {
		filled=true;
	}
}