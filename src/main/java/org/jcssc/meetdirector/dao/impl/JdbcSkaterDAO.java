package org.jcssc.meetdirector.dao.impl;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * http://javarhymes.blogspot.com/2008/06/spring-dao-with-jdbcdaosupport.html
 */
public class JdbcSkaterDAO extends JdbcDaoSupport implements ISkaterDAO
{
    @Override
    public List<Skater> getSkaters()
    {
        final String sql = "SELECT Id,LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Skater ORDER BY LastName, FirstName";
        return getJdbcTemplate().query( sql, new SkaterRowMapper() );
    }

    @Override
    public Skater getSkaterById( long id )
    {
        final String sql = "SELECT Id,LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Skater WHERE Id = ?";
        final Object[] args = {id};
        final List<Skater> skaters = getJdbcTemplate().query( sql, args, new SkaterRowMapper() );
        return skaters.size() == 0 ? null : skaters.get( 0 );
    }

    @Override
    public Skater updateSkater( Skater skater )
    {
        final long id = skater.getId();
        final Skater oldSkater = getSkaterById( id );

        if( oldSkater == null )
        {
            throw new RuntimeException( "Not found" );
        }

        if( !oldSkater.getLastMaintDateTime().equals( skater.getLastMaintDateTime() ) )
        {
            throw new RuntimeException( "Updated by another user" );
        }

        final String sql = "UPDATE aaronja_SpeedskaterPro.Skater SET LastName='?', FirstName='?' WHERE Id=?";
        final Object[] args = {skater.getLastName(), skater.getFirstName(), id};
        /*final int rows =*/ getJdbcTemplate().update( sql, args );
        return null;
    }

    @Override
    public Skater addSkater( Skater skater )
    {
        return null;
    }
}
