package dataTypeDemo;

public class DataTypeDemo {
	
	/*
	 * Primitive Data Types
	 * Type:		bits:		min - max-Value:	unsigned-Value
	 * byte			8-bit		-128 - 127
	 * short		16-bit		-32768 - 32767
	 * int			32-bit		-2^31 - 2^31-1
	 * long(int)	64-bit		-2^63 - 2^63-1		0 - 2^64-1
	 * float		32-bit IEEE 754 floating point
	 * double		64-bit IEEE 754 floating point
	 * boolean		1-bit		true - false
	 * char			16-bit 		'\u0000' - '\uffff' (65535)
	 * 	 		
	 */
	
	
	byte byteType;
	short shortType;
	int intType;
	long longType;
	float floatType;
	double doubleType;
	char charType;
	String stringType;
	boolean booleanType;
	
	int decVal = 26;
	int hexVal = 0x1a;
	int binVal = 0b11010;
	
	char character = 'C';
	char charUnicodeEscape = '\u0108';
	
	long underscoreLong = 1234_5678_9012_3456L;
	float pi = 3.14_15F;
	float f1 = 1.2345675f*254.4865482f;
	
	public void showDataTypes() {
		
		System.out.println(
				"byte: " + byteType +"\n"+
				"short: " + shortType+"\n"+
				"int: " + intType+"\n"+
				"long: " + longType+"\n"+
				"float: " + floatType+"\n"+
				"double: " + doubleType+"\n"+
				"char: " + charType+"\n"+
				"string: " + stringType+"\n"+
				"boolean: " + booleanType+"\n"+
				"decimal int: "+ decVal +"\n"+
				"hexadecimal 0x1a: "+ hexVal+"\n"+
				"binary 0b11010: " + binVal +"\n"+
				"character: " + character +"\n"+
				"character Unicode Escape: " + charUnicodeEscape +"\n"+
				"float pi: " + pi +"\n"+
				"float numer: " + f1
				);
		
	}
}
