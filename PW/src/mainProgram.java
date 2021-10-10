import java.io.IOException;
import java.util.Scanner;

import Handlers.*;

public class mainProgram {
    public static void main(String[] args) throws IOException{

    MainHandler handler = MainHandler.getHandler();
    @SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in); 
    
    while(1==1) {
        System.out.println("please, choose an option:");
        System.out.println("1. Create User");
        System.out.println("2. Create Show");
        String option = scanner.nextLine();
        switch(option) {
        case "1":
        	handler.createUser();
        case "2":
        	handler.createShow();
        }
    }
    }
  }