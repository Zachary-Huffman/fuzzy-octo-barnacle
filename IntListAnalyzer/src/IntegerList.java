public class IntegerList implements SortChallenge 
{	
	public int intList[];
	public int numUnique;
	public boolean order = false;
/*------------Defining the methods set in the SortChallenge interface------------------
 *  simpleSort
 *  printSortedFrequency
 *  numberOfUniqueValues
 * */	
	
	//Option 2
	void printList(int list[])
    {
        int n = list.length;
        for (int i=0; i<n; ++i)
            System.out.print(list[i] + " ");
        System.out.println();
    }//end printList
	
	//Option 3
	public int[] simpleSort(int[] list, boolean ascending) {
		order = ascending;		
        int n = list.length;
        if (order) {
	        for (int i = 0; i < n-1; i++) {
	            for (int j = 0; j < n-i-1; j++) {
	                if (list[j] > list[j+1])
	                {
	                    // swap temp and list[i]
	                    int temp = list[j];
	                    list[j] = list[j+1];
	                    list[j+1] = temp;
	                }
	            }
	        }
        } else {
        	for (int i = 0; i < n-1; i++) {
	            for (int j = 0; j < n-i-1; j++) {
	                if (list[j] < list[j+1])
	                {
	                    // swap temp and list[i]
	                    int temp = list[j];
	                    list[j] = list[j+1];
	                    list[j+1] = temp;
	                }
	            }
	        }
        }
		return list;
	}//end simpleSort
	
	//Option 4
    public void printSortedFrequency(int[] list) {
    	intList = list;
    	
    }//end SortedFrequency
    
    //Option 5
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
    }//end unique
}//end class
