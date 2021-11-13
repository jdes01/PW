package refactor.mainProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import refactor.MainHandler;
import refactor.Model.Entities.Review;
import refactor.Model.Entities.User;
import refactor.Model.Entities.Show.Show;
import refactor.Model.ValueObjects.ShowSesion;

public class Main {

    static void printMenu(){

        System.out.print("\n");
        System.out.print("#######################################################\n");
        System.out.print("########                                      #########\n");
        System.out.print("########     - Gestor de espectáculos -       #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("#######################################################\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 0 ] login viewer                  #########\n");
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
        System.out.print("########  [ 6 ] Delete review                 #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 7 ] Create a Single Date Show     #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 8 ] Create a Multiple Date Show   #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 9 ] Create a Season Show          #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 10 ] Display all shows            #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("########  [ 11 ] Rate review                  #########\n");
        System.out.print("########                                      #########\n");
        System.out.print("#######################################################\n");
        System.out.print("########  -> ");
    }
    
    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, NoSuchFileException, ParseException{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        String hostMail = new String();

        while(true){

            printMenu();

            Scanner s = new Scanner(System.in);

            int option = s.nextInt();

            if(option == 0){

                System.out.print("########  Introduzca el mail del user:      #########\n");
                System.out.print("######## -> ");
                String inputMail = br.readLine();

                if (MainHandler.getHandler().loginUser(inputMail) == true){

                    hostMail = inputMail;
                }
            }

            else if(option == 1){
        
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

            else if(option == 2){
        
                System.out.print("######## ");

                for(String mail: MainHandler.getHandler().getAllUsersMails()){

                    System.out.print(mail);
                    System.out.print(" ########\n");
                }

            }

            else if(option == 3){

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

            else if(option == 4){

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

            else if(option == 5){

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

            else if(option == 6){

                System.out.print("########  Introduzca el titulo de la reivew: \n");
                System.out.print("######## -> ");
                String inputReviewTitle = br.readLine();

                MainHandler.getHandler().deleteReviewByTitle(inputReviewTitle);
            }

            else if(option == 7){

                System.out.print("########  Introduzca el titulo :              #########\n");
                System.out.print("######## -> ");
                String inputTitle = br.readLine();
                System.out.print("########  Introduzca la descripcion :         #########\n");
                System.out.print("######## -> ");
                String inputDescription = br.readLine();
                System.out.print("########  Introduzca la categoria :           #########\n");
                System.out.print("######## -> ");
                String inputCategory = br.readLine();
                System.out.print("########  Introduzca la fecha ( dd-MM-yyyy ) :  #########\n");
                System.out.print("######## -> ");
                String inputDate = br.readLine();
                System.out.print("########  Introduzca la capacidad :           #########\n");
                System.out.print("######## -> ");
                Integer inputCapacity = Integer.parseInt(br.readLine());
                System.out.print("########                                      #########");

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date date = sdf.parse(inputDate);
                Calendar formattedCalendar = Calendar.getInstance();
                formattedCalendar.setTime(date);

                MainHandler.getHandler().createPunctualShow(inputTitle, inputDescription, inputCategory, inputCapacity, formattedCalendar);
            }

            else if(option == 8){

                System.out.print("########  Introduzca el titulo :              #########\n");
                System.out.print("######## -> ");
                String inputTitle = br.readLine();
                System.out.print("########  Introduzca la descripcion :         #########\n");
                System.out.print("######## -> ");
                String inputDescription = br.readLine();
                System.out.print("########  Introduzca la categoria :           #########\n");
                System.out.print("######## -> ");
                String inputCategory = br.readLine();

                System.out.print("########  Introduzca el numero de fechas :    #########\n");
                System.out.print("######## -> ");
                Integer numberOfDate = Integer.parseInt(br.readLine());

                ArrayList<Calendar> dates = new ArrayList<Calendar>();

                for(int i=0; i<numberOfDate; i++){

                    System.out.print("########  Introduzca la fecha ( dd-MM-yyyy ) :  #########\n");
                    System.out.print("######## -> ");
                    String inputDate = br.readLine();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = sdf.parse(inputDate);
                    Calendar formattedCalendar = Calendar.getInstance();
                    formattedCalendar.setTime(date);

                    dates.add(formattedCalendar);
                }

                System.out.print("########  Introduzca la capacidad :           #########\n");
                System.out.print("######## -> ");
                Integer inputCapacity = Integer.parseInt(br.readLine());
                System.out.print("########                                      #########");

                MainHandler.getHandler().createMultipleDateShow(inputTitle, inputDescription, inputCategory, inputCapacity, dates);
            }

            else if(option == 9){

                System.out.print("########  Introduzca el titulo :              #########\n");
                System.out.print("######## -> ");
                String inputTitle = br.readLine();
                System.out.print("########  Introduzca la descripcion :         #########\n");
                System.out.print("######## -> ");
                String inputDescription = br.readLine();
                System.out.print("########  Introduzca la categoria :           #########\n");
                System.out.print("######## -> ");
                String inputCategory = br.readLine();

                System.out.print("########  Introduzca la fecha de inicio ( dd-MM-yyyy ) : \n");
                System.out.print("######## -> ");
                String inputBeginDate = br.readLine();

                System.out.print("########  Introduzca la fecha final( dd-MM-yyyy ) : \n");
                System.out.print("######## -> ");
                String inputEndDate = br.readLine();

                System.out.print("########  Introduzca el dia de la semana (1 - 7) : \n");
                System.out.print("######## -> ");
                Integer inputWeekDay = Integer.parseInt(br.readLine());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date beginDate = sdf.parse(inputBeginDate);
                    Date endDate = sdf.parse(inputEndDate);
                    Calendar formattedBeginDate = Calendar.getInstance();
                    Calendar formattedEndDate = Calendar.getInstance();
                    formattedBeginDate.setTime(beginDate);
                    formattedEndDate.setTime(endDate);

                System.out.print("########  Introduzca la capacidad :           #########\n");
                System.out.print("######## -> ");
                Integer inputCapacity = Integer.parseInt(br.readLine());
                System.out.print("########                                      #########");
            
                MainHandler.getHandler().createSeasonPassDateShow(inputTitle, inputDescription, inputCategory, inputCapacity, formattedBeginDate, formattedEndDate, inputWeekDay);
            }
        
            else if(option == 10){

                System.out.print("######## \n");

                for(Show show: MainHandler.getHandler().getAllShows()){

                    System.out.print("\n");
                    System.out.print("Show: ");
                    System.out.print(show.getTitle());
                    System.out.print("\n");

                    System.out.print("Dates: \n");
                    
                    for(ShowSesion sesion: show.getSesions()){

                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        String stringDate = sdf.format(sesion.getDate().getTime());

                        System.out.print(stringDate);
                        System.out.print(" with ");
                        System.out.print(sesion.getTickets());
                        System.out.print(" tickets \n");
                    }
                }
            }

            else if(option == 11){

                System.out.print("########  Introduzca el titulo :              #########\n");
                System.out.print("######## -> ");
                String inputTitle = br.readLine();

                for(Review review: MainHandler.getHandler().getAllReviews()){

                    if(review.getTitle() == inputTitle && review.getUser().getMail() == hostMail){

                        System.out.print("\n");
                        System.out.print("########  Introduzca el score :              #########\n");
                        System.out.print("######## -> ");
                        Integer inputScore = Integer.parseInt(br.readLine());

                        MainHandler.getHandler().rateReviewByUser(review, hostMail, inputScore);
                    }
                }
            }
        }

    }
}