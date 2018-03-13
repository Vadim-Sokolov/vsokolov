package ru.job4j.board;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Board {
	
	private final Figure[] figures = new Figure[32];
	
	public void add(Figure figure) {
	}
	
	public boolean move(Cell source, Cell dest) 
		throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
			if (!source.isOccupied()) {
			throw new FigureNotFoundException();
			} else if (!(figure.isMovePossible(source, dest))) {
				throw new ImpossibleMoveException();
			} else if (!isPathClear(figure.way(source, dest))) {
				throw new OccupiedWayException();
			} else {
				Figure figure.copy(dest);
			}
		}
}
		