package com.example.demo.service;

import com.example.demo.common.Gear;

import java.util.List;

/**
 * @author Administrator
 */
public interface IGearService {


    /**
     * 获取列表
     */
    List<Gear> getGearList( );


    /**
     * 开启爬虫
     **/
    int startWebMagic();


    /**
     * 新增实体
     **/
    int addGear(Gear gear);

    /**
     *  删除数据
     **/
    int clearData();
}
