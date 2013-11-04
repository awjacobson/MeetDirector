package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;

public interface ISkaterDAO
{
    public List<Skater> findAll();
    public Skater findById( long id );
    public Skater update( Skater skater );
    public Skater add( Skater skater );
    public void delete( Skater skater );
}
