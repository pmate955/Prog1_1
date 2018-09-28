package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Map.GameMap;

public class GameFrame extends JFrame implements ActionListener {
	
	private JLabel[][] labels;
	private GameMap map;
	private int size;
	private ImageIcon dirt;
	private ImageIcon rock;
	private ImageIcon water;
	private ImageIcon robot;
	private ImageIcon station;
	private ImageIcon rail;
	
	public GameFrame(int size){
		this.setTitle("Jatekunk");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		this.labels = new JLabel[size][size];
		this.size = size;
		
		try {
			this.dirt = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/dirt.PNG")));
			this.rock = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/rock.PNG")));
			this.water = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/water.PNG")));
			this.robot = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/robot.PNG")));
			this.station = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/station.PNG")));
			this.rail = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Icons/rail.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(generateGamePanel(), BorderLayout.CENTER);
		this.add(generateButtons(),BorderLayout.SOUTH);
		this.map =  new GameMap(size);
		this.draw();
		this.setVisible(true);
		
		this.pack();
	}

	private JPanel generateButtons() {
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		JButton up = new JButton("UP");
		JButton down = new JButton("Down");
		JButton left = new JButton("Left");
		JButton right = new JButton("Right");
		JButton dinamite = new JButton("Dinamite");
		JButton bridge = new JButton("Bridge");
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		up.setActionCommand("up");
		down.setActionCommand("down");
		left.setActionCommand("left");
		right.setActionCommand("right");
		
		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		dinamite.addActionListener(this);
		bridge.addActionListener(this);
		start.addActionListener(this);
		stop.addActionListener(this);
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		jp.add(dinamite);
		jp.add(bridge);
		jp.add(start);
		jp.add(stop);
		return jp;
	}

	private JPanel generateGamePanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(6,6));
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				JLabel actual = new JLabel();
				labels[x][y] = actual;				
				jp.add(actual);
			}
		}
		
		return jp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton act = (JButton)e.getSource();
		System.out.println(act.getActionCommand());
		String cmd = act.getActionCommand();
		if(cmd.equals("up")){
			if(map.doStep(cmd)){
				System.out.println("Lefutott");
			} else {
				System.out.println("Nem");
			};
		} else if(cmd.equals("down")){
			
		}
		this.draw();
	}
	
	public void draw(){
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				int actual = map.map[x][y];
				if(actual==1){
					labels[x][y].setIcon(dirt);
				} else if(actual == 2){
					labels[x][y].setIcon(rock);
				} else if(actual == 3){
					labels[x][y].setIcon(water);
				} else if(actual == 5){
					labels[x][y].setIcon(robot);
				} else if(actual == 10){
					labels[x][y].setIcon(station);
				} else if(actual == 15){
					labels[x][y].setIcon(rail);
				}
			}
		}
		this.repaint();	
	}

}
