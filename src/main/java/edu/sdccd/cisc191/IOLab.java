package edu.sdccd.cisc191;

import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class IOLab {
    public static String readTestResults(String s) {

        // Set FileResult as new File parameter: path + s
        File FileResult = new File("src/main/resources/" + s);

        // Ties result 'r' to string variable
        String r = "";

        try {

            // Set scanner as new Scanner object, reads FileResult file
            Scanner scanner = new Scanner(FileResult);

            // while loop reads every line in FileResult file
            while (scanner.hasNextLine()) {

                r += scanner.nextLine();

            }
            return r;

        }
        // FileNotFoundException returns nothing
        catch (FileNotFoundException e) {
            return "";
        }

    }

    public static void appendTestResult(String s, String s1) {

        // try statement for appending new file
        try {
            // set bw as new BufferedWriter wrapping new FileWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/" + s,true));

            // overwrites new TestResult to new line
            bw.write("\n" + s1);

            // closes bw
            bw.close();

        }

        // IOException returns error statement
        catch (IOException e) {
            System.out.println("An error has occurred");
        }

    }



    public static String readDateTime(String s) {

        try{

            // sets url as new URL object
            URL url = new URL(s);

            // sets dl as new scanner object
            Scanner dl = new Scanner(url.openStream());

            // next line in dl as new string getInput
            String getInput = dl.nextLine();

            // transfers data from index of datetime into integer dateTime
            int dateTime = getInput.indexOf("datetime");

            // returns substring of dateTime
            return getInput.substring(dateTime + 11, dateTime + 43);

        }

            // errors for catch statements
            catch(FileNotFoundException e) {
                System.out.println("An error has occurred");
        }
            catch(MalformedURLException m) {
                System.out.println("An error has occurred");
        }
            catch(IOException e) {
                throw new RuntimeException(e);
        }

        return "";

        }

    }

