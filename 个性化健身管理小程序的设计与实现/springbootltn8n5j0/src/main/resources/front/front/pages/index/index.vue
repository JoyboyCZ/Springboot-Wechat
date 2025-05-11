<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"0 0 40rpx 0","background":"#fff","flexDirection":"column","display":"flex","height":"auto"}'>
			<view class="list-swiper-4" :style='{"width":"100%","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"width":"100%","position":"absolute","top":"0%","left":"0%","background":"#fff","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__backInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>{{ swiper.title }}</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.3)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#F7EFDB","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 关于我们 -->
			<view :style='{"padding":"0 20rpx","margin":"40rpx 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","height":"auto","order":"1"}'>
				<view :style='{"padding":"0 0 0 60rpx","margin":"0","color":"#fff","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250113/39adce2564a546ee874376961cb8928b.png) no-repeat center","display":"flex","width":"100%","fontSize":"32rpx","position":"relative","justifyContent":"left","height":"58rpx"}'>{{aboutUsDetail.title}}</view>
				<view :style='{"margin":"0 0 20rpx","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"32rpx"}'>{{aboutUsDetail.subtitle}}</view>
				<view :style='{"width":"100%","padding":"0","margin":"40rpx 0 0","flexWrap":"no-wrap","display":"flex","height":"auto"}'>
					<img :style='{"margin":"0","objectFit":"cover","borderRadius":"0","flex":1,"display":"block","height":"124rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
					<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"124rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
					<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"block","height":"124rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
				</view>
				<view :style='{"padding":"20rpx","margin":"0","color":"#333","background":"none","width":"100%","lineHeight":"2","fontSize":"28rpx"}' v-html="aboutUsDetail.content"></view>
				<view :style='{"border":"none","padding":"0","margin":"0","top":"0","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"58rpx","position":"absolute","right":"40rpx","height":"58rpx"}' @tap="onDetailTap('aboutus',1)">
					<text :style='{"color":"#FFFFFF","fontSize":"28rpx"}'>查看更多</text>
					<text class="icon iconfont " :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 商品推荐 -->
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<view class="listBox news" :style='{"width":"100%","padding":"0 20rpx","margin":"40rpx 0 0","background":"none","order":"2"}'>
				<view class="title" :style='{"padding":"0 0 0 60rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250113/39adce2564a546ee874376961cb8928b.png) no-repeat center","display":"flex","width":"100%","position":"relative","justifyContent":"start","height":"58rpx"}'>
					<view :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"58rpx"}'>健康资讯</view>
					<view :style='{"position":"absolute","right":"20rpx","alignItems":"center","top":"0","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
					  <text :style='{"fontSize":"28rpx","lineHeight":"58rpx","color":"#fff","height":"58rpx"}'>查看更多</text>
					  <text class="icon iconfont " :style='{"color":"#773018","fontSize":"28rpx"}'></text>
					</view>
				</view>
				<!-- 样式7 -->
				<view class="news-box4" :style='{"width":"100%","padding":"0","margin":"40rpx 0 0","height":"auto"}'>
					<block v-for="(item,index) in news" :key="index">
						<view @tap="onNewsDetailTap(item.id)" v-if="index%2==0" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"20rpx","margin":"0 0 40rpx 0","alignItems":"center","borderRadius":"10rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
							<image :style='{"border":"8rpx solid #4D357B","width":"140rpx","objectFit":"cover","borderRadius":"50%","display":"block","height":"140rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
							<view class="list-item-body" :style='{"width":"calc(100% - 140rpx)","padding":"0","margin":"0","height":"auto"}'>
								<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#333"}' class="title ">{{item.title}}</view>
								<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#666","maxHeight":"144rpx","width":"100%","lineHeight":"36rpx","fontSize":"28rpx"}' class="text">{{item.introduction}}</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
									<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
								</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#D6B4D3"}'></text>
									<text :style='{"color":"#D6B4D3","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#49436A"}'></text>
									<text :style='{"color":"#49436A","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#E0A4A4"}'></text>
									<text :style='{"color":"#E0A4A4","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#9EA8C4"}'></text>
									<text :style='{"color":"#9EA8C4","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
								</view>
							</view>
						</view>
						<view @tap="onNewsDetailTap(item.id)" v-if="index%2==1" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"20rpx","margin":"0 0 40rpx 0","alignItems":"center","borderRadius":"10rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
							<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
								<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#333"}' class="title ">{{item.title}}</view>
								<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#666","maxHeight":"144rpx","width":"100%","lineHeight":"36rpx","fontSize":"28rpx"}' class="text">{{item.introduction}}</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
									<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
								</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#D6B4D3"}'></text>
									<text :style='{"color":"#D6B4D3","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#49436A"}'></text>
									<text :style='{"color":"#49436A","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#E0A4A4"}'></text>
									<text :style='{"color":"#E0A4A4","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#9EA8C4"}'></text>
									<text :style='{"color":"#9EA8C4","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
								</view>
							</view>
							<image :style='{"border":"8rpx solid #4D357B","width":"140rpx","objectFit":"cover","borderRadius":"50%","display":"block","height":"140rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+item.picture"></image>
						</view>
					</block>
				</view>
			</view>
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#F7EFDB","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				role : '',
				aboutUsDetail: {},
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',

				//轮播
				swiperList: [],
				news: [],
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
		},
		async onShow() {
			if (this.timerList4&&this.timerList4!=null) clearInterval(this.timerList4)
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = {}
			if(table) {
				res = await this.$api.session(table);
				this.user = res.data;
				this.tableName = table;
			}
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 3000)

			this.getAboutUs();
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 4,
					sort: 'id',
					order: 'desc',
				}
				// 健康资讯
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			async getAboutUs() {
				let res = await this.$api.info('aboutus', 1)
				this.aboutUsDetail = res.data;
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}
	.list {
		.style2 {
			.tabView {
				.tab {
					border: none;
					border-radius: 40rpx;
					padding: 0 30rpx;
					margin: 0 10rpx;
					color: #fff;
					background: #412E5F;
				}
				.tabActive {
					border: none;
					border-radius: 40rpx;
					padding: 0 20rpx;
					margin: 0 10rpx;
					color: #fff;
					background: #7A66A8;
				}
			}
		}
	}

	.menu_view {
		padding: 0;
		margin: 0;
		background: none;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		flex-wrap: wrap;
		height: auto;
		.menu-item {
			padding: 12rpx 0;
			margin: 10rpx 0;
			width: 25%;
			height: auto;
			.iconarr {
				border-radius: 100%;
				padding: 0;
				margin: 0px auto;
				color: #D4A2F7;
				background: none;
				display: block;
				width: 84rpx;
				font-size: 84rpx;
				line-height: 84rpx;
				height: 84rpx;
			}
			.text {
				padding: 0;
				margin: 12rpx auto 0;
				color: #333;
				width: 100%;
				font-size: 28rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>
