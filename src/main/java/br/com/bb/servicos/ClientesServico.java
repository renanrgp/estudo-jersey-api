package br.com.bb.servicos;
 
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.bb.api.dao.ClienteDAO;
import br.com.bb.api.objetos.Clientes;
 
@Path("/clientes")
public class ClientesServico {
 
    // URI:
    // /contextPath/servletPath/c
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Clientes> getCliente_JSON() {
        List<Clientes> listClientes = ClienteDAO.getAllClientes();
        return listClientes;
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Clientes getEmployee(@PathParam("id") String id) {
        return ClienteDAO.getCliente(id);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST 
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Clientes addCliente(Clientes cliente) {
        return ClienteDAO.addCliente(cliente);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Clientes updateCliente(Clientes cliente) {
        return ClienteDAO.updateCliente(cliente);
    }
 
    @DELETE
    @Path("/{clienteid}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteEmployee(@PathParam("clienteid") String clienteid) {
        ClienteDAO.deleteCliente(clienteid);
        return Response.ok("Cliente Deletado  " + clienteid).build();
    }
 
}