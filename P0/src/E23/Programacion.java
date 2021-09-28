package ej23;

import ej1.Espectaculo;
import ej1.Espectaculo.categoria;

import java.util.ArrayList;
import java.util.Date;
 

public class Programacion {

	private ArrayList<Espectaculo> Espectaculos;
	
	public Programacion() {

		this.Espectaculos = new ArrayList<Espectaculo>();
	}
	
	public void programarEspectaculo(Espectaculo espectaculo) {
        
		this.Espectaculos.add(espectaculo);
	}
	
	public ArrayList<Espectaculo> verEspectaculos(){

		return this.Espectaculos;
	}
	
	public void imprimirEventos() {

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			System.out.println(this.Espectaculos.get(i).toString());			
		}
	}
	
	public ArrayList<String> verTitulos(){

		ArrayList<String> titulos = new ArrayList<String>();

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			titulos.add(this.Espectaculos.get(i).getTitulo());
		}

		return titulos;
	}
	
	public boolean eliminarEspectaculo(String titulo) {

		for(int i = 0; i < this.Espectaculos.size(); i++) {

			if (this.Espectaculos.get(i).getTitulo() == titulo) {

				this.Espectaculos.remove(i);
				return true;
			}
		}
		return false;
	}
	
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
	
	public ArrayList<Espectaculo> verEspectaculosDisponibles(categoria categoria){

		ArrayList<Espectaculo> espectaculosDisponibles = new ArrayList<Espectaculo>();
		
		for(int i = 0; i < this.Espectaculos.size(); i++) {

			if(this.Espectaculos.get(i).getCategoria() == categoria and this.Espectaculos.get(i).getLocalidadesDisponibles() > 0) {

				espectaculosDisponibles.add(this.Espectaculos.get(i));
			}
		}
		return espectaculosDisponibles;
	}
}