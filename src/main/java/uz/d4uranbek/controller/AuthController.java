package uz.d4uranbek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.d4uranbek.SecurityContextHolder;
import uz.d4uranbek.entity.AuthUser;
import uz.d4uranbek.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private final UserService userService;

    @Autowired
    public AuthController(SecurityContextHolder security, UserService userService) {
        super(security);
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String cabinet(HttpServletRequest httpServletRequest) {
        AuthUser user = new AuthUser();
        user.setUsername(httpServletRequest.getParameter("username"));
        user.setPassword(httpServletRequest.getParameter("password"));
        userService.login(user);
        return "redirect:/";
    }
}
