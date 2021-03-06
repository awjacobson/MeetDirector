package org.jcssc.meetdirector.bean;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Years;

/**
 *
 */
public class Skater extends BaseBean
{
    private int id;
    private String lastName;
    private String firstName;
    private String gender;
    private Date birthDate;
    private String skaterClass;
    private String ussNumber;
    private int time500;
    private int time333;
    private int time111;
    private String comments;
    private Club club;

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

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate( Date birthDate )
    {
        this.birthDate = birthDate;
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

    public Club getClub()
    {
        return club;
    }

    public void setClub( Club club )
    {
        this.club = club;
    }

    /**
     * Calculates the age of this skater as of July 1st of the current year.
     *
     * @return Age (in years) of the skater
     */
    public int getAge()
    {
        final DateTimeZone timeZone = DateTimeZone.forID( "America/Chicago" );
        final DateTime now = new DateTime( DateTime.now( timeZone ).getYear(), 7, 1, 0, 0 ); // midnight of July 1st of current year
        final DateTime birthdate = new DateTime( getBirthDate() );
        final Years age = Years.yearsBetween( birthdate, now );
        return age.getYears();
    }

    @Override
    public String toString()
    {
        return "Skater [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
                + ", gender=" + gender + ", birthDate=" + birthDate + ", skaterClass="
                + skaterClass + ", ussNumber=" + ussNumber + ", time500=" + time500 + ", time333="
                + time333 + ", time111=" + time111 + ", comments=" + comments + "]";
    }
}
