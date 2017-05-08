import java.util.*;
import static java.lang.Math.*;
/**
 * Creates a Place with a number of Events and a position, in this one Event only
 *
 * @author Sava Kovalenko
 * @version 2 May 2017
 */
public class Place
{
    private Event[] events;
    private int xPos;
    private int yPos;
    /**
     * Sets the position and creates an empty array of Events
     *
     * @param xPos x-coordinate of the Place
     * @param yPos y-coordinate of the Place
     */
    public Place(int xPos, int yPos)
    {
        this.xPos=xPos;
        this.yPos=yPos;
        this.events=new Event[1];
    }

    /**
     * Gets the x-coordinate of the Place
     *
     * @return x-coordinate of the Place
     */
    public int getX()
    {
        return xPos;
    }

    /**
     * Gets the y-coordinate of the Place
     *
     * @return y-coordinate of the Place
     */
    public int getY()
    {
        return yPos;
    }

    /**
     * Retrives the Event form Event array
     *
     * @param pos position in the Event array
     * @return specified Event
     */
    public Event getEvent(int pos)
    {
        return events[pos];
    }

    /**
     * Retrives number of Events in a Place
     *
     * @return number of Events
     */
    public int getNumberOfEvents()
    {
        return events.length;
    }

    /**
     * Retrieves ID of an Event in an Event array
     *
     * @param pos position in the Event array
     * @return ID of the Event
     */
    public int getEventID(int pos)
    {
        return this.events[pos].getID();
    }

    /**
     * Creates an Event with a specified ID in a an Event array
     *
     * @param pos position in the Event array
     * @param ID unique ID
     */
    public void setEventID(int pos, int ID)
    {
        this.events[pos]=new Event(ID);
    }

    /**
     * Retrieves the Manhattan distance between two points
     *
     * @param xPos x-coordinate of the point
     * @param yPos y-coordinate of the point
     * @return Distance between the points
     */
    public int getDistance(int xPos, int yPos)
    {
        return abs(this.xPos-xPos)+ abs(this.yPos-yPos);
    }
} 
