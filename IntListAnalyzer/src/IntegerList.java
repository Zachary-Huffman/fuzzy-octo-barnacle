import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class IntegerList implements SortChallenge 
{	
	public int intList[];
	public int numUnique;
	public boolean order = false;
	
	public int[] simpleSort(int[] list, boolean ascending) {
		order = ascending;		
        int n = list.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list[j] > list[j+1])
                {
                    // swap temp and list[i]
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
		return list;
	}
    public void printSortedFrequency(int[] list) {
    	intList = list;
    	
    }
    public int numberOfUniqueValues(int[] list) {
    	numUnique = 1;
    	for (int i = 1; i < list.length; i++) {
    		int j = 0;
    		for (j = 0; j < i; j++) 
    			if (list[i] == list[j])
    				break;
    		if (i==j)
    			numUnique++;
    	}
    	return numUnique;
    	
    }
    
    void printList(int list[])
    {
        int n = list.length;
        for (int i=0; i<n; ++i)
            System.out.print(list[i] + " ");
        System.out.println();
    }
    
    public static void main(String args[])
    {
    	
    	Scanner myObj = new Scanner(System.in);
        String userList;
        
        
        // Enter username and press Enter
        System.out.println("Please enter a list of numbers"); 
        userList = myObj.nextLine();   
        int[] userListChar = new int[userList.length()];
        for (int i = 0; i < userList.length();i++) {
        	userListChar[i] = Character.getNumericValue(userList.charAt(i));
        }
        
        IntegerList ob = new IntegerList();
        int list[] = {64, 34, 25, 12, 22, 11, 90};
        list = ob.simpleSort(list, true);
        System.out.println("Sorted array");
        ob.printList(list);
    }
    
}
