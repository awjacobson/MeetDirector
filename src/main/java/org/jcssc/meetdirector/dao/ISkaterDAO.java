package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Skater;

public interface ISkaterDAO
{
    public List<Skater> getSkaters();
    public Skater getSkaterById( String id );
}
