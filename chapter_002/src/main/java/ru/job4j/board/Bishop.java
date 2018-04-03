package ru.job4j.board;

import java.lang.Math;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Bishop extends Figure {
	
	private Cell position;
	
	public Bishop(Cell position) {
		super(position);
	}
	
	public Bishop copy(Cell dest) {
             return new Bishop(dest);
         }
	
	@Override
	public Cell[] way(Cell start, Cell dest) throws ImpossibleMoveException {
		if (isMovePossible(start, dest)) {
		Cell[] result = new Cell[Math.abs(start.getX() - dest.getX())];
		int position = 0;
			for (int i = start.getX() + 1, j = start.getY() + 1; i <= dest.getX(); i++, j++) {
				Cell add = new Cell(i, j);
				result[position++] = add;
			}
			return result;
		} else {
			throw new ImpossibleMoveException();
		}
	}

	@Override
	public boolean isMovePossible(Cell start, Cell dest) {
		return (Math.abs(start.getX() - dest.getX())) == (Math.abs(start.getY() - dest.getY()));
	}
		
	public Cell getPosition() {
		return this.position;
	}
}
					