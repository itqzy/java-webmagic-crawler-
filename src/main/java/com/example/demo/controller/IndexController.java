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
import java.util.concurrent.atomic.AtomicInteger;


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
        model.addAttribute("datas", gearList);

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
}