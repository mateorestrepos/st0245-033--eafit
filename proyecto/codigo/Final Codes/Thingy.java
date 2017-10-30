/**
 * @author Nicolas Restrepo Lopez
 * @author Mateo Restrepo Sierra
 */
import java.util.LinkedList;
public class Thingy
{
    int data;
    String name, size, user, directory;
    boolean isFolder;
    LinkedList<Thingy> subdirectories;
    
    public Thingy (String name, String size, String user)
    {
        this.name = name;                                                           //0(1)
        this.size = size;                                                           //0(1)
        this.user = user;                                                           //0(1)
        subdirectories = new LinkedList<>();                                        //0(1)
    }
    private int hashFunction()
    {
        int a = 0;                                                                  //0(1)
        for (int i = 0; i < name.length(); i++)                                     //0(n); n is the length of the name    
            a = a +  name.charAt(i) * (int) Math.pow(31, name.length() - 1 - i);    //0(n)
        return a;                                                                   //0(1)
    }
    /**
         * Converts the name of the Thingy into a number and assigns that value to the Thingy's data.
         * @see Thingy#hashFunction()
         */
    public void assignValue()
    {
        data = hashFunction();                                                      //0(n)
    }
    private int makeSize()
    {
        size = size.toUpperCase();                                                  //0(1)
        if (size.contains("K"))                                                     //0(1)
        {
            size = size.substring(0, size.indexOf("K"));                            //0(1)
            float a = Float.parseFloat(size);                                       //0(1)
            return (int) (a * 1024);                                                //0(1)            
        }
        else if (size.contains("M"))                                                //0(1)
        {
            size = size.substring(0, size.indexOf("M"));                            //0(1)
            float a = Float.parseFloat(size);                                       //0(1)
            return (int) (a * Math.pow(1024, 2));                                   //0(1)
        }
        else if (size.contains("G"))                                                //0(1)
        {
            size = size.substring(0, size.indexOf("G"));                            //0(1)
            float a = Float.parseFloat(size);                                       //0(1)
            return (int) (a * Math.pow(1024, 3));                                   //0(1)
        }
        else if (size.equals(".*\\d.*"));                                           //0(1)
        {
            float a = Float.parseFloat(size);                                       //0(1)
            return (int) (a);                                                       //0(1)
        }
    }
    /**
         * Converts the size of the Thingy into a number and assigns that value to teh Thingy's data.
         * @see Thingy#makeSize()
         */
    public void assignSize()
    {
        data = makeSize();                                                          //0(1)
    }
    /**
         * Prints all subdirectoires contained in Thingy.
         */
    public void printSubDirectories ()
    {
        if (!subdirectories.isEmpty())                                              //0(1)
        {
            subdirectories.forEach((subdirectory) -> {                              //0(1)
                System.out.println(subdirectory.name);                              //0(1)
            });
        }
        else
        System.out.println("<<" + name + ">> is not a directory.");                 //0(1)
    }
}