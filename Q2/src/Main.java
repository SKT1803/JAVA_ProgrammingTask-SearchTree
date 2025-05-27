//-----------------------------------------------------
// Title: Main class
// Author: SKT
// Description: This class takes inputs from user as text files and 
// using the String values in the text file, operates the code in seven situations
// which are add captain, isAvailable, display captain, finish, delete captain,
// display all captains and quit.  
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	// --------------------------------------------------------
	// Summary: In this method, the text file is read by using BufferedReader.
	// After that, It check every line in the text whether the file contains
	// Add_Captain, Is_Available, Display_captain, Finish, Delete_captain,
	// Display_all_captains and Quit. If the line contains Add_product,
	// first, we trim the line, so there will be no space beginning and end
	// of the line. After that, using replaceAll method we delete the unnecessary
	// spaces in the line but there will be one space each word. So that, we can
	// use split method in order to convert the line to String array. At the and we select
	// the right indexes from the array and use them for the proper case. We are using
	// this processes in other cases.
	// --------------------------------------------------------
	{
		 Scanner scan = new Scanner(System.in);
			
			String file =  scan.nextLine();

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				BinarySearch bs = new BinarySearch(); // Instance of CaptainDatabase (BinaryTree) class.
				System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");
				while ((line = reader.readLine()) != null) 
					// --------------------------------------------------------
					// Summary: In this while loop, we check 7 case, In the first case (Add Captain), we
					// call the addCaptain method in order to create a captain in CaptainDatabase
					// system(BinarySearchTree). In the second case(Is Available) we call the isAvailable method.
					// and it looks the captain is available or not. In the third case (Display_captain), we prints
					// the one captain's information. In the fourth case (Finish) finish methods is called 
					// and it prints the captain situation ( finish the ride or not). In the fifth case(Delete_captain),
					// deleteCaptain method is called and delete the captain from database(searchTree) and prints
					// the situation. In the sixth case (Display_all_captains), displayAllCaptains method is called
					// and prints the all the captain's information in the tree. In the final case (Quit) system finishes. 
					// --------------------------------------------------------
				{
				

					if (line.contains("Add_Captain")) {

						line.trim(); // method that deletes the spaces beginning and end of the line.
						String f = line.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
                                                           //spaces in the line but there will be one space each word

						String[] arr = f.split(" ", 3); // method that convert the line to String array.

						bs.addCaptain(Integer.parseInt(arr[1]), arr[2]);

					} else if (line.contains("Is_Available")) {
						String f2 = line;

						f2 = f2.trim(); // method that deletes the spaces beginning and end of the line.

						String f = f2.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
                        //spaces in the line but there will be one space each word

						String[] arr = f.split(" ", 2); // method that convert the line to String array.
						bs.isAvailable(Integer.parseInt(arr[1]));

					} else if(line.contains("Display_captain")) {
						
						String f2 = line;

						f2 = f2.trim(); // method that deletes the spaces beginning and end of the line.

						String f = f2.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
                        //spaces in the line but there will be one space each word

						String[] arr = f.split(" ", 2); // method that convert the line to String array.
						bs.displayOneCaptain(Integer.parseInt(arr[1]));
						
					}else if(line.contains("Finish")) {
						line.trim(); // method that deletes the spaces beginning and end of the line.
						String f = line.replaceAll("\\s{2,}", " ");  // method that deletes the unnecessary 
                        //spaces in the line but there will be one space each word

						String[] arr = f.split(" ", 3); // method that convert the line to String array.
						bs.finish(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
					}else if(line.contains("Delete_captain")) {
						String f2 = line;

						f2 = f2.trim(); // method that deletes the spaces beginning and end of the line.

						String f = f2.replaceAll("\\s{2,}", " "); // method that deletes the unnecessary 
                        //spaces in the line but there will be one space each word

						String[] arr = f.split(" ", 2); // method that convert the line to String array.
						bs.deleteCaptain(Integer.parseInt(arr[1]));
					}
					else if(line.contains("Display_all_captains")) {
						bs.displayAllCaptains();
					}
					else if(line.contains("Quit")) {
						System.out.println("\nThank you for using CDRC, Good Bye!");
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

