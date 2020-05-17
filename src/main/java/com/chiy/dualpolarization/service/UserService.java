package com.chiy.dualpolarization.service;
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

import com.chiy.dualpolarization.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author liuqiang
 * @ClassName UserService
 * @Description TODO 测试接口
 * @Date 2020/5/13 11:25
 * @Version 1.0
 */
public interface UserService {
    PageInfo<User> findAll(int currentPage, int pageSize);

    List<User> selectAll();
}
