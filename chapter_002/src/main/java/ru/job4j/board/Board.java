package ru.job4j.board;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Board {
	
	private final Figure[] figures = new Figure[32];
	private int position = 0;

	public void add(Figure figure) {
		figures[position++] = figure;
	}
	
	public boolean move(Cell source, Cell dest)
		throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
			if (getFigure(source) == null) {
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
			if (getFigure(c) == null) {
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

	public Figure[] getFigures() {
		return figures;
	}
}
		