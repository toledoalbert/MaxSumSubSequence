/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author toledoalbert
 */
//sequence class, that allows to create sequence object to hold sequence properties.
    public class Sequence{
        
        //variables
        int size;
        int[] sequence;
        int sum;
        
        //constructor.
        public Sequence(int[] a){
            //set attributes to the proper values.
            sequence = a;
            size = sequence.length;     //get length of the array.
            sum = 0;                    //sum starts with 0.
            
            //for loop to go thru the array and add them together.
            for(int i = 0; i<size; i++){
                sum += sequence[i];
            }
        }
        
        //no parameter constructor for random sized random sequence.
        public Sequence(int n){
            
            //create random object.
            Random rand = new Random();
            
            //generate random size
            //size = rand.nextInt(100000)+100; //canceled in order to allow
            //user to choose size using the slider.
            
            //set size equal to N.
            size = n;
            
            //generate random sized integer array.
            sequence = new int[size]; 
            
            for( int j = 0; j < sequence.length; j++ ) {
               sequence[ j ] = rand.nextInt( 10000 ) - 1000;
            }	
            
            sum = 0;                    //sum starts with 0.
            
            //for loop to go thru the array and add them together.
            for(int i = 0; i<size; i++){
                sum += sequence[i];
            }

        }
        
        //method to get the size
        public int getSize(){
            return size;
        }
        
        //method to get sequence array
        public int[] getSequence(){
            return sequence;       
        }
        
        //method to get sum
        public int getSum(){
            return sum;
        }
        
        //method to return sequence as string
        public String getSequenceString(){
            return Arrays.toString(getSequence());
        }
        
        //find max sum and subsequence using the cubic algorithm.
            //The max sum method with cubic N efficiency.
    //Accepts an array of integers and returns the sum as integer.
    public Sequence maxSubSumCubic()
    {
        //the variable maxSume to keep track of the sum starting at 0.
        int maxSum = 0;
        int[] subSeq = null;
        int[] a = sequence;
        
        //for loop to go thru the array.
        for( int i = 0; i < a.length; i++ )
            
            //for loop to go thru the whole array for every element.
            for( int j = i; j < a.length; j++ )
            {
                //variable thisSume starting at 0.
                int thisSum = 0;
                
                for( int k = i; k <= j; k++ )  
                    thisSum += a[ k ];
               

                if( thisSum > maxSum )
                {
                    maxSum   = thisSum;
                    int seqStart = i;
                    int seqEnd   = j;
                    int seqSize = seqEnd - seqStart+1;
                    
                    subSeq = new int[seqSize];
                    int f = 0;
                    for(int g = seqStart; g<seqSize; g++){
                        subSeq[f] = a[g];
                        f++;
                    }
                }
            }

        return new Sequence(subSeq);
    }
    
    //the method to find the maxsubsequence using the cubic method.
    public Sequence maxSubSumQuadratic()
    {
        int maxSum = 0;
        int[] subSeq = null;
        int[] a = sequence;

        for( int i = 0; i < a.length; i++ )
        {
            int thisSum = 0;
            for( int j = i; j < a.length; j++ )
            {
                thisSum += a[ j ];

                if( thisSum > maxSum )
                {
                    maxSum = thisSum;
                    int seqStart = i;
                    int seqEnd   = j;
                    int seqSize = seqEnd - seqStart+1;
                    
                    subSeq = new int[seqSize];
                    int f = 0;
                    for(int g = seqStart; g<seqSize; g++){
                        subSeq[f] = a[g];
                        f++;
                    }
                }
            }
        }

        return new Sequence(subSeq);
    }

    //method to return the maximum subsequence using O(N) efficiency.
    public Sequence maxSubSumLinear()
    {
        int maxSum = 0;
        int thisSum = 0;
        int[] subSeq = null;
        int[] a = sequence;

        for( int i = 0, j = 0; j < a.length; j++ )
        {
            thisSum += a[ j ];

            if( thisSum > maxSum )
            {
                maxSum = thisSum;
                int seqStart = i;
                int seqEnd   = j;
                int seqSize = seqEnd - seqStart+1;
                    
                    subSeq = new int[seqSize];
                    int f = 0;
                    for(int g = seqStart; g<seqSize; g++){
                        subSeq[f] = a[g];
                        f++;
                    }
            }
            else if( thisSum < 0 )
            {
                i = j + 1;
                thisSum = 0;
            }
        }

        return new Sequence(subSeq);
    }

    
    
    
       
    }
