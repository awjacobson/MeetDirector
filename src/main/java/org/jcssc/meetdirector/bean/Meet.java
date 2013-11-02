package org.jcssc.meetdirector.bean;

public class Meet extends BaseBean
{
    private int id;
    private String name;
    // TODO dates and times
    // TODO location

    public int getId()
    {
        return id;
    }
    public void setId( int id )
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }
}
