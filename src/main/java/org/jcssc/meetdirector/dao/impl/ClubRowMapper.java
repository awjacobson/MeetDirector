package org.jcssc.meetdirector.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jcssc.meetdirector.bean.Club;
import org.springframework.jdbc.core.RowMapper;

public class ClubRowMapper implements RowMapper<Club>
{
    @Override
    public Club mapRow( ResultSet rs, int rowNum ) throws SQLException
    {
        final Club club = new Club();
        club.setId( rs.getInt( "Id" ) );
        club.setLongName( rs.getString( "LongName" ) );
        club.setShortName( rs.getString( "ShortName" ) );
        club.setLastMaintOpid( rs.getString( "LastMaintOpid" ) );
        club.setLastMaintDateTime( rs.getString( "LastMaintDateTime" ) );
        return club;
    }
}
