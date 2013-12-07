package org.jcssc.meetdirector.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jcssc.meetdirector.bean.Rink;
import org.springframework.jdbc.core.RowMapper;

public class RinkRowMapper implements RowMapper<Rink>
{
    @Override
    public Rink mapRow( ResultSet rs, int rowNum ) throws SQLException
    {
        final Rink rink = new Rink();
        rink.setId( rs.getInt( "Id" ) );
        rink.setName( rs.getString( "Name" ) );
        rink.setStreet( rs.getString( "Street" ) );
        rink.setCity( rs.getString( "City" ) );
        rink.setState( rs.getString( "State" ) );
        rink.setZip( rs.getString( "Zip" ) );
        rink.setWebsite( rs.getString( "Website" ) );
        rink.setLastMaintOpid( rs.getString( "LastMaintOpid" ) );
        rink.setLastMaintDateTime( rs.getString( "LastMaintDateTime" ) );
        return rink;
    }
}
