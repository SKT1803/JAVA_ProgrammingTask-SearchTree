//-----------------------------------------------------
// Title: ProductNode class
// Author: Serdar Kemal Topkaya / Burak Eren Birinci
// ID: 71200082370 / 36596076990
// Section: 3
// Assignment: 3
// Description: This class creates the elements required for the Products as Nodes of Binary
// Tree. These Nodes represent product's attributes. These Nodes will have their own 
// id value, name value, piece value, right value and left value. The data required for the Node
// elements are created and their initial values are set.  
//-----------------------------------------------------
public class Node {

	public Node left;
    public Node right;
	public int id; // It represents id of the product.
	public int piece; // It represents the number of the product in the stock.
	public String name; // It represents name of the product.

	public Node(int id, String name, int piece)
	// --------------------------------------------------------
	// Summary: Assigns a value to the variables whose.
	// Precondition: id is an integer, name is a String, piece is an integer.
	// Postcondition: The value of id variable is set, name variable is set,
	// size variable is set, left and right variables are set as null.
	// --------------------------------------------------------
	{
		left = right = null;
		this.id = id;
		this.name = name;
		this.piece = piece;

	}

	public String toString()
	// --------------------------------------------------------
	// Summary: It shows the product's attributes in the specified format.
	// --------------------------------------------------------
	{

		System.out.println("Create Product: ");
		String result = "\n\t\t\tID: " + this.id 
				+ "\n\t\t\tName: " + this.name
				+ "\n\t\t\tPiece: " + this.piece;

		return result;
	}
}
