package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Club;

public interface IClubDAO
{
    public List<Club> findAll();
    public Club findById( long id );
    public Club update( Club club );
    public Club add( Club club );
    public void delete( Club club );
}
