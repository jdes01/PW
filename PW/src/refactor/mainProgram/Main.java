package refactor.mainProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.sql.SQLException;

import refactor.MainHandler;

public class Main {

    static void printMenu(){

        System.out.print("\n");
        System.out.print("#######################################################\n");
        System.out.print("########                                      #########\n");
        System.out.print("########     - Gestor de espectáculos -       #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("#######################################################\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 1 ] Registrar Espectador          #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 2 ] Registrar Show                #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("#######################################################\n");
        System.out.print("########  -> ");
    }
    
    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, NoSuchFileException{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        while(true){

            printMenu();

            int option = Integer.parseInt (br.readLine());

            if(option == 1){
        
                System.out.print("########  Introduzca el nombre del user:      #########\n");
                System.out.print("######## -> ");
                String inputName = br.readLine();
                System.out.print("########  Introduzca el apellido:             #########\n");
                System.out.print("######## -> ");
                String inputLastName = br.readLine();
                System.out.print("########  Introduzca el nick:                 #########\n");
                System.out.print("######## -> ");
                String inputNickName = br.readLine();
                System.out.print("########  Introduzca el correo:               #########\n");
                System.out.print("######## -> ");
                String inputMail = br.readLine();
                System.out.print("########                                      #########");

                MainHandler.getHandler().registerViewer(inputName, inputLastName, inputNickName, inputMail);

            }

            if(option == 2){
        
                System.out.print("########  Introduzca el nombre del user:      #########\n");
                System.out.print("######## -> ");
                String inputName = br.readLine();
                System.out.print("########  Introduzca el apellido:             #########\n");
                System.out.print("######## -> ");
                String inputLastName = br.readLine();
                System.out.print("########  Introduzca el nick:                 #########\n");
                System.out.print("######## -> ");
                String inputNickName = br.readLine();
                System.out.print("########  Introduzca el correo:               #########\n");
                System.out.print("######## -> ");
                String inputMail = br.readLine();
                System.out.print("########                                      #########");

            }
        }

    }
}
