package model;

import java.awt.Color;

public class Field {

	private Color color;

	public Field(Color c) {

		color = c;

	}
	
	public Color getColor() {
		
		return color;
	}
	
	public String toString() {
		
		return color.toString();
	}

}
