<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"minHeight":"100%","width":"100%","padding":"0 20rpx","position":"relative","background":"#fff","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"padding":"20rpx 0 0 0","margin":"0","background":"none","display":"flex","width":"100%","position":"relative","height":"auto"}'>
					<view :style='{"border":"none","margin":"0","borderRadius":"20rpx","flex":"1","background":"none","lineHeight":"80rpx","position":"relative","height":"80rpx"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgb(153, 153, 153)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input placeholder-style="color: #fff" :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#fff","borderRadius":"40rpx","background":"rgba(139, 125, 165, 0.5)","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.title" type="text" placeholder="标题" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","right":"0","borderRadius":"40rpx","top":"20rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.406%,rgb(130, 98, 197) 93.656%)","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"99"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"20rpx","margin":"20rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexWrap":"wrap","background":"rgba(255, 255, 255,0.2)","display":"flex"}'>
					<view @click="sortClick('clicknum')" :style='{"border":"2rpx solid rgb(153, 152, 152)","padding":"0 12rpx","margin":"0 20rpx 0 0","outline":"0","borderRadius":"8rpx","display":"flex"}'>
						<text :style='{"color":"#333","lineHeight":"48rpx","fontSize":"24rpx"}'>点击量</text>
						<text v-if="listSort!='clicknum'" class="icon iconfont icon-xiaoliang13" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='asc'" class="icon iconfont icon-xiaoliang13" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='desc'" class="icon iconfont icon-xiaoliang13" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
					</view>
					<view @click="sortClick('addtime')" :style='{"border":"2rpx solid rgb(153, 152, 152)","padding":"0 12rpx","margin":"0 20rpx 0 0","outline":"0","borderRadius":"8rpx","display":"flex"}'>
						<text :style='{"color":"#333","lineHeight":"48rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
					</view>
				</view>
				<view :style='{"width":"100%","background":"none","flexDirection":"column","display":"flex","height":"auto"}'>
					<scroll-view scroll-x="true" class="category-one" :style='{"padding":"20rpx","margin":"0","whiteSpace":"wrap","borderRadius":"0 0 20rpx 20rpx","background":"rgba(175, 145, 238,0.2)","flexDirection":"row","display":"flex","width":"100%","height":"auto"}'>
						<view :class='categoryName === item.typename ? "active" : ""' class="tab" v-for="(item,index) in categoryList" :key="index" @tap="categoryClick(item.typename)">{{item.typename}}</view>
					</scroll-view>
			
			
			
					<!-- 样式4 -->
					<view v-if="list.length" class="news-box4" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
						<block v-for="(product,index) in list" :key="index">
							<view @tap="onDetailTap(product)" v-if="index%2==0" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"20rpx","margin":"0 0 40rpx 0","alignItems":"center","borderRadius":"10rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
								<image :style='{"border":"8rpx solid #4D357B","width":"140rpx","objectFit":"cover","borderRadius":"50%","display":"block","height":"140rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+product.picture"></image>
								<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
									<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#333"}' class="title ">{{product.title}}</view>
									<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#666","maxHeight":"144rpx","width":"100%","lineHeight":"36rpx","fontSize":"28rpx"}' class="text ">{{product.introduction}}</view>
									<view :style='{"padding":"0 20rpx"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.name}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.clicknum}}</text>
									</view>
								</view>
							</view>
							<view @tap="onDetailTap(product)" v-if="index%2==1" class="list-item" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"20rpx","margin":"0 0 40rpx 0","alignItems":"center","borderRadius":"10rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>
								<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
									<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#333"}' class="title ">{{product.title}}</view>
									<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","color":"#666","maxHeight":"144rpx","width":"100%","lineHeight":"36rpx","fontSize":"24rpx"}' class="text ">{{product.introduction}}</view>
									<view :style='{"padding":"0 20rpx"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.name}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
										<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.clicknum}}</text>
									</view>
								</view>
								<image :style='{"border":"8rpx solid #4D357B","width":"140rpx","objectFit":"cover","borderRadius":"50%","display":"block","height":"140rpx"}' mode="aspectFill" class="listmpic" :src="baseUrl+product.picture"></image>
							</view>
						</block>
					</view>
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.406%,rgb(130, 98, 197) 93.656%)","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="userid && isAuth('news','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.406%,rgb(130, 98, 197) 93.656%)","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="!userid && isAuthFront('news','新增')" class="add-btn" @click="onAddTap()">新增</button>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				clicknumColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					title: '',
				},
				categoryList:[],
				categoryName :'全部',
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
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
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.clicknumColor = this.clicknumColor.sort(()=> {
				return (0.5-Math.random());
			});
			let res = {};
			if(this.userid) {
				res = await this.$api.page('newstype', {page:1,limit:100});
			} else {
				res = await this.$api.list('newstype', {page:1,limit:100});
			}
			res.data.list.splice(0,0,{id:0,typename:'全部'})
			this.categoryList = res.data.list;
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			screenReset(){
				this.searchForm = {}
				this.search()
				this.$forceUpdate()
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
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			categoryClick(categoryName){
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					params.typename = this.categoryName
				}
				if(this.searchForm.title){
					params['title'] = '%' + this.searchForm.title + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`news`, params);
                } else {
                    res = await this.$api.list(`news`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`../news-detail/news-detail?id=${item.id}`)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('news', JSON.stringify([id]));
							let obj = await _this.$api.list('storeup',{
								page: 1,
								limit: 100,
								tablename: 'news',
								refid: id,
							})
							if(obj.data.list.length){
								let arr = []
								for(let x in obj.data.list){
									arr.push(obj.data.list[x].id)
								}
								await _this.$api.del('storeup',JSON.stringify(arr))
							}
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					searchForm.typename = this.categoryName
				}
				if(this.searchForm.title){
					searchForm['title'] = '%' + this.searchForm.title + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`news`, searchForm);
                } else {
                    res = await this.$api.list(`news`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		border-radius: 10rpx;
		padding: 0 20rpx;
		margin: 0 12rpx 12rpx 0;
		color: #000;
		background: #dcdcdc;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
		height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border-radius: 10rpx;
		padding: 0 20rpx;
		margin: 0 12rpx 0 0;
		color: #fff;
		background: #8258CF;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
		height: 60rpx;
	}
</style>
