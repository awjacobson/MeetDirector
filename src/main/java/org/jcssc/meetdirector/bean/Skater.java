package org.jcssc.meetdirector.bean;

public class Skater extends BaseBean
{
    private int id;
    private String lastName;
    private String firstName;
    private String gender;
    private String date;
    private String skaterClass;
    private String ussNumber;
    private int time500;
    private int time333;
    private int time111;
    private String comments;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender( String gender )
    {
        this.gender = gender;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate( String date )
    {
        this.date = date;
    }

    public String getSkaterClass()
    {
        return skaterClass;
    }

    public void setSkaterClass( String skaterClass )
    {
        this.skaterClass = skaterClass;
    }

    public String getUssNumber()
    {
        return ussNumber;
    }

    public void setUssNumber( String ussNumber )
    {
        this.ussNumber = ussNumber;
    }

    public int getTime500()
    {
        return time500;
    }

    public void setTime500( int time500 )
    {
        this.time500 = time500;
    }

    public int getTime333()
    {
        return time333;
    }

    public void setTime333( int time333 )
    {
        this.time333 = time333;
    }

    public int getTime111()
    {
        return time111;
    }

    public void setTime111( int time111 )
    {
        this.time111 = time111;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments( String comments )
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "Skater [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
                + ", gender=" + gender + ", date=" + date + ", skaterClass=" + skaterClass
                + ", ussNumber=" + ussNumber + ", time500=" + time500 + ", time333=" + time333
                + ", time111=" + time111 + ", comments=" + comments + "]";
    }
}
