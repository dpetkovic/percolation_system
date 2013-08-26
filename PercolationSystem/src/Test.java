
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
		{
			Percolation per = new Percolation(10);
			per.open(0, 6);
		}
	}
}
