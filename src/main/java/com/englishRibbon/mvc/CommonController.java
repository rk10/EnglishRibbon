package com.englishRibbon.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by t3wr on 08.03.15.
 */
public class CommonController {
    @RequestMapping("/{errorArtifact}")
    public String defaultMethod() {
        return "error";
    }
}
