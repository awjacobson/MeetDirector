package org.jcssc.meetdirector.bean;

/**
 * The Club class represents a club such as Jefferson City Speed Skating Club
 * (JCSSC), St. Louis Speed Skating (STSS), etc.
 */
public class Club extends BaseBean
{
    private int id;
    private String longName;
    private String shortName;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getLongName()
    {
        return longName;
    }

    public void setLongName( String longName )
    {
        this.longName = longName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName( String shortName )
    {
        this.shortName = shortName;
    }
}
