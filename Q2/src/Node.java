//-----------------------------------------------------
// Title: CaptainNode class
// Author: Serdar Kemal Topkaya / Burak Eren Birinci
// ID: 71200082370 / 36596076990
// Section: 3
// Assignment: 3
// Description: This class creates the elements required for the Captains as Nodes of Binary
// Tree. These Nodes represent captain's attributes. These Nodes will have their own 
// id value, name value, available value, ratingStar value, right value and left value.
// The data required for the Node elements are created and their initial values are set.  
//-----------------------------------------------------
public class Node {

	public Node left;
	public Node right;

	public int id; // It represents the id of the captain.
	public int ratingStar; // It represents the rating star of the captain.
	public String name; // It represents the name of the captain.
	public boolean available; // It represents the situation of the captain.

	public Node(int id, String name)
	// --------------------------------------------------------
	// Summary: Assigns a value to the variables whose.
	// Precondition: id is an integer value, name is a String value.
	// Postcondition: The value of id variable is set, name variable is set,
	// available variable is set as true, ratingStar variable is set as 0,
	// left and right variables are set as null.
	// --------------------------------------------------------
	{
		left = right = null;
		this.id = id;
		this.name = name;
		this.available = true;
		this.ratingStar = 0;

	}
    @Override
	public String toString() 
	// --------------------------------------------------------
	// Summary: It shows the captain's attributes in the specified format.
	// --------------------------------------------------------
    {

		String t = "";
		if (this.available) {
			t = "True";
		} else {
			t = "False";
		}

		
		String result = "\n		       ID: " + this.id + "\n		       Name: " + this.name
				+ "\n		       Available: " + t + "\n		       Rating star: " + this.ratingStar;

		return result;
	}

	public String toStringforAllCaptains()
	// --------------------------------------------------------
	// Summary: It shows the all captains's attributes in the specified format
	// --------------------------------------------------------
	{

		String t = "";
		if (this.available) {
			t = "True";
		} else {
			t = "False";
		}

		System.out.println("--CAPTAIN: ");
		String result = "\n		       ID: " + this.id + "\n		       Name: " + this.name
				+ "\n		       Available: " + t + "\n		       Rating star: " + this.ratingStar + "\n";

		return result;
	}

}