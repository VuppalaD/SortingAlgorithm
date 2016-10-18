/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Divya
 */

    /**
     * @param args the command line arguments
     */
   /**********************************************************************************
   * Divya Vuppala  CSCI 6305.01 Spring 2015 Final Project: Sorting                  *
   *                                                                                 *
    **********************************************************************************/

    // Final Project: SortingAlgorithms.java

import java.util.Random;// it imports the randomly generated values
import java.util.Scanner;//It imports the scanner classes and methods
import java.util.NoSuchElementException;// it imports all the run time exceptions

public class SortingAlgorithms_vuppalaDivya
{
    private int[] data; // array of values
    private static final Random generator = new Random();
    
   public static void main( String[] args )//main method
   {    
       
      Scanner input = new Scanner( System.in );
      int option; // store user's option
      
      // create object to perform sorting
      SortingAlgorithms_vuppalaDivya sortArray = new SortingAlgorithms_vuppalaDivya( 50 );

      //show menu options
      do {
          
        System.out.println( " Choose the sorting algorithm to perform on data: \n");//prints the statement to choose the sorting algorithm to perform on data.
        System.out.println( " 1) Selection sort");// prints selection sort for 1
        System.out.println( " 2) Insertion sort");// prints insertion sort for 2
        System.out.println( " 3) Merge sort");// prints merge sort for 3
        System.out.println( " 4) Bubble sort");// prints bubble sort for 4
        System.out.println( " 5) Bucket sort");// prints bucket sort for 5
        System.out.println( " 6) Quick sort");// prints quick sort for 6
        System.out.print( " Option: ");// prints option
      
     
        try
        {
          option = input.nextInt();// scans the input
          if ( option >= 1 && option <= 6 )// checks the condition so that option lies in between 1 to 6 only 
            break;
          else
              System.err.println( " Invalid input. Please try again.");// prints that given input is invalid and to try again
        }
      
        catch (NoSuchElementException elementException)
        {
          System.err.println( " Invalid input. Please try again.");//prints invalid input and to try again
          input.nextLine();// reads the input again
        }
      } while (true); // repeat as necesary until user enters proper input
      
      
      // print unsorted array
      System.out.println( "Unsorted:" + sortArray + "\n" );// prints the unsorted array
      
      switch (option)
      {
        case 1:
              System.out.println( " Executing Selection sort ... \n\n");// prints the  statement executing selection sort
              sortArray.selectionSort(); // sort array using selection sort
              break;
              
        case 2:
              System.out.println( " Executing Insertion sort ... \n\n");// prints the statement executing insertion sort 
              sortArray.insertionSort(); // sort array using insertion sort
              break;
            
        case 3:
              System.out.println( " Executing Merge sort ... \n\n");// prints the statement executing merge sort
              sortArray.mergeSort(); // sort array using merge sort
              break;

        case 4:
              System.out.println( " Executing Bubble sort ... \n\n");// prints the statement executing bubble sort 
              sortArray.bubbleSort();
              // call bubble sort here
              break;
            
        case 5:
              System.out.println( " Executing Bucket sort ... \n\n");// prints the statement executing bucket sort 
              sortArray.bucketSort();
              //call bucket sort here
              break;
            
        case 6:
              System.out.println( " Executing Quick sort ... \n\n");// prints the statement executing quick sort
              sortArray.quickSort();
              //call quick sort here
              break;
            
      }

      // print sorted array
      System.out.println( "Sorted:  " + sortArray );
   } // end main

   // create array of given size and fill with random integers
   public SortingAlgorithms_vuppalaDivya( int size )
   {
      data = new int[ size ]; // create space for array

      // fill array with random ints in range 10-999
      for ( int i = 0; i < size; i++ )
         data[ i ] = 10 + generator.nextInt( 990 );
   } // end SortingAlgorithms constructor

   public void selectionSort()
   {
      int smallest; // index of smallest element

      // loop over data.length - 1 elements
      for ( int i = 0; i < data.length - 1; i++ )
      {
         smallest = i; // first index of remaining array

         // loop to find index of smallest element
         for ( int index = i + 1; index < data.length; index++ )
            if ( data[ index ] < data[ smallest ] )
               smallest = index;

         swap( i, smallest ); // swap smallest element into position
      } // end out of  for loop
   } // end method selection 
   public void bubbleSort()
   {
	   int n, c, d, swap;// declaring the values 
	   n = data.length;
	   for (c = 0; c < ( n - 1 ); c++) {// checks the condition when c=0
		      for (d = 0; d < n - c - 1; d++) {// checks the condtion when d=0
		        if (data[d] > data[d+1]) /* For descending order use < */
		        {
		          swap       = data[d];// stores the value of data[d] in swap variable.
		          data[d]   = data[d+1];//stores the value of data[d+1] in data[d].
		          data[d+1] = swap;// stores the value of swap in data[d+1].
		        }
		      }
		    }
	   
   }
   public void bucketSort()
   {
	   int [] bucket=new int[max(data)+1];// creates a new object
	   for (int i=0; i<bucket.length; i++) {// when i=0 check for the condition bucket.length and increment.
	         bucket[i]=0;//stores the value as 0
	      }
	   for (int i=0; i<data.length; i++) {// when i=0 checks for the condition data.length.
	         bucket[data[i]]++;// stores the incremented  data value
	      }
	   int outPos=0; // declaring the outpos =0
	      for (int i=0; i<bucket.length; i++) {// when i=0 checks for the condition bucket.length.
	         for (int j=0; j<bucket[i]; j++) {// when j=0 checks for the condition bucket[i].
	            data[outPos++]=i;//stores the value as i
	         }
	      }
   }
   public void quickSort()
   {
	   recursiveQuickSort(data,0,data.length-1);//doing recursion for quicksort method
   }
   public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
	     
       int idx = partition(array, startIdx, endIdx);// declaring the values of array,startIdx, endIdx 

       // Recursively call quicksort with left part of the partitioned array
       if (startIdx < idx - 1) {
           recursiveQuickSort(array, startIdx, idx - 1);
       }

       // Recursively call quick sort with right part of the partitioned array
       if (endIdx > idx) {
           recursiveQuickSort(array, idx, endIdx);
       }
   }
   public static int partition(int[] array, int left, int right) {
       int pivot = array[left]; // taking first element as pivot

       while (left <= right) {
           //searching number which is greater than pivot, bottom up
           while (array[left] < pivot) {
               left++;
           }
           //searching number which is less than pivot, top down
           while (array[right] > pivot) {
               right--;
           }

           // swaping the values
           if (left <= right) {
               int tmp = array[left];
               array[left] = array[right];
               array[right] = tmp;

               //increment left index and decrement right index
               left++;
               right--;
           }
       }
       return left;// returns left
   }
   public int max(int a[])
   {
       int max=0;// declaring max=0
       for(int i=0;i<a.length;i++)// when i=0 checks for the condition 
       {
           if(a[i]>=a[max])// if the value of a[i] is greater than or equal to a[max] 
           max=i;//stores the value of i
       }
       return (a[max]);// returns a[max]
   }
      // sort array using insertion sort
   public void insertionSort()
   {
      int insert; // temporary variable to hold element to insert

      // loop over data.length - 1 elements
      for ( int next = 1; next < data.length; next++ )
      {
         // store value in current element
         insert = data[ next ]; 

         // initialize location to place element
         int moveItem = next; 

         // search for place to put current element
         while ( moveItem > 0 && data[ moveItem - 1 ] > insert )
         {
            // shift element right one slot
            data[ moveItem ] = data[ moveItem - 1 ];
            moveItem--;
         } // end while

         data[ moveItem ] = insert; // place inserted element
      } // end for
   } // end method sort

   // helper method to swap values in two elements
   private void swap( int first, int second )
   {
      int temporary = data[ first ]; // store first in temporary
      data[ first ] = data[ second ]; // replace first with second
      data[ second ] = temporary; // put temporary in second
   } // end method swap

    // calls recursive split method to begin merge sorting
    public void mergeSort()
    {
        splitArray( 0, data.length - 1 ); // split entire array
    } // end method sort

    // splits array, sorts subarrays and merges subarrays into sorted array
    private void splitArray( int low, int high )
    {
        // test base case; size of array equals 1
        if ( ( high - low ) >= 1 ) // if not base case
        {
            int middle1 = ( low + high ) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over

            // split array in half; sort each half (recursive calls)
            splitArray( low, middle1 ); // first half of array
            splitArray( middle2, high ); // second half of array

            // merge two sorted arrays after split calls return
            merge ( low, middle1, middle2, high );
        } // end if
    } // end method sortArray

    // merge two sorted subarrays into one sorted subarray
    private void merge( int left, int middle1, int middle2, int right )
    {
        int leftIndex = left; // index into left subarray
        int rightIndex = middle2; // index into right subarray
        int combinedIndex = left; // index into temporary working array
        int[] combined = new int[ data.length ]; // working array

        // merge arrays until reaching end of either
        while ( leftIndex <= middle1 && rightIndex <= right )
        {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if ( data[ leftIndex ] <= data[ rightIndex ] )
                combined[ combinedIndex++ ] = data[ leftIndex++ ];
            else
                combined[ combinedIndex++ ] = data[ rightIndex++ ];
        } // end while

        // if left array is empty
        if ( leftIndex == middle2 )
            // copy in rest of right array
            while ( rightIndex <= right )
                combined[ combinedIndex++ ] = data[ rightIndex++ ];
        else // right array is empty
            // copy in rest of left array
            while ( leftIndex <= middle1 )
                combined[ combinedIndex++ ] = data[ leftIndex++ ];

        // copy values back into original array
        for ( int i = left; i <= right; i++ )
        data[ i ] = combined[ i ];

    } // end method merge

   // method to output certain values in array
   private String subarray( int low, int high )
   {
      StringBuilder temporary = new StringBuilder();

      // output spaces for alignment
      for ( int i = 0; i < low; i++ )
         temporary.append( "   " );

      // output elements left in array
      for ( int i = low; i <= high; i++ )
         temporary.append( " " + data[ i ] );

      return temporary.toString();
   } // end method subarray

   // method to output values in array
   public String toString()
   {
      return subarray( 0, data.length - 1 );
   } // end method toString 


} // end class SortingAlgorithms


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
*************************************************************************/
