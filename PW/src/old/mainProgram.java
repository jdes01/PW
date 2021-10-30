package old;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import old.Handlers.*;
import old.Model.Entities.User;
import old.Model.Entities.Show.Show;

public class mainProgram {
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

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
			handler.updateShow();
			break;
		case 5:
			handler.deleteUser();
			break;
		case 6:
			handler.cancelShow();
			break;
		case 7:
			handler.cancelAllShows();
			break;
		case 8:
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
		case 9:
			try {
				ArrayList<Show> shows = handler.getShows();
				for (Show show : shows) {
					System.out.println(
							"Title: " + show.getTitle() + "; Description: " + show.getDescription() + "; Category: " + show.getCategory() + "; Capacity: " + show.getCapacity());
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