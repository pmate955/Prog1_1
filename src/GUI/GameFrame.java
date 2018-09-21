package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener {
	
	private JLabel[][] labels;
	
	public GameFrame(){
		this.setTitle("Jatekunk");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		this.labels = new JLabel[6][6];
		this.add(generateGamePanel(), BorderLayout.CENTER);
		this.add(generateButtons(),BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private JPanel generateButtons() {
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		JButton up = new JButton("UP");
		JButton down = new JButton("Down");
		JButton left = new JButton("Left");
		JButton right = new JButton("Right");
		up.setActionCommand("up");
		down.setActionCommand("down");
		up.addActionListener(this);
		down.addActionListener(this);
		jp.add(up);
		jp.add(down);
		return jp;
	}

	private JPanel generateGamePanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(6,6));
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				JLabel actual = new JLabel("0");
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
		
	}

}
