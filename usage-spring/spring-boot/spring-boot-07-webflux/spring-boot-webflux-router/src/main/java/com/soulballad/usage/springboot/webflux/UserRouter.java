package com.soulballad.usage.springboot.webflux;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : router
 * @since ：2020/5/24 15:10
 */
@Configuration
public class UserRouter {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/user/list").and(accept(MediaType.APPLICATION_JSON)), userHandler::list)
            .andRoute(GET("/user/find/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::findById)
            .andRoute(POST("/user/add").and(contentType(MediaType.APPLICATION_JSON)), userHandler::add)
            .andRoute(PUT("/user/update").and(contentType(MediaType.APPLICATION_JSON)), userHandler::update)
            .andRoute(DELETE("/user/delete/{id}"), userHandler::deleteId);
    }
}
