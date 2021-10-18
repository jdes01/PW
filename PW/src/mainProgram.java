import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

import Handlers.*;
import Model.Entities.User.User;

public class mainProgram {
	public static void main(String[] args) throws IOException {

		MainHandler handler = MainHandler.getHandler();
		Integer option = 1;
		
		option = handler.mainMenu();
		switch(option) {
		case 1:
			handler.createUser();
			try {
				ArrayList<User> users = handler.getUsers();
				for(User user : users) {
					System.out.println(user.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			handler.createShow();
			break;
		default:
			break;
		}
	}
}