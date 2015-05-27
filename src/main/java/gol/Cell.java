package gol;

import java.util.HashSet;
import java.util.Set;

public class Cell {

	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Cell))
			return false;

		Cell c = (Cell) o;
		return this.x == c.x && this.y == c.y;
	}

	public boolean isNeighbor(Cell liveCell) {
		if (this.equals(liveCell))
			return false;

		int thisx = this.x;
		int thisy = this.y;
		int thatx = liveCell.x;
		int thaty = liveCell.y;

		// check left and right
		if (thisx == thatx) {
			return thaty == thisy - 1 || thaty == thisy + 1;
		// check above and below
		} else if (thisy == thaty) {
			return thatx == thisx - 1 || thatx == thisx + 1;
		}

		// check diagonals
		return (thisx == thatx - 1 || thisx == thatx + 1) && (thaty == thisy - 1 || thaty == thisy + 1);
	}
	
	/**
	 * Returns LIVE and DEAD cells that are neighbors to this cell.
	 * @return
	 */
	public Set<Cell> getNeighbors() {
		Set<Cell> neighbors = new HashSet<Cell>();
		neighbors.add(new Cell(this.x - 1, this.y + 1));
		neighbors.add(new Cell(this.x - 1, this.y));
		neighbors.add(new Cell(this.x - 1, this.y - 1));
		neighbors.add(new Cell(this.x, this.y + 1));
		neighbors.add(new Cell(this.x, this.y - 1));
		neighbors.add(new Cell(this.x + 1, this.y + 1));
		neighbors.add(new Cell(this.x + 1, this.y));
		neighbors.add(new Cell(this.x +1, this.y - 1));
		return neighbors;
	}
}
