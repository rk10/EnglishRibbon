package com.englishRibbon.resources;

import com.englishRibbon.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by t3wr on 09.03.15.
 */
@Controller
@Scope("request")
@RequestMapping(value = "/users")
public class UserResource
{
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody User getUser(
        @PathVariable Integer id
    ) {
        User user = new User();
        user.setId( id );
        return user;
    }


}
