package com.chiy.dualpolarization.dao;

import com.chiy.dualpolarization.model.DualUser;
import java.util.List;

public interface DualUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(DualUser record);

    DualUser selectByPrimaryKey(Integer userId);

    List<DualUser> selectAll();

    int updateByPrimaryKey(DualUser record);
}