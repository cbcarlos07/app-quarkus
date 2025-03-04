package br.britosoftware.controller;

import br.britosoftware.dto.User;
import br.britosoftware.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController extends RestController {
    @Inject
    private UserService service;

    @GET
    public Response getUsers(){
        return buildResponse( () -> service.getUsers() );
    }

    @GET
    @Path("/name")
    public Response getUser(@QueryParam("name") String nome){
        return buildResponse(() -> service.getUser( nome ));
    }

    @POST
    @Transactional //@Transactional é necessário quando mudar algo no banco como insert por exemplo
    public Response insertUser(User user){
        return buildResponse(()-> service.insertUser( user ));
    }


}
