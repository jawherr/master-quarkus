package com.example.controller;

import com.example.dto.CreateUserRequest;
import com.example.dto.UserResponse;
import com.example.model.User;
import com.example.service.UserService;
import com.example.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public Response create(@Valid CreateUserRequest request) {
        return Response.status(Response.Status.CREATED)
                .entity(userService.create(request))
                .build();
    }

    @GET
    public Response list(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size,
            @QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {

        return Response.ok(
                userService.list(page, size, sort, direction)
        ).build();
    }


    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(userService.getById(id)).build();
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("name") String name) {
        return Response.ok(userService.searchByName(name)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id,
                           @Valid CreateUserRequest request) {

        return Response.ok(userService.update(id, request)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        userService.delete(id);
        return Response.noContent().build();
    }
}
