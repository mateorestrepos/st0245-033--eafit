import java.util.*;
import javafx.util.*;
public class UnaTablaDeHash
{
   private ArrayList<LinkedList<Pair<String,Integer>>> tabla;

   public UnaTablaDeHash(){
      tabla = new ArrayList();
      for(int i = 0; i< 10;i++){
         tabla.add(new LinkedList<Pair<String,Integer>>());
        }
   }

   private int funcionHash(String k){
       int a = 0;
       for(int i = 0; i < k.length();i++){
           a = a + (int)k.charAt(i) * (int)Math.pow(31, k.length() - 1 - i);
        }
       return a % tabla.size();
   }

   public int get(String k){
       LinkedList<Pair<String,Integer>> x = tabla.get(funcionHash(k));
       if (x.size() > 0)
       {
           for (int i = 0; i < x.size(); i++)
           {
               if (x.get(i).getKey().equals(k))
                   return x.get(i).getValue();
           }
       }
       return 0;
   }

   public void put(String k, int v){
       tabla.get(funcionHash(k)).add(new Pair(k, v));
   }
   
   public static void main(String [] args)
   {
       UnaTablaDeHash ejemplo = new UnaTablaDeHash();
       ejemplo.put("Mateo", 1);
       ejemplo.put("Nico", 3);
       ejemplo.put("Fede", 5);
       ejemplo.put("Ola", 7);
       ejemplo.put("Alo", 4);
       ejemplo.put("Mauro", 2);
       System.out.println(ejemplo.get("Mateo"));
      System.out.println(ejemplo.get("Nico"));
      System.out.println(ejemplo.get("Carmen"));
    }
   }