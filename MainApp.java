import java.util.*;
/**
 * Main program, where most of the action happens, i.e. the world is created, the user is asked for input and the resluts are displayed
 *
 * @author Sava Kovalenko
 * @version 3 May 2017
 */
public class MainApp
{
    static Scanner scanner=new Scanner(System.in);
    private static Place[][] world = new Place[21][21];
    private static ArrayList<Place> resultingList=new ArrayList<Place>();
    private static int x,y;
    /**
     * Main method which calls all the others
     *
     * @param args No need for parameters so far
     */
    public static void main(String[] args)
    {
        populateTheWorld();
        UserInterface();
        outputResults();
    }

    /**
     * Creates a world defined in the requirements, with events, tickets, prices and etc.
     *
     */
    public static void populateTheWorld()
    {
        ArrayList<Integer> numbersForID=new ArrayList<Integer>();
        for (int i=0;i<world.length*world[0].length;i++)
        {
            numbersForID.add(i);
        }
        Collections.shuffle(numbersForID);

        int IDPos=0;
        for (int i=0;i<world.length;i++)
        {
            for (int j=0;j<world[0].length;j++)
            {
                world[i][j]=new Place(i-10,j-10);
                for (int k=0;k<world[i][j].getNumberOfEvents();k++)
                {
                    world[i][j].setEventID(k,numbersForID.get(IDPos));
                    IDPos++;
                }
            }
        }
    }

    /**
     * Asks the user for input of coordinates, checks if format is correct and passes them to be used to calculate the closest events
     *
     */
    public static void UserInterface()
    {
        String userInput;
        System.out.println("Enter the location of reference, i.e. starting location in format (x,y)");
        while(true)
        {
            userInput=scanner.next();
            if (MyUtils.isCorrectFormat(userInput)==false)
            {
                System.out.println("Invalid! Please enter a set of coordinates from -10 to 10, format: (x,y)");
            }
            else
            {
                String[] formattedInput= userInput.split(",");
                x=Integer.parseInt(formattedInput[0]);
                y=Integer.parseInt(formattedInput[1]);
                if (x>=-10 && x<=10 && y>=-10 && y<=10)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid! Please enter an integer from -10 to 10");
                }
            }
        }
        calculateClosest(x,y);
    }

    /**
     * Creates a list of all places that have events that have tickets. Then sorts the list by distance from the reference location
     *
     * @param xPos x-coordinate of starting position
     * @param yPos y-coordinate of starting position
     */
    public static void calculateClosest(int xPos, int yPos)
    {

        for (int i=0;i<world.length;i++)
        {
            for (int j=0;j<world[0].length;j++)
            {
                if (world[i][j].getEvent(0).getNumberOfTickets()>0)
                {
                    resultingList.add(world[i][j]);
                }
            }
        }

        for (int i=0;i<resultingList.size();i++)
        {
            for(int j=0;j<resultingList.size()-i-1;j++)
            {
                if (resultingList.get(j).getDistance(xPos, yPos)>resultingList.get(j+1).getDistance(xPos, yPos))
                {
                    Collections.swap(resultingList, j, j+1);
                }
            }
        }

    }

    /**
     * Shows five closest events, which have tickets, their ID, tickets price and distance
     *
     */
    public static void outputResults()
    {
        for (int i=1;i<6;i++)
        {
            System.out.println("Event "+resultingList.get(i).getEventID(0)+" - $"+resultingList.get(i).getEvent(0).getTicket(0).getPrice()+" "+", Distance "+resultingList.get(i).getDistance(x, y));
        }
    }
}
