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
			} else if (!(getFigure(source).isMovePossible(source, dest))) {
				throw new ImpossibleMoveException();
			} else if (!isPathClear(getFigure(source).way(source, dest))) {
				throw new OccupiedWayException();
			} else {
				getFigure(source).copy(dest);
			}
		return true;
	}

	/**
	 * Method evaluates whether any of the Cells in the given
	 * array are occupied by a Figure.
	 * @param cells - array to be evaluated
	 * @return boolean result
	 */
	public boolean isPathClear(Cell[] cells) {
		boolean result = true;
		for (Cell c : cells) {
			if (c.isOccupied()) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Method retrieves a figure from a given cell.
	 * @param target - the provided Cell
	 * @return the obtained Figure
	 */
	public Figure getFigure(Cell target) {
		Figure result = null;
		for (Figure fig : this.figures) {
			if (fig.getPosition().equals(target)) {
				result =  fig;
			}
		}
		return result;
	}
}
		