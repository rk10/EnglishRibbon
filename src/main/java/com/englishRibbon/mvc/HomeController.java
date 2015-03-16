package com.englishRibbon.mvc;

import com.englishRibbon.utils.SessionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("request")
@RequestMapping("/")
public class HomeController extends CommonController
{
    @Autowired
    private SessionStorage sessionStorage;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePageWithoutId(
            @RequestParam(value = "name", defaultValue = "") String name,
            @CookieValue(value = "sessionKey", defaultValue = "") String sessionKey,
            ModelMap model
    ) {
        int id = sessionStorage.getUserIdBySessionKey( sessionKey );
        return id == -1 ? "redirect:/registration/" : "redirect:/user/" + id;
	}

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String homePageWithId(
            @PathVariable("id") String id,
            @CookieValue(value = "sessionKey", defaultValue = "") String sessionKey
    ) {
        if (sessionKey.isEmpty() || !sessionStorage.checkSessionKey(sessionKey)) {
            return "redirect:/registration/";
        }
        return "home";
    }
}