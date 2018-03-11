/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFolder;

import java.util.Scanner;

/**
 *
 * @author Nemanja
 */
public class ScannerTest {
    
    static Scanner test = new Scanner(System.in);
    public static void main(String[] args){
     System.out.println("Tell me your name please.");
     String testScan = test.nextLine();
     System.out.println("Please tell me your age");
     String ageNew = test.nextLine();
     
     System.out.println("This is test " + testScan + ", your age is: " + ageNew);
    }
    
}
