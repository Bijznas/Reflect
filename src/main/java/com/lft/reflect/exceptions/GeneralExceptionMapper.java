package com.lft.reflect.exceptions;

import com.lft.reflect.object.*;
import com.lft.reflect.object.Error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by leapfrog on 7/11/16.
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable>{
    @Override
    public Response toResponse(Throwable throwable) {
        throwable.printStackTrace();
        com.lft.reflect.object.Error error = new Error(5000, throwable.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
