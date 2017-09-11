/*Este trabajo fue realizado por:
 *
 *Mateo Restrepo Sierra
 *Nicolas Restrepo Lopez
 * 
 */

import java.util.Arrays;

public class MiArrayList {
        private int size;
        private static final int DEFAULT_CAPACITY = 10;
        private int elements[];

          // Inicializa los atributos size en cero y elements como un arreglo de tamaño  DEFAULT_CAPACITY. No, no recibe parámetros.
        public MiArrayList() { 
            elements = new int [DEFAULT_CAPACITY];
             size = 0;
        }

          // Retorna el tamaño de la lista
        public int size() {
           return size;
        }

        // Agrega un elemento e a la última posición de la lista
        public void addLast(int e) {
            add(size,e);
        }
        
        public void mover(int [] a, int pos){
            for(int i = size - 1;i>= pos; i-- ){
                elements[i+1] = elements[i];
            }
        }

          // Retorna el elemento que se encuentra en la posición i de la lista
        public int get(int i) {
            return elements[i];
        }

          // Agrega un elemento e en la posición index de la lista
        public void add(int index, int e) {   
            if(size < elements.length){
                mover(elements,index);
                elements[index] = e;
                size++;
            }
            else{
                newArray(elements);
                mover(elements,index);
                elements[index]=e;
                size++;
            }
             
        }
        
        public void newArray(int [] elements){
            int []elements1 = new int [elements.length*2];
            for(int i = 0; i< elements.length; i++){
                elements1[i] = elements[i];
            }
            elements = elements1;
        }
        
        public static void main (String [] args){
             MiArrayList mateo = new MiArrayList();   
        }
}
