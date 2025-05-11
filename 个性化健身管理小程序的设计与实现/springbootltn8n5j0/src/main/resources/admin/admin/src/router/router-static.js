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
	import yinshijianyi from '@/views/modules/yinshijianyi/list'
	import discussyinshijianyi from '@/views/modules/discussyinshijianyi/list'
	import storeup from '@/views/modules/storeup/list'
	import yundongleixing from '@/views/modules/yundongleixing/list'
	import forumtype from '@/views/modules/forumtype/list'
	import yonghu from '@/views/modules/yonghu/list'
	import discussjianshenjianyi from '@/views/modules/discussjianshenjianyi/list'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import jianshenzhuanjia from '@/views/modules/jianshenzhuanjia/list'
	import jianshendingzhi from '@/views/modules/jianshendingzhi/list'
	import shiwufenlei from '@/views/modules/shiwufenlei/list'
	import yingyangzhuanjia from '@/views/modules/yingyangzhuanjia/list'
	import jianshenjianyi from '@/views/modules/jianshenjianyi/list'
	import jianshenjindu from '@/views/modules/jianshenjindu/list'
	import menu from '@/views/modules/menu/list'
	import jianshenjilu from '@/views/modules/jianshenjilu/list'
	import forum from '@/views/modules/forum/list'
	import popupremind from '@/views/modules/popupremind/list'
	import yinshidingzhi from '@/views/modules/yinshidingzhi/list'
	import forumreport from '@/views/modules/forumreport/list'
	import yinshijilu from '@/views/modules/yinshijilu/list'
	import config from '@/views/modules/config/list'
	import jianyileixing from '@/views/modules/jianyileixing/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
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
	}
	,{
		path: '/yinshijianyi',
		name: '饮食建议',
		component: yinshijianyi
	}
	,{
		path: '/discussyinshijianyi',
		name: '饮食建议评论',
		component: discussyinshijianyi
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/yundongleixing',
		name: '运动类型',
		component: yundongleixing
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/discussjianshenjianyi',
		name: '健身建议评论',
		component: discussjianshenjianyi
	}
	,{
		path: '/news',
		name: '健康资讯',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/jianshenzhuanjia',
		name: '健身专家',
		component: jianshenzhuanjia
	}
	,{
		path: '/jianshendingzhi',
		name: '健身定制',
		component: jianshendingzhi
	}
	,{
		path: '/shiwufenlei',
		name: '食物分类',
		component: shiwufenlei
	}
	,{
		path: '/yingyangzhuanjia',
		name: '营养专家',
		component: yingyangzhuanjia
	}
	,{
		path: '/jianshenjianyi',
		name: '健身建议',
		component: jianshenjianyi
	}
	,{
		path: '/jianshenjindu',
		name: '健身进度',
		component: jianshenjindu
	}
	,{
		path: '/menu',
		name: '菜单列表',
		component: menu
	}
	,{
		path: '/jianshenjilu',
		name: '健身记录',
		component: jianshenjilu
	}
	,{
		path: '/forum',
		name: '交流论坛',
		component: forum
	}
	,{
		path: '/popupremind',
		name: '弹窗提醒',
		component: popupremind
	}
	,{
		path: '/yinshidingzhi',
		name: '饮食定制',
		component: yinshidingzhi
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/yinshijilu',
		name: '饮食记录',
		component: yinshijilu
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/jianyileixing',
		name: '建议类型',
		component: jianyileixing
	}
	,{
		path: '/newstype',
		name: '健康资讯分类',
		component: newstype
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
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
