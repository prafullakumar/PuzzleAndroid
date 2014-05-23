package com.diegodagum.codinginterviewpuzzles.core;

/**
 * @author diegum
 * Utilities applicable to numbers (converters, etc.)
 */
public class NumberUtils {

	public enum Endianness {
		BIG_ENDIAN, LITTLE_ENDIAN
	}
	
	/**
	 * Converts a decimal numbers to its binary representation as a String,
	 * using {@link Endianness#BIG_ENDIAN} notation.
	 * @param decimal a positive long integer.
	 * @return its binary representation as a String (0 if the input is 0 or
	 * negative).
	 * @see #binaryStringFromDecimal(long, Endianness)
	 */
	public static String binaryStringFromDecimal(long decimal) {
		return binaryStringFromDecimal(decimal, Endianness.BIG_ENDIAN);
	}
	
	/**
	 * Converts a decimal numbers to its binary representation as a String,
	 * based on the {@link Endianness} notation.
	 * @param decimal a positive long integer.
	 * @param endianness an {@link Endianness} to indicate whether
	 * {@link Endianness#BIG_ENDIAN} or {@link Endianness#LITTLE_ENDIAN}. 
	 * @return its binary representation as a String (0 if the input is 0 or
	 * negative).
	 */
	public static String binaryStringFromDecimal(long decimal, 
			Endianness endianness) {
		// fail-fast
		if (decimal <= 0) return "0";
		
		char[] outputBuffer = 
				new char[(int) (Math.ceil(Math.log(decimal+1)/Math.log(2)))];
		
		int index, gap;
		if (endianness == Endianness.BIG_ENDIAN) {
			index = (outputBuffer.length - 1);
			gap = -1;
		} else {
			index = 0;
			gap = 1;
		}
		
		while (decimal > 0) {
			outputBuffer[index] = ((decimal % 2) == 0) ? '0' : '1';
			decimal/= 2;
			index+= gap;
		}
		
		return new String(outputBuffer);
	}
}
