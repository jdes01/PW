import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Handlers.*;
import Model.Entities.User.User;

public class mainProgram {
	public static void main(String[] args) throws IOException {

		MainHandler handler = MainHandler.getHandler();
		Scanner scanner = new Scanner(System.in);
		Integer option = 1;
		
		option = handler.mainMenu();
		switch(option) {
		case 1:
			handler.createUser();
			break;
		case 2:
			handler.createShow();
			break;
		case 3:
			handler.deleteUser();
			break;
		case 4:
			try {
				ArrayList<User> users = handler.getUsers();
				for(User user : users) {
					System.out.println(user.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		scanner.close();
	}
}