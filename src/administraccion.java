

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

public class administraccion {

	JFrame frmAdministracin;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected Object frame;
	private JLabel lblIdproducto;
	private JTextField textField_7;
	private JLabel lblIdproducto_1;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField textField_8;
	private JLabel lblPrecio_1;
	private JButton btnInicio;

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
		frmAdministracin = new JFrame();
		frmAdministracin.setTitle("Administraci\u00F3n");
		frmAdministracin.getContentPane().setBackground(Color.ORANGE);
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
		btnAadirProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAadirProducto.setBounds(30, 125, 185, 40);
		frmAdministracin.getContentPane().add(btnAadirProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
			
			}
		});
		btnEliminarProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEliminarProducto.setBounds(30, 30, 185, 40);
		frmAdministracin.getContentPane().add(btnEliminarProducto);
		
		textField = new JTextField();
		textField.setBounds(118, 94, 83, 20);
		frmAdministracin.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table.setBounds(253, 30, 375, 96);
		frmAdministracin.getContentPane().add(table);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "ID_Categoria", "Nombre", "Precio", null},
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 173, 91, 20);
		frmAdministracin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 204, 91, 20);
		frmAdministracin.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 261, 91, 20);
		frmAdministracin.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("listar productos");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConexionBBDD Prueba = new ConexionBBDD();
				table.setModel(Prueba.ConsultaTablaEmpleados());
				
				
			
			}
			
			
		});
		btnNewButton.setBounds(253, 151, 238, 40);
		frmAdministracin.getContentPane().add(btnNewButton);
		
		lblIdproducto = new JLabel("ID_Producto");
		lblIdproducto.setBounds(30, 94, 65, 14);
		frmAdministracin.getContentPane().add(lblIdproducto);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(110, 292, 91, 20);
		frmAdministracin.getContentPane().add(textField_7);
		
		lblIdproducto_1 = new JLabel("ID_Producto");
		lblIdproducto_1.setBounds(30, 176, 70, 14);
		frmAdministracin.getContentPane().add(lblIdproducto_1);
		
		lblId = new JLabel("ID");
		lblId.setBounds(30, 208, 46, 14);
		frmAdministracin.getContentPane().add(lblId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 264, 46, 14);
		frmAdministracin.getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(30, 295, 46, 14);
		frmAdministracin.getContentPane().add(lblPrecio);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(110, 235, 91, 20);
		frmAdministracin.getContentPane().add(textField_8);
		
		lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(30, 239, 46, 14);
		frmAdministracin.getContentPane().add(lblPrecio_1);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnInicio.setBounds(253, 378, 194, 40);
		frmAdministracin.getContentPane().add(btnInicio);
	}
}
