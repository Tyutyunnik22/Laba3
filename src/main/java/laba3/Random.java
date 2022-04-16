package laba3;

public class Random {
	public int getRandomValue()
	{
		int min = 900; int max = 1200;
		max -= min;
		return (int) (Math.random() * ++max) + min;
	}
}
