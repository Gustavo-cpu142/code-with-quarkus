package org.acme.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.acme.entities.apiresponse.Gastos;
import org.acme.entities.response.ApiResponse;
import org.acme.service.api.GenericDaoServiceWithJason;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api-examples")
public class ApiResponseResource {

    private GenericDaoServiceWithJason serviceConConstructor;

    public ApiResponseResource(GenericDaoServiceWithJason instanciaService) {
        this.serviceConConstructor = instanciaService;
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