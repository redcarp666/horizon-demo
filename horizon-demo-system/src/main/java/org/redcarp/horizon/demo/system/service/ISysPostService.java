package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.demo.system.entity.SysPost;

public interface ISysPostService extends IService<SysPost> {

    Page<SysPost> getList(Request<SysPost> request);

}
