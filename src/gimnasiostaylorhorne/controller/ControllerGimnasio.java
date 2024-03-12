package gimnasiostaylorhorne.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gimnasiostaylorhorne.entities.Gimnasio;

public class ControllerGimnasio {

	private static String nombreTabla = "gimnasios.gimnasio";

	public static List<Gimnasio> getTodos() {
		List<Gimnasio> l = new ArrayList<Gimnasio>();

		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Gimnasio o = getEntidadFromResultSet(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	private static Gimnasio getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Gimnasio o = new Gimnasio();
		o.setId(rs.getInt("id"));
		o.setLocalidad(rs.getString("descripcion"));
		return o;
	}
}
