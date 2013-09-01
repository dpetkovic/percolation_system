package com.percolation.main;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *  Simulation of percolation, This uses Weighted Quick Union Algorithm to connect nodes in a N * N size array
 * for more information look at this - link http://en.wikipedia.org/wiki/Percolation
 * more about specification for this project - http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 * @author Dejan Pekovic
 */
public class Percolation 
{
	private WeightedQuickUnionUF union; // quick union object
	private WeightedQuickUnionUF unionbot;
	private boolean[] perTable; // overlay table of open nodes
	private int numRows; //  number of rows in the table, also number of columns
	private int testTopNode; // root of top nodes
	private int testBotNode;
	
	
	 /**
	  * create grid, with all sites blocked
	  * @param N size of the grid N * N
	  */
	public Percolation(int N)
	{
		this.perTable = new boolean[N * N];
		this.union = new WeightedQuickUnionUF(N * N);
		this.unionbot = new WeightedQuickUnionUF(N * N);
		this.numRows = N;
		
		//connects all top, bot nodes		
		for (int j = 2; j <= numRows; j++)
		{			
			this.union.union(getIndex(1,       1), getIndex(1,       j));
			
			this.unionbot.union(getIndex(1,       1), getIndex(1,       j));
			// System.out.println(this.unionbot.connected(getIndex(1,       1), getIndex(1,       j)));
			
			this.unionbot.union(getIndex(numRows, 1), getIndex(numRows, j));
			// System.out.println(this.unionbot.connected(getIndex(numRows, 1), getIndex(numRows, j)));
		}
		this.testTopNode = getIndex(1,       1); // get root of top nodes				
		this.testBotNode = getIndex(numRows, 1); // get root of bot nodes
	}
	
	/**
	 * Open site (row i, column j) if it is not already
	 * @param i row to open
	 * @param j column to open
	 */
	public void open(int i, int j)
	{
		
		if (perTable[getIndex(i, j)] == false) // open only if its closed
		{
			perTable[getIndex(i, j)] = true;					
			
			// test to see if the adjusted panels are open if they are we connect them
			if (j != numRows && isOpen(i, j + 1))
			{
				union.union(getIndex(i, j), getIndex(i, j + 1));
				unionbot.union(getIndex(i, j), getIndex(i, j + 1));
			}
			if (j != 1       && isOpen(i, j - 1)) 
			{
				union.union(getIndex(i, j), getIndex(i, j - 1));
				unionbot.union(getIndex(i, j), getIndex(i, j - 1));
			}
			if (i != numRows && isOpen(i + 1, j))
			{ 
				union.union(getIndex(i, j), getIndex(i + 1, j));
				unionbot.union(getIndex(i, j), getIndex(i + 1, j));
			}
			if (i != 1       && isOpen(i - 1, j))
			{
				union.union(getIndex(i, j), getIndex(i - 1, j));
				unionbot.union(getIndex(i, j), getIndex(i - 1, j));
			}
		}
	}
	
	/**
	 * Is site (row i, column j) open?
	 * @param i row of table 
	 * @param j column of table
	 * @return true if open, false if closed
	 */
	public boolean isOpen(int i, int j)
	{
		indexTest(i, j); // test i and j to see if they are out of bounds		
		return perTable[getIndex(i, j)] == true;
	}
	
	/**
	 * Is site (row i, column j) full?
	 * @param i row of table
	 * @param j column of table
	 * @return true if full of water, false if not(connected to top row)
	 */
	public boolean isFull(int i, int j)
	{	//return false if the node is closed always!
		indexTest(i, j); // test i and j to see if they are out of bounds	
		if (!isOpen(i, j))
			return false;
		// we compare roots of the last open top node with this node
		// if they are the same return true else return false		
		int topRoot = union.find(getIndex(1, 1));
		int root = union.find(getIndex(i, j));
		if (topRoot == root)
			return true;
		else
			return false;
		
	}
	
	/**
	 * Test - does the system percolate?
	 * @return true if it does, false if not
	 */
	public boolean percolates()
	{
		int test1 = unionbot.find(testTopNode);
		int test2 = unionbot.find(testBotNode);
		
		// System.out.println(test1 + ", " + test2 + ", " + result);
		return  test1 == test2;
		/*
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
		*/				
	}
	
	/**
	 * gets the true index of row and column
	 * we translate row and index to its true array index
	 * @param i row
	 * @param j column
	 * @return index of a row and column
	 */
	private int getIndex(int i, int j)
	{
		// indexTest(i, j);
		return (i - 1) * numRows + (j - 1);
	}
	
	/**
	 * tests if row, column inputs are valid
	 * @param i row
	 * @param j column
	 */
	private void indexTest(int i, int j)
	{
		if (i <= 0 || i > numRows) throw new IndexOutOfBoundsException("row index i out of bounds");
		if (j <= 0 || j > numRows) throw new IndexOutOfBoundsException("column index i out of bounds");
	}	
}
