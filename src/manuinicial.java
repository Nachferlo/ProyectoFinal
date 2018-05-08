import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class manuinicial {

	 JFrame frmBarrestauranteLosPerdidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manuinicial window = new manuinicial();
					window.frmBarrestauranteLosPerdidos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public manuinicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBarrestauranteLosPerdidos = new JFrame();
		frmBarrestauranteLosPerdidos.setTitle("Bar-Restaurante Los perdidos");
		frmBarrestauranteLosPerdidos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DAW1\\Desktop\\fondo.png"));
		frmBarrestauranteLosPerdidos.getContentPane().setBackground(Color.ORANGE);
		frmBarrestauranteLosPerdidos.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("     Bar");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\coas escritorio\\bar 1.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bar ventana=new Bar();
				 ventana.frmBar.setVisible(true);
				 frmBarrestauranteLosPerdidos.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(94, 166, 370, 122);
		frmBarrestauranteLosPerdidos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("     Administraccion");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administraccion ventana=new administraccion();
				 ventana.frmAdministracin.setVisible(true);
				 frmBarrestauranteLosPerdidos.setVisible(false);
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\coas escritorio\\icono-e.png"));
		btnNewButton_1.setBounds(94, 31, 370, 108);
		frmBarrestauranteLosPerdidos.getContentPane().add(btnNewButton_1);
		frmBarrestauranteLosPerdidos.setBounds(100, 100, 612, 400);
		frmBarrestauranteLosPerdidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
