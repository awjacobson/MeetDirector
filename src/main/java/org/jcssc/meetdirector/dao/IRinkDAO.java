package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Rink;

public interface IRinkDAO
{
    public List<Rink> findAll();
    public Rink findById( long id );
    public Rink update( Rink rink );
    public Rink add( Rink rink );
    public void delete( Rink rink );
}
