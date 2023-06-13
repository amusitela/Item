package com.ruoyi.Logistics.utils;


import com.ruoyi.Logistics.clean.domain.Logistics;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/10
 */
public class SolveLogisticsErrorUtil {

    public Integer getCount(List<Logistics> logisticses) {
        return logisticses.size();
    }

    public List solve(List<Logistics> logisticses) {
        Integer cnt = getCount(logisticses);
        List<Integer> counts = new ArrayList(cnt+5);
        if (cnt != null) {
            Logistics logistics = null;
            for (int i = 0; i < cnt; i ++ ) {
                logistics = logisticses.get(i);
                if (!logistics.getNum().matches("^[1-9]\\d{5}(18|19|20)\\d{2}(0\\d|1[0-2])([0-2]\\d|3[0-1])\\d{3}[0-9Xx]$")) {
                    logistics.setError(1);
                }
                counts.add(logistics.getError());
            }
        }
        return counts;
    }

}
