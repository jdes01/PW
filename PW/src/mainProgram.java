import java.io.IOException;

import Handlers.*;

public class mainProgram {
    public static void main(String[] args) throws IOException{

    MainHandler handler = MainHandler.getHandler();
    
    handler.createUser();
    }
  }