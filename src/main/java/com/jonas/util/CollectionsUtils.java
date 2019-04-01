package com.jonas.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/12/07
 */
public class CollectionsUtils {

    /**
     * 集合差集
     * @param list1
     * @param list2
     * @return
     */
    public static List<Long> differenceSet(List<Long> list1, List<Long> list2) {
        List<Long> l1 = Lists.newArrayList(list1);
        List<Long> l2 = Lists.newArrayList(list2);
        l1.removeAll(l2);
        return Lists.newArrayList(l1);
    }

}
