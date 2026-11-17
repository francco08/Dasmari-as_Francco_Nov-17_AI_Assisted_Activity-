/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package livecoding;

import java.util.Scanner;

/**
 *
 * @author DASMARIÑAS_CPE113
 */
public class LiveCoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        //Problem 1: Methods with Parameters & Return Values
        System.out.println("---Problem 1---");
        System.out.print("Input total: ");
        int total = input.nextInt();
        System.out.print("Input count: ");
        int count = input.nextInt();
        System.out.println("Average: " + computeAverage(total, count));
        System.out.println();
        
        /**
         * Problem 1 questions:
         * 1. Why does the method need the word double (or a cast) in the return?
         * Answer: The word double is needed in at least 1 of the variables in the return to output a real number,
         * as without the word double, the result would be an integer regardless of the data type of the method.
         * An example would be, if 5.8 was the average when calculated, the numbers to the right of the period
         * would be chopped off, thus only outputting 5.0
         * 
         * 2. What would go wrong without the count <= 0 guard?
         * Answer: It would result in an error, where the output is infinity.
         */
        
        
        
        //Problem 2: From Loop to Recursion
        System.out.println("---Problem 2---");
        System.out.print("How many grades are to be evaluated? ");
        int gradeAmount = input.nextInt();
        int[] grades = new int[gradeAmount];
        for (int i = 0; i < gradeAmount; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = input.nextInt();
        }
        System.out.print("What is the passing mark? ");
        int passingMark = input.nextInt();
        int index = grades.length;
        System.out.println("Passed: " + countPassingRecursive(grades, passingMark, index));
        System.out.println();
        
        /**
         * Problem 2 questions:
         * 1. What does each recursive call do to index, and why must it change?
         * Answer: Each recursive call subtracts the index by 1 in order to evaluate the next value in the set.
         * Not doing so would result in an infinite recursion.
         * 
         * 2. What happens if you delete the base case entirely?
         * Answer: It would result in an infinite recursion, as the program is not coded to stop at a given point.
         */
        
        
        
        //Problem 3: Debug the AI: Fixing a Flawed Recursion
        System.out.println("---Problem 3---");
        System.out.print("Input an integer for factorial calculation: ");
        int n = input.nextInt();
        if (factorial(n) == -1) {
            System.out.println("Invalid integer for factorial calculation.");
        } else {
            System.out.println("Factorial of " + n + ": " + factorial(n));
        }
        
        /**
         * Problem 3 questions:
         * 1. Why did one wrong return make every result wrong?
         * Answer: One wrong return made every result wrong because of the way the base case was written. Every valid
         * integer inputted to the program will always be deducted by 1 until it reaches the base case of 0, where
         * it returns the value 0. With the recursive formula n * factorial(n - 1), no matter how big the calculations become,
         * because it is multiplied by the returned 0 at the end, it will output a 0, thus making it incorrect.
         * 
         * 2. Stretch: what happens for factorial(-2) with your corrected code, and why?
         * Answer: First, it returns a guard number, treated as a safeguard against unexpected inputs, and where the number
         * itself is unobtainable through normal calculations within the method.
         * Second, the main string also contains an if-else statement to check the output of the method. If the sentinel number
         * is returned, it will output a message that states that the integer inputted was invalid.
         */
    }

    
    
    //Problem 1 method
    public static double computeAverage(int total, int count) {
        if (count <= 0) {
            return 0.0;
        }
        return (double)total/count;
    }
    
    //Problem 2 method - Part A
    public static int countPassing(int[] grades, int passingMark) {
        int passed = 0;
        for (int i = 0; i <= grades.length - 1; i++) {
            if (grades[i] >= passingMark) {
                passed++;
            }
        }
        return passed;
    }
    
    //Problem 2 method - Part B
    public static int countPassingRecursive(int[] grades, int passingMark, int index) {
        if (index <= 0) {
            return 0;
        }
        if (grades[index - 1] >= passingMark) {
            return 1 + countPassingRecursive(grades, passingMark, index - 1);
        } else {
            return countPassingRecursive(grades, passingMark, index - 1);
        }
    }
    
    //Problem 3 method
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
