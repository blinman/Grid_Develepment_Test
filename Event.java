import java.util.*;

/**
 * This class is for creating an Event with an ID and some tickets
 *
 * @author Sava
 * @version 2 May 2017
 */
public class Event
{
    Random random=new Random();
    private int ID;
    private Ticket[] tickets;
    /**
     * Creates an Event, sets it ID.
     * Then creates a Ticket array with a random number of tickets and sorts the array.
     * 
     * @param unique ID
     */
    public Event(int ID)
    {
        this.ID=ID;
        this.tickets=new Ticket[random.nextInt(100)];
        for (int i=0;i<tickets.length;i++)
        {
            this.tickets[i]=new Ticket();
        }
        for (int i=0;i<this.tickets.length;i++)
        {
            Arrays.sort(tickets);
        }
    }

    /**
     * Retrives Event ID
     *
     * @return ID of the Event
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Retrives a Ticket from the Ticket array
     *
     * @param pos index of the specified Ticket
     * @return specified Ticket
     */
    public Ticket getTicket(int pos)
    {
        return tickets[pos];
    }

    /**
     * Retrives the number of tickets in the Ticket array
     *
     * @return number of tickets
     */
    public int getNumberOfTickets()
    {
        return tickets.length;
    }
}
