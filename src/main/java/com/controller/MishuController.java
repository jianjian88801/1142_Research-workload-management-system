
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
 * 秘书
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/mishu")
public class MishuController {
    private static final Logger logger = LoggerFactory.getLogger(MishuController.class);

    @Autowired
    private MishuService mishuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        PageUtils page = mishuService.queryPage(params);

        //字典表数据转换
        List<MishuView> list =(List<MishuView>)page.getList();
        for(MishuView c:list){
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
        MishuEntity mishu = mishuService.selectById(id);
        if(mishu !=null){
            //entity转view
            MishuView view = new MishuView();
            BeanUtils.copyProperties( mishu , view );//把实体数据重构到view中

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
    public R save(@RequestBody MishuEntity mishu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,mishu:{}",this.getClass().getName(),mishu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MishuEntity> queryWrapper = new EntityWrapper<MishuEntity>()
            .eq("username", mishu.getUsername())
            .or()
            .eq("mishu_phone", mishu.getMishuPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MishuEntity mishuEntity = mishuService.selectOne(queryWrapper);
        if(mishuEntity==null){
            mishu.setCreateTime(new Date());
            mishu.setPassword("123456");
            mishuService.insert(mishu);
            return R.ok();
        }else {
            return R.error(511,"账户或者秘书手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MishuEntity mishu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,mishu:{}",this.getClass().getName(),mishu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<MishuEntity> queryWrapper = new EntityWrapper<MishuEntity>()
            .notIn("id",mishu.getId())
            .andNew()
            .eq("username", mishu.getUsername())
            .or()
            .eq("mishu_phone", mishu.getMishuPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MishuEntity mishuEntity = mishuService.selectOne(queryWrapper);
        if("".equals(mishu.getMishuPhoto()) || "null".equals(mishu.getMishuPhoto())){
                mishu.setMishuPhoto(null);
        }
        if(mishuEntity==null){
            mishuService.updateById(mishu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者秘书手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        mishuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<MishuEntity> mishuList = new ArrayList<>();//上传的东西
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
                            MishuEntity mishuEntity = new MishuEntity();
//                            mishuEntity.setUsername(data.get(0));                    //账户 要改的
//                            //mishuEntity.setPassword("123456");//密码
//                            mishuEntity.setMishuUuidNumber(data.get(0));                    //秘书工号 要改的
//                            mishuEntity.setMishuName(data.get(0));                    //秘书姓名 要改的
//                            mishuEntity.setMishuPhone(data.get(0));                    //秘书手机号 要改的
//                            mishuEntity.setMishuPhoto("");//照片
//                            mishuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            mishuEntity.setMishuEmail(data.get(0));                    //电子邮箱 要改的
//                            mishuEntity.setCreateTime(date);//时间
                            mishuList.add(mishuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //秘书工号
                                if(seachFields.containsKey("mishuUuidNumber")){
                                    List<String> mishuUuidNumber = seachFields.get("mishuUuidNumber");
                                    mishuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> mishuUuidNumber = new ArrayList<>();
                                    mishuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("mishuUuidNumber",mishuUuidNumber);
                                }
                                //秘书手机号
                                if(seachFields.containsKey("mishuPhone")){
                                    List<String> mishuPhone = seachFields.get("mishuPhone");
                                    mishuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> mishuPhone = new ArrayList<>();
                                    mishuPhone.add(data.get(0));//要改的
                                    seachFields.put("mishuPhone",mishuPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<MishuEntity> mishuEntities_username = mishuService.selectList(new EntityWrapper<MishuEntity>().in("username", seachFields.get("username")));
                        if(mishuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MishuEntity s:mishuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //秘书工号
                        List<MishuEntity> mishuEntities_mishuUuidNumber = mishuService.selectList(new EntityWrapper<MishuEntity>().in("mishu_uuid_number", seachFields.get("mishuUuidNumber")));
                        if(mishuEntities_mishuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MishuEntity s:mishuEntities_mishuUuidNumber){
                                repeatFields.add(s.getMishuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [秘书工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //秘书手机号
                        List<MishuEntity> mishuEntities_mishuPhone = mishuService.selectList(new EntityWrapper<MishuEntity>().in("mishu_phone", seachFields.get("mishuPhone")));
                        if(mishuEntities_mishuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MishuEntity s:mishuEntities_mishuPhone){
                                repeatFields.add(s.getMishuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [秘书手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        mishuService.insertBatch(mishuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        MishuEntity mishu = mishuService.selectOne(new EntityWrapper<MishuEntity>().eq("username", username));
        if(mishu==null || !mishu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(mishu.getId(),username, "mishu", "秘书");
        R r = R.ok();
        r.put("token", token);
        r.put("role","秘书");
        r.put("username",mishu.getMishuName());
        r.put("tableName","mishu");
        r.put("userId",mishu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody MishuEntity mishu){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<MishuEntity> queryWrapper = new EntityWrapper<MishuEntity>()
            .eq("username", mishu.getUsername())
            .or()
            .eq("mishu_phone", mishu.getMishuPhone())
            ;
        MishuEntity mishuEntity = mishuService.selectOne(queryWrapper);
        if(mishuEntity != null)
            return R.error("账户或者秘书手机号已经被使用");
        mishu.setCreateTime(new Date());
        mishuService.insert(mishu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        MishuEntity mishu = new MishuEntity();
        mishu.setPassword("123456");
        mishu.setId(id);
        mishuService.updateById(mishu);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        MishuEntity mishu = mishuService.selectOne(new EntityWrapper<MishuEntity>().eq("username", username));
        if(mishu!=null){
            mishu.setPassword("123456");
            boolean b = mishuService.updateById(mishu);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrMishu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        MishuEntity mishu = mishuService.selectById(id);
        if(mishu !=null){
            //entity转view
            MishuView view = new MishuView();
            BeanUtils.copyProperties( mishu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
