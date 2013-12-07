package org.jcssc.meetdirector.dao;

import java.util.List;

import org.jcssc.meetdirector.bean.Meet;

public interface IMeetDAO
{
    public List<Meet> findAll();
    public Meet findById( long id );
    public Meet update( Meet meet );
    public Meet add( Meet meet );
    public void delete( Meet meeet );
}
