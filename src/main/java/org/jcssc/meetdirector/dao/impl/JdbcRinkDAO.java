package org.jcssc.meetdirector.dao.impl;

import java.util.List;

import org.jcssc.meetdirector.bean.Rink;
import org.jcssc.meetdirector.dao.IRinkDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcRinkDAO extends JdbcDaoSupport implements IRinkDAO
{

    @Override
    public List<Rink> findAll()
    {
        final String sql = "SELECT Id,Name,Street,City,State,Zip,Website,LastMaintOpid,LastMaintDateTime " +
                "FROM aaronja_SpeedskaterPro.Rink ORDER BY Name";
        return getJdbcTemplate().query( sql, new RinkRowMapper() );
    }

    @Override
    public Rink findById( long id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rink update( Rink rink )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rink add( Rink rink )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete( Rink rink )
    {
        // TODO Auto-generated method stub

    }

}
