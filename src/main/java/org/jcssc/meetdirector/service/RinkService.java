package org.jcssc.meetdirector.service;

import java.util.List;

import org.jcssc.meetdirector.bean.Rink;
import org.jcssc.meetdirector.dao.IRinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RinkService
{
    @Autowired
    private IRinkDAO rinkRepository;

    public List<Rink> findAll()
    {
        return rinkRepository.findAll();
    }

    public Rink findById( final long id )
    {
        return rinkRepository.findById( id );
    }

    public Rink add( final Rink rink )
    {
        return rinkRepository.add( rink );
    }

    public Rink update( final Rink rink )
    {
        final long id = rink.getId();
        final Rink oldRink = findById( id );

        if( oldRink == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldRink.getLastMaintDateTime().equals( rink.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        return rinkRepository.update( rink );
    }

    public void delete( final Rink rink )
    {
        final long id = rink.getId();
        final Rink oldRink = findById( id );

        if( oldRink == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldRink.getLastMaintDateTime().equals( rink.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        rinkRepository.delete( rink );
    }
}
