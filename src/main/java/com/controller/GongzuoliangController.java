
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
 * 工作量
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongzuoliang")
public class GongzuoliangController {
    private static final Logger logger = LoggerFactory.getLogger(GongzuoliangController.class);

    @Autowired
    private GongzuoliangService gongzuoliangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiangmuService xiangmuService;

    @Autowired
    private MishuService mishuService;
    @Autowired
    private JiaoshiService jiaoshiService;


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
        PageUtils page = gongzuoliangService.queryPage(params);

        //字典表数据转换
        List<GongzuoliangView> list =(List<GongzuoliangView>)page.getList();
        for(GongzuoliangView c:list){
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
        GongzuoliangEntity gongzuoliang = gongzuoliangService.selectById(id);
        if(gongzuoliang !=null){
            //entity转view
            GongzuoliangView view = new GongzuoliangView();
            BeanUtils.copyProperties( gongzuoliang , view );//把实体数据重构到view中

                //级联表
                XiangmuEntity xiangmu = xiangmuService.selectById(gongzuoliang.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                    DictionaryEntity dictionaryEntity = dictionaryService.selectOne(new EntityWrapper<DictionaryEntity>().eq("dic_code", "xiangmu_types").eq("code_index", xiangmu.getXiangmuTypes()));
                    if(dictionaryEntity == null)
                        return  R.error("查不到该项目的工作量标准");
                    view.setXiangmuTypesBeizhu(dictionaryEntity.getBeizhu());

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
    public R save(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongzuoliang:{}",this.getClass().getName(),gongzuoliang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        XiangmuEntity xiangmuEntity = xiangmuService.selectById(gongzuoliang.getXiangmuId());
        if(xiangmuEntity == null)
            return  R.error("查不到该项目");
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(new EntityWrapper<DictionaryEntity>().eq("dic_code", "xiangmu_types").eq("code_index", xiangmuEntity.getXiangmuTypes()));
        if(dictionaryEntity == null)
            return  R.error("查不到该项目的工作量标准");
        gongzuoliang.setZonggongzuoliang(Integer.valueOf(dictionaryEntity.getBeizhu()) * gongzuoliang.getTijiaozongshu());


        gongzuoliang.setInsertTime(new Date());
            gongzuoliang.setCreateTime(new Date());
            gongzuoliangService.insert(gongzuoliang);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuoliangEntity gongzuoliang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongzuoliang:{}",this.getClass().getName(),gongzuoliang.toString());


        XiangmuEntity xiangmuEntity = xiangmuService.selectById(gongzuoliang.getXiangmuId());
        if(xiangmuEntity == null)
            return  R.error("查不到该项目");
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(new EntityWrapper<DictionaryEntity>().eq("dic_code", "xiangmu_types").eq("code_index", xiangmuEntity.getXiangmuTypes()));
        if(dictionaryEntity == null)
            return  R.error("查不到该项目的工作量标准");
        gongzuoliang.setZonggongzuoliang(Integer.valueOf(dictionaryEntity.getBeizhu()) * gongzuoliang.getTijiaozongshu());

            gongzuoliangService.updateById(gongzuoliang);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongzuoliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GongzuoliangEntity> gongzuoliangList = new ArrayList<>();//上传的东西
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
                            GongzuoliangEntity gongzuoliangEntity = new GongzuoliangEntity();
//                            gongzuoliangEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            gongzuoliangEntity.setGongzuoliangContent("");//照片
//                            gongzuoliangEntity.setTijiaozongshu(Integer.valueOf(data.get(0)));   //提交总数 要改的
//                            gongzuoliangEntity.setZonggongzuoliang(Integer.valueOf(data.get(0)));   //总工作量 要改的
//                            gongzuoliangEntity.setInsertTime(date);//时间
//                            gongzuoliangEntity.setCreateTime(date);//时间
                            gongzuoliangList.add(gongzuoliangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gongzuoliangService.insertBatch(gongzuoliangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
