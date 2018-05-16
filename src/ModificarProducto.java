import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import conexionbasedatos.ConexionBBDD;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ModificarProducto {

	JFrame framemodificar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected Object frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ModificarProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConexionBBDD conexion = new ConexionBBDD();
		framemodificar = new JFrame();
		framemodificar.getContentPane().setBackground(new Color(255, 255, 153));
		framemodificar.getContentPane().setForeground(new Color(51, 204, 255));
		framemodificar.setBounds(100, 100, 450, 300);
		framemodificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framemodificar.getContentPane().setLayout(null);
		
		JLabel lblIdproducto = new JLabel("ID_Producto");
		lblIdproducto.setBounds(35, 38, 68, 14);
		framemodificar.getContentPane().add(lblIdproducto);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(35, 68, 73, 14);
		framemodificar.getContentPane().add(lblCategoria);
		
		textField = new JTextField();
		textField.setBounds(113, 35, 89, 20);
		framemodificar.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 65, 89, 20);
		framemodificar.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 96, 89, 20);
		framemodificar.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 99, 46, 14);
		framemodificar.getContentPane().add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 131, 89, 20);
		framemodificar.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(35, 134, 46, 14);
		framemodificar.getContentPane().add(lblPrecio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 158, 89, 20);
		framemodificar.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(35, 161, 46, 14);
		framemodificar.getContentPane().add(lblCantidad);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText());
				String categoria = String.valueOf(textField_1.getText());
				String nombre = String.valueOf(textField_2.getText());
				int precio = Integer.valueOf(textField_3.getText());
				int cantidad = Integer.valueOf(textField_4.getText());
				
				
				if(id != 0 && categoria != null && nombre != null && precio != 0 && cantidad != 0) {

				try {
					conexion.EliminarProducto(id);
					conexion.AñadirProducto(id, categoria, nombre, precio, cantidad);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				}
			}
		});
		btnModificar.setBounds(35, 210, 89, 23);
		framemodificar.getContentPane().add(btnModificar);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				administraccion ventana=new administraccion();
				 ventana.frmAdministracin.setVisible(false);
				 framemodificar.setVisible(false);
				
			}
		});
		btnAtras.setBounds(316, 11, 89, 23);
		framemodificar.getContentPane().add(btnAtras);
		framemodificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
