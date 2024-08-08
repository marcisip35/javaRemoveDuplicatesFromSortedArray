import java.util.Arrays;

class Main{
    public static void main(String[] args){
        /* Leet Code Question #26
         * Easy Question #7
         */
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums){
        int k = 0;

        //Remove duplicates and replace it with null
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    nums[j] = 101;
                }
            }
        }

        //Re-Sort the Arraay
        for(int i = 0; i < nums.length; i++){
            int temp = 0;
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[i]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        //Count how many nums are valid, below 101
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 101){
                k++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return k;
    }

    public static int alternative(int[] nums){
        int j = 1;
        for(int i = j; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}