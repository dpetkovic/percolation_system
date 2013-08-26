// Simulation of percolation
public class Percolation 
{
	private WeightedQuickUnionUF union; // quick union object
	private boolean[] perTable; // overlay table of open nodes
	private int numRows; //  number of rows in the table, also number of columns
	private int testTopNode; // root of top nodes
	
	
	 // create N-by-N grid, with all sites blocked
	public Percolation(int N)
	{
		this.perTable = new boolean[N * N];
		this.union = new WeightedQuickUnionUF(N * N);		
		this.numRows = N;
		
		//connects all top nodes		
		for (int j = 1; j < numRows; j++)
		{			
			this.union.union(getIndex(1, 1), getIndex(1, j));
		}
		this.testTopNode = union.find(getIndex(1, 1)); // get root of top nodes
	}
	
	// open site (row i, column j) if it is not already
	public void open(int i, int j)
	{
		
		if (perTable[getIndex(i, j)] == false) // open only if its closed
		{
			perTable[getIndex(i, j)] = true;					
			
			// test to see if the adjusted panels are open if they are we connect them
			if (j != numRows && isOpen(i, j + 1)) union.union(getIndex(i, j), getIndex(i, j + 1));
			if (j != 1       && isOpen(i, j - 1)) union.union(getIndex(i, j), getIndex(i, j - 1));
			if (i != numRows && isOpen(i + 1, j)) union.union(getIndex(i, j), getIndex(i + 1, j));
			if (i != 1       && isOpen(i - 1, j)) union.union(getIndex(i, j), getIndex(i - 1, j));						
		}
	}
	
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j)
	{
		indexTest(i, j); // test i and j to see if they are out of bounds		
		return perTable[getIndex(i, j)] == true;
	}
	
	// is site (row i, column j) full?
	public boolean isFull(int i, int j)
	{	//return false if the node is closed always!
		indexTest(i, j); // test i and j to see if they are out of bounds	
		if (!isOpen(i, j))
			return false;
		// we compare roots of the last open top node with this node
		// if they are the same return true else return false		
		int topRoot = union.find(testTopNode);
		int root = union.find(getIndex(i, j));
		if (topRoot == root)
			return true;
		else
			return false;
		
	}
	
	// does the system percolate?
	public boolean percolates()
	{
		int i = numRows;
		for (int j = 1; j <= numRows; j++) // to do, maybe a better way to test bot nodes
		{
			if (isOpen(i, j))
			{
				int root = union.find(getIndex(i, j));
				this.testTopNode = union.find(getIndex(1, 1));
				if (root == testTopNode)
					return true;
			}
		}
		return false;				
	}
	
	// gets the true index of row and column
	private int getIndex(int i, int j)
	{
		// indexTest(i, j);
		return (i - 1) * numRows + (j - 1);
	}
	
	// tests if row, column values are valid
	private void indexTest(int i, int j)
	{
		if (i <= 0 || i > numRows) throw new IndexOutOfBoundsException("row index i out of bounds");
		if (j <= 0 || j > numRows) throw new IndexOutOfBoundsException("column index i out of bounds");
	}	
}
