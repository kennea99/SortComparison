import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Alex Kennedy
 *  @version HT 2019
 *  
 *  Table of Results for Sorting Algorithms
 *  Time is in milliseconds (ms)
 *   ____________________________________________________________________________________________
 *  |					 | Insertion | Merge Recursive  | Quick Sort | Merge Iterative | Selection|
 *  |--------------------|----------------------------------------------------------------------- |		
 *  |10 random		     | 0.0031193 | 0.015496	 		| 0.003924					   |0.0041257 |
 *  |--------------------|----------------------------------------------------------------------- |	
 *  |100 random			 | 0.081808	 | 0.060173	 		| 0.036225					   |0.114108  |
 *  |--------------------|----------------------------------------------------------------------  |	
 *  |1000 random		 | 2.927472	 | 0.636652	 		| 0.420209					   |3.311959  |		
 *  |--------------------|----------------------------------------------------------------------  |		
 *  |1000 few unique	 | 1.2708893 | 0.212619	 		| 0.152245					   |1.936722  |			
 *  |--------------------|----------------------------------------------------------------------  |	
 *  |1000 nearly ordered | 0.189114	 | 0.179615	 		| 0.224795					   |1.173585  |		
 *  |--------------------|----------------------------------------------------------------------  |			
 *  |1000 reverse order	 | 3.323329  | 0.167037	 		| 2.350088					   |1.727926  |  
 *  |--------------------|----------------------------------------------------------------------  |
 *  |1000 sorted		 | 0.005132	 | 0.155968	 		| 1.778540					   |1.512288  |		
 *  |____________________|________________________________________________________________________|	
 *  
 *  
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	SortComparison sorting = new SortComparison();
    	double a[] = new double[0];
    	assertEquals(null, (sorting.insertionSort(a)));
    	
    	sorting = new SortComparison();
    	double b[] = new double[0];
    	assertEquals(null, sorting.selectionSort(b));
    	
    	sorting = new SortComparison();
    	double c[] = new double[0];
    	assertEquals(null, (sorting.quickSort(c, 0, c.length)));
    	
    	sorting = new SortComparison();
    	double d[] = new double[0];
    	assertEquals(null, (sorting.mergeSortRecursive(d)));
    }
     @Test
    public void insertionTest()
    {
    	SortComparison sorting = new SortComparison();
    	double a[] = new double[]{1.2, 5.5, 79.2, 35, 10, 8, 9, 99.9, 76, 77};
    	//System.out.println("Before insertion sort" + Arrays.toString(sorting.insertionSort(a)));
    	//System.out.println( "InsertionSort" +Arrays.toString(sorting.insertionSort(a)) +"\n");
    	assertEquals(Arrays.toString(sorting.insertionSort(a)),Arrays.toString(new double[] {1.2, 5.5, 8, 9, 10, 35, 76, 77, 79.2, 99.9}));
    }
     
     @Test 
     public void selectionTest()
     {
    	 SortComparison sorting = new SortComparison();
    	 double a[] = new double[]{1.2, 5.5, 79.2, 35, 10, 8, 9, 99.9, 76, 77};
    	 //System.out.println("Before Selection Sort: " +Arrays.toString(sorting.selectionSort(a)));
    	 //System.out.println("Selection Sort: " +Arrays.toString(sorting.selectionSort(a)) +"\n");
    	 assertEquals(Arrays.toString(sorting.selectionSort(a)), Arrays.toString((new double[] {1.2, 5.5, 8, 9, 10, 35, 76, 77, 79.2, 99.9})));
     }
     

     
     @Test
     public void recursiveMergeTest()
     {
    	 SortComparison sorting = new SortComparison();
    	 double a[] = new double[]{1.2, 5.5, 79.2, 35, 10, 8, 9, 99.9, 76, 77};
    	 assertEquals(Arrays.toString(sorting.mergeSortRecursive(a)), Arrays.toString((new double[] {1.2, 5.5, 8, 9, 10, 35, 76, 77, 79.2, 99.9})));
    	 
     }
     
     @Test
     public void quickSortTest()
     {
    	SortComparison sorting = new SortComparison();
     	double a[] = new double[]{1.2, 5.5, 79.2, 35, 10, 8, 9, 99.9, 76, 77};
     	//System.out.println("Before insertion sort" + Arrays.toString(sorting.insertionSort(a)));
     	//System.out.println( "InsertionSort" +Arrays.toString(sorting.insertionSort(a)) +"\n");
     	assertEquals(Arrays.toString(sorting.quickSort(a, 0, 9)),Arrays.toString(new double[] {1.2, 5.5, 8, 9, 10, 35, 76, 77, 79.2, 99.9}));
     }
     



    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /*
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     **/
    @Test
    public void main()
    {	
    	double[] numbers10 = new double[10];
    	double[] numbers100 = new double[100];
    	double[] numbers1000 = new double[1000];
    	double[] numbers1000Dupes = new double[1000];
    	double[] numbers1000Nearly = new double[1000];
    	double[] numbers1000Reverse = new double[1000];
    	double[] numbers1000Sorted = new double[1000];
    	
    	try {
			Scanner scanner = new Scanner(new File("numbers10.txt")).useDelimiter("\\n");
			int i = 0;
			while(scanner.hasNextDouble())
			{
				numbers10[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers10));
			
			scanner = new Scanner(new File("numbers100.txt")).useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers100[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers100));
			
			scanner = new Scanner(new File("numbers1000.txt")).useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers1000[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers1000));
			
			scanner = new Scanner(new File("numbers1000Duplicates.txt"));//;.useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers1000Dupes[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers1000Dupes));
			
			scanner = new Scanner(new File("numbersNearlyOrdered1000.txt"));//.useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers1000Nearly[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers1000Nearly));
			
			scanner = new Scanner(new File("numbersReverse1000.txt"));//.useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers1000Reverse[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers1000Reverse));
			
			scanner = new Scanner(new File("numbersSorted1000.txt"));//.useDelimiter("\\n");
			i = 0;
			while(scanner.hasNextDouble()){
				numbers1000Sorted[i++] = scanner.nextDouble();
			}
			//System.out.println(Arrays.toString(numbers1000Sorted));
			
			
			double[] tmp1 = new double[10];
			double[] tmp2 = new double[100];
			double[] tmp3 = new double[1000];
			double[] tmp4 = new double[1000];
			double[] tmp5 = new double[1000];
			double[] tmp6 = new double[1000];
			double[] tmp7 = new double[1000];
			
			tmp1 = Arrays.copyOf(numbers10, numbers10.length);
			tmp2 = Arrays.copyOf(numbers100, numbers100.length);
			tmp3 = Arrays.copyOf(numbers1000, numbers1000.length);
			tmp4 = Arrays.copyOf(numbers1000Dupes, numbers1000Dupes.length);
			tmp5 = Arrays.copyOf(numbers1000Nearly, numbers1000Nearly.length);
			tmp6 = Arrays.copyOf(numbers1000Reverse, numbers1000Reverse.length);
			tmp7 = Arrays.copyOf(numbers1000Sorted, numbers1000Sorted.length);
			
			//SelectionSort Testing
			SortComparison sorting = new SortComparison();
			double begin = System.currentTimeMillis();
			sorting.selectionSort(tmp1);
			double end = System.currentTimeMillis();
			System.out.println("SelectionSort 10 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.selectionSort(tmp2);
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 100 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			//System.out.println(Arrays.toString(tmp3));
			sorting.selectionSort(tmp3);
			//System.out.println(Arrays.toString(tmp3));
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 1000 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.selectionSort(tmp4);
			System.out.println(Arrays.toString(tmp4));
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 1000 Duplicate numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.selectionSort(tmp5);
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 1000 Nearly Ordered numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.selectionSort(tmp6);
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 1000 numbers Reversed: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.selectionSort(tmp7);
			end = System.currentTimeMillis();
			System.out.println("SelectionSort 1000 Sorted numbers: " +(end-begin) +" ms \n-------------------------------------------------------------------------");
			
			//Insertion Sort Testing
			tmp1 = Arrays.copyOf(numbers10, numbers10.length);
			tmp2 = Arrays.copyOf(numbers100, numbers100.length);
			tmp3 = Arrays.copyOf(numbers1000, numbers1000.length);
			tmp4 = Arrays.copyOf(numbers1000Dupes, numbers1000Dupes.length);
			tmp5 = Arrays.copyOf(numbers1000Nearly, numbers1000Nearly.length);
			tmp6 = Arrays.copyOf(numbers1000Reverse, numbers1000Reverse.length);
			tmp7 = Arrays.copyOf(numbers1000Sorted, numbers1000Sorted.length);

			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp1);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 10 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp2);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 100 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp3);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 1000 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp4);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 1000 Duplicate numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp5);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 1000 Nearly Ordered numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp6);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 1000 numbers reversed: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.insertionSort(tmp7);
			end = System.currentTimeMillis();
			System.out.println("InsertionSort 1000 Sorted numbers: " +(end-begin) +" ms \n-------------------------------------------------------------------------");
			
			//Recursive Merge Sort Test
			tmp1 = Arrays.copyOf(numbers10, numbers10.length);
			tmp2 = Arrays.copyOf(numbers100, numbers100.length);
			tmp3 = Arrays.copyOf(numbers1000, numbers1000.length);
			tmp4 = Arrays.copyOf(numbers1000Dupes, numbers1000Dupes.length);
			tmp5 = Arrays.copyOf(numbers1000Nearly, numbers1000Nearly.length);
			tmp6 = Arrays.copyOf(numbers1000Reverse, numbers1000Reverse.length);
			tmp7 = Arrays.copyOf(numbers1000Sorted, numbers1000Sorted.length);
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp1);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 10 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp2);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 100 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp3);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 1000 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp4);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 1000 Duplicate numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp5);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 1000 Nearly Ordered numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp6);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 1000 numbers reversed: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.mergeSortRecursive(tmp7);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge Sort 1000 Sorted numbers: " +(end-begin) +" ms \n-------------------------------------------------------------------------");
			
			//QuickSort Test
			tmp1 = Arrays.copyOf(numbers10, numbers10.length);
			tmp2 = Arrays.copyOf(numbers100, numbers100.length);
			tmp3 = Arrays.copyOf(numbers1000, numbers1000.length);
			tmp4 = Arrays.copyOf(numbers1000Dupes, numbers1000Dupes.length);
			tmp5 = Arrays.copyOf(numbers1000Nearly, numbers1000Nearly.length);
			tmp6 = Arrays.copyOf(numbers1000Reverse, numbers1000Reverse.length);
			tmp7 = Arrays.copyOf(numbers1000Sorted, numbers1000Sorted.length);

			begin = System.currentTimeMillis();
			sorting.quickSort(tmp1, 0, tmp1.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 10 numbers: " +(end-begin) +" ms");

			begin = System.currentTimeMillis();
			sorting.quickSort(tmp2, 0, tmp2.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 100 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.quickSort(tmp3, 0, tmp3.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 1000 numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.quickSort(tmp4, 0, tmp4.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 1000 Duplicate numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.quickSort(tmp5, 0, tmp5.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 1000 Nearly Ordered numbers: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.quickSort(tmp6, 0, tmp6.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 1000 numbers Reversed: " +(end-begin) +" ms");
			
			begin = System.currentTimeMillis();
			sorting.quickSort(tmp7, 0, tmp7.length-1);
			end = System.currentTimeMillis();
			System.out.println("Quick Sort 1000 Sorted numbers: " +(end-begin) +" ms");
		

			
			
		} 
			catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
    	
    }

}
