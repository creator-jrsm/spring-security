package com.yDie.aclService.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yDie.aclService.entity.UserRole;
import com.yDie.aclService.mapper.UserRoleMapper;
import com.yDie.aclService.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
