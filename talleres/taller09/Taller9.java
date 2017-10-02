import java.util.HashMap;

/**
 *
 * @author 
 */
public class Taller9{
    //pedrito 1
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }
    //pedrito 2
    public static void buscar(HashMap empresas,String key){
        empresas.get(key);
    }
    //pedrito 3
    public static boolean contienekey(HashMap empresas,String key){
        return empresas.containsKey(key);
    }
    
    public static void main (String [] args)
    {
        HashMap ejemplo = new HashMap();
        agregar(ejemplo,"Google", "United States");
        agregar(ejemplo,"Nokia", "Finland");
        agregar(ejemplo,"Sony", "Japan");
        agregar(ejemplo,"La locura", "Colombia");
        System.out.println(ejemplo);
        
        System.out.println("¿La llave 'Nokia' está contenida en Empresas?: " + contienekey(ejemplo, "Nokia"));
        System.out.println("¿La llave 'Motorola' está contenida en Empresas?: " + contienekey(ejemplo, "Motorola"));
    }
}