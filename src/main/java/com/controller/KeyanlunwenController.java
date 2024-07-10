
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 科研论文
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/keyanlunwen")
public class KeyanlunwenController {
    private static final Logger logger = LoggerFactory.getLogger(KeyanlunwenController.class);

    @Autowired
    private KeyanlunwenService keyanlunwenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;

    @Autowired
    private MishuService mishuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("秘书".equals(role))
            params.put("mishuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        params.put("keyanlunwenDeleteStart",1);params.put("keyanlunwenDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = keyanlunwenService.queryPage(params);

        //字典表数据转换
        List<KeyanlunwenView> list =(List<KeyanlunwenView>)page.getList();
        for(KeyanlunwenView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KeyanlunwenEntity keyanlunwen = keyanlunwenService.selectById(id);
        if(keyanlunwen !=null){
            //entity转view
            KeyanlunwenView view = new KeyanlunwenView();
            BeanUtils.copyProperties( keyanlunwen , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(keyanlunwen.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanlunwenEntity keyanlunwen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,keyanlunwen:{}",this.getClass().getName(),keyanlunwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教师".equals(role))
            keyanlunwen.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KeyanlunwenEntity> queryWrapper = new EntityWrapper<KeyanlunwenEntity>()
            .eq("jiaoshi_id", keyanlunwen.getJiaoshiId())
            .eq("keyanlunwen_name", keyanlunwen.getKeyanlunwenName())
            .eq("keyanlunwen_types", keyanlunwen.getKeyanlunwenTypes())
            .eq("keyanlunwen_delete", keyanlunwen.getKeyanlunwenDelete())
            .eq("keyanlunwen_yesno_types", keyanlunwen.getKeyanlunwenYesnoTypes())
            .eq("keyanlunwen_yesno_text", keyanlunwen.getKeyanlunwenYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanlunwenEntity keyanlunwenEntity = keyanlunwenService.selectOne(queryWrapper);
        if(keyanlunwenEntity==null){
            keyanlunwen.setKeyanlunwenDelete(1);
            keyanlunwen.setInsertTime(new Date());
            keyanlunwen.setKeyanlunwenYesnoTypes(1);
            keyanlunwen.setCreateTime(new Date());
            keyanlunwenService.insert(keyanlunwen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KeyanlunwenEntity keyanlunwen, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,keyanlunwen:{}",this.getClass().getName(),keyanlunwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教师".equals(role))
//            keyanlunwen.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KeyanlunwenEntity> queryWrapper = new EntityWrapper<KeyanlunwenEntity>()
            .notIn("id",keyanlunwen.getId())
            .andNew()
            .eq("jiaoshi_id", keyanlunwen.getJiaoshiId())
            .eq("keyanlunwen_name", keyanlunwen.getKeyanlunwenName())
            .eq("keyanlunwen_types", keyanlunwen.getKeyanlunwenTypes())
            .eq("keyanlunwen_delete", keyanlunwen.getKeyanlunwenDelete())
            .eq("insert_time", keyanlunwen.getInsertTime())
            .eq("keyanlunwen_yesno_types", keyanlunwen.getKeyanlunwenYesnoTypes())
            .eq("keyanlunwen_yesno_text", keyanlunwen.getKeyanlunwenYesnoText())
            .eq("update_time", keyanlunwen.getUpdateTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanlunwenEntity keyanlunwenEntity = keyanlunwenService.selectOne(queryWrapper);
        if("".equals(keyanlunwen.getKeyanlunwenFile()) || "null".equals(keyanlunwen.getKeyanlunwenFile())){
                keyanlunwen.setKeyanlunwenFile(null);
        }
        keyanlunwen.setUpdateTime(new Date());
        if(keyanlunwenEntity==null){
            keyanlunwenService.updateById(keyanlunwen);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<KeyanlunwenEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KeyanlunwenEntity keyanlunwenEntity = new KeyanlunwenEntity();
            keyanlunwenEntity.setId(id);
            keyanlunwenEntity.setKeyanlunwenDelete(2);
            list.add(keyanlunwenEntity);
        }
        if(list != null && list.size() >0){
            keyanlunwenService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KeyanlunwenEntity> keyanlunwenList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            KeyanlunwenEntity keyanlunwenEntity = new KeyanlunwenEntity();
//                            keyanlunwenEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            keyanlunwenEntity.setKeyanlunwenName(data.get(0));                    //科研论文名称 要改的
//                            keyanlunwenEntity.setKeyanlunwenTypes(Integer.valueOf(data.get(0)));   //科研论文类型 要改的
//                            keyanlunwenEntity.setKeyanlunwenFile(data.get(0));                    //相关文件 要改的
//                            keyanlunwenEntity.setKeyanlunwenContent("");//照片
//                            keyanlunwenEntity.setKeyanlunwenDelete(1);//逻辑删除字段
//                            keyanlunwenEntity.setInsertTime(date);//时间
//                            keyanlunwenEntity.setKeyanlunwenYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            keyanlunwenEntity.setKeyanlunwenYesnoText(data.get(0));                    //审核意见 要改的
//                            keyanlunwenEntity.setUpdateTime(new Date(data.get(0)));          //审核时间 要改的
//                            keyanlunwenEntity.setCreateTime(date);//时间
                            keyanlunwenList.add(keyanlunwenEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        keyanlunwenService.insertBatch(keyanlunwenList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
