package org.acme.controllers.proyecto;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entities.proyecto.Categoria;
import org.acme.model.response.ApiResponse;
import org.acme.services.proyecto.CategoriaService;

@Path("categoria")
public class CategoriaResource {
    private final CategoriaService service;

    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    /**
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Categoria> obtenerPorId(
            @PathParam("id") Integer id) {
        ApiResponse<Categoria> respuesta = new ApiResponse();

        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Se obtuvo exitosamente.");
            respuesta.setData(service.obtener(id));
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("No se obtuvo  la entidad con id :" + id);
            respuesta.setData(null);
        }

        return respuesta;
    }
