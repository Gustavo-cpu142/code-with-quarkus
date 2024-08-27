package main.java.org.acme.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import main.java.py.edu.ucom.entities.HolaMundo;
import main.java.py.edu.ucom.services.api.ApiResponseService;
import main.java.py.edu.ucom.entities.apiresponse.Gastos;
import main.java.py.edu.ucom.services.api.GenericDaoServiceWithJason;
import py.edu.ucom.model.response.ApiResponse;
import py.edu.ucom.services.api.ApiResponseService;

@Path("/api-examples")
public class ApiResponseResource {
    @Inject
    private ApiResponseService servicioConInject;

    private GenericDaoServiceWithJason serviceConConstructor;

    public ApiResponseResource(GenericDaoServiceWithJason instanciaService) {
        this.serviceConConstructor = instanciaService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recursoBasicoTest() {
        @Path("clase-generica/service/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public ApiResponse<String> retornoDeClaseGenericaConServicio(
                @PathParam("id") Integer id) {
            ApiResponse<String> respuesta = new ApiResponse();
            System.out.println(id);
            try {
                if (id == 2) {
                    throw new Exception("se nos fue de las manos");
                }
                respuesta.setCode(Response.Status.OK.getStatusCode());
                respuesta.setMessage("Service message");
                respuesta.setData(servicioConInject.responseDummy());
            } catch (Exception e) {
                respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
                respuesta.setMessage("Primer error");
                respuesta.setData(e.getMessage());
            }
    
            return respuesta;
        }
    
        @GET
        @Path("gastos/json")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public ApiResponse<List<Gastos>> listarGastos() {
            ApiResponse<List<Gastos>> respuesta = new ApiResponse();
            List<Gastos> lista = new ArrayList<>();
            try {
                lista = serviceConConstructor.listar();
                respuesta.setCode(Response.Status.OK.getStatusCode());
                respuesta.setMessage("Listado, ok");
                respuesta.setData(lista);
            } catch (Exception e) {
    
                respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
                respuesta.setMessage("Listado, no ok\"");
                respuesta.setData(null);
            }
    
            return respuesta;
        }
    
        @POST
        @Path("gastos/json")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public ApiResponse<Gastos> agregarGastos(Gastos param) {
            ApiResponse<Gastos> respuesta = new ApiResponse();
            try {
                respuesta.setCode(Response.Status.OK.getStatusCode());
                respuesta.setMessage("Listado, ok");
                respuesta.setData(serviceConConstructor.agregar(param));
            } catch (Exception e) {
    
                respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
                respuesta.setMessage("Listado, no ok\"");
                respuesta.setData(null);
            }
    
            return respuesta;
        }
    
    }