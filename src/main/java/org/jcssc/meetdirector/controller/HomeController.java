package org.jcssc.meetdirector.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements ApplicationContextAware
{
    private static final Logger logger = LoggerFactory.getLogger( HomeController.class );
    private ApplicationContext context;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home( Locale locale, Model model )
    {
        logger.info( "Welcome home! The client locale is {}.", locale );

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.LONG, locale );

        String formattedDate = dateFormat.format( date );

        model.addAttribute( "serverTime", formattedDate );

        return "home";
    }

    @RequestMapping(value = "/skaters", method = RequestMethod.GET)
    public @ResponseBody List<Skater> getSkaters(HttpServletRequest request, HttpServletResponse response ) throws SQLException
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        final List<Skater> skaters = skaterDAO.getSkaters();
        return skaters;
    }

    @RequestMapping(value = "/skater/{id}", method = RequestMethod.GET)
    public @ResponseBody Skater getSkater( @PathVariable("id") String id,
            HttpServletRequest request, HttpServletResponse response )
    {
        final ISkaterDAO skaterDAO = (ISkaterDAO) context.getBean("skaterDAO");
        return skaterDAO.getSkaterById( id );
    }

    @Override
    public void setApplicationContext( ApplicationContext context ) throws BeansException
    {
        this.context = context;
    }


}
