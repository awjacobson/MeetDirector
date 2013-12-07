package org.jcssc.meetdirector.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jcssc.meetdirector.bean.Meet;
import org.jcssc.meetdirector.bean.Rink;
import org.jcssc.meetdirector.dao.IMeetDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcMeetDAO extends JdbcDaoSupport implements IMeetDAO
{
    @Override
    public List<Meet> findAll()
    {
        final String sql = "SELECT Meet.Id AS MeetId, Meet.Name AS MeetName, Meet.StartDate, Meet.EndDate, " +
                "Rink.Id AS RinkId, Rink.Name AS RinkName, Rink.City, Rink.State " +
                "FROM aaronja_SpeedskaterPro.Meet AS Meet " +
                "INNER JOIN aaronja_SpeedskaterPro.Rink AS Rink " +
                "ON Rink.Id = Meet.RinkId " + 
                "ORDER BY StartDate";

        final RowMapper<Meet> rowMapper = new RowMapper<Meet>()
        {
            @Override
            public Meet mapRow( ResultSet rs, int rowNum ) throws SQLException
            {
                final Meet meet = new Meet();
                meet.setId( rs.getInt( "MeetId" ) );
                meet.setName( rs.getString( "MeetName" ) );
                meet.setStartDate( rs.getDate( "StartDate" ) );
                meet.setEndDate( rs.getDate( "EndDate" ) );

                final Rink rink = new Rink();
                rink.setId( rs.getInt( "RickId" ) );
                rink.setName( rs.getString( "RinkName" ) );
                rink.setCity( rs.getString( "City" ) );
                rink.setState( rs.getString( "State" ) );
                meet.setRink( rink );

                return meet;
            }
        };

        return getJdbcTemplate().query( sql, rowMapper );
    }

    @Override
    public Meet findById( long id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Meet update( Meet meet )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Meet add( Meet meet )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete( Meet meeet )
    {
        // TODO Auto-generated method stub

    }

}
