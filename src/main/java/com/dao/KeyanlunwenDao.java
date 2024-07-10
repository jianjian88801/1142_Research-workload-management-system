package com.dao;

import com.entity.KeyanlunwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KeyanlunwenView;

/**
 * 科研论文 Dao 接口
 *
 * @author 
 */
public interface KeyanlunwenDao extends BaseMapper<KeyanlunwenEntity> {

   List<KeyanlunwenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
