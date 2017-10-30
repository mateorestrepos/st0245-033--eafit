import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Nicolas Restrepo Lopez
 * @author Mateo Restrepo Sierra
 */
public class MainTree
{
    public static void main (String [] args) throws IOException
    {
        test();                                                                                                                     //O(m*n*t*s) + O(h*log m)
    }
    private static void test() throws IOException {
        try {
            System.out.println("- Type search plus the name of the file to see its location,");                                     //0(1)
            System.out.println("  sub plus the name of the folder to print its content,");                                          //0(1)
            System.out.println("  high plus a size to print files bigger than that size,");                                         //0(1)
            System.out.println("  low plus a size to print files smaller than that size");                                          //0(1)
            System.out.println("  and two separated sizes to print files with size within that range.");                            //0(1)
            System.out.println("- For sizes type a number plus K to indicate KiloBytes, M for MegaBytes or G for GygaBytes;");      //0(1)
            System.out.println("  type only a number to indicate Bytes.");                                                                //0(1)
            System.out.println("- Type quit to end.");                                                                              //0(1)
            
             AVL_Tree names = new AVL_Tree();                                                                           //O(1)
            AVL_Tree sizes = new AVL_Tree();                                                                            //O(1)
            Stack<Stack<Thingy>> auxiliaryStack = new Stack<>();                                                        //O(1)
            auxiliaryStack.push(new Stack<>());                                                                         //O(1)
            Stack<Thingy> folders = new Stack<>();                                                                      //O(1)
            BufferedReader currentLine = new BufferedReader(new FileReader("ejemplito3.txt"));                          //O(1)
            BufferedReader nextLine = new BufferedReader(new FileReader("ejemplito3.txt"));                             //O(1)                                                                                        //O(1)
            String firstLine = currentLine.readLine();                                                                  //O(1)
            String line;                                                                                                //O(1)
            String directories = firstLine;                                                                             //O(1)
            String next = nextLine.readLine();                                                                          //O(1)
            next = nextLine.readLine();                                                                                 //O(1)
            if(directories.contains("/") && directories.indexOf("/") == directories.length() - 1)                       //O(1)
                directories = directories.substring(0, directories.indexOf("/"));                                       //O(1)
            while (((line = currentLine.readLine()) != null) && ((next = nextLine.readLine()) != null                   //O(m) m = # of lines of txt
                    || (next = nextLine.readLine()) == null))
            {
                int currentIdentation = line.indexOf("[");                                                              //O(m)
                String [] n = new String [3];                                                                           //O(m)
                String r = line.substring(currentIdentation + 1);                                                       //O(m)
                n[0] = r.substring(0, r.indexOf(" "));                                                                  //O(m)
                n[1] = r.substring(r.indexOf(" ") + 1, r.indexOf("]"));                                                 //O(m)
                n[2] = r.substring(r.indexOf("]") + 3);                                                                 //O(m)
                if (n[2].contains("->"))                                                                                //O(m)
                    n[2] = n[2].substring(0, n[2].indexOf("->") - 1);                                                   //O(m)
                n[1] = n[1].substring(n[1].indexOf(" ") + 1);                                                           //O(m)
                Thingy t = new Thingy(n[2], n[1], n[0]);                                                                //O(m)
                
                int numberOfDirectories;                                                                                //O(m)
                if (next != null)                                                                                       //O(m)
                {                                                                                                       
                    numberOfDirectories = (line.indexOf("[") - next.indexOf("[")) / 4;                                  //O(m)                                                               //O(m)
                    if (numberOfDirectories < 0)                                                                        //O(m)
                    {                                                                                                  
                        t.isFolder = true;                                                                              //O(m)
                        t.directory = directories;                                                                      //O(m)
                        directories += "/" + t.name;                                                                    //O(m)
                        auxiliaryStack.peek().push(t);                                                                  //O(m)
                        folders.push(t);                                                                                //O(m)
                        auxiliaryStack.push(new Stack<>());                                                             //O(m)
                    } 
                    else if (numberOfDirectories == 0)                                                                  //O(m)
                    {                                                                
                        t.directory = directories;                                                                      //O(m)
                        auxiliaryStack.peek().push(t);                                                                  //O(m)
                    } 
                    else 
                    {  
                        t.directory = directories;                                                                      //O(m)
                        auxiliaryStack.peek().push(t);                                                                  //O(m)
                        for(int i = 0; i < numberOfDirectories; i++)                                                    //O(m*k) k = # directories
                        {                                                  
                            directories = directories.substring(0, directories.lastIndexOf("/"));                       //O(m*k)
                            Thingy folder = folders.pop();                                                              //O(m*k)
                            Stack<Thingy> subFiles = auxiliaryStack.pop();                                              //O(m*k)
                            while (!subFiles.isEmpty())                                                                 //O(m*k*s) s = # subFiles
                            {                                                               
                                Thingy subFile = subFiles.pop();                                                        //O(m*k*s)
                                folder.subdirectories.add(subFile);                                                     //O(m*k*s)
                                subFile.assignValue();                                                                  //O(n*m*k*s) n = length name
                                names.insert(subFile);                                                                  //O(m*k*s)    
                                Thingy tempFile = new Thingy(subFile.name, subFile.size, subFile.user);                 //O(m*k*s)
                                tempFile.assignSize();                                                                  //O(m*k*s)
                                sizes.insert(tempFile);                                                                 //O(m*k*s)
                            }
                            folder.assignValue();                                                                       // O(n*m*k) n = length name
                            names.insert(folder);                                                                       //O(m*k)
                            Thingy tempFolder = new Thingy(folder.name, folder.size, folder.user);                      //O(m*k)
                            tempFolder.assignSize();                                                                    //O(m*k)
                            sizes.insert(tempFolder);                                                                   //O(m*k)
                        }
                    }
                    
                    if (t.directory.equals(firstLine))                                                                  //O(m)
                        auxiliaryStack.peek().push(t);                                                                  //O(m)
                } else {
                    t.directory = directories;
                    while (!folders.isEmpty())                                                                          //O(m*t) t = # folders
                    {                                                                        
                        directories = directories.substring(0, directories.lastIndexOf("/"));                           //O(m*t)
                        Thingy folder = folders.pop();                                                                  //O(m*t)
                        Stack<Thingy> subFiles = auxiliaryStack.pop();                                                  //O(m*t)
                        while (!subFiles.isEmpty())                                                                     //O(m*t*s) s = # subFiles
                        {                                                                   
                            Thingy subFile = subFiles.pop();                                                            //O(m*t*s)
                            folder.subdirectories.add(subFile);                                                         //O(m*t*s)
                            subFile.assignValue();                                                                      // O(m*n*t*s) n = length name
                            names.insert(subFile);                                                                      // O(m*t*s)
                            Thingy tempFile = new Thingy(subFile.name, subFile.size, subFile.user);                     // O(m*t*s)
                            tempFile.assignSize();                                                                      // O(m*t*s)
                            sizes.insert(tempFile);                                                                     // O(m*t*s)
                        }
                        folder.assignValue();                                                                           // O(m*n*t*s) n = length name
                        names.insert(folder);                                                                           // O(m*t)
                        Thingy tempFolder = new Thingy(folder.name, folder.size, folder.user);                          // O(m*t)
                        tempFolder.assignSize();                                                                        // O(m*t)
                        sizes.insert(tempFolder);                                                                       // O(m*t)
                    }
                    Stack<Thingy> lastStack = auxiliaryStack.pop();                                                     // O(m)
                    lastStack.push(t);                                                                                  // O(m)
                    while (!lastStack.isEmpty())                                                                        // O(m*w) w = # elements last stack
                    {                                                                      
                        Thingy w = lastStack.pop();                                                                     // O(m*w)
                        w.assignValue();                                                                                // O(n*w*m) n = length name
                        names.insert(w);                                                                                // O(m*w)    
                        Thingy p = new Thingy(w.name, w.size, w.user);                                                  // O(m*w) 
                        p.assignSize();                                                                                 // O(m*w) 
                        sizes.insert(p);                                                                                // O(m*w) 
                    }
                }                   
            }                                                                                              
            currentLine = new BufferedReader(new InputStreamReader(System.in));                                         //O(1)
            while(true)                                                                                             //Search
            {
                String input = currentLine.readLine();                                                              //O(1)
                if (input.equals("quit"))                                                                           //O(1)
                {
                    currentLine.close();                                                                            //O(1)
                    break;                                                                                          //O(1)        
                }
                String [] order = input.split(" ");                                                                 //O(q) q = # spaces for each line  
                String search = "";                                                                                 //O(1)
                for(int i = 1; i < order.length; i++) {                                                             //O(q)
                    search += order[i];                                                                             //O(q)
                    if (i != order.length - 1)                                                                      //O(q)    
                        search += " ";                                                                              //O(q)
                }
                if (order.length >= 2)                                                                              //O(1)
                {
                    if (order[0].equals("search"))                                                                  //O(1)
                    {
                        String printing = names.search(hashFunction(search));                                       //O(log m)
                        if(printing != null)                                                                        //O(1)
                            System.out.println("Located: " + printing);                                             //O(log m)
                        else
                            System.out.println("Not such file or directory found");                                 //O(1)
                    }
                    else if (order[0].equals("sub"))                                                                //O(1)
                    {
                        try
                        {
                            names.searchThingy(hashFunction(search)).printSubDirectories();                         //O(h * log m) h = # subDirectories
                        }
                        catch (NullPointerException e)                                                              //O(1)
                        {
                            System.out.println("Not such file or directory found");                                 //O(1)        
                        }
                    }
                    else if (order[0].equals("high") && order[1].substring(0, 1).matches(".*\\d.*"))                //O(1)
                        sizes.printHigher(order[1]);                                                                //O(1)
                    else if (order[0].equals("low") && order[1].substring(0, 1).matches(".*\\d.*"))                 //O(1)
                        sizes.printLower(order[1]);                                                                 //O(1)
                    else if (order[0].substring(0, 1).matches(".*\\d.*") && order[1].substring(0, 1).matches(".*\\d.*")) //O(1)
                        sizes.printRange(order[0], order[1]);  
                else
                    System.out.println("Wrong input");                                                              //O(1)
                }
            else
                System.out.println("Wrong input");                                                                  //O(1)
            }
        } 
        catch(IOException ex) 
        {
            Logger.getLogger(MainTree.class.getName()).log(Level.SEVERE, null, ex);                                 //O(1)
        }
    }
    private static int hashFunction(String s)
{   
    int a = 0;                                                                                      //O(1)
    for (int i = 0; i < s.length(); i++)                                                            //O(n) n = length of the name 
        a = a +  s.charAt(i) * (int) Math.pow(31, s.length() - 1 - i);                              //O(n)
    return a;                                                                                       //O(1)
}
}