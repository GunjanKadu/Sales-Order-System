/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for handling login
 *
 * @author colin
 */
@Controller
public class LoginController {

    /**
     * Shows the login page
     *
     * @param error
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
        @RequestParam(value = "error", required = false) String error
    ) {

        ModelAndView modelAndView = new ModelAndView();

        if(error != null) {
            modelAndView.addObject("error", "Invalid username and password!");
        }

        modelAndView.setViewName("login");

        return modelAndView;
    }

}
