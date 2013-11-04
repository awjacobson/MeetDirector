package org.jcssc.meetdirector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController
{
    @RequestMapping({ "/skaters" })
    public String showSkaters()
    {
        return "skaters";
    }
}
