package ws;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import Domain.Cliente;

@Path("ClienteService")
public class ClienteService {

	@GET
	@Path("GetCliente/{id}")
	public String GetCliente(@PathParam("id") int id)
	{
		
		Gson gson = new Gson();
		ClienteController cc = new ClienteController();
		Cliente c = new Cliente();
		
		c = cc.GetCliente_X_Id(id);
		
		if(c.getEdad() == 0) c = null;
		
		return gson.toJson(c, Cliente.class);
		
	}
	
}
