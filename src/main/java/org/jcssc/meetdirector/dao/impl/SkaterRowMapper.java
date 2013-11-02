package org.jcssc.meetdirector.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jcssc.meetdirector.bean.Skater;
import org.springframework.jdbc.core.RowMapper;

public class SkaterRowMapper implements RowMapper<Skater>
{
    @Override
    public Skater mapRow( ResultSet rs, int rowNum ) throws SQLException
    {
        final Skater skater = new Skater();
        skater.setId( rs.getInt( "Id" ) );
        skater.setLastName( rs.getString( "LastName" ) );
        skater.setFirstName( rs.getString( "FirstName" ) );
        return skater;
    }

}
