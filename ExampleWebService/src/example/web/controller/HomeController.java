/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.web.controller;

import firo.Controller;
import firo.Request;
import firo.Response;
import firo.Route;
import firo.RouteInfo;
import example.web.render.RenderMain;

public class HomeController extends Controller {

    public static final String _className = "=============HomeController";

    public HomeController() {
    }

    @RouteInfo(method = "get", path = "/")
    public Route renderHome() {
        return (Request request, Response response) -> {
            System.out.println("Render Home");
            return RenderMain.getInstance().renderHome(request, response);
        };
    }
    @RouteInfo(method = "get", path = "/search")
    public Route renderSearch(){
        return (Request request, Response response) -> {
            System.out.println("Render Search");
            return RenderMain.getInstance().renderSearch(request, response);
        };
    }
}
