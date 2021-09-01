/* ZCrowell_Week12_Exceptions.java

 * Added a try and catch block to the "ZCrowell_Part2" assignment
 * from Week 9.
 *
 * A try-catch block was added to handle "file not found" exceptions.
 * It alerts the user and allows them to enter the correct file name.
 *
 *
 * Last edited December 18, 2020 by Zane Crowell
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // declare variables
        double scoreArray[] = new double[5];    // array of 5 test scores
        double sum = 0.0;
        double avg;
        double min = 101.0;
        double max = 0.0;
        double[] resultsArray = new double[3];

        // set up scanner
        Scanner kb = new Scanner(System.in);
        Scanner sourceFile = new Scanner(System.in);

        // do-while loop to get file name from user. Uses try-catch to inform user if
        // the input file name is correct. For this example you can input either (without
        // quotes) "scores.txt", or "newScores.txt" - two text files with 5 test scores.
        do {
            try {
                System.out.println("Enter the name of the text file containing the test scores: ");
                sourceFile = new Scanner(new File(kb.nextLine()));

                for (int i=0; i<scoreArray.length; i++)
                    scoreArray[i] = sourceFile.nextDouble();

            } catch(Exception e) {
                System.out.println("File not found - please enter a different file name.");
            }
        } while(sourceFile == null);

        // for loop - find sum of scoreArray
        for (int i=0; i<scoreArray.length; i++) {
            sum = sum + scoreArray[i];
        }

        // combine min and max loops:
        for (int i=0; i< scoreArray.length; i++) {
            if (scoreArray[i] < min) {
                min = scoreArray[i];
            }
            if (scoreArray[i] > max) {
                max = scoreArray[i];
            }
        }

        // calculate average score
        avg = (sum/scoreArray.length);

        // put min, max, & avg in resultsArray
        resultsArray[0] = min;
        resultsArray[1] = max;
        resultsArray[2] = avg;

        // set up scanner to outputting results to text file
        Scanner outputFile = new Scanner(System.in);

        // output output min, max, and avg to text file
        File results = new File("testResults.txt");
        PrintWriter fileOut = new PrintWriter(results);

        fileOut.println("The minimum test score is: " + resultsArray[0]);
        fileOut.println("The maximum test score is: " + resultsArray[1]);
        fileOut.printf("The average test score is: %.1f%n", resultsArray[2]);   // modified to use printf to format the avg
        fileOut.close();

    } // end method main()

} // end class Main


