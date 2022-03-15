package laba4;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArraySortTest {
	static ArraySort as;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		as = new ArraySort();
	}
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		as = null;
	}
	
	@Test
	public void test() {
		int[] mas = as.getSort();
		 for (int i = 0; i < mas.length-1; i++){  
	         for (int j = i+1; j < mas.length; j++){       
	             if(mas[i] > mas[j]) {
	            	 fail("массив не отсортирован по возрастанию");
	             }        	       
	         }
		 }
	}

}

