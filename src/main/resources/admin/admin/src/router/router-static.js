import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gongzuoliang from '@/views/modules/gongzuoliang/list'
    import keyanhuojiang from '@/views/modules/keyanhuojiang/list'
    import keyanlunwen from '@/views/modules/keyanlunwen/list'
    import mishu from '@/views/modules/mishu/list'
    import xiangmu from '@/views/modules/xiangmu/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import dictionaryKeyanhuojiang from '@/views/modules/dictionaryKeyanhuojiang/list'
    import dictionaryKeyanhuojiangYesno from '@/views/modules/dictionaryKeyanhuojiangYesno/list'
    import dictionaryKeyanlunwen from '@/views/modules/dictionaryKeyanlunwen/list'
    import dictionaryKeyanlunwenYesno from '@/views/modules/dictionaryKeyanlunwenYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXiangmu from '@/views/modules/dictionaryXiangmu/list'
    import dictionaryXiangmuYesno from '@/views/modules/dictionaryXiangmuYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryKeyanhuojiang',
        name: '科研获奖类型',
        component: dictionaryKeyanhuojiang
    }
    ,{
        path: '/dictionaryKeyanhuojiangYesno',
        name: '审核状态',
        component: dictionaryKeyanhuojiangYesno
    }
    ,{
        path: '/dictionaryKeyanlunwen',
        name: '科研论文类型',
        component: dictionaryKeyanlunwen
    }
    ,{
        path: '/dictionaryKeyanlunwenYesno',
        name: '审核状态',
        component: dictionaryKeyanlunwenYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXiangmu',
        name: '科研项目类型',
        component: dictionaryXiangmu
    }
    ,{
        path: '/dictionaryXiangmuYesno',
        name: '审核状态',
        component: dictionaryXiangmuYesno
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gongzuoliang',
        name: '工作量',
        component: gongzuoliang
      }
    ,{
        path: '/keyanhuojiang',
        name: '科研获奖',
        component: keyanhuojiang
      }
    ,{
        path: '/keyanlunwen',
        name: '科研论文',
        component: keyanlunwen
      }
    ,{
        path: '/mishu',
        name: '秘书',
        component: mishu
      }
    ,{
        path: '/xiangmu',
        name: '科研项目',
        component: xiangmu
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
