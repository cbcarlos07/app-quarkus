package br.britosoftware.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestController {

    protected <R> Response buildResponse( RestFunctionNoArgs<R> f ){
        try{
            return Response.ok( f.apply() ).build();
        }catch (Exception e){
            return  Response.serverError().build();
        }
    }

    protected interface RestFunctionNoArgs<R> {
        R apply();
    }
}
