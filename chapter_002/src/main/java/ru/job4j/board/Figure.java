package ru.job4j.board;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public abstract class Figure {
	
	final Cell position;

	Figure(Cell position) {
		this.position = position;
	}
	
	
	abstract Cell[] way(Cell start, Cell dest) throws ImpossibleMoveException;
	
	abstract Figure copy(Cell dest);
}