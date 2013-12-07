package org.jcssc.meetdirector.service;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkaterService
{
    @Autowired
    private ISkaterDAO skaterRepository;

    public List<Skater> findAll()
    {
        return skaterRepository.findAll();
    }

    public Skater findById( final long id )
    {
        return skaterRepository.findById( id );
    }

    public Skater add( final Skater skater )
    {
        return skaterRepository.add( skater );
    }

    public Skater update( final Skater skater )
    {
        final long id = skater.getId();
        final Skater oldSkater = findById( id );

        if( oldSkater == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldSkater.getLastMaintDateTime().equals( skater.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        return skaterRepository.update( skater );
    }

    public void delete( final Skater skater )
    {
        final long id = skater.getId();
        final Skater oldSkater = findById( id );

        if( oldSkater == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldSkater.getLastMaintDateTime().equals( skater.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        skaterRepository.delete( skater );
    }
}
