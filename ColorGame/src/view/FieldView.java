package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Board;

@SuppressWarnings("serial")
public class FieldView extends JPanel {

	private int x;
	private int y;
	private Board board;
	public FieldView(Board board, int i, int j) {
	
		this.board = board;
		x = j;
		y = i;
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		
		g.setColor(board.getColorAt(x,y));
		g.fillRect(2, 2, this.getWidth()-4, this.getHeight()-4);
		
	}
	
	private int oldX;

	private int oldY;

	public void saveOldPos() {

		oldX = this.getX();
		oldY = this.getY();
	}
	
	public void setPosTemp(int x, int y, int maxX, int maxY) {

		int oldWidth = this.getWidth();
		int oldHeight = this.getHeight();

		int halfSizeX = this.getWidth()/2;
		int halfSizeY = this.getHeight()/2;
		
		int newX = (oldX + x) % maxX;
		
		if(oldX + x > maxX - halfSizeX) {
			
			newX = (oldX + x + halfSizeX) % maxX - halfSizeX;
			
		} else if(oldX + x < halfSizeX) {

			newX = (oldX + x + halfSizeX + maxX) % maxX - halfSizeX;
		}
		

		int newY = (oldY + y) % maxY;

		if(oldY + y > maxY - halfSizeY) {
			
			newY = (oldY + y + halfSizeY) % maxY - halfSizeY;
			
		} else if(oldY + x < halfSizeY) {

			newY = (oldY + y + halfSizeY + maxY) % maxY - halfSizeY;
		}
		
		this.setBounds(newX, newY, oldWidth, oldHeight);
	}

	public void saveNewPos() {
		
		
	}

}
