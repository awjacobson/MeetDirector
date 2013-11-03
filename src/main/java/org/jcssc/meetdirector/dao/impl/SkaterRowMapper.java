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
        skater.setGender( rs.getString( "Gender" ) );
        skater.setBirthDate( rs.getDate( "BirthDate" ) );
        skater.setSkaterClass( rs.getString( "Class" ) );
        skater.setUssNumber( rs.getString( "USSNumber" ) );
        skater.setTime500( rs.getInt( "Time500" ) );
        skater.setTime333( rs.getInt( "Time333" ) );
        skater.setTime111( rs.getInt( "Time111" ) );
        skater.setComments( rs.getString( "Comments" ) );
        skater.setLastMaintOpid( rs.getString( "LastMaintOpid" ) );
        skater.setLastMaintDateTime( rs.getString( "LastMaintDateTime" ) );
        return skater;
    }

}
