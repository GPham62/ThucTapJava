/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example.web.render;

import java.io.IOException;
import java.util.HashMap;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import firo.Request;
import firo.Response;
import firo.utils.config.Config;
import java.util.Map;
import org.json.JSONObject;
import example.web.transport.ExampleAPIService;
import example.web.utils.CookieUtil;
import example.web.utils.ServletUtil;

/**
 *
 * @author anbq
 */
public class RenderMain extends RenderEngine {

    private static final Logger log = Log.getLogger(RenderMain.class);
    private static RenderMain _instance = new RenderMain();
    JSONObject userInfo = new JSONObject();
    public static RenderMain getInstance() {
        return _instance;
    }

    public String renderHome(Request request, Response response) throws IOException {
        String content = "";
        Map<String, Object> attributes = new HashMap<>();
        try {
            attributes.put("static_url", Config.getParamString("config", "static_url", ""));
            content = RenderEngine.getInstance().render(attributes, "home.ftl");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.warn("render renderHome", ex);
        }
        return content;
    }

    
}
