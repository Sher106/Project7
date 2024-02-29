//**************************************************************************************************************************
// FileReader.java      Author: Hall/ Sherica
//Date: February 28, 2024
//***********************************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public class FileReader {
        public static void main(String[] args) {

            //Can input any file path within the quotations
            String fileName = "C:\\Users\\juliet mclean\\Documents\\Sherica\\CSIT501\\Project7\\src\\Jesus Saves";

                try {
                    checkFilePopulated(fileName);
                    System.out.println("File successfully read.");    //Prints message
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + e.getMessage());    //Prints message
                } catch (EmptyFileException e) {
                    System.out.println("Empty file exception: " + e.getMessage());    //Prints message
                }
        }
         //Creates exception object and throws exception if empty
        public static void checkFilePopulated(String fileName) throws FileNotFoundException, EmptyFileException {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                throw new EmptyFileException("File is empty.");
            }

            scanner.close();
        }
    }
    //Sets up the exception object with a particular message
    class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}