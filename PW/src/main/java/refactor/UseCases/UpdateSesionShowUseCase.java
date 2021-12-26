package refactor.UseCases;

import java.util.Calendar;

import refactor.Repository.ShowRepository;
import refactor.Repository.UserRepository;

/**
 * Clase que se encarga del caso de uso que llama al repositorio para actualizar una sesión.
 * 
 * @author Marcos Rodríguez Moreno
 */
public class UpdateSesionShowUseCase {
    
    
    /**
     * Función que se encarga del caso de uso que llama al repositorio para actualizar una sesión.
     *  
     * @param id Id de la sesión.
     * @param date Fecha de la sesión.
     * @param capacity Capacidad de la sesión.
     */
    public static void updateSesionShowData(int id, Calendar date, int capacity){

        ShowRepository showRepository = new ShowRepository();

        showRepository.updateShowSesion(id, date, capacity);
    }
}
