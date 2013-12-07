package org.jcssc.meetdirector.service;

import java.util.List;

import org.jcssc.meetdirector.bean.Club;
import org.jcssc.meetdirector.dao.IClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService
{
    @Autowired
    private IClubDAO clubRepository;

    public List<Club> findAll()
    {
        return clubRepository.findAll();
    }

    public Club findById( final long id )
    {
        return clubRepository.findById( id );
    }

    public Club add( final Club club )
    {
        return clubRepository.add( club );
    }

    public Club update( final Club club )
    {
        final long id = club.getId();
        final Club oldClub = findById( id );

        if( oldClub == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldClub.getLastMaintDateTime().equals( club.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        return clubRepository.update( club );
    }

    public void delete( final Club club )
    {
        final long id = club.getId();
        final Club oldClub = findById( id );

        if( oldClub == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldClub.getLastMaintDateTime().equals( club.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        clubRepository.delete( club );
    }
}
