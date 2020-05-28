import tester.*;

class ArrayExamples {
    public int findSecond (String[] arr, String str) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                count++;
            }
            if (count == 2) {
                return i;
            }
        }
        return -1;
    }

    int find(int[] nums, int n) {
        for(int i = 0; i < nums.length; i += 1) {
            if(nums[i] == n) { return i; }
        }
        return -1;
    }

    int[] mystery(int[] nums, int n) {
        int index = Math.max(find(nums, n), 0);
        int[] result = new int[index];
        for(int i = 0; i < index; i += 1) {
            result[i] = nums[i];
        }
        return result;
    }
}