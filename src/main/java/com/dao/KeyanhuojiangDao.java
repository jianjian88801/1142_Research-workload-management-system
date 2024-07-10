package com.dao;

import com.entity.KeyanhuojiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KeyanhuojiangView;

/**
 * 科研获奖 Dao 接口
 *
 * @author 
 */
public interface KeyanhuojiangDao extends BaseMapper<KeyanhuojiangEntity> {

   List<KeyanhuojiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
