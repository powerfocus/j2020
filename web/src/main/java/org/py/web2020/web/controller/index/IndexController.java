package org.py.web2020.web.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping({"", "index"})
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("title", "站点首页");
        modelMap.addAttribute("msg", "欢迎使用本系统2020-12-11");
        modelMap.addAttribute("osList", Arrays.asList("win95", "win98", "win2k"));
        return "index/index";
    }
}
