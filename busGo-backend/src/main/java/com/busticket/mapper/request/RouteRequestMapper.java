package com.busticket.mapper.request;

import com.busticket.dto.request.RouteRequest;
import com.busticket.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestMapper {

    public Route requestToEntity(RouteRequest request) {
        Route route = new Route();
        route.setFromCity(request.getFromCity());
        route.setToCity(request.getToCity());
        route.setBreakPoints(request.getBreakPoints());
        route.setDuration(request.getDuration());
        return route;
    }

    public RouteRequest entityToRequest(Route route) {
        RouteRequest request = new RouteRequest();
        request.setFromCity(route.getFromCity());
        request.setToCity(route.getToCity());
        request.setBreakPoints(route.getBreakPoints());
        request.setDuration(route.getDuration());
        return request;
    }
}