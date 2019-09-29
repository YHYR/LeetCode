package com.yhyr.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yhyr
 * @since 2019/09/29 22:19
 */
public class Q169_MajorityElement {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.keySet().contains(i)) {
                int tmp = map.get(i) + 1;
                map.put(i, tmp);
                if (tmp > count) {
                    count = tmp;
                    result = i;
                }
            } else {
                map.put(i, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q169_MajorityElement action = new Q169_MajorityElement();
        System.out.println(action.majorityElement(new int[]{2}));
    }
}
