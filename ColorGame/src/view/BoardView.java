package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import model.Board;

@SuppressWarnings("serial")
public class BoardView extends JPanel implements MouseListener,
		MouseMotionListener {

	private Board board;
	private FieldView[][] fieldViews;

	public BoardView(Board board, Dimension dim) {

		super(null);

		this.board = board;

		this.setPreferredSize(dim);

		int fieldX = (int) (dim.getWidth() / board.getDimension().width);
		int fieldY = (int) (dim.getHeight() / board.getDimension().height);

		fieldViews = new FieldView[board.getDimension().width][board
				.getDimension().height];

		for (int i = 0; i < board.getDimension().width; i++) {
			for (int j = 0; j < board.getDimension().height; j++) {

				fieldViews[i][j] = new FieldView(board, i, j);
				fieldViews[i][j].setBounds(i * fieldX, j * fieldY, fieldX,
						fieldY);
				this.add(fieldViews[i][j]);
			}
		}

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	private void moveRow(int j, int l) {

		for (int i = 0; i < board.getDimension().width; i++) {

			fieldViews[i][j].setPosTemp(l, 0, this.getWidth(), this.getHeight());
		}

	}

	private void moveColumn(int i, int l) {

		for (int j = 0; j < board.getDimension().height; j++) {

			fieldViews[i][j]
					.setPosTemp(0, l, this.getWidth(), this.getHeight());
		}

	}

	private int oldPosX;
	private int oldPosY;

	private boolean shiftingVertical = false;
	private boolean shiftingHorizontal = false;
	
	private boolean shiftingIndex;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {

		if(!shiftingVertical && !shiftingHorizontal) {
			
			if(Math.abs(arg0.getX() - oldPosX) > Math.abs(arg0.getY() - oldPosY)) {
				
				shiftingHorizontal = true;
				
			} else {
				
				shiftingVertical = true;
			}
			
		} else {
			
		}
		
		moveRow(0, arg0.getX() - oldPosX);

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		// nothing to do here

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// nothing to do here

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		oldPosX = e.getX();
		oldPosY = e.getY();

		for (FieldView[] fva : fieldViews) {

			for (FieldView fv : fva) {

				fv.saveOldPos();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		shiftingHorizontal = false;
		shiftingVertical = false;

	}

}
