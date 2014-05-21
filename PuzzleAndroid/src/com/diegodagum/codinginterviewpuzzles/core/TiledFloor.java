package com.diegodagum.codinginterviewpuzzles.core;

/**
 * @author diegum
 * This class has a method, {@link #calculateWaysToTileFloorForWidth(int)}, that
 * returns the number of ways to tile a floor of dimensions 2 x W with tiles of 
 * dimensions 2 x 1.
 */
public class TiledFloor {
	
	public static long calculateWaysToTileFloorForWidth(int width) {
		if (width < 1) throw new RuntimeException("Input must be equal or greater"+
				" than 1.");
		
		long ret = 0;
		
		int vertical = width / 2;
		for (int horizontal = (width % 2); 
				horizontal <= width;
				horizontal+= 2, --vertical) {
			long partial = 1;
			int base = Math.max(horizontal, vertical);
			
			for (long i = base + 1; i <= (horizontal + vertical); ++i) {
				partial*= i;
			}
			
			for (long i = 2; i <= Math.min(horizontal, vertical); ++i) {
				partial/= i;
			}
			
			ret+= partial;
		}
		
		return ret;
	}
	
}

