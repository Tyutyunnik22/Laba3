package laba4;

public class MakeArray {
	public static int[] getArray() {
		int[] mas = new int[15];
		Random rnd = new Random();
		for (int i=0;i<mas.length;i++) {
			mas[i] = rnd.getRandomValue();
		}
		return mas;
	}
}
