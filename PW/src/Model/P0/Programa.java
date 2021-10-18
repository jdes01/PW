package Model.P0;

import Model.P0.Espectaculo;
import Model.P0.Espectaculo.categoria;
import Model.P0.Programacion;

import java.util.Date;

/**
 * Clase programa 
 * @author David Salcedo Sanchez
 *
 */

public class Programa {
	

	public static void main(String [] args) {

		Programacion programacion = new Programacion();
		
		Espectaculo concierto1 = new Espectaculo();
		Espectaculo monologo = new Espectaculo();
		
		
		concierto1.setTitulo("Grupo 1");
		concierto1.setCategoria(categoria.concierto);
		concierto1.setDescripcion("Va a cantar el primer grupo");
		concierto1.setFecha(new Date(System.currentTimeMillis()*1));
		concierto1.setLocalidadesDisponible(10);
		concierto1.setLocalidadesVendidas(100);
		
		monologo.setTitulo("Monologo");
		monologo.setCategoria(categoria.monologo);
		monologo.setDescripcion("Va a actuar el comico");
		monologo.setFecha(new Date(System.currentTimeMillis()*1));
		monologo.setLocalidadesDisponible(20);
		monologo.setLocalidadesVendidas(200);
		
		Espectaculo concierto3 = new Espectaculo("Grupo 2", categoria.concierto, "Va a cantar el segundo grupo");		
		Espectaculo concierto4 = new Espectaculo("Grupo 3", categoria.concierto, "Va a cantar el tercers grupo");
		
		concierto3.setFecha(new Date(System.currentTimeMillis()*1));
		concierto3.setLocalidadesDisponible(30);
		concierto3.setLocalidadesVendidas(300);
		
		concierto4.setFecha(new Date(System.currentTimeMillis()*1));
		concierto4.setLocalidadesDisponible(40);
		concierto4.setLocalidadesVendidas(400);
		
		programacion.programarEspectaculo(concierto1);
		programacion.programarEspectaculo(monologo);
		programacion.programarEspectaculo(concierto3);
		programacion.programarEspectaculo(concierto4);
		
		System.out.println(programacion.verTitulos());
		System.out.println(programacion.verProximosEspectaculos(new Date(System.currentTimeMillis()*1)));
		System.out.println(programacion.verProximosEspectaculos(new Date(System.currentTimeMillis()/1)));
		System.out.println(programacion.verEspectaculosDisponibles(categoria.concierto));
		
		programacion.eliminarEspectaculo("Grupo 3");
		programacion.imprimirEventos();
	}
}