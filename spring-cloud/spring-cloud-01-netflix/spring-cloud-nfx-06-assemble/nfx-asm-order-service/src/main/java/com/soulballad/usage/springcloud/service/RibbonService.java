package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.vo.UserVo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : ribbon
 * @since ：2020/6/6 22:19
 */
public interface RibbonService {

    UserVo queryUserInfo(Long userId);

    UserVo updateUserPoint(UserVo userVo);

    String getOrderPoint();
}
