package com.lft.reflect.resource;

import com.lft.reflect.service.ReflectService;
import com.lft.reflect.service.ReflectServiceImpl;
import com.lft.reflect.utils.Utils;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by leapfrog on 7/11/16.
 */
@Path("/{resource}")
public class ReflectResource {

    //TODO Use CDI for this
    ReflectService reflectService = new ReflectServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("resource")String resource){
        try {
            Class resourceClass = reflectService.getClassFromResource(resource);
            List students = reflectService.getAll(resourceClass.getSimpleName());
            return Response.status(Response.Status.OK).entity(students).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("resource")String resource, Map map){
        try {
            Class resourceClass = reflectService.getClassFromResource(resource);
            Object obj = reflectService.constructObjectFrom(resourceClass, map, null);
            reflectService.saveOrUpdate(obj);
            return Response.created(new URI("http://www.google.com")).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }catch (InstantiationException|IllegalAccessException|InvocationTargetException|URISyntaxException|NoSuchMethodException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{resourceId}")
    public Response update(@PathParam("resource")String resource, @PathParam("resourceId")Integer resourceId, Map map){
        try {
            Class resourceClass = reflectService.getClassFromResource(resource);
            Object obj = reflectService.constructObjectFrom(resourceClass, map, resourceId);
            reflectService.saveOrUpdate(obj);
            return Response.ok().build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


}
