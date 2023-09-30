package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
	private static String banco = "jdbc:mysql://127.0.0.1:3306/sa3_uc9";
	private static String usuario = "root";
	private static String senha = "root";
	private static Connection conn = null;


	public static Connection getConnection()
				  {
					return conn;
				  }

	static {
			conectar();
		   }
	
	public  ConexaoBanco() 
			{
			 conectar();
			}
	
	private static void conectar() 
						{
							try {
								if  (conn == null) 
									{
									  Class.forName("com.mysql.cj.jdbc.Driver");
									  conn = DriverManager.getConnection(banco, usuario, senha);
									  conn.setAutoCommit(false);
									}
								} catch (Exception e) 
										{
										   // TODO: handle exception
										  e.printStackTrace();
										}
						}
}