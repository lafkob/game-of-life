package gol;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testFirstRule_NoNeighbors() {
		Set<Cell> boardCells = new HashSet<Cell>();
		boardCells.add(new Cell(5,4));
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		assertTrue(next.getLiveCells().size() == 0);
	}
	
	@Test
	public void testFirstRule_OneNeighbor() {
		Set<Cell> boardCells = new HashSet<Cell>();
		boardCells.add(new Cell(5,4));
		boardCells.add(new Cell(5,5));
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		assertTrue(next.getLiveCells().size() == 0);
	}
	
	@Test
	public void testSecondRule_TwoNeighbors() {
		Set<Cell> boardCells = new HashSet<Cell>();
		Cell targetCell = new Cell(5,4);
		boardCells.add(targetCell);
		boardCells.add(new Cell(5,3));
		boardCells.add(new Cell(6,5));
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		boolean foundTargetCell = false;
		for(Cell cell : next.getLiveCells()) {
			if(cell.equals(targetCell)) {
				foundTargetCell = true;
				break;
			}
		}
		
		assertTrue(foundTargetCell);
	}
	
	@Test
	public void testSecondRule_ThreeNeighbors() {
		Set<Cell> boardCells = new HashSet<Cell>();
		Cell targetCell = new Cell(5,4);
		boardCells.add(targetCell);
		boardCells.add(new Cell(5,3));
		boardCells.add(new Cell(6,5));
		boardCells.add(new Cell(4,5));
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		boolean foundTargetCell = false;
		for(Cell cell : next.getLiveCells()) {
			if(cell.equals(targetCell)) {
				foundTargetCell = true;
				break;
			}
		}
		
		assertTrue(foundTargetCell);
	}
	
	@Test
	public void testThirdRule() {
		Set<Cell> boardCells = new HashSet<Cell>();
		Cell targetCell = new Cell(5,4);
		boardCells.add(targetCell);
		boardCells.add(new Cell(4,3));
		boardCells.add(new Cell(6,3));
		boardCells.add(new Cell(6,5));
		boardCells.add(new Cell(4,5));
		
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		boolean foundTargetCell = false;
		for(Cell cell : next.getLiveCells()) {
			if(cell.equals(targetCell)) {
				foundTargetCell = true;
				break;
			}
		}
		
		assertFalse(foundTargetCell);
	}
	
	@Test
	public void testFourthRule() {
		Set<Cell> boardCells = new HashSet<Cell>();
		Cell targetCell = new Cell(6,4);
		
		boardCells.add(new Cell(5,4));
		boardCells.add(new Cell(6,3));
		boardCells.add(new Cell(6,5));
		
		
		Board b = new Board(boardCells);
		Board next = b.nextGeneration();
		boolean foundTargetCell = false;
		for(Cell cell : next.getLiveCells()) {
			if(cell.equals(targetCell)) {
				foundTargetCell = true;
				break;
			}
		}
		
		assertTrue(foundTargetCell);
	}
}
