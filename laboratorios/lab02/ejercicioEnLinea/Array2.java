public class Array2
{
    //CountEvens
    public int countEvens(int [] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0)
            count++;
        }
        return count;
    } 
    //BigDiff
    public int bigDiff (int [] nums){
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
         return max - min;
    }
    //Has22
    public boolean has22 (int [] nums){
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 2 && nums[i + 1] == 2)
                return true;
        }
        return false;
    }
    //Sum28
    public boolean sum28 (int [] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++){ 
            if (nums[i] == 2)
                sum += nums[i]; 
        }
        if (sum == 8)
            return true; 
        return false;
    }
    //FizzArray
    public int [] fizzArray (int n){
        int [] arr = new int [n]; 
        for (int i = 0; i < n; i++){ 
            arr[i] = i;
        }
        return arr;
    }
}
