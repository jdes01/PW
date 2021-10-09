package Model;

import Model.Espectaculo;
import Model.Espectaculo.categoria;

import java.util.ArrayList;
import java.util.Date;
 
/**
 * 
 * @author kan0
 *
 */

public class Programacion {

	private ArrayList<Espectaculo> Espectaculos;
	
/**
 * 	
 */
	
	public Programacion() {

		this.Espectaculos = new ArrayList<Espectaculo>();
	}
	
/**
 * 	
 * @param espectaculo
 */
	
	public void programarEspectaculo(Espectaculo espectaculo) {
        
		this.Espectaculos.add(espectaculo);
	}
	
/**
 * 	
 * @return
 */
	
	public ArrayList<Espectaculo> verEspectaculos(){

		return this.Espectaculos;
	}
	
/**
 * 	
 */
	
	public void imprimirEventos() {

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			System.out.println(this.Espectaculos.get(i).toString());			
		}
	}
	
/**
 * 	
 * @return
 */
	
	public ArrayList<String> verTitulos(){

		ArrayList<String> titulos = new ArrayList<String>();

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			titulos.add(this.Espectaculos.get(i).getTitulo());
		}

		return titulos;
	}
	
/**
 * 	
 * @param titulo
 * @return
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
 * 
 * @param fecha
 * @return
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
 * 	
 * @param categoria
 * @return
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