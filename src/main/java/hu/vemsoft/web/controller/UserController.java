package hu.vemsoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("profile")
    public String profile() {
        // we tell the controller where to look for the desired view file
        // the exact same view can be requested via the browser by explicitly putting /jsp/profile.jsp into the URL
        return "jsp/profile.jsp";
    }

}
