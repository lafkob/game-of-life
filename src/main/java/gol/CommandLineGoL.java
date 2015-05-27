package gol;

import java.util.HashSet;
import java.util.Set;

public class CommandLineGoL {

	public static void main(String[] args) throws InterruptedException {
		Set<Cell> startingPopulation = getBeacon();
		Board b = new Board(startingPopulation);
		printSixBySixBoard(b);
		while(true) {
			Thread.sleep(500);
			b = b.nextGeneration();
			System.out.println("");
			System.out.println("************************************************************");
			printSixBySixBoard(b);			
		}
	}
	
	private static void printSixBySixBoard(Board b) {
		for(int y = 5; y >= 0; y--) {
			for(int x = 0; x <= 5; x ++) {
				Cell cell = new Cell(x,y);
				System.out.print(" ");
				if(b.getLiveCells().contains(cell)) {
					System.out.print("O");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	private static Set<Cell> getToad() {
		Set<Cell> startingPopulation = new HashSet<Cell>();
		startingPopulation.add(new Cell(1,2));
		startingPopulation.add(new Cell(2,2));
		startingPopulation.add(new Cell(3,2));
		startingPopulation.add(new Cell(2,3));
		startingPopulation.add(new Cell(3,3));
		startingPopulation.add(new Cell(4,3));
		return startingPopulation;
	}
	
	private static Set<Cell> getBeacon() {
		Set<Cell> startingPopulation = new HashSet<Cell>();
		startingPopulation.add(new Cell(1,3));
		startingPopulation.add(new Cell(1,4));
		startingPopulation.add(new Cell(2,3));
		startingPopulation.add(new Cell(2,4));
		startingPopulation.add(new Cell(3,1));
		startingPopulation.add(new Cell(3,2));
		startingPopulation.add(new Cell(4,1));
		startingPopulation.add(new Cell(4,2));
		return startingPopulation;
	}
}
