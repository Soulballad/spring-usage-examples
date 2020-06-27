package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.http.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : rest service
 * @since ：2020/6/23 21:51
 */
@Service(version = "1.0.0", protocol = {"dubbo", "rest"})
@Path("/")
public class RestServiceImpl implements RestService {

    @Override
    @Path("param")
    @GET
    public String param(@QueryParam("param") String param) {
        return "alb-dubbo-provider param : " + param;
    }

    @Override
    @Path("params")
    @POST
    public String params(@QueryParam("a") Integer a, @QueryParam("b") String b) {
        return "alb-dubbo-provider params : " + a + ";" + b;
    }

    @Override
    @Path("headers")
    @GET
    public String headers(@HeaderParam("h1") String header1, @HeaderParam("h2") String header2, @QueryParam("val") Integer param) {
        return "alb-dubbo-provider headers : " + header1 + ";" + header2 + ";" + param;
    }

    @Override
    @Path("pathVariables/{p1}/{p2}")
    @GET
    public String pathVariables(@PathParam("p1") String path1, @PathParam("p2") String path2, @QueryParam("val") String param) {
        return "alb-dubbo-provider pathVariables : " + path1 + ";" + path2 + ";" + param;
    }

    @Override
    @Path("form")
    @POST
    public String form(@FormParam("form") String form) {
        return "alb-dubbo-provider form : " + form;
    }

    @Override
    @Path("/request/body/map")
    @POST
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public UserModel requestBodyMap(Map<String, Object> data, @QueryParam("param") String param) {
        UserModel user = new UserModel();
        user.setId(((Integer) data.get("id")).longValue());
        user.setName((String) data.get("name"));
        user.setAge((Integer) data.get("age"));
        return user;
    }

    @Override
    @Path("/request/body/user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> requestBodyUser(UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", userModel.getId());
        map.put("name", userModel.getName());
        map.put("age", userModel.getAge());
        return map;
    }
}
