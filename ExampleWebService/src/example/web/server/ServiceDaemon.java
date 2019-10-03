/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example.web.server;

import firo.Firo;
import firo.utils.config.Config;

public class ServiceDaemon {

    public static void main(String[] args) throws Exception {

        Firo.getInstance().externalStaticFileLocation("static");
        Firo.getInstance().init(Config.getParamString("service", "host", "0.0.0.0"), Config.getParamInt("service", "port", 1111));
        Firo.getInstance().initializeControllerFromPackage(Config.getParamString("service", "controllerPackage", "example.web.controller"), ServiceDaemon.class);
    }
}
