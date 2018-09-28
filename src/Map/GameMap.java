package Map;

import java.awt.Point;
import java.io.*;
import java.net.URISyntaxException;

public class GameMap {

	public int[][] map;			//1- sima, 2- szikla, 3- viz, 5 - robot, 10 - allomas, 15 - sin
	private int size;
	private Point robot;
	
	public GameMap(int size) {
		this.size = size;
		this.map = new int[size][size];
		this.robot = new Point(0,0);
		this.readMap();
	}
	
	public void generate(){
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				int random = (int)(Math.random()*3)+1;
				map[x][y] = random;
			}
		}
		this.printMap();
	}
	
	public void printMap(){
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){				
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	public void readMap(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(this.getClass().getResource("/Levels/lvl1.txt").toURI())));
			String s = br.readLine();
			int row = 0;
			while(s != null){
				String[] d = s.split(" ");
				for(int i = 0; i < d.length; i++){
					int act = Integer.parseInt(d[i]);
					map[row][i] = act;
					if(act == 5){
						this.robot.setLocation(row, i);
					}
				}
				s = br.readLine();
				row++;
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			
		}
	}
	
	public boolean doStep(String direction){
		int x = robot.x;
		int y = robot.y;
		if(direction.equals("up")){
			if(x > 0){
				if(map[x-1][y] == 1 || map[x-1][y] == 10){
					map[x][y] = 15;
					map[x-1][y] = 5;
					robot.x--;
				} else return false;
			} else return false;
		}
		return true;
	}
	
}
