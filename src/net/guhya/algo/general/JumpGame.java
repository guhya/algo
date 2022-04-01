package net.guhya.algo.general;

public class JumpGame {

    public static int canJumpUtil(int[] nums, int idx, String path) {
    	
    	if (idx == nums.length-1) {
    		System.out.println("Found " + path);
    		return 1;
    	}
    	
    	if (idx > nums.length-1) {
    		return 0;
    	}
    	
    	int found = 0;
    	for (int i=1; i<=nums[idx]; i++) {
    		if (found < 1) {
    			found += canJumpUtil(nums, idx+i, path + i);
    		}
    	}
    	
    	return found;
    }
	
    public static boolean canJump(int[] nums) {
        return canJumpUtil(nums, 0, "") > 0;
    }
    
    public static boolean canJumpLinear(int[] nums) {
    	int hi = nums.length - 1;
    	int i = hi-1;
    	while (i >= 0) {
    		if (i + nums[i] >= hi) {
    			hi = i;
    		}
    		i--;
    	}
    	
    	return nums[0] > hi;
    }


	public static void main(String[] args) {
		int[] nums1 = {2,3,1,1,4};
		System.out.println(canJumpLinear(nums1));
		
		int[] nums2 = {3,2,1,0,4};
		System.out.println(canJumpLinear(nums2));
		
		int[] nums3 = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		System.out.println(canJumpLinear(nums3));
		
		int[] nums4 = {2,0,0};
		System.out.println(canJumpLinear(nums4));
		
		int[] nums5 = {1, 2};
		System.out.println(canJumpLinear(nums5));
	}

}
