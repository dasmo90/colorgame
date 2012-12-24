package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import model.Board;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	public MainView(Board board) {
		
		super("Game");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		BoardView boardView = new BoardView(board, new Dimension(300,300));
		this.add(boardView);
		
		this.setVisible(true);
	}
}
