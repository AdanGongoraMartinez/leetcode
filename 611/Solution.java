import java.util.Arrays;

public class Solution {
  int binarySearch(int nums[], int left, int right, int target) {
    while (right >= left && right < nums.length) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return left;
  }

  public int triangleNumber(int[] nums) {
    int count = 0;
    Arrays.sort(nums);
    for (int firstSide = 0; firstSide < nums.length - 2; firstSide++) {
      int thirdSideStart = firstSide + 2;
      for (int secondSide = firstSide + 1; secondSide < nums.length - 1 && nums[firstSide] != 0; secondSide++) {
        thirdSideStart = binarySearch(nums, thirdSideStart, nums.length - 1, nums[firstSide] + nums[secondSide]);
        count += thirdSideStart - secondSide - 1;
      }
    }
    return count;
  }
}
