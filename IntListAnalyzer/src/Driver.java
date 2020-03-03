import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	/* --------------------------Main starts here--------------------------
	 * User will be presented with text in welcome.txt file
	 * Switch statement used to determine which function user wishes to use
	 */    
    static void printMessage() {
    	try {
            File welcome = new File("welcome.txt");
            Scanner myReader = new Scanner(welcome);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("Welcome message not found.");
          //  e.printStackTrace();
          }
    }//end print message
    
	    public static void main(String args[])
	    {
	    	IntegerList ob = new IntegerList();
	    	Scanner userInput = new Scanner(System.in);
	        String userList;
	        String option;
	        String option2;
	        String[] userListSplit;
	        Boolean order = true;
	        int[] userListInt = null;
	        int[] userListInt2 = {4, 5, 7, 3, 1, 7, 9};
	        
	        
	        // Application welcome screen. From here user chooses desired function
	        System.out.println("*********Number List Sorter and Analyzer*********");
	        do {
	        	option = "";
	        	option2 = "";
	        	printMessage();
		        System.out.print(">");
		        option = userInput.nextLine();
		        switch(option) {
		        
		        
		        case "1": //User input of a comma/white-space delimited list of integers
		        	System.out.println("Please enter list of number separated by spaces or commas.");
		        	System.out.print(">");
		        	userList = userInput.nextLine(); 
		        	//split the user input regardless of use of commas or spaces (to an extent)
		        	userListSplit = userList.split(",+\\s*|\\s+,*");
		        	
		        	
		        	for (int z = 0; z < userListSplit.length; z++) {
		        		System.out.println(userListSplit[z]);
		        	}
		        	userListInt = new int[userListSplit.length];
		        	System.out.println(userListSplit.length + " " + userListInt.length); 
		            for (int i = 0; i < userList.length();i++) {
		            	try {
		            	userListInt[i] = Integer.valueOf(userListSplit[i]);
		            	}catch (Exception e) {
		            		System.out.println("Invalid number of entered. Returning to main menu");
		            		System.out.println(e.getMessage());
		            		userListInt = null; 
		            		break;
		            	}
		            }
		        	break;
		        	
		        	
		        case "2": //Print out the current list
		        	if (userListInt2 == null) { //tt
		        		System.out.println("No list found.");
		        		break;
		        	}
		        	ob.printList(userListInt2); //tt
		        	break;
		        	
		        	
		        case "3": //Simple sort of either ascending or descending
		        	if (userListInt2 == null) {//TT
		        		System.out.println("No list found.");
		        		break;
		        	}
		        	System.out.println("Please choose desired order: \n(1) Ascending order\n(2) Descending order ");
		        	option2 = userInput.nextLine();
		        	if (option2.compareTo("1")== 0) order = true;
		        	else if (option2.compareTo("2")== 0) order = false;
		        	else {
		        		System.out.println("Invalid selection of "+option2+", returning to main menu");
		        		break;
		        	}
		        	userListInt = ob.simpleSort(userListInt2, order); //tt
		        	System.out.println("Sorted array");
		            ob.printList(userListInt2); //tt
		        	break;
		        	
		        	
		        case "4": //Print out frequency of unique integers in list, sorted ascending
		        	if (userListInt == null) {
		        		System.out.println("No list found.");
		        		break;
		        	}
		        	break;
		        	
		        	
		        case "5": // Print out the total number of unique integers in the list
		        	if (userListInt == null) {
		        		System.out.println("No list found.");
		        		break;
		        	}
		        	int uniqueNum = ob.numberOfUniqueValues(userListInt2); //tt
		        	System.out.println("There are "+uniqueNum+" unique numbers in the list.");
		        	break;
		        	
		        	
		        case "6": //Exit program
		            System.out.println("Bye!");
		            break;
		            
		            
		        default:
		        	System.out.println("Incorrect option, please try again.");
		        	break;
		        	
		        	
		        }//end switch
		        System.out.println("Hit enter to continue.");
		        userInput.nextLine();
	        }while (option.compareTo("6")!=0);
	        userInput.close();
	    }//end main
}
