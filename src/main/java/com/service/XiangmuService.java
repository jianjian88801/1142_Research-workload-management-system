package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 科研项目 服务类
 */
public interface XiangmuService extends IService<XiangmuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}