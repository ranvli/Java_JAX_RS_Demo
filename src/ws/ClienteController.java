package ws;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.ConnectionHelper;
import Domain.Cliente;
import Domain.Estado;
import Domain.Producto;
import Domain.Tipo;
import Domain.TipoCliente;

 
public class ClienteController {

	Statement statement = null;   
    ResultSet resultSet = null;
    
     
     public Cliente GetCliente_X_Id(int id) 
     {
    	 
    	 Cliente c = new Cliente();
          
         String selectSql = String.format("SELECT * FROM cliente WHERE id = %s", id);  
         try {
	
        	 statement = ConnectionHelper.Conectar().createStatement();
        	 resultSet = statement.executeQuery(selectSql);  
			 
	         while (resultSet.next())   
	         {  
	        	 c.setNombre(resultSet.getString(2));
	        	 c.setEdad(Integer.parseInt(resultSet.getString(3)));
	             c.setTipoCliente(TipoCliente.Parse(resultSet.getString(4)));
	             c.setProductos(GetProductosDeCliente(id));
	         }  
	 
		} catch (SQLException e) {
			e.printStackTrace();
		}  
          
         
         return c;
         
     }
     
     private List<Producto> GetProductosDeCliente(int clienteId)
     {
    	 
    	 List<Producto> listaProductos = new ArrayList<Producto>();
         
         String selectSql = String.format("SELECT * FROM Producto p, Cliente_Producto cp WHERE p.id = cp.producto_id AND cp.cliente_id = %s", clienteId);  
         try {
	
        	 statement = ConnectionHelper.Conectar().createStatement();
        	 resultSet = statement.executeQuery(selectSql);  
			 
	         while (resultSet.next())   
	         {  
	        	 Producto p = new Producto();
	        	 p.setNombre(resultSet.getString(2));
	        	 p.setTipo(Tipo.Parse(resultSet.getString(3)));
	        	 p.setEstado(Estado.Parse(resultSet.getString(4)));
	        	 listaProductos.add(p);
	         }  
	 
		} catch (SQLException e) {
			e.printStackTrace();
		}  
          
         
         return listaProductos;
    	 
     }

}
