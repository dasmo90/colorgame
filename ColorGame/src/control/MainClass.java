package control;

import java.awt.Color;

import view.MainView;

import model.Board;

public class MainClass {

	public static void main(String [] args) {
		
		Color [] [] colors = {
				{Color.BLUE, Color.RED, Color.GREEN},
				{Color.WHITE, Color.YELLOW, Color.ORANGE},
				{Color.WHITE, Color.YELLOW, Color.GREEN},
		};
		
		Board b = new Board(colors);

		new MainView(b);
	}
}
