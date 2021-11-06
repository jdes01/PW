package P0;

import java.util.ArrayList;
import java.util.Date;

import P0.Espectaculo.categoria;
 
/**
 * Clase programacion que tiene todo lo relacionado a la programacion de los espectaculos
 * @author Javier De Santiago Palomino
 *
 */

public class Programacion {

	private ArrayList<Espectaculo> Espectaculos;
	
/**
 * 	Constructor de la clase programacion
 */
	
	public Programacion() {

		this.Espectaculos = new ArrayList<Espectaculo>();
	}
	
/**
 * 	Funcion publica para programar espectaculos
 * @param espectaculo Espectaculo que se va a programar
 */
	
	public void programarEspectaculo(Espectaculo espectaculo) {
        
		this.Espectaculos.add(espectaculo);
	}
	
/**
 * 	Funcion publica para ver los espectaculos
 * @return Retorna los espectaculos
 */
	
	public ArrayList<Espectaculo> verEspectaculos(){

		return this.Espectaculos;
	}
	
/**
 * 	Funcion publica que imprime los eventos
 */
	
	public void imprimirEventos() {

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			System.out.println(this.Espectaculos.get(i).toString());			
		}
	}
	
/**
 *  Funcion publica para ver los titulos de los espectaculos
 * @return Retorna los titulos de los espectaculos
 */
	
	public ArrayList<String> verTitulos(){

		ArrayList<String> titulos = new ArrayList<String>();

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			titulos.add(this.Espectaculos.get(i).getTitulo());
		}

		return titulos;
	}
	
/**
 * 	Funcion publica para eliminar espectaculos
 * @param titulo Titulo de los espectaculos
 * @return Retorna false
 */
	
	public boolean eliminarEspectaculo(String titulo) {

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			if (this.Espectaculos.get(i).getTitulo() == titulo) {

				this.Espectaculos.remove(i);
				return true;
			}
		}
		return false;
	}
	
/**
 * Funcion publica para ver los proximos espectaculos
 * @param fecha Fecha del espectaculo
 * @return Retorna los espectaculos
 */
	
	public ArrayList<Espectaculo> verProximosEspectaculos(Date fecha){

		Date hoy = new Date(System.currentTimeMillis());

		if(fecha.before(hoy)) { return null; }

		ArrayList<Espectaculo> espectaculos = new ArrayList<Espectaculo>();

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			if(this.Espectaculos.get(i).getFecha().before(fecha)) {

				espectaculos.add(this.Espectaculos.get(i));
			}
		}
		return espectaculos;
	}

/**
 * 	Funcion publica para ver los espectaculos disponibles
 * @param categoria Categoria del espectaculo
 * @return Retorna los espectaculos disponibles
 */
	
	public ArrayList<Espectaculo> verEspectaculosDisponibles(categoria categoria){

		ArrayList<Espectaculo> espectaculosDisponibles = new ArrayList<Espectaculo>();
		
		for(int i = 0; i < this.Espectaculos.size(); i++) {

			if(this.Espectaculos.get(i).getCategoria() == categoria && this.Espectaculos.get(i).getLocalidadesDisponibles() > 0) {

				espectaculosDisponibles.add(this.Espectaculos.get(i));
			}
		}
		return espectaculosDisponibles;
	}
}