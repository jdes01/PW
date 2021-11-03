package refactor;

import java.io.IOException;

import refactor.UseCases.RegisterUserUseCase;

public class MainHandler {

    private static final MainHandler mainHandler = new MainHandler();

    public static MainHandler getHandler() {

		if (MainHandler.mainHandler == null) {

			MainHandler mainHandler = new MainHandler();
			return mainHandler;
		}

		return MainHandler.mainHandler;
	}

    public void registerUser(String name, String lastName, String nickName, String mail) throws IOException{

        RegisterUserUseCase.registerUser(name, lastName, nickName, mail);
    }


    
}
