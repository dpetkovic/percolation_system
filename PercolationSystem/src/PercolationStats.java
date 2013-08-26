// Testing Class for Percolation object
public class PercolationStats 
{
	
	private double percolationtThreshold[];
	private int T;
	
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats (int N, int T) 
	{
		this.T = T; 
		percolationtThreshold = new double[T];
		
		int runTimes = 0;
		while ( runTimes < T)
		{
			Percolation per = new Percolation(N);
			int perTrashhold = 0;
			while (per.percolates() == false && perTrashhold < N*N)
			{
				int i = 1 + StdRandom.uniform(N);
				int j = 1 + StdRandom.uniform(N);
				// System.out.println(i + ", " + j); // Random number tester
				if (!per.isOpen(i, j))
				{
					per.open(i, j);
					perTrashhold++;
				}
			}
			double threshold = perTrashhold / Math.pow(N, 2);
			
			percolationtThreshold[runTimes] = threshold;
			runTimes++;
		}
	}
	
	// sample mean of percolation threshold
	public double mean()
	{		
		return StdStats.mean(percolationtThreshold);
	}
	
	// sample standard deviation of percolation threshold
	public double stddev()
	{
		return StdStats.stddev(percolationtThreshold);
	}
	
	// returns lower bound of the 95% confidence interval
	public double confidenceLo()
	{
		return mean() - (1.96 * stddev()) / Math.sqrt(this.T);
	}
	
	// returns upper bound of the 95% confidence interval
	public double confidenceHi()
	{
		return mean() + (1.96 * stddev()) / Math.sqrt(this.T);		
	}
		
	// test client 
	// input 1 size of the Table
	// input 2 number of repeat operations
	public static void main (String[] args)
	{
		
		int sizeOfTable = Integer.parseInt(args[0]);
		int numberOfRepeats = Integer.parseInt(args[1]);;
		if (sizeOfTable <=0 || sizeOfTable <=0) throw  new IllegalArgumentException("Cant be lower than 1"); 
			
		PercolationStats ps = new PercolationStats(sizeOfTable, numberOfRepeats);
		StdOut.println("mean                    = " + ps.mean());
		StdOut.println("stddev                  = " + ps.stddev());
		StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
		
	}

}
