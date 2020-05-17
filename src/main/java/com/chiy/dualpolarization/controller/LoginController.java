package com.chiy.dualpolarization.controller;
/**
 * .::::.
 * .::::::::.
 * :::::::::::    佛主保佑、永无Bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

import com.chiy.dualpolarization.common.vo.R;
import com.chiy.dualpolarization.model.User;
import com.chiy.dualpolarization.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqiang
 * @ClassName LoginController
 * @Description TODO 测试类
 * @Date 2020/5/12 18:48
 * @Version 1.0
 */
@RequestMapping(value = "/user")
@RestController
@Slf4j(topic = "LoginController")
public class LoginController {

    @RequestMapping(value = "/lq")
    public R Hello() {
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return R.ok().data("success","lq");
    }

    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    public R selectAll() {
        List<User> list = userService.selectAll();
        return R.ok().data("itms", list).message("用户信息");
    }
    /**
     * @return java.util.List<com.chiy.dualpolarization.model.User>
     * @throws
     * @Description 查找全部
     * @Author liuqaing
     * @Date 2020/5/13 11:24
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        PageInfo<User> allUser = userService.findAll(page, limit);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> obj = new HashMap<>();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", allUser.getTotal());
        obj.put("data", allUser.getList());
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("转换失败，",e);
            e.printStackTrace();
        }
        return json;
    }
}
