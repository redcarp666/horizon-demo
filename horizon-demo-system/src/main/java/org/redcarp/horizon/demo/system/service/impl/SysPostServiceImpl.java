package org.redcarp.horizon.demo.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.demo.system.entity.SysPost;
import org.redcarp.horizon.demo.system.mapper.SysPostMapper;
import org.redcarp.horizon.demo.system.service.ISysPostService;
import org.springframework.stereotype.Service;

@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

    @Override
    public Page<SysPost> getList(Request<SysPost> request) {
        SysPost sysPost = request.getData();
        LambdaQueryWrapper<SysPost> wrapper = Wrappers.lambdaQuery(SysPost.class);
        wrapper.eq(ObjectUtil.isNotNull(sysPost.getPostCode()),SysPost::getPostCode,sysPost.getPostCode());
        wrapper.eq(ObjectUtil.isNotNull(sysPost.getPostName()),SysPost::getPostName,sysPost.getPostName());
        wrapper.eq(ObjectUtil.isNotNull(sysPost.getStatus()),SysPost::getStatus,sysPost.getStatus());
        return this.page(request.getPage(), wrapper);
    }
}
