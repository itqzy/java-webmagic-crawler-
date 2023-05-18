package com.example.demo.controller;

import com.example.demo.common.Gear;
import com.example.demo.common.User;
import com.example.demo.common.UserCluster;
import com.example.demo.service.IGearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * @author Administrator
 * @CreateTime: 2023-05-17  10:13
 * @Description: 首页
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @Value("${system.title}")
    private String title;

    @Value("${system.remark}")
    private String remark;

    @Autowired
    private UserCluster userCluster;


    @Autowired
    private IGearService iearService; ;

    @GetMapping("index")
    public String index(Model model) {

        model.addAttribute("title", title);
        model.addAttribute("remark", remark);
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public Boolean login(User user) {

        List<User> userConfigs = userCluster.getUserConfigs();

        int  count = 0;
        for (User userConfig : userConfigs) {
            if (userConfig.getLoginName().equals(user.getLoginName()) && userConfig.getPassword().equals(user.password)) {
                count++;
            }
        }


        if (count> 0){
            return true;
        }

        return false;
    }

    @GetMapping("/gear")
    public String gear(Model model) {
        List<Gear> gearList = iearService.getGearList();
        Map<Integer, List<Gear>> collect = gearList.stream().collect(Collectors.groupingBy(Gear::getType));

        model.addAttribute("datas0", collect.get(0));
        model.addAttribute("datas1", collect.get(1));
        model.addAttribute("datas2", collect.get(2));
        model.addAttribute("datas3", collect.get(3));
        model.addAttribute("datas4", collect.get(4));
        model.addAttribute("datas5", collect.get(5));
        model.addAttribute("datas6", collect.get(6));

        return "gear";
    }





    @GetMapping("/startWebMagic")
    @ResponseBody
    public Boolean  startWebMagic() {
        try {
            int i = iearService.startWebMagic();
        }catch (Exception e){
            return false;
        }
        return true;
    }


    @GetMapping("/clearData")
    @ResponseBody
    public Boolean  clearData() {
        try {
            int i = iearService.clearData();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}