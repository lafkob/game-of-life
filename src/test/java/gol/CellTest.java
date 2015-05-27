package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CellTest {
	
	@Test
	public void hashCodeTest(){
		Cell a = new Cell(5,5);
		Cell b = new Cell(5,5);
		Set<Cell> test = new HashSet<Cell>();
		test.add(a);
		assertFalse(test.add(b));
	}

	@Test
	public void stringIsNotACell(){
		Cell c = new Cell(1,2);
		assertFalse(c.equals("this is a string"));
	}
	
	@Test
	public void testNeighbors() {
		Cell mainCell = new Cell(5,4);
		
		Cell topLeft = new Cell(4,5);
		assertTrue(mainCell.isNeighbor(topLeft));
		
		Cell left = new Cell(4,4);
		assertTrue(mainCell.isNeighbor(left));
		
		Cell bottomLeft = new Cell(4,3);
		assertTrue(mainCell.isNeighbor(bottomLeft));
		
		Cell above = new Cell(5,5);
		assertTrue(mainCell.isNeighbor(above));
		
		Cell below = new Cell(5,3);
		assertTrue(mainCell.isNeighbor(below));
		
		Cell topRight = new Cell(6,5);
		assertTrue(mainCell.isNeighbor(topRight));
		
		Cell right = new Cell(6,4);
		assertTrue(mainCell.isNeighbor(right));
		
		Cell bottomRight = new Cell(6,3);
		assertTrue(mainCell.isNeighbor(bottomRight));
	}
	
	@Test
	public void testNonNeighbors() {
		Cell mainCell = new Cell(5,4);
		
		Cell notANeighbor = new Cell(10, 11);
		assertFalse(mainCell.isNeighbor(notANeighbor));
		
		Cell sameX = new Cell(5,2);
		assertFalse(mainCell.isNeighbor(sameX));

		Cell sameY = new Cell(7,4);
		assertFalse(mainCell.isNeighbor(sameY));
	}
}
