package gol;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Board {
	private Set<Cell> liveCells;
	
	public Board(Set<Cell> cells){
		liveCells = cells;
	}
	
	public Board nextGeneration() {
		Set<Cell> toLive = new HashSet<Cell>();
		
		for(Cell c : liveCells) {
			// rule 1: < 2 neighbors dies
			// rule 2: 2-3 neighbors lives
			// rule 3: > 3 neighbors dies
			int liveNeighborCount = getLiveNeighborCount(c);
			if(liveNeighborCount == 2 || liveNeighborCount == 3){
				toLive.add(c);
			}

			// rule 4: dead w/ three neighbors born
			Set<Cell> deadNeighbors = getDeadNeighbors(c);
			for(Cell deadNeighbor: deadNeighbors) {
				if(getLiveNeighborCount(deadNeighbor) == 3) {
					toLive.add(deadNeighbor);
				}
			}
		}
		
		return new Board(toLive);
	}
	
	private int getLiveNeighborCount(Cell cell) {
		
		int count = 0;
		
		for(Cell liveCell : liveCells) {
			if(cell.equals(liveCell)) continue;
			
			if(cell.isNeighbor(liveCell)) {
				count ++;
			}
		}
		
		return count;
	}
	
	private Set<Cell> getDeadNeighbors(Cell cell) {
		Set<Cell> deadNeighbors = new HashSet<Cell>();
		
		for(Cell neighbor : cell.getNeighbors()) {
			if(!liveCells.contains(neighbor)) {
				deadNeighbors.add(neighbor);
			}
		}
		
		return deadNeighbors;
	}
	
	public Set<Cell> getLiveCells() {
		return Collections.unmodifiableSet(liveCells);
	}
}
