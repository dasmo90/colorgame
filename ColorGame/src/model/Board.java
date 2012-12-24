package model;

import java.awt.Color;
import java.awt.Dimension;

public class Board {

	private Field[][] fields;
	private Dimension dim;

	public Board(Color[][] colors) {

		int y = colors.length;
		int x = colors[0].length;

		dim = new Dimension(x, y);

		fields = new Field[y][x];

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {

				fields[i][j] = new Field(colors[i][j]);

			}
		}
	}

	public Dimension getDimension() {

		return dim;
	}

	public void moveRow(int i, int l) {

		if (i >= dim.height || i < 0) {

			throw new IndexOutOfBoundsException("Illegal index of rows: " + i
					+ ", only values from 0 to " + (dim.height - 1) + " are valid.");
		}
		
		while(l < 0) {
			
			l += dim.width;
		}
		
		l = l % dim.width;
		
		for(int k = 0;k < l;k++) {
			
			pushRow(i);
		}
		
	}
	
	private void pushRow(int i) {

		Field temp = fields[i][dim.width - 1];
		
		for(int k = dim.width - 1;k > 0;k--) {
			
			fields[i][k] = fields[i][k-1];
		}
		
		fields[i][0] = temp;
		
	}
	
	public void moveColumn(int i, int l) {

		if (i >= dim.width || i < 0) {

			throw new IndexOutOfBoundsException("Illegal index of rows: " + i
					+ ", only values from 0 to " + (dim.width - 1) + " are valid.");
		}
		
		while(l < 0) {
			
			l += dim.height;
		}
		
		l = l % dim.height;
		
		for(int k = 0;k < l;k++) {
			
			pushColumn(i);
		}
		
	}
	
	private void pushColumn(int i) {

		Field temp = fields[dim.height - 1][i];
		
		for(int k = dim.height - 1;k > 0;k--) {
			
			fields[k][i] = fields[k-1][i];
		}
		
		fields[0][i] = temp;
		
	}
	
	public String toString() {
		
		String s = "";
		
		for (int i = 0; i < dim.height; i++) {
			for (int j = 0; j < dim.width; j++) {

				s += fields[i][j].toString() + " ";

			}
			
			s += "\n";
		}
		return s;
	}

	public Color getColorAt(int x, int y) {

		return fields[x][y].getColor();
	}

}
