package gimnasiostaylorhorne.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gimnasiostaylorhorne.entities.Localidad;

public class ControllerLocalidad {

	private static String nombreTabla = "gimnasios.localidad";

	public static List<Localidad> getTodos() {
		List<Localidad> l = new ArrayList<Localidad>();

		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Localidad o = getEntidadFromResultSet(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	private static Localidad getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Localidad o = new Localidad();
		o.setId(rs.getInt("id"));
		o.setLocalidad(rs.getString("localidad"));
		return o;
	}
}
