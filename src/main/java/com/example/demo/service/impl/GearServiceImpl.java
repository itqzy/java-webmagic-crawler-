package com.example.demo.service.impl;

import com.example.demo.common.Gear;
import com.example.demo.mapper.GearMapper;
import com.example.demo.service.IGearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.List;


/**
 * @author Administrator
 */
@Service
public class GearServiceImpl implements IGearService {

    @Autowired
    private GearMapper gearMapper;


    @Override
    public List<Gear> getGearList() {
        return gearMapper.getAllGears();
    }

    @Override
    public int startWebMagic() {
        Spider.create(new SpiderServiceImpl())
                // 设置起始URL
                .addUrl("https://khkchilun.com")
                .run(); // 启动爬虫
        return 0;

    }

    @Override
    public int addGear(Gear gear) {
        return gearMapper.addGear(gear);
    }

    @Override
    public int clearData() {
        return gearMapper.clearData();
    }


}
