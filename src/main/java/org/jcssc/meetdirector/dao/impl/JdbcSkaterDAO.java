package org.jcssc.meetdirector.dao.impl;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;
import org.jcssc.meetdirector.dao.ISkaterDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcSkaterDAO extends JdbcDaoSupport implements ISkaterDAO
{
    @Override
    public List<Skater> getSkaters()
    {
        final String sql = "select Id,LastName,FirstName,Gender,BirthDate,Class,USSNumber,Time500,Time333,Time111,Comments,LastMaintOpid,LastMaintDateTime from aaronja_SpeedskaterPro.Skater ORDER BY LastName, FirstName";
        return getJdbcTemplate().query( sql, new SkaterRowMapper() );
    }

    @Override
    public Skater getSkaterById( String id )
    {
        final String sql = "";
        final Skater skater = null;// = getJdbcTemplate().query( sql, new SkaterRowMapper() );
        return skater;
    }
}
