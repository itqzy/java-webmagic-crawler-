package com.example.demo.service.impl;

import com.example.demo.common.Gear;
import com.example.demo.common.GetBeanUtils;
import com.example.demo.service.IGearService;
import org.assertj.core.util.Lists;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Administrator
 */
public class SpiderServiceImpl implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public static final String URL_LIST = "https://khkchilun.com";
    //因为要固定的几个页面故写死
    public static final ArrayList<String> URLS = Lists.newArrayList("https://khkchilun.com/spurgears.html", "https://khkchilun.com/helicalgears.html", "https://khkchilun.com/gearrack.html", "https://khkchilun.com/wormgears.html", "https://khkchilun.com/bevelgears.html", "https://khkchilun.com/mitergears.html", "https://khkchilun.com/internalgears.html");




    @Override
    public void process(Page page) {
        // 在这里定义你的页面解析逻辑
        // 使用page对象提供的方法来提取数据，如XPath、CSS选择器等
        // 解析页面，提取数据
        if (page.getUrl().toString().equals(URL_LIST)) {
            List<String> all = page.getHtml().xpath("//div[@id='leftprolist']").links().all();

            page.addTargetRequests(URLS);
        } else {

            dispose(page);
        }


    }

    private void dispose(Page page) {
        Selectable xpath = page.getHtml().xpath("//div[@class='bigcolumn']");

        //型号
        List<String> all = xpath.xpath("//div[@class='centertex']").xpath("//h3/text()").all();
        all.remove(0);


        //名称
        List<String> all3 = xpath.xpath("//div[@class='centertex']").xpath("//p/text()").all();

        //备注
        List<String> all1 = xpath.xpath("//div[@class='righttex']").xpath("//p/text()").all();

        //内容
        List<String> all2 = xpath.xpath("//p").all();

        //图片
        List<String> all4 = xpath.$("img", "src").all();
        all4.remove(0);

        HashMap<String, String> map = new HashMap(14);


        List<Gear> list = new ArrayList<Gear>();

        for (int i = 0; i < all.size(); i++) {
            // 创建实体对象
            Gear gear = new Gear();
            gear.setModel(all.get(i));

            gear.setName(all3.get(i));

            for (int j = 0; j < all2.size(); j++) {
               if (all2.get(j).startsWith("<p>模数")){
                   String s = all2.get(j);
                   String substring = s.substring(3);
                   String substring1 = substring.substring(0,substring.length() - 4);
                   String[] brs = substring1.split("<br>");
                   for (String br : brs) {
                       String[] split = br.split(":");
                        if (split.length > 1){
                            map.put(split[0], split[1]);
                        }


                   }


               }

                all2.remove(all2.get(j));
            }

            gear.setRemarks(all1.get(i));

            int typeNum =0;

            for (int i1 = 0; i1 < URLS.size(); i1++) {
                if (URLS.get(i1).equals(page.getUrl().toString())){
                    typeNum =i1;
                }
            }

            gear.setType(typeNum);

            gear.setIndexNumber(i);
            gear.setModulus(map.get("模数 "));
            gear.setMaterials(map.get("材料 "));
            gear.setHeatTreatment(map.get("热处理 "));
            gear.setTotalLength(map.get("全长 "));
            gear.setHeadCount(map.get("头数 "));
            gear.setGearToothMachining(map.get("齿面加工 "));
            gear.setGearPrecision(map.get("齿轮精度 "));

            gear.setImg(all4.get(i));

            list.add(gear);

        }

        IGearService bean = GetBeanUtils.getBean(IGearService.class);

        // 保存到数据库
        for (Gear gear : list) {
           bean.addGear(gear);
        }

    }



    @Override
    public Site getSite() {
        return site;
    }


}
