package refactor;

import java.io.IOException;
import java.sql.SQLException;

import refactor.UseCases.DeleteUserUseCase;
import refactor.UseCases.LoginUserUseCase;
import refactor.UseCases.RegisterAdminUseCase;
import refactor.UseCases.RegisterViewerUseCase;
import refactor.UseCases.UpdateUserDataUseCase;

public class MainHandler {

    private static final MainHandler mainHandler = new MainHandler();

    public static MainHandler getHandler() {

		if (MainHandler.mainHandler == null) {

			MainHandler mainHandler = new MainHandler();
			return mainHandler;
		}

		return MainHandler.mainHandler;
	}

    public void registerViewer(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        RegisterViewerUseCase.registerViewer(name, lastName, nickName, mail);
    }

	public void registerAdmin(String name, String lastName, String nickName, String mail) throws IOException, ClassNotFoundException, SQLException{

        RegisterAdminUseCase.registerAdmin(name, lastName, nickName, mail);
    }

	public void deleteUser(String mail) throws IOException{

		DeleteUserUseCase.deleteUser(mail);
	}
    
	public Boolean loginUser(String mail) throws IOException{

		return LoginUserUseCase.loginUser(mail);
	}

	public void updateUserData(String userMail, String name, String lastName, String nickName, String mail){

		UpdateUserDataUseCase.updateUserData(userMail, name, lastName, nickName, mail);
	}

}
