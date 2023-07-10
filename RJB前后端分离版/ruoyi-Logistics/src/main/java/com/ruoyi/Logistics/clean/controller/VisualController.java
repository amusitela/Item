package com.ruoyi.Logistics.clean.controller;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.domain.Goods;
import com.ruoyi.Logistics.clean.domain.THB;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.Logistics.utils.getdata.RefreshView;
import com.ruoyi.common.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
    public Map<String, Object> portThroughput(String port, String goods, String start, String end) throws SQLException, ClassNotFoundException {
       // System.out.println(port);
        //System.out.println(goods);
        RefreshView.Create();
        //港口货物
        Conditions conditions = new Conditions();
        //全部
        Conditions conditions1 = new Conditions();
        //港口
        Conditions conditions2 = new Conditions();



        Object temp = new Object();
        Map<String, Object> ans = new LinkedHashMap<>();
        if(!(port==null||goods==null||port==""||goods=="")){
            conditions.setPort(port);
            conditions.setGoods(goods);
        }else{
            conditions.setPort("杭州港");
            conditions.setGoods("黑麦");
        }

        conditions2.setPort("杭州港");
        if(port!=null&&port!=""){
            conditions2.setPort(port);
        }
        if(!(start==null||end==null||start==""||end=="")){
            Date s = new Date(Long.parseLong(start));
            Date e = new Date(Long.parseLong(end));
            // 设置日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 格式化日期
            String S = sdf.format(s);
            String E = sdf.format(e);
//            System.out.println("======================================");
//            System.out.println(s+" "+S);
//            System.out.println(e+" "+E);
            conditions.setStart(S);
            conditions.setEnd(E);
        }



//        conditions.setPort("南通港");
//        conditions.setGoods("大豆");
        //总吞吐量

        Double aDouble = userWorkService.selectAllThroughput(conditions1);
        ans.put("总吞吐量",aDouble);
        //港口货物吞吐量
        Map<String,Object> portThroughput = userWorkService.selectPortThroughput(conditions1);
        Object[] temp1 = portThroughput.values().toArray(new Object[portThroughput.size()]);
        temp=temp1;
        ans.put("港口货物吞吐量",temp);

        Map<String,Object> goodsThroughput = userWorkService.selectGoodsThroughput(conditions1);
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

        String[] stringArray = new String[temp1.length];
        for (int i = 0; i < temp1.length; i++) {
            stringArray[i] = String.valueOf(temp1[i]);
            stringArray[i]=stringArray[i].replace("{","");
            stringArray[i]=stringArray[i].replace("=",":");
            stringArray[i]=stringArray[i].replace("}","");
           // System.out.print(stringArray[i]+",");
        }
        //排序
        Sort(stringArray);
        //计算同比环比
        ArrayList<THB> thbs = new ArrayList<>();
        THB thb = new THB();
        Double[] a=new Double[12];
        Double[] b=new Double[12];

        String o = stringArray[1].replaceAll("\\d{4}-\\d{2}", "");
        String[] zuo = stringArray[1].split(",");
        String[] you = o.split(",");
        String d1 = zuo[0].replace(you[0], "");
        String[] split = d1.split("-");
       // System.out.println(split[0]+"======================================="+split[1]);
        for (int i = 0; i < stringArray.length; i++) {
            String rep = stringArray[i].replaceAll("\\d{4}-\\d{2}", "");
            String[] zuo1 = stringArray[i].split(",");
            String[] you1 = rep.split(",");
            String time = zuo1[0].replace(you1[0], "");
            String num1 = you1[1].replaceAll("\\d+", "");
            String num2 = num1.replace(".", "");
            String num = you1[1].replace(num2, "");
            String[] n = new String[2];
            n=time.split("-");
           // System.out.println(n[0]+"======================"+n[1]);
            if(n[0].equals(split[0])){
                String s = n[1];
                 int a1 = Integer.valueOf(s);
                a[a1-1]= Double.valueOf(num);
            }else{
                String s = n[1];
                int b1 = Integer.valueOf(s);
                b[b1-1]= Double.valueOf(num);
            }
        }
        for (int i = 0; i < stringArray.length; i++) {
            String rep = stringArray[i].replaceAll("\\d{4}-\\d{2}", "");
            String[] zuo1 = stringArray[i].split(",");
            String[] you1 = rep.split(",");
            String time = zuo1[0].replace(you1[0], "");
            thb.setNow(time);
            String num1 = you1[1].replaceAll("\\d+", "");
            String num2 = num1.replace(".", "");
            String num = you1[1].replace(num2, "");
            thb.setZz(num);
            String[] n = new String[2];
            n=time.split("-");
            //System.out.println(n[0]+"======================"+n[1]);
            if(n[0].equals(split[0])){
            }else{
                String s = n[1];
                int b1 = Integer.valueOf(s);
                double v = 0.0;
                if (!(b[b1-1]==null||a[b1-1]==null)){
                    v=(b[b1-1] - a[b1-1]) / a[b1-1] * 100;
                }
                String format = String.format("%.2f", v);
                thb.setTb(format);
                if(b1==1){
                    double v1 = 0.0;
                    if(!(b[b1-1]==null||a[11]==null)){
                        v1=(b[b1-1] - a[11]) / a[11] * 100;
                    }

                    String format1 = String.format("%.2f", v1);
                    thb.setHb(format1);
                }else{
                    double v1 = 0.0;
                    if(!(b[b1-1]==null||b[b1-2]==null)){
                        v1=(b[b1-1] - b[b1 - 2]) / b[b1 - 2] * 100;
                    }

                    String format1 = String.format("%.2f", v1);
                    thb.setHb(format1);
                }
            }
            if(!n[0].equals(split[0])){
                thbs.add(thb);
            }

            thb = new THB();
           // System.out.println(thb);
        }
//        for (THB thba:thbs
//             ) {
//            System.out.println(thba);
//        }
        System.out.println(tb.size());
        temp=thbs;
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

        //货物入库周期分析
        Map<String,Object> rk = userWorkService.selectRUKU(conditions);
        temp1 = rk.values().toArray(new Object[rk.size()]);
        System.out.println(rk.size());
        temp=temp1;
        ans.put("货物入库周期分析",temp);

        //货物出库周期分析
        Map<String,Object> ck = userWorkService.selectCHUKU(conditions);
        temp1 = ck.values().toArray(new Object[ck.size()]);
        System.out.println(ck.size());
        temp=temp1;
        ans.put("货物出库周期分析",temp);

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

    public static void Sort(String[] objects) {

        Arrays.sort(objects, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                String s3=new String(s1);
                String s4=new String(s2);

                String o = s3.replaceAll("\\d{4}-\\d{2}", "");
                String[] zuo = s3.split(",");
                String[] you = o.split(",");
                String s5 = zuo[0].replace(you[0], "");

                String o1 = s4.replaceAll("\\d{4}-\\d{2}", "");
                String[] zuo1 = s4.split(",");
                String[] you1 = o1.split(",");
                String s6 = zuo1[0].replace(you1[0], "");

                return s5.compareTo(s6); // 根据字符串的自然顺序排序
            }
        });

    }

//    public static void main(String[] args) {
//        String a="now:2022-12, 总重:705.0";
//        String o = a.replaceAll("\\d{4}-\\d{2}", "");
//        String[] zuo = a.split(",");//now:2022-12  总重:705.0
//        String[] you = o.split(",");//now: 总重:705.0
//        String d1 = zuo[0].replace(you[0], "");
//        String[] split = d1.split("-");
//        String num1 = you[1].replaceAll("\\d+", "");
//        String num2 = num1.replace(".", "");
//        String num = you[1].replace(num2, "");
//        System.out.println(split[0]+"======================================="+split[1]);
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(num);
//
//    }

}
