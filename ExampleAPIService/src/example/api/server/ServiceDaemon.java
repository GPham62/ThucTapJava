/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example.api.server;

import firo.Firo;
import firo.utils.config.Config;
import org.hibernate.SessionFactory;

/**
 *
 * @author anbq
 */
public class ServiceDaemon {

    private static SessionFactory factory;

    public static void main(String[] args) throws Exception {
        Firo.getInstance().init(Config.getParamString("service", "host", "127.0.0.1"), Config.getParamInt("service", "port", 3003));
        Firo.getInstance().initializeControllerFromPackage("example.api.controller", ServiceDaemon.class);

    }

}
