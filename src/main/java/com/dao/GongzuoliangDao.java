package com.dao;

import com.entity.GongzuoliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuoliangView;

/**
 * 工作量 Dao 接口
 *
 * @author 
 */
public interface GongzuoliangDao extends BaseMapper<GongzuoliangEntity> {

   List<GongzuoliangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
