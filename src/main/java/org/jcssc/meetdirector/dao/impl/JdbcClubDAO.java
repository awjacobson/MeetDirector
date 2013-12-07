package org.jcssc.meetdirector.dao.impl;

import java.util.List;

import org.jcssc.meetdirector.bean.Club;
import org.jcssc.meetdirector.dao.IClubDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcClubDAO extends JdbcDaoSupport implements IClubDAO
{
    @Override
    public List<Club> findAll()
    {
        final String sql = "SELECT Id,LongName,ShortName,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Club ORDER BY LongName";
        return getJdbcTemplate().query( sql, new ClubRowMapper() );
    }

    @Override
    public Club findById( long id )
    {
        final String sql = "SELECT Id,LongName,ShortName,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Club WHERE Id = ?";
        final Object[] args = {id};
        final List<Club> clubs = getJdbcTemplate().query( sql, args, new ClubRowMapper() );
        return clubs.size() == 0 ? null : clubs.get( 0 );
    }

    @Override
    public Club update( Club club )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Club add( Club club )
    {
        final String sql = "INSERT INTO aaronja_SpeedskaterPro.Club " +
                "(LongName,ShortName,LastMaintOpid) VALUES (?,?,?)";
        final Object[] args = {club.getLongName(), club.getShortName(), club.getLastMaintOpid()};
        getJdbcTemplate().update( sql, args );

        final long id = getJdbcTemplate().queryForLong( "select last_insert_id()" );
        return findById( id );
    }

    @Override
    public void delete( Club club )
    {
        // TODO Auto-generated method stub
        
    }
}
