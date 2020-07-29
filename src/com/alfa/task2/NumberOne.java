package com.alfa.task2;

import java.util.Scanner;

public class NumberOne {

    public static void main(String[] args) {
        // write your code here
        //For capturing user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String for check:");
        String string = scanner.nextLine();
        /* If function returns true then the string is
         * palindrome else not
         */
        if (isPal(string))
            System.out.println(string + " is a palindrome");
        else
            System.out.println(string + " is not a palindrome");
    }

    public static boolean isPal(String P){
        int l = 0;
        int h = P.length()-1;

        // Lowercase string
        P = P.toLowerCase();

        // Compares character until they are equal
        while(l <= h)
        {

            char getAtl = P.charAt(l);
            char getAth = P.charAt(h);

            // If there is another symbol in left
            // of sentence
            if (!(getAtl >= 'a' && getAtl <= 'z'))
                l++;

                // If there is another symbol in right
                // of sentence
            else if(!(getAth >= 'a' && getAth <= 'z'))
                h--;

                // If characters are equal
            else if( getAtl == getAth)
            {
                l++;
                h--;
            }

            // If characters are not equal then
            // sentence is not palindrome
            else
                return false;
        }

        // Returns true if sentence is palindrome
        return true;
    }
}
