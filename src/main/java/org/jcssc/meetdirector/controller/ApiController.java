package org.jcssc.meetdirector.controller;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.service.SkaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController
{
    private static final Logger logger = LoggerFactory.getLogger( ApiController.class );

    @Autowired
    private SkaterService skaterService;

    @RequestMapping(value = "/api/skaters", method = RequestMethod.GET)
    public @ResponseBody List<Skater> getSkaters()
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug( "getSkaters" );
        }

        return skaterService.findAll();
    }

    @RequestMapping(value = "/api/skater/{id}", method = RequestMethod.GET)
    public @ResponseBody Skater getSkater( @PathVariable("id") long id )
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug( "getSkater: id={}", id );
        }

        return skaterService.findById( id );
    }

    @RequestMapping(value = "/api/skater", method = RequestMethod.POST)
    public @ResponseBody Skater updateSkater( @RequestBody Skater skater )
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug( "updateSkater: skater={}", skater );
        }

        return skaterService.update( skater );
    }

    @RequestMapping(value = "/api/skater", method = RequestMethod.PUT)
    public @ResponseBody Skater addSkater( @RequestBody Skater skater )
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug( "addSkater: skater={}", skater );
        }

        return skaterService.add( skater );
    }
}
