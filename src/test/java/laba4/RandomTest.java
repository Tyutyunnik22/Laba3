package laba4;

import static org.junit.Assert.fail;

import org.junit.Test;

public class RandomTest {
	@Test
	public void test() {
		Random rnd = new Random();;
		int x = 0;

		for (int i=1;i<10000;i++) {
			x = rnd.getRandomValue();
			if (x <900 || x > 1200) {
				fail("число выходит за пределы интервала [900;1200]");
			}
		}
	}
}
