package com.englishRibbon.mvc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by t3wr on 08.03.15.
 */
@Controller
@Scope("request")
@RequestMapping(value = "/registration")
public class RegistrationController extends CommonController
{
    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }
}
