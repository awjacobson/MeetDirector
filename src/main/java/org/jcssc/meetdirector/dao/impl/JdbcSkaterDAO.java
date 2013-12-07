package org.jcssc.meetdirector.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jcssc.meetdirector.bean.Club;
import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.jdbc.core.RowMapper;
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
        final String sql = "(SELECT Skater.Id AS SkaterId, Skater.LastName, Skater.FirstName, Skater.BirthDate, " +
                "Club.Id AS ClubId, Club.ShortName " +
                "FROM aaronja_SpeedskaterPro.Skater AS Skater " +
                "INNER JOIN aaronja_SpeedskaterPro.Club AS Club " +
                "ON Club.Id = Skater.ClubId) " +
                "UNION " +
                "(SELECT Skater.Id, Skater.LastName, Skater.FirstName, Skater.BirthDate, NULL, NULL " +
               "FROM aaronja_SpeedskaterPro.Skater AS Skater " +
                "WHERE Skater.ClubId IS NULL) " +
                "ORDER BY LastName, FirstName";

        final RowMapper<Skater> rowMapper = new RowMapper<Skater>()
        {
            @Override
            public Skater mapRow( ResultSet rs, int rowNum ) throws SQLException
            {
                final Skater skater = new Skater();
                skater.setId( rs.getInt( "SkaterId" ) );
                skater.setLastName( rs.getString( "LastName" ) );
                skater.setFirstName( rs.getString( "FirstName" ) );
                skater.setBirthDate( rs.getDate( "BirthDate" ) );

                final Club club = new Club();
                club.setId( rs.getInt( "ClubId" ) );
                club.setShortName( rs.getString( "ShortName" ) );
                skater.setClub( club );

                return skater;
            }
        };

        return getJdbcTemplate().query( sql, rowMapper );
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
    public Skater update( Skater skater )
    {
        final String sql = "UPDATE aaronja_SpeedskaterPro.Skater SET LastName='?', FirstName='?' WHERE Id=?";
        //final Object[] args = {skater.getLastName(), skater.getFirstName(), skater.getId() };
        /*final int rows =*/ getJdbcTemplate().update( sql, skater.getLastName(), skater.getFirstName(), skater.getId() );
        return null;
    }

    @Override
    public Skater add( Skater skater )
    {
        final String sql = "INSERT INTO aaronja_SpeedskaterPro.Skater " +
                "(LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid) " +
                "VALUES (?,?,?)";
        final Object[] args = {skater.getLastName(), skater.getFirstName(), skater.getLastMaintOpid()};
        getJdbcTemplate().update( sql, args );

        final long id = getJdbcTemplate().queryForLong( "select last_insert_id()" );
        return findById( id );
    }

    @Override
    public void delete( Skater skater )
    {
        // TODO Auto-generated method stub
    }
}
