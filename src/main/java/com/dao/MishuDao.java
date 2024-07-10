package com.dao;

import com.entity.MishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MishuView;

/**
 * 秘书 Dao 接口
 *
 * @author 
 */
public interface MishuDao extends BaseMapper<MishuEntity> {

   List<MishuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
