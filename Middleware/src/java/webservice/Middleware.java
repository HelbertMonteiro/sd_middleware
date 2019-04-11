/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
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
@Path("middleware")
public class Middleware {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of mdware
     */
    public Middleware() {
        
    }

    /**
     * Retrieves representation of an instance of webservice.Middleware
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Middleware
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content) {
        
    }
    
    @Path("textos/{texto}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String TextoConcatenado(@PathParam("texto") String txtModel) throws UnsupportedEncodingException{
        
        String txtModel2 = URLEncoder.encode(txtModel, "UTF-8");
        
        
        ModeloTexto modeloTexto = new ModeloTexto();
        
        Thread threadConcatenar = new Thread(new Runnable() {
            @Override
            public void run() {
                String urlConcatenar = "http://192.168.43.214:8084/ServidorConcatenar/webresources/concatenar/concatenar/" + txtModel2;
                modeloTexto.setTextoConcatenado(Conexao.conectaWSGD(urlConcatenar, "GET"));
            }
        });
        
        Thread threadUppercase = new Thread(new Runnable() {
            @Override
            public void run() {
                String urlUppercase  = "http://192.168.43.157:8084/ServidorUpperCase/webresources/uppercase/uppercase/"    + txtModel2;
                modeloTexto.setTextoUppercase  (Conexao.conectaWSGD(urlUppercase, "GET"));
            }
        });
        
        threadConcatenar.run();
        threadUppercase.run();
        
        return new Gson().toJson(modeloTexto);
    }
}
