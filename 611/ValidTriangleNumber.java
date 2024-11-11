/* Given an integer array nums, return the number of triplets chosen from the
 * array that can make triangles if we take them as side lengths of a triangle.*/

import java.util.Arrays;

public class ValidTriangleNumber {
  public static void main(String[] args) {
    int[] nums = { 2, 2, 3, 4 };
    System.out.println(triangleNumber(nums));
  }

  public static int binarySearch(int[] nums, int left, int right, int target) {
    // Encuentra el limite derecho del array
    // Es decir, todos los lados que cumplan a+b>c
    while (right >= left && right < nums.length) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return left;
  }

  public static int triangleNumber(int[] nums) {
    int triangleCount = 0;
    Arrays.sort(nums);
    // Primer lado
    for (int firstSide = 0; firstSide < nums.length - 2; firstSide++) {
      int thirdSideStart = firstSide - 2; // Inicio de la busqueda del tercer lado
      // Segundo lado
      for (int secondSide = firstSide + 1; secondSide < nums.length - 1 && nums[firstSide] != 0; secondSide++) {
        // Tercer lado
        thirdSideStart = binarySearch(nums, thirdSideStart, nums.length - 1, nums[firstSide] + nums[secondSide]);
        triangleCount += thirdSideStart - secondSide - 1;
      }
    }
    return triangleCount;
  }
}
