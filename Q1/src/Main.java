
//-----------------------------------------------------
// Title: Main class
// Author: SKT
// Description:  This class takes inputs from user as text files and 
// using the String values in the text file, operates the code in three situations
// which are add product, isAvailable and Quit.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	// --------------------------------------------------------
	// Summary: In this method, the text file is read by using BufferedReader.
	// After that, It check every line in the text whether the file contains
	// Add_product, Is_Available an Quit. If the line contains Add_product,
	// first, we trim the line, so there will be no space beginning and end
	// of the line. After that, using replaceAll method we delete the unnecessary
	// spaces in the line but there will be one space each word. So that, we can
	// use split method in order to convert the line to String array. At the and we select
	// the right indexes from the array and use them for the proper case. We are using
	// this processes in other cases.
	// --------------------------------------------------------
	{

		Scanner scan = new Scanner(System.in);

		String file = scan.nextLine();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			BinarySearch bs = new BinarySearch(); // Instance of ProductDatabase class.
			System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");
			while ((line = reader.readLine()) != null)
			// --------------------------------------------------------
			// Summary: In this while loop, we check 3 case, In the first case (Add product), we
			// call the addProduct method in order to create a product in ProductDatabase
			// system(BinarySearchTree). After that we call the message method to print product
		    // information. In the second case(Is Available) we call the searchProductAvailable method.
			// and it looks the product is in the stocks or not. In the final case (Quit) system finishes. 
			// --------------------------------------------------------

			{

				if (line.contains("Add_product")) {

					line.trim(); // method that deletes the spaces beginning and end of the line.
					String f = line.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
					                                            //spaces in the line but there will be one space each word

					String[] arr = f.split(" ", 4); // method that convert the line to String array.

					bs.addProduct(Integer.parseInt(arr[1]), arr[2], Integer.parseInt(arr[3]));
					bs.message(Integer.parseInt(arr[1]));

				} else if (line.contains("Is_Available")) {
					String f2 = line;

					f2 = f2.trim(); // method that deletes the spaces beginning and end of the line.

					String f = f2.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
                    //spaces in the line but there will be one space each word

					String[] arr = f.split(" ", 2); // method that convert the line to String array.
					bs.searchProductAvailable(Integer.parseInt(arr[1]));

				} else if (line.contains("Quit")) {
					System.out.println("\nThank you for using ITS, Good Bye!");
					return;
				}

			}

			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
