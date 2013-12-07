package org.jcssc.meetdirector.controller;

import java.util.List;

import org.jcssc.meetdirector.bean.Rink;
import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.service.RinkService;
import org.jcssc.meetdirector.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController
{
    @Autowired
    private SkaterService skaterService;

    @Autowired
    private RinkService rinkService;

    @RequestMapping({ "/skaterList" })
    public String showSkaterList( ModelMap map )
    {
        final List<Skater> skaterList = skaterService.findAll();
        map.addAttribute( "skaterList", skaterList );
        return "skaterList";
    }

    @RequestMapping({ "/skaterDetails"})
    public String showSkaterDetail( @RequestParam("id") long skaterId, ModelMap map)
    {
        final Skater skater = skaterService.findById( skaterId );
        map.addAttribute( "skater", skater );
        return "skaterDetails";
    }

    @RequestMapping(value="/skaterDetails", method=RequestMethod.POST, params={"save"})
    public String saveSkaterDetail()
    {
        return "redirect:/skatersList";
    }

    @RequestMapping({ "/rinkList" })
    public String showRinkList( ModelMap map )
    {
        final List<Rink> rinkList = rinkService.findAll();
        map.addAttribute( "rinkList", rinkList );
        return "rinkList";
    }
}
