package com.chiy.dualpolarization.dao;
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
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author liuqiang
 * @ClassName UserMapper
 * @Description TODO  测试用例Mapper
 * @Date 2020/5/13 11:18
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * @Description 查找全部
     * @return java.util.List<com.chiy.dualpolarization.model.User>
     * @throws
     * @Author liuqaing
     * @Date 2020/5/13 11:21
     */
    Page<User> findAll();

    List<User> selectAll();


}
