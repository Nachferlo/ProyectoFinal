package conexionbasedatos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	String bd;
	String url;
	String usr;
	String pwd;
	String xcema;
	Connection conexion;
	Statement stmt;
	
	public ConexionBBDD()  {
		FicheroINI();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);	
			}catch (Exception e) {
				e.printStackTrace();
			}		
	}
	
	public DefaultTableModel ConsultaTablaEmpleados() {
		String [] columnas={"ID_PRODUCTO","CATEGORIA", "NOMBRE", "PRECIO", "CANTIDAD"};
		String [] registro={"ID_PRODUCTO","CATEGORIA", "NOMBRE", "PRECIO", "CANTIDAD"};
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM " +  xcema + ".PRODUCTOS";
		  ModeloTabla.addRow(registro);
		try {
			stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("CATEGORIA");
		         registro[2]=rset.getString("NOMBRE");
		         registro[3]=rset.getString("PRECIO");
		         registro[4]=rset.getString("CANTIDAD");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel ConsultaTablaMESA() {
		String [] columnas={"ID_MESA","N_PERSONAS"};
		String [] registro={"ID_MESA","N_PERSONAS"};
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM " +  xcema + ".MESA";
		  ModeloTabla.addRow(registro);
		try {
			stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_MESA");
		         registro[1]=rset.getString("N_PERSONAS");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel ConsultaTablaCUENTA() {
		String [] columnas={"ID_CUENTA","PRECIO_TOTAL"};
		String [] registro={"ID_CUENTA","PRECIO_TOTAL"};
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM " +  xcema + ".CUENTA";
		  ModeloTabla.addRow(registro);
		try {
			stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_CUENTA");
		         registro[1]=rset.getString("PRECIO_TOTAL");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}		
		return ModeloTabla;
		
	}
	
public int EliminarCuenta(int id, int precio) throws SQLException {
		
		int resultado = 0;
		String insertar = "INSERT INTO " +  xcema + ".CUENTA VALUES ( " + id + ", " + precio + ")";
		  
		try {
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(insertar);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return resultado;	
	}
	
	public DefaultTableModel ConsultaTablaPEDIDO() {
		String [] columnas={"ID_PEDIDO","ID_CUENTA", "ID_MESA", "N_PRODUCTOS"};
		String [] registro={"ID_PEDIDO","ID_CUENTA", "ID_MESA", "N_PRODUCTOS"};
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM " +  xcema + ".PEDIDOS";
		  ModeloTabla.addRow(registro);
		try {
			stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PEDIDO");
		         registro[1]=rset.getString("ID_CUENTA");
		         registro[2]=rset.getString("ID_MESA");
		         registro[3]=rset.getString("N_PRODUCTOS");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}	
		return ModeloTabla;
		
	}
	
	public int AñadirProducto(int id, String categoria, String nombre, int precio, int cantidad) throws SQLException {
		
		int resultado = 0;
		String añadir = "INSERT INTO " +  xcema + ".PRODUCTOS VALUES (" + id + ", " + "'" + categoria + "'" + ", " +  "'" + nombre + "'" + ", " + precio + ", " + cantidad + ")";
		System.out.println(añadir);
		  
		try {
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(añadir);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return resultado;	
	}
	
	public int EliminarProducto(int id) throws SQLException {
		
		int resultado = 0;
		String eliminar = "DELETE FROM " +  xcema + ".PRODUCTOS WHERE ID_PRODUCTO = " + id;
		  
		try {
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(eliminar);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return resultado;	
	}

		
	public int AñadirPedido(int id_pedido, int id_cuenta, int id_mesa, int num) throws SQLException {
		
		int resultado = 0;
		String añadir = "INSERT INTO " +  xcema + ".PEDIDOS VALUES (" + id_pedido + "," + id_cuenta + "," + id_mesa + "," + num + ")";
		  
		try {
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(añadir);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return resultado;	
	}
	
	public int AñadirMesa(int id_cuenta, int precio) throws SQLException {
		
		int resultado = 0;
		String añadir = "INSERT INTO " +  xcema + ".MESA VALUES (" + id_cuenta + "," + precio + ")";
		  
		try {
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(añadir);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return resultado;	
	}
	
	public void FicheroINI() {

		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			File miFichero = new File("src/configuracion.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				usr=propiedades.getProperty("usuario");
				pwd=propiedades.getProperty("contraseña");
				xcema=propiedades.getProperty("xcema");
			}
			else {
				System.err.println("fichero no encontrado");
			}

		}catch(IOException ex) {

			ex.printStackTrace();

		}finally {

			if(entrada != null) {

				try {

					entrada.close();

				}catch(IOException e) {

					e.printStackTrace();

				}

			}

		}

	}


}