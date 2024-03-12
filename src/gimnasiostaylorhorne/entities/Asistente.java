package gimnasiostaylorhorne.entities;

import java.util.Date;

public class Asistente {

	private int id;
	private int idGimnasio;
	private String dniNiePasaporte;
	private int idLocalidad;
	private boolean activo;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private float cuotaMensual;

	public Asistente() {
		super();
	}

	public Asistente(int id, int idGimnasio, String dniNiePasaporte, int idLocalidad, boolean activo, String nombre,
			String apellido, Date fechaNac, float cuotaMensual) {
		super();
		this.id = id;
		this.idGimnasio = idGimnasio;
		this.dniNiePasaporte = dniNiePasaporte;
		this.idLocalidad = idLocalidad;
		this.activo = activo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.cuotaMensual = cuotaMensual;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdGimnasio() {
		return idGimnasio;
	}

	public void setIdGimnasio(int idGimnasio) {
		this.idGimnasio = idGimnasio;
	}

	public String getDniNiePasaporte() {
		return dniNiePasaporte;
	}

	public void setDniNiePasaporte(String dniNiePasaporte) {
		this.dniNiePasaporte = dniNiePasaporte;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public float getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

}
