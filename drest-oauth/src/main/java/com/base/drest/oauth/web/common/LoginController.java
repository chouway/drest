package com.base.drest.oauth.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * LoginController
 * @author zhouyw
 * @date 2018.05.20
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest httpServletRequest,String username){
        AuthenticationException authenticationException = (AuthenticationException) httpServletRequest.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        model.addAttribute("SPRING_SECURITY_LAST_EXCEPTION",authenticationException);
        model.addAttribute("username",username);
        return "login";
    }


    @RequestMapping("/oauth/confirm_access")
    public String authorize(Model model, HttpServletRequest httpServletRequest,HttpSession httpSession){
        Object spring_security_context = httpSession.getAttribute("SPRING_SECURITY_CONTEXT");


        return "authorize";
    }

}
