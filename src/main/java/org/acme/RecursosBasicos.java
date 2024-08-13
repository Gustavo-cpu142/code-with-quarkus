package main.java.org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/recursos-basicos")
public class RecursosBasicos {
    
    @Path("Suma")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer recursosBasicosSuma(){
        return 5+5;}

   
    @GET
    @Path("Resta")  
    @Produces(MediaType.TEXT_PLAIN)
    public Integer recursosBasicosResta(){return 100-5;}
    
}

