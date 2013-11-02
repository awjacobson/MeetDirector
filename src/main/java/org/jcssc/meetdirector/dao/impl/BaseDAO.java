package org.jcssc.meetdirector.dao.impl;

import javax.sql.DataSource;

public class BaseDAO
{
    private DataSource dataSource;

    public DataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource( DataSource dataSource )
    {
        this.dataSource = dataSource;
    }
}