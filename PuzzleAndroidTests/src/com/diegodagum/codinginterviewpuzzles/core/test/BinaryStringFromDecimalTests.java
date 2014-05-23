package com.diegodagum.codinginterviewpuzzles.core.test;

import com.diegodagum.codinginterviewpuzzles.core.NumberUtils;
import com.diegodagum.codinginterviewpuzzles.core.NumberUtils.Endianness;

import junit.framework.TestCase;

public class BinaryStringFromDecimalTests extends TestCase {

	public void testBinaryStringFromDecimal() {
		assertEquals("10110", NumberUtils.binaryStringFromDecimal(22));
		assertEquals("01101", NumberUtils.binaryStringFromDecimal(22, 
				Endianness.LITTLE_ENDIAN));

		assertEquals("111", NumberUtils.binaryStringFromDecimal(7));
		assertEquals("1000", NumberUtils.binaryStringFromDecimal(8));
		assertEquals("1001", NumberUtils.binaryStringFromDecimal(9));
		
		assertEquals("11111", NumberUtils.binaryStringFromDecimal(31));
		assertEquals("000001", NumberUtils.binaryStringFromDecimal(32, 
				Endianness.LITTLE_ENDIAN));
		
		assertEquals("0", NumberUtils.binaryStringFromDecimal(-31));
		assertEquals("0", NumberUtils.binaryStringFromDecimal(0));
		assertEquals("1", NumberUtils.binaryStringFromDecimal(1));
	}
}
