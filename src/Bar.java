import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexionbasedatos.ConexionBBDD;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Bar {

	JFrame frmBar;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	private JTable table_2;
	private JButton btnCuentas;
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
					Bar window = new Bar();
					window.frmBar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConexionBBDD conexion = new ConexionBBDD();
		frmBar = new JFrame();
		frmBar.getContentPane().setBackground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		frmBar.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAadirMesa = new JButton("A\u00F1adir Mesa");
		btnAadirMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText());
				int precio = Integer.valueOf(textField_5.getText());
				try {
					conexion.AñadirMesa(id, precio);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnAadirMesa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAadirMesa.setBounds(26, 30, 145, 40);
		panel.add(btnAadirMesa);
		
		JButton btnEditarMesa = new JButton("Nuevo pedido");
		btnEditarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.valueOf(textField_1.getText());
				int id_m = Integer.valueOf(textField_2.getText());
				int id_c = Integer.valueOf(textField_3.getText());
				int num = Integer.valueOf(textField_6.getText());
				
				try {
					conexion.AñadirPedido(id, id_m, id_c, num);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEditarMesa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEditarMesa.setBounds(26, 163, 145, 40);
		panel.add(btnEditarMesa);
		
		JButton btnNewButton = new JButton("Finalizar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manuinicial ventana=new manuinicial();
				 ventana.frmBarrestauranteLosPerdidos.setVisible(true);
				 frmBar.setVisible(false);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "pedido finalizado tu comida saldra en breves");
				
				frmBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(566, 466, 145, 40);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table.setBounds(268, 30, 443, 112);
		panel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID_Mesa", "Nº Personas"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		
		textField = new JTextField();
		textField.setBounds(110, 81, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 242, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 273, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 304, 86, 20);
		panel.add(textField_3);
		
		table_1 = new JTable();
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table_1.setBackground(Color.WHITE);
		table_1.setForeground(Color.BLACK);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID_Pedido", "ID_Cuenta", "ID_Mesa", "Nº Productos"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
					"ID_Pedido", "ID_Cuenta", "ID_Mesa", "Nº Productos"
			}
		));
		table_1.setBounds(268, 177, 443, 112);
		panel.add(table_1);
		
		JButton btnVolver = new JButton("Inicio");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manuinicial ventana=new manuinicial();
				 ventana.frmBarrestauranteLosPerdidos.setVisible(true);
				 frmBar.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnVolver.setBounds(386, 466, 145, 40);
		panel.add(btnVolver);
		
		table_2 = new JTable();
		table_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID_Cuenta", "Precio"},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
					"ID_Cuenta", "Precio"
			}
		));
		
		ConexionBBDD Prueba = new ConexionBBDD();
		table.setModel(Prueba.ConsultaTablaMESA());
		table_1.setModel(Prueba.ConsultaTablaPEDIDO());
		table_2.setModel(Prueba.ConsultaTablaCUENTA());
		
		table_2.setForeground(Color.BLACK);
		table_2.setBackground(Color.WHITE);
		table_2.setBounds(268, 353, 443, 80);
		panel.add(table_2);
		
		btnCuentas = new JButton("Cuentas Pagada");
		btnCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField_4.getText());
				try {
					conexion.EliminarCuenta(id);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCuentas.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCuentas.setBounds(26, 363, 170, 40);
		panel.add(btnCuentas);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 425, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblIdmesa = new JLabel("ID_Mesa");
		lblIdmesa.setBounds(26, 81, 46, 14);
		panel.add(lblIdmesa);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 112, 86, 20);
		panel.add(textField_5);
		
		JLabel lblNpersonas = new JLabel("N\u00BAPersonas");
		lblNpersonas.setBounds(26, 115, 67, 14);
		panel.add(lblNpersonas);
		
		JLabel lblIdpedido = new JLabel("ID_Pedido");
		lblIdpedido.setBounds(26, 245, 74, 14);
		panel.add(lblIdpedido);
		
		JLabel lblIdcuenta = new JLabel("Id_Cuenta");
		lblIdcuenta.setBounds(26, 276, 74, 14);
		panel.add(lblIdcuenta);
		
		JLabel lblIdmesa_1 = new JLabel("ID_mesa");
		lblIdmesa_1.setBounds(26, 307, 74, 14);
		panel.add(lblIdmesa_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(110, 332, 86, 20);
		panel.add(textField_6);
		
		JLabel lblNproductos = new JLabel("N\u00BAProductos");
		lblNproductos.setBounds(26, 332, 67, 14);
		panel.add(lblNproductos);
		
		JLabel lblIdcuenta_1 = new JLabel("ID_Cuenta");
		lblIdcuenta_1.setBounds(26, 428, 67, 14);
		panel.add(lblIdcuenta_1);
		
		JButton btnNewButton_1 = new JButton("Cobrar");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cobrar ventana=new Cobrar();
				 ventana.frame.setVisible(true);
				 frmBar.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(243, 466, 125, 40);
		panel.add(btnNewButton_1);
		
		JButton actualizar2 = new JButton("");
		actualizar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_1.setModel(conexion.ConsultaTablaPEDIDO());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		actualizar2.setBounds(238, 171, 20, 20);
		panel.add(actualizar2);
		
		JButton actualizar = new JButton("");
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(conexion.ConsultaTablaMESA());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		actualizar.setBounds(238, 22, 20, 20);
		panel.add(actualizar);
		
		JButton actualizar3 = new JButton("");
		actualizar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_2.setModel(conexion.ConsultaTablaCUENTA());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		actualizar3.setBounds(238, 349, 20, 20);
		panel.add(actualizar3);
		frmBar.setTitle("Bar");
		frmBar.setBounds(100, 100, 737, 556);
		frmBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
