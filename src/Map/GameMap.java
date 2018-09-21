package Map;

public class GameMap {

	private int[][] map;			//1- sima, 2- szikla, 3- viz, 5 - robot, 10 - allomas
	private int size;
	
	
	public GameMap(int size) {
		this.size = size;
		this.map = new int[size][size];
	}
	
	
	
}
