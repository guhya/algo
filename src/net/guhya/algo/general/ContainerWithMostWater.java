package net.guhya.algo.general;

public class ContainerWithMostWater {

    /**
     * We check all possible square area, moving pointer which has potential to get more area (to taller heights)
     * Use two pointers lo and hi
     * Get the height, check which height is smaller between element at pointer lo and hi
     * Get the width of the square, which is hi - lo
     * Calculate area, if this area is bigger than previous, then save it
     * Increment pointer lo if element at it is shorter than hi
     * Decrement hi if the opposite
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int lo = 0; 
        int hi = height.length-1;
        int area = 0;
        while (lo < hi) {
            int minHeight = Math.min(height[lo], height[hi]);
            int len = hi - lo;
            area = Math.max(area, minHeight * len);
            System.out.println(minHeight + " " + len + " " + area);
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        
        return area;
        
    }	
	
	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}

}
