import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import conexionbasedatos.ConexionBBDD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cobrar {

	 JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cobrar window = new Cobrar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cobrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConexionBBDD conexion = new ConexionBBDD();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(117, 60, 97, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(47, 63, 46, 14);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblPago = new JLabel("Pago");
		lblPago.setBounds(47, 94, 46, 14);
		frame.getContentPane().add(lblPago);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 91, 97, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 122, 97, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDevolucion = new JLabel("devoluci\u00F3n");
		lblDevolucion.setBounds(47, 125, 60, 14);
		frame.getContentPane().add(lblDevolucion);
		
		JButton btnAbrirCaja = new JButton("Abrir caja");
		btnAbrirCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Caja Abierta retire dinero");
			}
		});
		btnAbrirCaja.setBounds(41, 199, 89, 23);
		frame.getContentPane().add(btnAbrirCaja);
		
		JButton btnFinalizarCobro = new JButton("Finalizar cobro");
		btnFinalizarCobro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Pedido cobrado y finalizado");
				Bar ventana=new Bar();
				 ventana.frmBar.setVisible(true);
			frame.setVisible(false);
			}
		});
		btnFinalizarCobro.setBounds(171, 199, 101, 23);
		frame.getContentPane().add(btnFinalizarCobro);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Bar ventana=new Bar();
				 ventana.frmBar.setVisible(true);
			}
		});
		btnAtras.setBounds(290, 11, 89, 23);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(btnAtras);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 29, 97, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIdmesa = new JLabel("ID_MESA");
		lblIdmesa.setBounds(47, 32, 46, 14);
		frame.getContentPane().add(lblIdmesa);
		
		JButton boton = new JButton("");
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.valueOf(textField_3.getText());
				try {
					textField.setText(String.valueOf(conexion.Cobrar(id)));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		boton.setBounds(224, 29, 18, 20);
		frame.getContentPane().add(boton);
	}
}
