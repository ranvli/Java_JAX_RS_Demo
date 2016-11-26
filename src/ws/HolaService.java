package ws;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;


@Path("HolaService")
public class HolaService {

	@GET
	@Path("/Hola/{nombre}")
	public String Hola(@PathParam("nombre") String nombre)
	{
		Gson gson = new Gson();
		return gson.toJson("Hola " + nombre);
	}
	
}
