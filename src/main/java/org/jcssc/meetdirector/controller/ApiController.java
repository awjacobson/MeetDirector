package org.jcssc.meetdirector.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController implements ApplicationContextAware
{
    private ApplicationContext context;

    @RequestMapping(value = "/api/skaters", method = RequestMethod.GET)
    public @ResponseBody List<Skater> getSkaters(HttpServletRequest request, HttpServletResponse response ) throws SQLException
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        final List<Skater> skaters = skaterDAO.getSkaters();
        return skaters;
    }

    @RequestMapping(value = "/api/skater/{id}", method = RequestMethod.GET)
    public @ResponseBody Skater getSkater( @PathVariable("id") long id,
            HttpServletRequest request, HttpServletResponse response )
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        return skaterDAO.getSkaterById( id );
    }

    @RequestMapping(value = "/api/skater/{id}", method = RequestMethod.POST)
    public @ResponseBody Skater updateSkater( @PathVariable("id") String id, @RequestBody Skater skater, HttpServletResponse response )
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        return skaterDAO.updateSkater( skater );
    }

    @RequestMapping(value = "/api/skater", method = RequestMethod.PUT)
    public @ResponseBody Skater addSkater( @RequestBody Skater skater, HttpServletResponse response )
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        return skaterDAO.updateSkater( skater );
    }

    @Override
    public void setApplicationContext( ApplicationContext context ) throws BeansException
    {
        this.context = context;
    }
}
