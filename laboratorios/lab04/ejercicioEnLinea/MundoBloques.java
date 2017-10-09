import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class MundoBloques
{   
    public static Stack<Integer> search(ArrayList<Stack<Integer>> lista, int a)     //O(n)
    {
        Stack<Integer> aux = new Stack<Integer>();                                  //C1
        for (int i = 0; i < lista.size(); i++)                                      //C2 * n
        {
            if (lista.get(i).search(a) != -1)                                       //(C3 + O(1)) * n
                aux = lista.get(i);                                                 //C4
        }
        return aux;                                                                 //C5
    }
    public static void moveOver(ArrayList<Stack<Integer>> lista, int a, int b)      //O(m+n)
    {
        Stack<Integer> aux = new Stack<Integer>();                                  //C1
        Stack<Integer> aux1 = search(lista, a);                                     //C2 + O(n)
        Stack<Integer> aux2 = search(lista, b);                                     //C3 + O(n)
        if (aux1 != aux2)                                                           //C4
        {
            while (aux1.peek() != a)                                                //C5 * m
                aux.push(aux1.pop());                                               //(C6 + C7) * m
            aux2.push(aux1.pop());                                                  //C8 + C9
            while (!aux.empty())                                                    //C10 * m
                aux1.push(aux.pop());                                               //(C11 + C12) * m
        }
    }
    public static void moveOnto(ArrayList<Stack<Integer>> lista, int a, int b)      //O(k+i+n)
    {
        Stack<Integer> aux = new Stack<Integer>();                                  //C1
        Stack<Integer> aux1 = new Stack<Integer>();                                 //C2
        Stack<Integer> aux2 = search(lista, a);                                     //C3 + O(n)
        Stack<Integer> aux3 = search(lista, b);                                     //C4 + O(n)    
        if (aux2 != aux3)                                                           //C5
        {
            while (aux2.peek() != a)                                                //C6 * k
                aux.push(aux2.pop());                                               //(C7 + C8) * k    
            while (aux3.peek() != b)                                                //C9 * i    
                aux1.push(aux3.pop());                                              //(C10 + C11) * i
            aux3.push(aux2.pop());                                                  //C12 + C13
            while (!aux.empty())                                                    //C14 * k
                aux2.push(aux.pop());                                               //(C15 + C16) * k    
            while (!aux1.empty())                                                   //C17 * i
                aux3.push(aux1.pop());                                              //(C18 + C19) * i
        }
    }
    public static void pileOnto(ArrayList<Stack<Integer>> lista, int a, int b)      //O(j+w+n)
    {
        Stack<Integer> aux = new Stack<Integer>();                                  //C1
        Stack<Integer> aux1 = new Stack<Integer>();                                 //C2
        Stack<Integer> aux2 = search(lista, a);                                     //C3 + O(n)
        Stack<Integer> aux3 = search(lista, b);                                     //C4 + O(n)    
        if (aux2 != aux3)                                                           //C5    
        {
            while (aux2.peek() != a)                                                //C6 * j
                aux.push(aux2.pop());                                               //(C7 + C8) * j
            aux.push(aux2.pop());                                                   //C9 + C10
            while (aux3.peek() != b)                                                //C11 * w
                aux1.push(aux3.pop());                                              //(C12 + C13) * w
            while (!aux.empty())                                                    //C14 * j
                aux3.push(aux.pop());                                               //(C15 + C16) * j    
            aux3.push(aux2.pop());                                                  //C17 + C18
            while (!aux1.empty())                                                   //C19 * w
                aux3.push(aux1.pop());                                              //(C20 + C21) * w
        }
    }
    public static void pileOver(ArrayList<Stack<Integer>> lista, int a, int b)      //O(s+n)
    {
        Stack<Integer> aux = new Stack<Integer>();                                  //C1
        Stack<Integer> aux1 = search(lista, a);                                     //C2 + O(n)
        Stack<Integer> aux2 = search(lista, b);                                     //C3 + O(n)
        if (aux1 != aux2)
        {
            while (aux1.peek() != a)                                                //C4 * s
                aux.push(aux1.pop());                                               //(C5 + C6) *s
            aux.push(aux1.pop());                                                   //C7 + C8
            while (!aux.empty())                                                    //C9 * s
                aux2.push(aux.pop());                                               //(C10 + C11) * s
        }
    }
    public static void main (String [] args)                                        //O(n^2)
    {
        Scanner sc = new Scanner(System.in);                                        //C1
        System.out.println("Ingrese el mundo de los bloques: ");                    //C2    
        int tam = sc.nextInt();                                                     //C3
        ArrayList<Stack<Integer>> lista = new ArrayList<Stack<Integer>>();          //C4    
        for (int i = 0; i < tam; i++)                                               //C5 * n
        {
            lista.add(new Stack<Integer>());                                        //C6 * n * n
            lista.get(i).push(i);                                                   //C7 + C8
            System.out.println("Cola " + i + ": " + i);                             //C9
        }
        sc = new Scanner(System.in);                                                //C10
        while(true)                                                                 //C11 * x
        {
            String command = sc.nextLine();                                         //C12 * x
            if (command.equals("quit"))                                             //C13 * x
            {
                sc.close();                                                         //C14
                break;                                                              //C15
            }
            String [] commands = command.split("\\s+");                             //(C16 + C17) * x
            String verb = commands[0];                                              //(C18 + C19) * x
            int a = Integer.parseInt(commands[1]);                                  //(C20 + C21) * x
            String prep = commands[2];                                              //(C22 + C23) * x
            int b = Integer.parseInt(commands[3]);                                  //(C24 + C25) * x
            if (verb.equals("move"))                                                //C26 * x
            {
                if (prep.equals("over"))                                            //C27 * x
                {                                                                   
                    moveOver(lista,a,b);                                            //O(m+n) * x
                }
                else if (prep.equals("onto"))                                       //C28 * x
                {
                    moveOnto(lista,a,b);                                            //O(k+i+n) * x
                }
            }
            else if (verb.equals("pile"))                                           //C29 * x
            {
                if (prep.equals("over"))                                            //C30 * x
                {
                    pileOver(lista,a,b);                                            //O(s+n) * x
                }
                if (prep.equals("onto"))                                            //C31 * x
                {
                    pileOnto(lista,a,b);                                            //O(j+w+n) * x
                }
            }
        }
        for(int i = 0 ; i < lista.size(); i++)                                      //C32 * n
        {
            String acum = "";                                                       //C33 * n
            acum += "Cola "+ i + ": ";                                              //C34 * n
            Stack stack = lista.get(i);                                             //(C35 + O(1)) * n
            Stack aux = new Stack();                                                //C36 * n
            while(!stack.empty())                                                   //C37 * n * z
            {
                aux.push(stack.pop());                                              //(C38 + C39) * n * z           
            }
            while(!aux.empty())                                                     //C40 * n * z
            {
                int x = (int) aux.pop();                                            //(C41 + C42) * n * z
                acum+= "" + x + " ";                                                //C43 * n * z
            }
            System.out.println(acum);                                               //C44 * n
        }
    }
}