package org.jcssc.meetdirector.dao.impl;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * http://javarhymes.blogspot.com/2008/06/spring-dao-with-jdbcdaosupport.html
 * http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/jdbc.html
 */
public class JdbcSkaterDAO extends JdbcDaoSupport implements ISkaterDAO
{
    @Override
    public List<Skater> findAll()
    {
        final String sql = "SELECT Id,LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Skater ORDER BY LastName, FirstName";
        return getJdbcTemplate().query( sql, new SkaterRowMapper() );
    }

    @Override
    public Skater findById( long id )
    {
        final String sql = "SELECT Id,LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid,LastMaintDateTime FROM aaronja_SpeedskaterPro.Skater WHERE Id = ?";
        final Object[] args = {id};
        final List<Skater> skaters = getJdbcTemplate().query( sql, args, new SkaterRowMapper() );
        return skaters.size() == 0 ? null : skaters.get( 0 );
    }

    @Override
    public Skater add( Skater skater )
    {
        return null;
    }

    @Override
    public Skater update( Skater skater )
    {
        final String sql = "UPDATE aaronja_SpeedskaterPro.Skater SET LastName='?', FirstName='?' WHERE Id=?";
        //final Object[] args = {skater.getLastName(), skater.getFirstName(), skater.getId() };
        /*final int rows =*/ getJdbcTemplate().update( sql, skater.getLastName(), skater.getFirstName(), skater.getId() );
        return null;
    }

    @Override
    public void delete( Skater skater )
    {
        // TODO Auto-generated method stub
    }
}
