package uz.d4uranbek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.d4uranbek.SecurityContextHolder;

@Controller
public class HomeController extends BaseController {

    @Autowired
    public HomeController(SecurityContextHolder security) {
        super(security);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        if (security.isLoggedIn()) {
            return "redirect:/auth/login";
        }
        return "redirect:/book/list";
    }
}
