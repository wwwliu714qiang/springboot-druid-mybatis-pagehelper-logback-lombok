package com.chiy.dualpolarization.service.Impl;
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

import com.chiy.dualpolarization.dao.UserMapper;
import com.chiy.dualpolarization.model.User;
import com.chiy.dualpolarization.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author liuqiang
 * @ClassName UserImpl
 * @Description TODO
 * @Date 2020/5/13 11:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageInfo<User> findAll(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数。必须在mapper接口中的方法执行之前设置该分页信息
        PageHelper.startPage(currentPage, pageSize);
        //全部用户
        Page<User> allItems = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(allItems);
        return pageInfo;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

}
