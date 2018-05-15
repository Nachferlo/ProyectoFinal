

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexionbasedatos.ConexionBBDD;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class administraccion {

	JFrame frmAdministracin;
	 JTable table;
	 JTextField texteliminar;
	 JTable table_1;
	 JTextField prod;
	 JTextField cat;
	 JTextField nom;
	 Object frame;
	 JLabel lblIdproducto;
	 JTextField pred;
	 JLabel lblIdproducto_1;
	 JLabel lblId;
	 JLabel lblNombre;
	 JLabel lblPrecio;
	 JTextField cant;
	 JLabel lblPrecio_1;
	 JButton btnInicio;
	 int id_eliminar;
	 int id_producto;
		String categoria;
		String nombre;
		int precio;
		int cantidad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administraccion window = new administraccion();
					window.frmAdministracin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public administraccion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConexionBBDD conexion = new ConexionBBDD();
		
		frmAdministracin = new JFrame();
		frmAdministracin.setTitle("Administraci\u00F3n");
		frmAdministracin.getContentPane().setBackground(new Color(204, 51, 51));
		frmAdministracin.setBounds(100, 100, 654, 487);
		frmAdministracin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracin.getContentPane().setLayout(null);
		
		JButton btnAadirCategoria = new JButton("Modificar producto");
		btnAadirCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ModificarProducto ventana= new ModificarProducto();
				 ventana.framemodificar.setVisible(true);
			}
		});
		btnAadirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAadirCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAadirCategoria.setBounds(30, 377, 185, 40);
		frmAdministracin.getContentPane().add(btnAadirCategoria);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id_producto = Integer.valueOf(prod.getText());
				categoria = String.valueOf(cat.getText());
				nombre = String.valueOf(nom.getText());
				precio = Integer.valueOf(pred.getText());
				cantidad = Integer.valueOf(cant.getText());
				
				
				if(id_producto != 0 && categoria != null && nombre != null && precio != 0 && cantidad != 0) {
					try {
						conexion.AñadirProducto(id_producto, categoria, nombre, precio, cantidad);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAadirProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAadirProducto.setBounds(30, 125, 185, 40);
		frmAdministracin.getContentPane().add(btnAadirProducto);
		
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.setBackground(Color.WHITE);
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id_eliminar = Integer.valueOf(texteliminar.getText());
				
				try {
					conexion.EliminarProducto(id_eliminar);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEliminarProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEliminarProducto.setBounds(30, 30, 185, 40);
		frmAdministracin.getContentPane().add(btnEliminarProducto);
		
		
		texteliminar = new JTextField();
		texteliminar.setBounds(118, 94, 83, 20);
		frmAdministracin.getContentPane().add(texteliminar);
		texteliminar.setColumns(10);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table.setBounds(253, 30, 375, 183);
		frmAdministracin.getContentPane().add(table);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Categoria", "Nombre", "Precio", null},
				{"", "", "", "", null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Categoria", "Nombre", "Precio", "New column"
			}
		));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(598, 347, -317, -42);
		frmAdministracin.getContentPane().add(table_1);
		
		prod = new JTextField();
		prod.setBounds(120, 173, 91, 20);
		frmAdministracin.getContentPane().add(prod);
		prod.setColumns(10);
		
		cat = new JTextField();
		cat.setBounds(120, 204, 91, 20);
		frmAdministracin.getContentPane().add(cat);
		cat.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(120, 261, 91, 20);
		frmAdministracin.getContentPane().add(nom);
		
		JButton btnNewButton = new JButton("listar productos");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConexionBBDD Prueba = new ConexionBBDD();
				table.setModel(Prueba.ConsultaTablaEmpleados());
				
			}
			
			
		});
		btnNewButton.setBounds(255, 224, 238, 40);
		frmAdministracin.getContentPane().add(btnNewButton);
		
		lblIdproducto = new JLabel("ID_Producto");
		lblIdproducto.setBounds(30, 94, 70, 14);
		frmAdministracin.getContentPane().add(lblIdproducto);
		
		pred = new JTextField();
		pred.setColumns(10);
		pred.setBounds(120, 292, 91, 20);
		frmAdministracin.getContentPane().add(pred);
		
		lblIdproducto_1 = new JLabel("ID_Producto");
		lblIdproducto_1.setBounds(30, 176, 70, 14);
		frmAdministracin.getContentPane().add(lblIdproducto_1);
		
		lblId = new JLabel("Categoria");
		lblId.setBounds(30, 208, 55, 14);
		frmAdministracin.getContentPane().add(lblId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 264, 46, 14);
		frmAdministracin.getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(30, 295, 46, 14);
		frmAdministracin.getContentPane().add(lblPrecio);
		
		cant = new JTextField();
		cant.setColumns(10);
		cant.setBounds(120, 235, 91, 20);
		frmAdministracin.getContentPane().add(cant);
		
		lblPrecio_1 = new JLabel("Cantidad");
		lblPrecio_1.setBounds(30, 239, 50, 14);
		frmAdministracin.getContentPane().add(lblPrecio_1);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manuinicial ventana=new manuinicial();
				 ventana.frmBarrestauranteLosPerdidos.setVisible(true);
				 frmAdministracin.setVisible(false);
			}
		});
		btnInicio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnInicio.setBounds(253, 378, 194, 40);
		frmAdministracin.getContentPane().add(btnInicio);
	}
}
