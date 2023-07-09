package com.ruoyi.Logistics.clean.controller;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.Logistics.utils.getdata.RefreshView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.SQLException;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
@Controller
@RequestMapping("/visual")
public class VisualController {
    @Autowired
    private IUserWorkService userWorkService;

    @GetMapping("/thput")
    public String portThroughput(Conditions conditions) throws SQLException, ClassNotFoundException {
        RefreshView.Create();
        conditions.setPort("杭州港");
        Double aDouble = userWorkService.selectPortThroughput(conditions);
        System.out.println(aDouble);
        return aDouble.toString();
    }


}
