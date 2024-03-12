package gimnasiostaylorhorne.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gimnasiostaylorhorne.entities.Asistente;

public class ControllerAsistente {

	private static String nombreTabla = "gimnasios.asistente";

	public static List<Asistente> getTodos(int idGimnasio, String searchName) {
		List<Asistente> l = new ArrayList<Asistente>();
		String search = ("'%" + searchName + "%'");
		System.out.println(search);
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement().executeQuery(
					"Select * from " + nombreTabla + " where idGimnasio=" + idGimnasio + " and nombre like " + search);
			while (rs.next()) {
				Asistente o = getEntidadFromResultSet(rs);

				l.add(o);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	private static Asistente getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Asistente o = new Asistente();
		o.setId(rs.getInt("id"));
		o.setIdGimnasio(rs.getInt("idGimnasio"));
		o.setDniNiePasaporte(rs.getString("dniNiePasaporte"));
		o.setActivo(rs.getBoolean("activo"));
		o.setNombre(rs.getString("nombre"));
		o.setApellido(rs.getString("apellidos"));
		o.setFechaNac(rs.getDate("fechaNacimiento"));
		o.setCuotaMensual(rs.getFloat("cuotaMensual"));
		o.setIdLocalidad(rs.getInt("idLocalidad"));

		return o;
	}

	public static Asistente getAsistente(int id) throws SQLException {
		ResultSet rs = ConnectionManager.getConexion().createStatement()
				.executeQuery("Select * from " + nombreTabla + " where id='" + id + "'");
		Asistente o = null;
		if (rs.next()) {
			o = new Asistente();
			o.setId(rs.getInt("id"));
			o.setIdGimnasio(rs.getInt("idGimnasio"));
			o.setDniNiePasaporte(rs.getString("dniNiePasaporte"));
			o.setActivo(rs.getBoolean("activo"));
			o.setNombre(rs.getString("nombre"));
			o.setApellido(rs.getString("apellidos"));
			o.setFechaNac(rs.getDate("fechaNacimiento"));
			o.setCuotaMensual(rs.getFloat("cuotaMensual"));
			o.setIdLocalidad(rs.getInt("idLocalidad"));

		}
		return o;
	}

	public static int save(Asistente o) {
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("update " + nombreTabla
					+ " set idGimnasio = ?, dniNiePasaporte = ?, idLocalidad = ?, "
					+ "activo = ?, nombre = ?, apellidos = ?, " + "fechaNacimiento = ?, cuotaMensual = ? where id = ?");

			ps.setInt(1, o.getIdGimnasio());
			ps.setString(2, o.getDniNiePasaporte());
			ps.setInt(3, o.getIdLocalidad());
			ps.setBoolean(4, o.isActivo());
			ps.setString(5, o.getNombre());
			ps.setString(6, o.getApellido());
			if (o.getFechaNac() != null) {
				ps.setDate(7, new java.sql.Date(o.getFechaNac().getTime()));
			} else {
				ps.setDate(7, null);
			}
			ps.setFloat(8, o.getCuotaMensual());
			ps.setInt(9, o.getId());

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
