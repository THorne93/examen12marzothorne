package gimnasiostaylorhorne;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gimnasiostaylorhorne.controller.ControllerAsistente;
import gimnasiostaylorhorne.controller.ControllerGimnasio;
import gimnasiostaylorhorne.controller.ControllerLocalidad;
import gimnasiostaylorhorne.entities.Asistente;
import gimnasiostaylorhorne.entities.Gimnasio;
import gimnasiostaylorhorne.entities.Localidad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JCheckBox jcbCheck;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField jtfSearch;
	private JTextField jtfId;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfApellido;
	private JTextField jtfFecha;
	private JTextField jtfCuota;
	private JComboBox<Gimnasio> jcbGimnasio;
	private JComboBox<Asistente> jcbAsistente;
	private JComboBox<Localidad> jcbLocalidad;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
//					frame.cargarPrimero();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de asistentes a gimnasio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Gimnasio:  ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbGimnasio = new JComboBox<Gimnasio>();
		GridBagConstraints gbc_jcbGimnasio = new GridBagConstraints();
		gbc_jcbGimnasio.gridwidth = 4;
		gbc_jcbGimnasio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbGimnasio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbGimnasio.gridx = 2;
		gbc_jcbGimnasio.gridy = 1;
		contentPane.add(jcbGimnasio, gbc_jcbGimnasio);

		JLabel lblNewLabel_2 = new JLabel("Filtro apellidos asistente: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfSearch = new JTextField();
		GridBagConstraints gbc_jtfSearch = new GridBagConstraints();
		gbc_jtfSearch.gridwidth = 2;
		gbc_jtfSearch.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSearch.gridx = 2;
		gbc_jtfSearch.gridy = 2;
		contentPane.add(jtfSearch, gbc_jtfSearch);
		jtfSearch.setColumns(10);

		JButton jbtnFiltrar = new JButton("Filtar asistentes");
		jbtnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtarAsistentes();
			}

		});
		GridBagConstraints gbc_jbtnFiltrar = new GridBagConstraints();
		gbc_jbtnFiltrar.gridwidth = 2;
		gbc_jbtnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnFiltrar.gridx = 4;
		gbc_jbtnFiltrar.gridy = 2;
		contentPane.add(jbtnFiltrar, gbc_jbtnFiltrar);

		JLabel lblNewLabel_6 = new JLabel("Asistentes filtrados: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jcbAsistente = new JComboBox<Asistente>();
		jcbAsistente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getSelected();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		GridBagConstraints gbc_jcbAsistente = new GridBagConstraints();
		gbc_jcbAsistente.gridwidth = 4;
		gbc_jcbAsistente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbAsistente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbAsistente.gridx = 2;
		gbc_jcbAsistente.gridy = 3;
		contentPane.add(jcbAsistente, gbc_jcbAsistente);

		JLabel lblNewLabel_3 = new JLabel("Datos del asistente");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 6;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Id: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 4;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("DNI/NIE/Pasaporte: ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 6;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.gridwidth = 4;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 2;
		gbc_jtfDni.gridy = 6;
		contentPane.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Localidad: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 7;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jcbLocalidad = new JComboBox<Localidad>();
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.gridwidth = 4;
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 2;
		gbc_jcbLocalidad.gridy = 7;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);

		JLabel lblNewLabel_9 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 8;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 4;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 8;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Apellidos: ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 9;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);

		jtfApellido = new JTextField();
		GridBagConstraints gbc_jtfApellido = new GridBagConstraints();
		gbc_jtfApellido.gridwidth = 4;
		gbc_jtfApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido.gridx = 2;
		gbc_jtfApellido.gridy = 9;
		contentPane.add(jtfApellido, gbc_jtfApellido);
		jtfApellido.setColumns(10);

		jcbCheck = new JCheckBox("");
		GridBagConstraints gbc_jcbCheck = new GridBagConstraints();
		gbc_jcbCheck.anchor = GridBagConstraints.EAST;
		gbc_jcbCheck.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCheck.gridx = 1;
		gbc_jcbCheck.gridy = 10;
		contentPane.add(jcbCheck, gbc_jcbCheck);

		JLabel lblNewLabel_12 = new JLabel("Activo");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 2;
		gbc_lblNewLabel_12.gridy = 10;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);

		JLabel lblNewLabel_7 = new JLabel("Fecha de nacimiento: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridwidth = 2;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 11;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 4;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 2;
		gbc_jtfFecha.gridy = 11;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Cuota mensual (€): ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 12;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfCuota = new JTextField();
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.gridwidth = 4;
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 2;
		gbc_jtfCuota.gridy = 12;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		jtfCuota.setColumns(10);

		JButton jbtnGuardar = new JButton("Guardar");
		jbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}

		});

		GridBagConstraints gbc_jbtnGuardar = new GridBagConstraints();
		gbc_jbtnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnGuardar.gridx = 2;
		gbc_jbtnGuardar.gridy = 14;
		contentPane.add(jbtnGuardar, gbc_jbtnGuardar);

		loadGimnasio();
		loadLocalidad();
	}

	private void loadGimnasio() {

		List<Gimnasio> l = ControllerGimnasio.getTodos();

		for (Gimnasio o : l) {
			jcbGimnasio.addItem(o);
		}
	}

	private void loadLocalidad() {
		List<Localidad> l = ControllerLocalidad.getTodos();

		for (Localidad o : l) {
			jcbLocalidad.addItem(o);
		}
	}

	private void filtarAsistentes() {
		String searchName = jtfSearch.getText();
		int idGimnasio = (((Gimnasio) this.jcbGimnasio.getSelectedItem()).getId());
		List<Asistente> l = ControllerAsistente.getTodos(idGimnasio, searchName);
		if (!l.isEmpty()) {
			jcbAsistente.removeAllItems();
			for (Asistente o : l) {
				jcbAsistente.addItem(o);
			}
		}

	}

	private void getSelected() throws SQLException {
		try {
			int id = ((((Asistente) this.jcbAsistente.getSelectedItem()).getId()));
			Asistente o = ControllerAsistente.getAsistente(id);
			if (String.valueOf(id) != null) {
				muestraEnPantalla(o);

			}
		} catch (Exception e) {

		}

	}

	private void muestraEnPantalla(Asistente o) {
		if (o != null) {
			this.jtfId.setText("" + o.getId());
			this.jtfDni.setText("" + o.getDniNiePasaporte());
			this.jtfNombre.setText("" + o.getNombre());
			this.jtfApellido.setText("" + o.getApellido());
			if (o.getFechaNac() != null) {
				this.jtfFecha.setText(sdf.format(o.getFechaNac()));
			} else {
				this.jtfFecha.setText("");
			}
			this.jtfCuota.setText(String.valueOf(o.getCuotaMensual()));
			this.jcbCheck.setSelected(o.isActivo());
			System.out.println(o.getIdLocalidad());
			this.jcbLocalidad.setSelectedIndex(o.getIdLocalidad());
		}
	}

	private void guardar() {

		if (!esDni()) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener 8 números seguidos");
			return;
		}

		if (!isFechaCaducidadValida()) {
			JOptionPane.showMessageDialog(null, "La fecha de nacimiente debe ser antes de hoy");
			return;
		}
//
		if (!isFloat()) {
			JOptionPane.showMessageDialog(null, "Hay que poner un número en 'Cuota mensual'");
			return;
		}

		try {
			Asistente o = new Asistente();

			o.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				o.setId(Integer.parseInt(this.jtfId.getText()));
			}

			o.setIdGimnasio((((Gimnasio) this.jcbGimnasio.getSelectedItem()).getId()));
			o.setDniNiePasaporte(this.jtfDni.getText());
			o.setIdLocalidad((((Localidad) this.jcbLocalidad.getSelectedItem()).getId()));
			o.setActivo(this.jcbCheck.isSelected());
			o.setNombre(this.jtfNombre.getText());
			o.setApellido(this.jtfApellido.getText());
			Date nuevaFecha = (!this.jtfFecha.getText().trim().equals("")) ? sdf.parse(this.jtfFecha.getText()) : null;
			o.setFechaNac(nuevaFecha);
			o.setCuotaMensual(Float.parseFloat(this.jtfCuota.getText()));

			if (ControllerAsistente.save(o) == 1) {
				JOptionPane.showMessageDialog(null, "Guardado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "NO se ha podido guardar");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean esDni() {
		return this.jtfDni.getText().matches(".*[0-9]{8,}.*");

	}

	private boolean isFechaCaducidadValida() {
		String strFechaNac = this.jtfFecha.getText();

		if (strFechaNac.trim().equals("")) {
			return true;
		}

		Date fechaCad = null;
		try {
			fechaCad = sdf.parse(strFechaNac);
		} catch (Exception ex) {
			return false;
		}

		if ((new Date()).before(fechaCad)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isFloat() {
		String strFloat = this.jtfCuota.getText();

		try {
			Float.parseFloat(strFloat);
		} catch (Exception e) {
			try {
				Integer.parseInt(strFloat);
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

}