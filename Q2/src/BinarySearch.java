//-----------------------------------------------------
// Title: CaptainDatabase class
// Author: Serdar Kemal Topkaya
// Description: This class creates a binary search tree that name is CaptainDatabase(BinarySearch).
// It has methods which are addCaptain (adds the captain in the tree(database)), 
// searchCaptain (search the captain in the tree), deleteCaptain (deletes the captain from the tree),  
// isAvailable, finish and display methods.
//-----------------------------------------------------
public class BinarySearch {

	public Node root; // In order to create BinarySearchtree, the root Node is created.

	public BinarySearch()
	// --------------------------------------------------------
	// Summary: Constructor of CaptainDatabase (BinarySearch) class. It sets the initial values of the necessary 
	// variables for this class.
	// Postcondition: The value of root variable set as null.
	// --------------------------------------------------------
	{
		root = null;
	}
	
	public void addCaptain(int id, String name)
	// --------------------------------------------------------
	// Summary: This is a calling method for addCpatain method. It calls the
	// displayForAddingCaptain method in order to display captain's information.
	// Precondition: id is an integer value, name is a String value.
	// --------------------------------------------------------
	{
		root = addCaptain(root, id, name);
		displayForAddingCaptain(id);
       
	}

	public Node addCaptain(Node root, int id, String name) 
	// --------------------------------------------------------
	// Summary: Adds the captains into the binary tree(database) by their id values and name
	// values.
	// Precondition: root is a Node value, id is an integer value, name is an String value.
	// --------------------------------------------------------
	{
		if (root == null) {
			root = new Node(id, name);
			return root;
		}
		if (id < root.id)
			root.left = addCaptain(root.left, id, name);
		else if (id > root.id)
			root.right = addCaptain(root.right, id, name);
		return root;
	}
	

	public Node searchCaptain(int id) 
	// --------------------------------------------------------
	// Summary: This is a calling method for search method. It returns the node value
	// that comes from search method.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		Node curr;
		if (search(root, id) == null) {
			curr = null;
		} else {
			curr = search(root, id);
		}
             return curr;
	}


	public Node search(Node root, int id) 
	// --------------------------------------------------------
	// Summary:  Searches the tree with respect to id values by traversing the 
	// binary tree recursively to find the captain and returns it.
	// Precondition: root is a Node value, id is an integer value.
	// --------------------------------------------------------
	{ 

		if (root == null || root.id == id) {
			return root;
		}
		if (id < root.id) {
			return search(root.left, id);
		} else {
			return search(root.right, id);
		}

	}
	
	

	public void deleteCaptain(int id) 
	// --------------------------------------------------------
	// Summary: This is a calling method for deleteCaptain. This method has one value that represents the 
	// captain’s ID. The command will search for this captain in the tree then remove his/her node from 
	// the BST, and it will output the “The captain left CDRC” message. If the specified captain is not found, 
	// it will output the “Couldn’t find any captain with ID number ” message.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		
		
		Node temp = searchCaptain(id);
		
		
		
		if(temp == null) {
			System.out.println("Delete Captain: Couldn't find any captain with ID number "+ id);
			System.out.println("----------------------------------------------------------------");
		}else {
			root = deleteCaptain(root, id);
			System.out.println("Delete Captain:The captain "+temp.name +"left CCR");
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public Node deleteCaptain(Node root, int id)
	// --------------------------------------------------------
	// Summary: Deletes the captain with the specified id value from the binary search
	// tree and refreshes the connections between the nodes as the deletion of a node
	// causes some unwanted alterations between the connections.
	// Precondition: root is a Node value, id is an integer value.
	// --------------------------------------------------------
	{
		if (root == null) {
			return root; //if the tree is empty, we just return the root node as there is nothing to delete.
				
		}
		if (id < root.id) {
			root.left = deleteCaptain(root.left, id);
		} else if (id > root.id) {
			root.right = deleteCaptain(root.right, id);
		} else { // this case is the one that we found our node to be deleted since the id value
			     // is equal to the root's id value.
			if (root.left == null) {
				return root.right; // the case that the node we want to delete has one child or no child.
			} else if (root.right == null) {
				return root.left;
			}
			root.id = minValue(root.right); // the case that the node we want to delete has two children, so we obtain
			// the smallest node in the right subtree.
			root.right = deleteCaptain(root.right, root.id); // and delete it recursively
		}
		return root;
	}
	public int minValue(Node root) 
	// --------------------------------------------------------
	// Summary: Finds the id of the smallest node under the passed-on parent node
	// and returns it.
	// Precondition: root is a Node value.
	// --------------------------------------------------------
	{
		int minValue = root.id;
		while (root.left != null) {
			minValue = root.left.id;
			root = root.left;
		}
		return minValue;
	}
	
	
	public void isAvailable(int id)
	// --------------------------------------------------------
	// Summary: This method has one value which is the captain ID. The command will book a ride 
	// with the specified captain by changing the available to “false”. If the available for the specified 
	// captain is already “false”, then output the “The captain is not available. He is on another ride!” 
	// message. If the specified captain is not found, it will output the “Couldn’t find any captain with 
	// ID number ” message.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		Node temp = searchCaptain(id);
		
		if (temp != null && temp.available == true) {
			temp.available = false;
			System.out.println("IsAvailable: Reserve a new Ride with captain "+ id);
			System.out.println("\n----------------------------------------------------------------");
		} else if (temp != null && temp.available == false) {
			System.out.println("IsAvailable: The captain "+temp.name +"is not available. He is on another ride!");
			System.out.println("\n----------------------------------------------------------------");
		} else {
			System.out.println("IsAvailable: Couldn't find any captain with ID number "+id);
			System.out.println("\n----------------------------------------------------------------");
		}

	}
	
	
	
	public void finish(int id, int riderSatisfication) 
	// --------------------------------------------------------
	// Summary: This method has two value which is the captain ID, and the rider satisfaction (0 
	// or 1). This command will make the specified captain available again by changing the available to 
	// “true”. The rating stars will affect the captain rating stars. The rating stars will increase by one if 
	// the rider is satisfied and decrease by one otherwise. (Note: the rating stars is a value between 0 and 
	// 5 only). If the available for the specified captain is already “true”, then output the “The captain is 
	// not in a ride!” message. If the specified captain is not found, it will output the “Couldn’t find any 
	// captain with ID number ” message.
	// Precondition: id is an integer value, riderSatisfication is an integer value.
	// --------------------------------------------------------
	{
		Node temp = searchCaptain(id);

		if (temp != null && temp.available == false) {
			temp.available = true;
			if (riderSatisfication == 1) {

				if (temp.ratingStar < 5) {
					temp.ratingStar++;
				} else {
					temp.ratingStar = temp.ratingStar;

				}

			} else {
				if (temp.ratingStar >= 1 && temp.ratingStar <= 5) {
					temp.ratingStar--;
				} else {
					temp.ratingStar = temp.ratingStar;
				}

			}
         System.out.println("Finish: Finish ride with captain "+ id);
         displayForFinish(id);
		} else if (temp != null && temp.available == true) {
			System.out.println("Finish: The captain " + temp.name+"is not in a ride");
			System.out.println("----------------------------------------------------------------");
		} else {
			System.out.println("Finish: Couldn't find any captain with ID number "+ id);
			System.out.println("----------------------------------------------------------------");
		}

	}
	
	
	
	public void displayForFinish(int id)
	// --------------------------------------------------------
	// Summary: This method display the finish situation for a captain by using
	// search method. It is called in finish method.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{

		System.out.println(search(root, id));

		System.out.println("----------------------------------------------------------------");

	}

	public void displayForAddingCaptain(int id)
	// --------------------------------------------------------
	// Summary: This method, when we add captain in the tree, display this captain's info.
	// It is called in addCaptain method.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		System.out.println("Add Captain: Add a new captain record in the System");

		System.out.println(search(root, id));

		System.out.println("----------------------------------------------------------------");

	}

	public void displayForIsAvailable(int id)
	// --------------------------------------------------------
	// Summary: This method display the available situation for a captain by using
	// search method. It is called in IsAvailable method.
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		System.out.println("----------------------------------------------------------------");

		System.out.println(search(root, id));

		System.out.println("----------------------------------------------------------------");

	}
	
	public void displayOneCaptain(int id)
	// --------------------------------------------------------
	// Summary: This method display one captain info by using search method. If there is 
	// captain that has the id taken as parameter, in the tree print the captain's info. If not,
	// prints the "Couldn't find any captain with ID number".
	// Precondition: id is an integer value.
	// --------------------------------------------------------
	{
		Node curr = search(root, id);
		if (curr == null) {
			System.out.println("Display Captain: Couldn't find any captain with ID number " + id);
			System.out.println("\n----------------------------------------------------------------");
		} else {
			System.out.print("Display Captain:");
			System.out.println(curr);
			System.out.println("\n----------------------------------------------------------------");
		}

	}

	public void displayAllCaptains()
	// --------------------------------------------------------
	// Summary: This is a calling method for displayAllCaptains method.
	// --------------------------------------------------------
	{

		System.out.println("----------ALL CAPTAINS----------");

		displayAllCaptains(root);

	}

	public void displayAllCaptains(Node root)
	// --------------------------------------------------------
	// Summary: This method display all captains info by applying in order traversal on our
	// binary search tree and prints all captain's IDs, names, available, and rating stars.
	// Precondition: root is a Node value.
	// --------------------------------------------------------
	{ 
		if (root == null) {
			return;
		}

		displayAllCaptains(root.left);

		System.out.print(root.toStringforAllCaptains());
		displayAllCaptains(root.right);

	}
}
