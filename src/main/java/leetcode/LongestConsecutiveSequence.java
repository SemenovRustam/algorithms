package leetcode;


import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * Дан неотсортированный массив целых чисел. Нужно найти длину наибольшей последовательности из идущих подряд чисел.
 *
 * Решение должно работать за O(N).
 *
 * Например:
 * Для [100,4,200,1,3,2] - Ответ 4. Это последовательность: [1, 2, 3, 4]
 *
 * Для [1,0,1,2] - Ответ 3. Это последовательно
 * сть: [0, 1, 2]
 *
 *
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 200, 350};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        var result = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int currentSeq = 1;

                while (set.contains(current + 1)) {
                    current++;
                    currentSeq++;
                }
                result = Math.max(result, currentSeq);
            }
        }
        return result;
    }
}

