package org.jcssc.meetdirector.bean;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class SkaterTest
{
    /**
     * Test that having a birthday just before July 1 calculates to the correct
     * age.
     */
    @Test
    public void testGetAge_1()
    {
        final Skater skater = new Skater();

        final Calendar calendar = Calendar.getInstance();
        calendar.set( 2011, Calendar.JUNE, 30 );
        skater.setBirthDate( calendar.getTime() );

        final int expected = 2;
        final int actual = skater.getAge();

        assertEquals( expected, actual );
    }

    /**
     * Test that having a birthday just after July 1 calculates to the correct
     * age.
     */
    @Test
    public void testGetAge_2()
    {
        final Skater skater = new Skater();

        final int expected = 1;
        final Calendar calendar = Calendar.getInstance();
        calendar.set( 2011, Calendar.JULY, 2 );
        skater.setBirthDate( calendar.getTime() );

        final int actual = skater.getAge();

        assertEquals( expected, actual );
    }

}
