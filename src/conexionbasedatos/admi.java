package conexionbasedatos;
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

public class admi {

	private JFrame frmAdministracin;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admi window = new admi();
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
	public admi() {
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
		btnAadirCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAadirCategoria.setBounds(30, 385, 171, 40);
		frmAdministracin.getContentPane().add(btnAadirCategoria);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAadirProducto.setBounds(30, 304, 171, 40);
		frmAdministracin.getContentPane().add(btnAadirProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
			
			}
		});
		btnEliminarProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEliminarProducto.setBounds(30, 81, 194, 40);
		frmAdministracin.getContentPane().add(btnEliminarProducto);
		
		textField = new JTextField();
		textField.setBounds(30, 132, 106, 28);
		frmAdministracin.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(253, 30, 375, 240);
		frmAdministracin.getContentPane().add(table);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "ID_Categoria", "Nombre", "Precio", "Cantidad"},
				{1, "Refresco", "Fanta", 2, 75},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"ID", "Categoria", "Nombre", "Precio", "Cantidad"
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
		textField_1.setBounds(253, 304, 86, 40);
		frmAdministracin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(389, 304, 86, 40);
		frmAdministracin.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(521, 304, 86, 40);
		frmAdministracin.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(253, 385, 86, 40);
		frmAdministracin.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(389, 387, 86, 40);
		frmAdministracin.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(521, 385, 86, 40);
		frmAdministracin.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("listar productos");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConexionBBDD Prueba = new ConexionBBDD();
				table.setModel(Prueba.ConsultaTablaEmpleados());
				
				
			
			}
			
			
		});
		btnNewButton.setBounds(35, 187, 189, 40);
		frmAdministracin.getContentPane().add(btnNewButton);
	}
}