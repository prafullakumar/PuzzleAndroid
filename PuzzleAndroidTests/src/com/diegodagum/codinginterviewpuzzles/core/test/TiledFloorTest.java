package com.diegodagum.codinginterviewpuzzles.core.test;

import com.diegodagum.codinginterviewpuzzles.core.TiledFloor;

import junit.framework.TestCase;

/**
 * @author diegum
 * Unit tests for {@link TiledFloor#calculateWaysToTileFloorForWidth(int)}.
 */
public class TiledFloorTest extends TestCase {

	public void testHappyPath() {
		assertEquals(1, TiledFloor.calculateWaysToTileFloorForWidth(1));
		assertEquals(2, TiledFloor.calculateWaysToTileFloorForWidth(2));
		assertEquals(3, TiledFloor.calculateWaysToTileFloorForWidth(3));
		assertEquals(5, TiledFloor.calculateWaysToTileFloorForWidth(4));
		assertEquals(8, TiledFloor.calculateWaysToTileFloorForWidth(5));
		assertEquals(13, TiledFloor.calculateWaysToTileFloorForWidth(6));
		assertEquals(21, TiledFloor.calculateWaysToTileFloorForWidth(7));
		assertEquals(34, TiledFloor.calculateWaysToTileFloorForWidth(8));
		assertEquals(55, TiledFloor.calculateWaysToTileFloorForWidth(9));
		assertEquals(89, TiledFloor.calculateWaysToTileFloorForWidth(10));
	}
	
	public void testNullInput() {
		try {
			TiledFloor.calculateWaysToTileFloorForWidth(0);
			fail("Expected failure for input 0.");
		} catch (RuntimeException e) {
			// success
		}
	}
	
	public void testInvalidData() {
		try {
			TiledFloor.calculateWaysToTileFloorForWidth(-1);
			fail("Expected failure for negative data.");
		} catch (RuntimeException e) {
			// success
		}

		try {
			TiledFloor.calculateWaysToTileFloorForWidth(-1000000);
			fail("Expected failure for negative data.");
		} catch (RuntimeException e) {
			// success
		}
	}
	
	public void testInsanelyBigOutput() {
		long i = 55, j = 89;
		
		for (int k = 11; k <= 43; ++k) {
			assertEquals(i + j, TiledFloor.calculateWaysToTileFloorForWidth(k));
			// i becomes j, j becomes i+j
			i = (j = i + j) - i;
		}
	}

}
