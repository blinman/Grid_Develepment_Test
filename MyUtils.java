import java.util.*;
/**
 * A set of functions written by yours truly to be used everywhere in the program
 *
 * @author Sava Kovalenko
 * @version 3 May 2017
 */
public class MyUtils
{
    /**
     * Checks if specified String can be converted into an Integer
     *
     * @param value specified String
     * @return is it possible to convert
     */
    public static boolean convertibleToInt(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }

    /**
     * Checks if specified String represnts a predefined format
     *
     * @param userInput specified String
     * @return is the format correct
     */
    public static boolean isCorrectFormat(String userInput)
    {
        if (userInput!=null && userInput.length()>=3)
        {
            String[] formattedInput = userInput.split(",");
            if (formattedInput.length==2 && MyUtils.convertibleToInt(formattedInput[0]) && MyUtils.convertibleToInt(formattedInput[1]))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
