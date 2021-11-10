package refactor.mainProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.sql.SQLException;
import java.util.Scanner;

import refactor.MainHandler;
import refactor.Model.Entities.Review;

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
        System.out.print("########  [ 2 ] Display all users             #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 3 ] Update user data              #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 4 ] Create Review                 #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 5 ] Display all Reviews           #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("#######################################################\n");
        System.out.print("########  -> ");
    }
    
    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, NoSuchFileException{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        while(true){

            printMenu();

            Scanner s = new Scanner(System.in);

            int option = s.nextInt();

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
        
                System.out.print("######## ");

                for(String mail: MainHandler.getHandler().getAllUsersMails()){

                    System.out.print(mail);
                    System.out.print(" ########\n");
                }

            }

            if(option == 3){

                System.out.print("########  Introduzca el correo del user que desea actualizar: \n");
                System.out.print("######## -> ");
                String userMail = br.readLine();
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

                MainHandler.getHandler().updateUserData(userMail, inputName, inputLastName, inputNickName, inputMail);
            }

            if(option == 4){

                System.out.print("########  Introduzca el mail del user  :      #########\n");
                System.out.print("######## -> ");
                String inputUserMail = br.readLine();
                System.out.print("########  Introduzca el titulo:               #########\n");
                System.out.print("######## -> ");
                String inputTitle = br.readLine();
                System.out.print("########  Introduzca el texto:                #########\n");
                System.out.print("######## -> ");
                String inputText = br.readLine();
                System.out.print("########  Introduzca el titulo del show:      #########\n");
                System.out.print("######## -> ");
                String inputShowTitle = br.readLine();
                System.out.print("########  Introduzca la calificacion   :      #########\n");
                System.out.print("######## -> ");
                Integer inputScore = Integer.parseInt(br.readLine());
                System.out.print("########                                      #########");

                MainHandler.getHandler().createReview(inputUserMail, inputTitle, inputText, inputShowTitle, inputScore);
            }

            if(option == 5){

                System.out.print("######## ");

                for(Review review: MainHandler.getHandler().getAllReviews()){

                    System.out.print(review.getTitle());
                    System.out.print(" ");
                    System.out.print(review.getText());
                    System.out.print(" ");
                    System.out.print(review.getUser().getName());
                    System.out.print(" ");
                    System.out.print(review.getShow().getTitle());
                    System.out.print(" ");
                    System.out.print(review.getScore().getScore());
                    System.out.print(" ");
                    System.out.print(" ########\n");
                }
            }
        }

    }
}
