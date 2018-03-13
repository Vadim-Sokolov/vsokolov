package ru.job4j.board;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Cell {
	
	private int x;
	private int y;
	private boolean occupied;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Cell(int x, int y, boolean occupied) {
		this.x = x;
		this.y = y;
		this.occupied = occupied;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
}