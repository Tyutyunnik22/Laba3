package laba4;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import laba3.MakeArray;

public class MakeArrayTest {
	static int[] make;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception{
		make = MakeArray.getArray();
	}
	
	@Test
	public void Testing() {
		
		if (make.length != 15 || make == null) {
			fail("Длина массива не равна 15 или массив пуст!");
		} 
		
		// Проверка на элементы массива, равные 0 (значение по умолчанию типа int)
		for (int i = 0; i < make.length; i++) {
			if (make[i] == 0) {
				fail("Одно/несколько значений равны нулю!");
			}
		}
	}
}
