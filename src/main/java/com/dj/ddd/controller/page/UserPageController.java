package com.dj.ddd.controller.page;

import com.alibaba.fastjson.JSONObject;
import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.common.HttpClientUtil;
import com.dj.ddd.controller.uservo.QueryUserResp;
import com.dj.ddd.service.UserDetService;
import com.dj.ddd.service.userdto.QueryOneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/u/")
public class UserPageController {

    @Autowired
    private UserDetService userDetService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "u/login";
    }

    @RequestMapping("index")
    public String index() throws Exception {
        return "index/index";
    }

    @RequestMapping("top")
    public String top(Model model, HttpServletRequest request) throws Exception {
        Map<String,String> params1 = new HashMap<>();
        params1.put("key", "73272c5675ba092757eb7bf87f07a19c");
        String result2 = HttpClientUtil.sendHttpRequest("https://apis.juhe.cn/fapig/soup/query",
                HttpClientUtil.HttpRequestMethod.GET, params1);
        JSONObject jsStr2 = JSONObject.parseObject(result2);
        String text = jsStr2.getJSONObject("result").getString("text");
        model.addAttribute("text", text);

        String addr = request.getRemoteAddr();
        Map<String,String> params = new HashMap<>();
        params.put("city","北京");
        params.put("key", "5f9d25590b4ca6959fae9711bb0a13dc");
        String result1 = HttpClientUtil.sendHttpRequest("http://apis.juhe.cn/simpleWeather/query",
                HttpClientUtil.HttpRequestMethod.GET, params);
        JSONObject jsStr1 = JSONObject.parseObject(result1);
        String tempeRature = jsStr1.getJSONObject("result").getJSONArray("future").getJSONObject(0).getString("temperature");
        String weather = jsStr1.getJSONObject("result").getJSONArray("future").getJSONObject(0).getString("weather");
        String city = jsStr1.getJSONObject("result").getString("city");
        model.addAttribute("tempeRature", tempeRature);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);
        return "index/top";
    }


    @RequestMapping("left")
    public String left() {
        return "index/left";
    }

    @RequestMapping("right")
    public String right() {
        return "index/right";
    }
    @RequestMapping("toShow")
    public String toShow(){
        return "u/show";
    }
    @RequestMapping("toRegister")
    public String toRegister(){
        return "u/register";
    }
    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model){
        QueryOneDto queryOneDto = userDetService.findById(id);
        model.addAttribute("user", DozerUtil.map(queryOneDto,QueryUserResp.class));
        return "u/update";
    }
}
