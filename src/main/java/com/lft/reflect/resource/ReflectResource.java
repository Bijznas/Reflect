package com.lft.reflect.resource;

import com.lft.reflect.dao.StudentDao;
import com.lft.reflect.dao.StudentDaoImpl;
import com.lft.reflect.model.Student;
import com.lft.reflect.service.ReflectService;
import com.lft.reflect.service.StudentServiceImpl;
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

    ReflectService reflectService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("resource")String resource){
        try {
            Class aClass = Class.forName("com.lft.reflect.service." + Utils.capitalizeFirstLetter(resource) + "ServiceImpl");
            reflectService = (ReflectService)aClass.getConstructor().newInstance();
            List students = reflectService.getAll();
            return Response.status(Response.Status.OK).entity(students).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException  e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("resource")String resource, Map map){
        try {
            Class resourceClass = Class.forName("com.lft.reflect.model." + Utils.capitalizeFirstLetter(resource));
            Object t = resourceClass.newInstance();
            Method[] methods = resourceClass.getMethods();

            for(Method method : methods){
                if(isSetter(method) && method.getName() != "setStudentId" && method.getName() != "setId") {
                    Object ob= map.get(Utils.decapitalizeFirstLetter(method.getName().split("set")[1]));
                    method.invoke(t, ob);
                }
            }

            Class aClass = Class.forName("com.lft.reflect.service." + Utils.capitalizeFirstLetter(resource) + "ServiceImpl");
            reflectService = (ReflectService)aClass.getConstructor().newInstance();
            reflectService.add(t);
            return Response.created(new URI("http://www.google.com")).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException|URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }



}
