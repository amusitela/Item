package com.ruoyi.Logistics.clean.controller;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.domain.Goods;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.Logistics.utils.getdata.RefreshView;
import com.ruoyi.common.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.*;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
@Controller
@RequestMapping("/visual")
public class VisualController extends BaseController {
    @Autowired
    private IUserWorkService userWorkService;

    @GetMapping("/thput")
    @ResponseBody
    public Map<String, Object> portThroughput(String port,String goods) throws SQLException, ClassNotFoundException {
        RefreshView.Create();

        Conditions conditions = new Conditions();
        Conditions conditions1 = new Conditions();
        Conditions conditions2 = new Conditions();
        Object temp = new Object();
        Map<String, Object> ans = new LinkedHashMap<>();
        conditions.setPort(port);
        conditions.setGoods(goods);


//        conditions.setPort("南通港");
//        conditions.setGoods("大豆");
        //总吞吐量

        Double aDouble = userWorkService.selectAllThroughput(conditions1);
        ans.put("总吞吐量",aDouble);
        //港口货物吞吐量
        Map<String,Object> portThroughput = userWorkService.selectPortThroughput(conditions);
        Object[] temp1 = portThroughput.values().toArray(new Object[portThroughput.size()]);
        temp=temp1;
        ans.put("港口吞吐量",temp);

        Map<String,Object> goodsThroughput = userWorkService.selectGoodsThroughput(conditions);
        temp1 = goodsThroughput.values().toArray(new Object[goodsThroughput.size()]);
        temp=temp1;
        ans.put("货物吞吐量",temp);

        Map<String,Object> classThroughput = userWorkService.selectGoodsThroughput(conditions);
        temp1 = goodsThroughput.values().toArray(new Object[goodsThroughput.size()]);
        System.out.println(goodsThroughput.size());
        List classify = Classify(temp1);
        temp=classify;
        ans.put("货物类型吞吐量",temp);

        //同比环比
        Map<String,Object> tb = userWorkService.selectTONGBI(conditions);
        temp1 = tb.values().toArray(new Object[tb.size()]);
        System.out.println(tb.size());
        temp=temp1;
        ans.put("同比环比",temp);

        //不同货物的日趋势
        Map<String,Object> rq = userWorkService.selectRIQU(conditions);
        temp1 = rq.values().toArray(new Object[rq.size()]);
        System.out.println(rq.size());
        temp=temp1;
        ans.put("不同货物的日趋势",temp);

        //不同货物的流向
        List<Goods> lx = userWorkService.selectGoodsGoWhere(conditions);
        System.out.println(lx.size());
        temp=lx;
        ans.put("不同货物的流向",temp);

        return ans;
    }

    public static List Classify(Object[] objects) {
        String[] a=new String[objects.length];
        String[] classa={"农产品类","金属和矿产类","建材类","能源类","食品类","化工类","其他类"};
        Double[] doublea=new Double[7];
        for (int i = 0; i < 7; i++) {
            doublea[i]=0.0;
        }
        String[] classb={"黑麦稻谷燕麦大麦小麦","铜铁矿石铁矿钢材","水泥木材砂石","原煤原油","茶叶猪腩活猪活牛大豆粉大豆油大豆","单氟磷酸钠","天然橡胶三钙"};
        for (int i = 0; i < objects.length; i++) {
            a[i] = String.valueOf(objects[i]);
        }
        for (int j= 0;j < a.length;j++){
            String[] split = a[j].split("=");
            String[] split1 = split[1].split(",");
            String[] split2 = split[2].split("}");
            Double d=Double.parseDouble(split2[0]);
            String s=split1[0];
            for (int i = 0; i < 7; i++) {
                if(classb[i].contains(s)){
                    doublea[i]+=d;
                }
            }
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 7 ; i++) {
            strings.add("货物类型:"+classa[i]+",总重:"+doublea[i]);
        }

        return strings;
    }


}
