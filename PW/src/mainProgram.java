import java.io.IOException;
import java.util.ArrayList;

import Handlers.*;
import Model.Entities.User;

public class mainProgram {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		MainHandler handler = MainHandler.getHandler();
		Integer option = 1;

		option = handler.mainMenu();
		switch (option) {
		case 1:
			handler.createUser();
			break;
		case 2:
			handler.createShow();
			break;
		case 3:
			handler.updateUser();
			break;
		case 4:
			handler.deleteUser();
			break;
		case 5:
			try {
				ArrayList<User> users = handler.getUsers();
				for (User user : users) {
					System.out.println(
							"Username: " + user.getUsername() + "; Name: " + user.getName() + "; Mail: " + user.getMail());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}