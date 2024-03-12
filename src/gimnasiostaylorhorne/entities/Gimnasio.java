package gimnasiostaylorhorne.entities;

public class Gimnasio {

	private int Id;
	private String localidad;

	public Gimnasio() {
		super();
	}

	public Gimnasio(int id, String localidad) {
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
