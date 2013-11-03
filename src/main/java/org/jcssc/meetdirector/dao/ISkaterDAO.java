package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;

public interface ISkaterDAO
{
    public List<Skater> getSkaters();
    public Skater getSkaterById( long id );
    public Skater updateSkater( Skater skater );
    public Skater addSkater( Skater skater );
}
