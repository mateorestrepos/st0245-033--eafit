public class Array3
{
    //MaxSpan
    public int maxSpan (int [] nums){
        int span = 0;
        int maxSpan = 0; 
        for (int i = 0; i < nums.length; i++){ 
            span = 0;
            for (int j = i; j < nums.length; j++){ 
                span++; 
                if (nums[i] == nums[j] && span > maxSpan) 
                    maxSpan = span; 
            }
        }
        return maxSpan;
    }
    //Fix34
    public int [] fix34 (int [] nums){
        for (int i = 0; i < nums.length; i++){ 
            if (nums[i] == 3) { 
                int temporal = nums[i + 1];
                nums[i + 1] = 4; 
                for (int j = i + 2; j < nums.length; j++){ 
                    if (nums[j] == 4)
                        nums[j] = temporal; 
                }
            }
        }
        return nums;
    }
    //Fix45
    public int [] fix45 (int [] nums){
        for (int i = 0; i < nums.length; i++){ 
            if (nums[i] == 5 && i == 0 || nums[i] == 5 && nums[i - 1] != 4){
                int p5 = i;
                for (int j = 0; j < nums.length; j++){
                    if (nums[j] == 4 && nums[j + 1] != 5){
                        int temporal = nums[j + 1];
                        nums[j + 1] = 5;
                        nums[p5] = temporal;
                        break;
                    }
                }
            }
        }
        return nums;
    }
    //CanBalance
    public boolean canBalance (int [] nums){
        int acumulador = 0; 
        for (int i = 0; i < nums.length; i++){ 
            int acumulador2 = 0; 
            for (int e = i; e < nums.length; e++){ 
                acumulador2 += nums[e]; 
            }
            if (acumulador == acumulador2) 
                return true; 
            acumulador += nums[i]; 
        }
        return false;
    }
    //LinearIn
    public boolean LinearIn (int [] outer, int [] inner){
        int n = 0; 
        if (inner.length != 0){ 
            for (int i = 0; i < outer.length; i++){ 
                if (outer[i] == inner[n]){ 
                    n++; 
                    if (n == inner.length) 
                        break; 
                }
            }
        }
        return n == inner.length; 
    }
}
