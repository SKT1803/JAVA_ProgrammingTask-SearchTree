//-----------------------------------------------------
// Title: ProductDatabase class
// Author: SKT
// Description: This class creates a binary search tree that name is ProductDatabese (BinarySearch).
// Using the addProduct method, creates products and store it in search tree data 
// structure. Using the searchProduct method, it traverses the three and find product.
// After that, using the result of searchProduct method, it shows the products attributes.
//-----------------------------------------------------
public class BinarySearch {
	
	public Node root; // In order to create BinarySearchtree, the root Node is created.

	public BinarySearch()
	// --------------------------------------------------------
	// Summary: Constructor of ProductDatabase (BinarySearch) class. It sets the initial values of the necessary 
	// variables for this class
	// Postcondition: The value of root variable set as null.
	// --------------------------------------------------------
	{
		this.root = null;
	}

	public void message(int id)
	// --------------------------------------------------------
	// Summary: First it searches the product using the id that taken as a parameter.
	// After that, it prints the products information.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		System.out.println(searchProduct(root, id));
	}

	public void addProduct(int id, String name, int piece)
	// --------------------------------------------------------
	// Summary: This is a calling method for addProduct method.
	// Precondition: id is an integer value, name is a String value, piece is a integer value.
	// --------------------------------------------------------
	{
		root = addProduct(root, id, name, piece);
	}

	public Node addProduct(Node root, int id, String name, int piece)
	// --------------------------------------------------------
	// Summary: This method creates the products corresponding to the values given in the
	// parameters. After that, It adds these product to BinarySearchTree.
	// Precondition: root is a ProductNode, id is an integer value, name is a String value,
	// piece is a integer value.
	// --------------------------------------------------------
	{

		if (root == null) {
			root = new Node(id, name, piece);

			return root;
		}

		if (id < root.id) {

			root.left = addProduct(root.left, id, name, piece);
		} else {
			root.right = addProduct(root.right, id, name, piece);
		}

		return root;

	}

	public void searchProductAvailable(int id)
	// --------------------------------------------------------
	// Summary: This is a calling method for searchProduct method. Using the value that comes from
	// searchProduct method, It prints 2 cases. This function, if the product is in stock, prints to the console how many 
	// are left. If the product is not found, the message “ The product is out of stock!!!” is displayed.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{

		if (searchProduct(root, id) == null || searchProduct(root, id).piece == 0) {
			System.out.println("\nThe product is out of stock!!!");
		} else {
			System.out.println("\nThere are " + searchProduct(root, id).piece + " products");
			
		}

	}

	public Node searchProduct(Node root, int id)
	// --------------------------------------------------------
	// Summary: This method searches using the product id taken as a parameter in the 
	// binary search tree that we have created and returns the node of the product.
	// Precondition: root is a ProductNode, id is an integer value.
	// --------------------------------------------------------
	{

		if (root == null || root.id == id) {
			return root;
		}
		if (id < root.id) {
			return searchProduct(root.left, id);
		} else {
			return searchProduct(root.right, id);
		}

	}
}
