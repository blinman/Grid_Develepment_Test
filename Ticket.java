import java.util.*;

/**
 * Creates a ticket with a random price from 10 to 300
 *
 * @author Sava Kovalenko
 * @version 2 May 2017
 */
public class Ticket implements Comparable<Ticket>
{
    Random random=new Random();
    private float price;
    private float maxPrice=300;
    private float minPrice=10;
    /**
     * Creates a ticket with a random price from 10 to 300
     *
     */
    public Ticket()
    {
        this.price=random.nextFloat()*(maxPrice-minPrice)+minPrice;
    }
    
    /**
     * Gets the ticket price
     *
     * @return ticket price
     */
    public float getPrice()
    {
        return price;
    }
    
    /**
     * Allows tickets to be sorted by their price
     *
     * @param compareTicket Ticket to be compared
     * @return if the price is larger, smaller or same
     */
    public int compareTo(Ticket compareTicket)
    {
        if (compareTicket.getPrice()<this.price)
        {
            return 1;
        }
        else if (compareTicket.getPrice()==this.price)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
}
