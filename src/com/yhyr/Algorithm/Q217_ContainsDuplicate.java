package com.yhyr.Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yhyr
 * @since 2019/09/29 22:47
 */
public class Q217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Integer value = null;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                flag = true;
                value = i;
            } else {
                set.add(i);
                flag = false;
            }
        }
        return flag || (value != null);
    }

    public static void main(String[] args) {
        Q217_ContainsDuplicate action = new Q217_ContainsDuplicate();
        System.out.println(action.containsDuplicate(new int[] {0,4,5,0,3,6}));
    }
}
