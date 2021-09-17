package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var filename = "Products.txt";
        var products = Paths.get(filename);
        var productName = new ArrayList<String>();
        var productPrice = new ArrayList<Float>();
        var productCount = new ArrayList<Integer>();
        var productLines = Files.readAllLines(products);
        for (var line : productLines) {
            var splitline = line.split(",");
            productName.add(splitline[0]);
            productPrice.add(Float.valueOf(splitline[1]));
            productCount.add(Integer.valueOf(splitline[2]));
        }

        //System.out.println("Product name: " +productName+ "  Product price: " +productPrice+ "  Product count: " +productCount);
        var reader = new Scanner(System.in);
        var userResponse = "";
        System.out.print("Hello, what would you like to look up? At any time you can end the program by typing 'end'.");

        while (!userResponse.equals("end")) {
            userResponse = reader.nextLine();

            if (userResponse.equals("end")) {
                System.out.print("Goodbye");
                break;
            }

            if (productName.contains(userResponse)) {
                var productSearch = productName.indexOf(userResponse);
                var price =productPrice.get(productSearch);
                var count = productCount.get(productSearch);
                System.out.println("Yes, we have " +count+ " " +userResponse+ " priced at " +price+ " dollars per "+userResponse);
            }
            else {
                System.out.print("I'm sorry but we do not have that, please check for a different product");
            }
        }
    }

}