package P0;
import java.util.Date;

/**
 * Clase espectaculo que tiene todo lo referente a los espectaculos
 * @author Alberto Cano Turnes
 *
 */

public class Espectaculo {
	
	

	public enum categoria{ concierto, obra, monologo }
	
	private categoria categoria;
	
	private String titulo;
	private String descripcion;
	
	private Date fecha;
	
	private int localidadesDisponibles;
	private int localidadesVendidas;
	
	
	public Espectaculo() {}
	
/**
 * Constructor de la clase espectaculo
 * @param titulo Titulo del espectaculo
 * @param categoria Categoria del espectaculo
 * @param descripcion Descripcion del espectaculo
 */
	
	public Espectaculo(String titulo, categoria categoria, String descripcion ) {
		
		this.titulo      = titulo;
		this.categoria   = categoria;
		this.descripcion = descripcion;
	}
	
/**
 * Getter del titulo
 * @return Retorna el titulo
 */
	public String getTitulo() { return this.titulo; }
	
/**
 * Getter de la categoria
 * @return Retorna la categoria
 */
	
	public categoria getCategoria() { return this.categoria; }
	
/**
 * Getter de la descripcion
 * @return Retorna la descripcion
 */
	
	public String getDescripcion() { return this.descripcion; }

/**
 * Getter de la fecha
 * @return Retorna la fecha
 */
	
	public Date getFecha(){ return this.fecha; }
	
/**
 * Getter de las localidades disponibles
 * @return Retorna las localidades disponibles
 */
	
	public int getLocalidadesDisponibles() { return this.localidadesDisponibles; }

/**
 * Getter de las localidades vendidas
 * @return Retorna las localidades vendidas
 */
	
	public int getLocalidadesVendidas() { return this.localidadesVendidas; }
	
/**
 * Setter del titulo
 * @param titulo Titulo del espectaculo
 */
	
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
/**
 * Setter de la categoria
 * @param categoria Categoria del espectaculo
 */
	
	public void setCategoria(categoria categoria) { this.categoria = categoria; }
	
/**
 * Setter de la descripcion
 * @param descripcion Descripcion del espectaculo
 */
	
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
/**
 * Setter de la fecha
 * @param fecha Fecha del espectaculo
 */
	
	public void setFecha(Date fecha) { this.fecha = fecha; }
	
/**
 * Setter de las localidades disponibles
 * @param localidadesDisponibles Localidades disponibles para el espectaculo
 */
	
	public void setLocalidadesDisponible(int localidadesDisponibles) { this.localidadesDisponibles = localidadesDisponibles; }
	
/**
 * Setter de las localidades vendidas
 * @param localidadesVendidas Localidades vendidas para el espectaculo
 */
	
	public void setLocalidadesVendidas(int localidadesVendidas) { this.localidadesVendidas = localidadesVendidas; }
	
/**
 * Funcion publica que convierte todo en un string
 * @return Retorna el string con el titulo, categoria, descripcion...
 */
	
	public String toString() {
		
		String info = "Título: " + this.titulo + ", Categoría: " + this.categoria + ", Descripción: " + this.descripcion + ", Fecha: " + this.fecha + ", las localidades disponibles: " + this.localidadesDisponibles + " y las localidades vendidas: " + this.localidadesVendidas;
		
		return info;
	}
	
	
}