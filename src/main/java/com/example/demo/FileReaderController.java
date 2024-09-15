package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

@RestController
public class FileReaderController {
    @GetMapping("/FileReader")
    public String index() {
        String stringcontent="";
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringcontent+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return stringcontent;
    }

    @GetMapping("/GetNumber")
    public String GetNumber() {
        int a = 0;
        int b=1;
        return Integer.toString(b/a);
    }
}
