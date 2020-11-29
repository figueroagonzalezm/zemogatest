/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web.api;


import com.zemogatest.web.entity.Portfolio;
import com.zemogatest.web.service.PortfolioRepository;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author figue
 */
@Path("portfolio")
public class PortfolioAPI {

    @Inject
    PortfolioRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Portfolio entity) {
        Portfolio portfolio = repository.create(entity);
        return Response.ok().
                status(Response.Status.CREATED)
                .entity(portfolio).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Portfolio portfolio) {
        repository.update(portfolio);
        return Response.ok()
                .status(Response.Status.CREATED)
                .entity(portfolio).build();
    }

    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        Portfolio portfolio = repository.find(id);
        return Response.ok().entity(portfolio).build();
    }

}
