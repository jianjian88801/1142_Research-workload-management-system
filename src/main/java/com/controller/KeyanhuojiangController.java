
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
 * 科研获奖
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/keyanhuojiang")
public class KeyanhuojiangController {
    private static final Logger logger = LoggerFactory.getLogger(KeyanhuojiangController.class);

    @Autowired
    private KeyanhuojiangService keyanhuojiangService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = keyanhuojiangService.queryPage(params);

        //字典表数据转换
        List<KeyanhuojiangView> list =(List<KeyanhuojiangView>)page.getList();
        for(KeyanhuojiangView c:list){
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
        KeyanhuojiangEntity keyanhuojiang = keyanhuojiangService.selectById(id);
        if(keyanhuojiang !=null){
            //entity转view
            KeyanhuojiangView view = new KeyanhuojiangView();
            BeanUtils.copyProperties( keyanhuojiang , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(keyanhuojiang.getJiaoshiId());
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
    public R save(@RequestBody KeyanhuojiangEntity keyanhuojiang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,keyanhuojiang:{}",this.getClass().getName(),keyanhuojiang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教师".equals(role))
            keyanhuojiang.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KeyanhuojiangEntity> queryWrapper = new EntityWrapper<KeyanhuojiangEntity>()
            .eq("jiaoshi_id", keyanhuojiang.getJiaoshiId())
            .eq("keyanhuojiang_name", keyanhuojiang.getKeyanhuojiangName())
            .eq("keyanhuojiang_types", keyanhuojiang.getKeyanhuojiangTypes())
            .eq("keyanhuojiang_yesno_types", keyanhuojiang.getKeyanhuojiangYesnoTypes())
            .eq("keyanhuojiang_yesno_text", keyanhuojiang.getKeyanhuojiangYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanhuojiangEntity keyanhuojiangEntity = keyanhuojiangService.selectOne(queryWrapper);
        if(keyanhuojiangEntity==null){
            keyanhuojiang.setInsertTime(new Date());
            keyanhuojiang.setKeyanhuojiangYesnoTypes(1);
            keyanhuojiang.setCreateTime(new Date());
            keyanhuojiangService.insert(keyanhuojiang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KeyanhuojiangEntity keyanhuojiang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,keyanhuojiang:{}",this.getClass().getName(),keyanhuojiang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教师".equals(role))
//            keyanhuojiang.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KeyanhuojiangEntity> queryWrapper = new EntityWrapper<KeyanhuojiangEntity>()
            .notIn("id",keyanhuojiang.getId())
            .andNew()
            .eq("jiaoshi_id", keyanhuojiang.getJiaoshiId())
            .eq("keyanhuojiang_name", keyanhuojiang.getKeyanhuojiangName())
            .eq("keyanhuojiang_types", keyanhuojiang.getKeyanhuojiangTypes())
            .eq("insert_time", keyanhuojiang.getInsertTime())
            .eq("keyanhuojiang_yesno_types", keyanhuojiang.getKeyanhuojiangYesnoTypes())
            .eq("keyanhuojiang_yesno_text", keyanhuojiang.getKeyanhuojiangYesnoText())
            .eq("update_time", keyanhuojiang.getUpdateTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanhuojiangEntity keyanhuojiangEntity = keyanhuojiangService.selectOne(queryWrapper);
        if("".equals(keyanhuojiang.getKeyanhuojiangFile()) || "null".equals(keyanhuojiang.getKeyanhuojiangFile())){
                keyanhuojiang.setKeyanhuojiangFile(null);
        }
        keyanhuojiang.setUpdateTime(new Date());
        if(keyanhuojiangEntity==null){
            keyanhuojiangService.updateById(keyanhuojiang);//根据id更新
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
        keyanhuojiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KeyanhuojiangEntity> keyanhuojiangList = new ArrayList<>();//上传的东西
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
                            KeyanhuojiangEntity keyanhuojiangEntity = new KeyanhuojiangEntity();
//                            keyanhuojiangEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            keyanhuojiangEntity.setKeyanhuojiangName(data.get(0));                    //科研获奖名称 要改的
//                            keyanhuojiangEntity.setKeyanhuojiangTypes(Integer.valueOf(data.get(0)));   //科研获奖类型 要改的
//                            keyanhuojiangEntity.setKeyanhuojiangFile(data.get(0));                    //相关文件 要改的
//                            keyanhuojiangEntity.setKeyanhuojiangContent("");//照片
//                            keyanhuojiangEntity.setInsertTime(date);//时间
//                            keyanhuojiangEntity.setKeyanhuojiangYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            keyanhuojiangEntity.setKeyanhuojiangYesnoText(data.get(0));                    //审核意见 要改的
//                            keyanhuojiangEntity.setUpdateTime(new Date(data.get(0)));          //审核时间 要改的
//                            keyanhuojiangEntity.setCreateTime(date);//时间
                            keyanhuojiangList.add(keyanhuojiangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        keyanhuojiangService.insertBatch(keyanhuojiangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
