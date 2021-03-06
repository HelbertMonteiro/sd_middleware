/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Raphael Felipe
 */
@Path("concatenar")
public class ServConcat {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServConcat
     */
    public ServConcat() {
    }

    /**
     * Retrieves representation of an instance of webservice.ServConcat
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ServConcat
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    @Path("concatenar/{texto}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String TextoConcatenado(@PathParam("texto") String txtModel){
        try{
            txtModel = URLDecoder.decode(txtModel, "UTF-8");
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
        return new Concatenador().Concatenar(txtModel);
    }
}
