import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        //todo: implement the sort
    	if(a.length == 0)
    			
    	{
    		return null;
    	}
    	int length = a.length;
    	int index2;
    	for(int index = 1; index < length; index++)
    	{
    		double key = a[index]; // specified element in the array
    		index2 = index -1;
    		
    		while(index2 >= 0 && a[index2] > key)
    		{
    			a[index2 + 1] = a[index2];
    			index2 = index2 - 1;
    		}
    		a[index2 + 1] = key;
    	}
    	return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    
    static int partition(double a[], int low, int high)
    {	
    	double pivot = a[high];
    	int i = (low-1);
    	for(int j = low; j<high; j++)
    	{
    		if(a[j] <= pivot)
    		{
    			i++;
    			
    			double temp = a[i];
    			a[i] = a[j];
    			a[j] = temp;
    		}
    	}
    	
    	double temp = a[i+1];
    	a[i+1] = a[high];
    	a[high] = temp;
    	
    	return i+1;
    }
    
    static double[] quickSort(double a[], int low, int high)
    {
    	if(a.length == 0)
    	{
    		return null;
    	}
    	
    	
    	if(low< high)
    	{
    		int index = partition(a, low, high);
    		
    		quickSort(a, low , index-1);
    		quickSort(a, index+1, high);
    	}
    	return a;
    }
    
    
    
    
    /*static double [] quickSort (double a[]){
	
		 //todo: implement the sort
    	double low = a[0];
    	double high = a.length-1;
    	
    	sort(a, low, high);

    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
   
    /*
    public static void merge(double[] a, double[]temp, int from, int mid, int to)
    {
    	int k = from, i = from, j = mid+1;
    	
    	while(i <= mid && j <= to)
    	{
    		if(a[i] < a[j])
    			temp[k++] = a[i++];
    		else
    			temp[k++] = a[j++];
    	}
    
	    while(i <= mid)
	    {
	    	temp[k++] = a[i++];
	    }
	    
	    for(i = from; i <= to; i++)
	    {
	    	a[i] = temp[i];
	    }
    }

    static double[] mergeSortIterative (double a[]) {
    	if(a.length == 0)
    		return null;
    	
    	int low = 0;
    	int high = a.length-1;
    	
    	double[] temp = Arrays.copyOf(a, a.length);
    	
    	for(int m = 1; m <= high -low; m = 2*m)
    	{
    		for(int i = low; i< high; i += 2*m)
    		{
    			int from = i;
    			int mid = i+m-1;
    			int to = Integer.min(i + 2*m-1, high);
    			
    			merge(a, temp, from, mid, to);
    		}
    	}
    	return a;

    }
    */
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	
    	if(a.length == 0)
    		return null;
    	
    	int length = a.length;
    	if(length < 2)
    		return a;
    	int mid = length/2;
    	double[] left = new double[mid];
    	double[] right = new double[length-mid];
    	
    	for(int i = 0; i< mid; i++)
    	{
    		left[i] = a[i];
    	}
    	
    	for(int i = mid; i< length; i++)
    	{
    		right[i - mid] = a[i];
    	}
    	mergeSortRecursive(left);
    	mergeSortRecursive(right);
    	
    	merge(a, left, right, mid, length - mid);
    	
    	return a;
   }//end mergeSortRecursive
    
    public static void merge(double a[], double[] left, double[] right, int l, int r)
    {
    	int i = 0, j = 0, k = 0;
    	while(i< l && j< r)
    	{
    		if(left[i] < right[j])
    			a[k++] = left[i++];
    		else
    			a[k++] = right[j++];
    		
    	}
    	while(i < l)
    	{
    		a[k++] = left[i++];
    	}
    	while(j < r)
    	{
    		a[k++] = right[j++];
    	}
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         //todo: implement the sort
    	if( a.length == 0)
    		return null;
    	int length = a.length;
    	
    	for(int index = 0; index < length - 1; index++)
    	{
    		int min_index = index;
    		for (int index2 = index+1; index2 < length; index2++)
    		{
    			if(a[index2] < a[min_index])
    				min_index = index2;
    		}
    		
    		double tempNum = a[min_index];
    		a[min_index] = a[index];
    		a[index] = tempNum;
    	}
    	return a;

    }//end selectionsort

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class