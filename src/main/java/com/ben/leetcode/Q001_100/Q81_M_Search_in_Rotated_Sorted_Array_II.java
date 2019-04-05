package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/14.
 */
public class Q81_M_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else
                right--;
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int low = 0, high = nums.length - 1;
        while (high > low + 1) {
            int mid = low + (high - low) / 2;

            if (nums[low] == nums[high]) {
                if (target < nums[mid]) {
                    if (nums[mid] < nums[low]) {
                        high = mid;
                    } else if (nums[mid] > nums[low]) {
                        if (target < nums[low]) {
                            low = mid;
                        } else if (target > nums[low]) {
                            high = mid;
                        } else {
                            return true;
                        }
                    } else {
                        low++;
                    }
                } else if (target > nums[mid]) {
                    if (nums[mid] < nums[low]) {
                        if (target < nums[low]) {
                            low = mid;
                        } else if (target > nums[low]) {
                            high = mid;
                        } else {
                            return true;
                        }
                    } else if (nums[mid] > nums[low]) {
                        low = mid;
                    } else {
                        high--;
                    }
                } else {
                    return true;
                }
            } else {
                if (target < nums[mid]) {
                    if (nums[mid] < nums[low]) {
                        high = mid;
                    } else if (nums[mid] > nums[low]) {
                        if (target > nums[low]) {
                            high = mid;
                        } else if (target < nums[low]) {
                            low = mid;
                        } else {
                            return true;
                        }
                    } else {
                        low = mid;
                    }
                } else if (target > nums[mid]) {
                    if (nums[mid] < nums[low]) {
                        if (target < nums[low]) {
                            low = mid;
                        } else if (target > nums[low]) {
                            high = mid;
                        } else {
                            return true;
                        }
                    } else {
                        low = mid;
                    }
                } else {
                    return true;
                }
            }
        }

        if (target == nums[low]) {
            return true;
        }

        if (target == nums[high]) {
            return true;
        }

        return false;
    }

    public boolean search1(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        if (nums.length == 1)
            return nums[0] == target;

        int len = nums.length;
        int dup = 0;
        if (nums[0] == nums[len - 1])
            dup++;

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dup++;
                continue;
            }
            if (dup > 0)
                nums[i - dup] = nums[i];
        }
        len = len - dup;

        int left = 0;
        int right = len - 1;
        if (right < 0)
            right = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q81_M_Search_in_Rotated_Sorted_Array_II q = new Q81_M_Search_in_Rotated_Sorted_Array_II();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        boolean res = q.search(nums, 3);
        Utils.println(res);
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        res = q.search(nums1, 0);
        Utils.println(res);

        int[] nums2 = {1, 3, 1, 1, 1, 1, 1};
        res = q.search(nums2, 3);
        Utils.println(res);

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1};
        res = q.search(nums3, 1);
        Utils.println(res);
    }
}
