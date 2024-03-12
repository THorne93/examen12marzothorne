package gimnasiostaylorhorne.entities;

public class Localidad {

	private int Id;
	private String localidad;

	public Localidad() {
		super();
	}

	public Localidad(int id, String localidad) {
		super();
		Id = id;
		this.localidad = localidad;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return localidad;
	}

}
