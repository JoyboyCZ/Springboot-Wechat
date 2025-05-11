<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">用户账号</view>
				<picker :disabled="ro.yonghuzhanghao" :style='{"width":"100%","flex":"1","height":"auto"}' @change="yonghuzhanghaoChange" :value="yonghuzhanghaoIndex" :range="yonghuzhanghaoOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{yonghuzhanghaoOptions[yonghuzhanghaoIndex]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.yonghuxingming" placeholder="用户姓名"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">食物名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shiwumingcheng" v-model="ruleForm.shiwumingcheng" placeholder="食物名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">食物分类</view>
				<picker :disabled="ro.shiwufenlei" :style='{"width":"100%","flex":"1","height":"auto"}' @change="shiwufenleiChange" :value="shiwufenleiIndex" :range="shiwufenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.shiwufenlei?ruleForm.shiwufenlei:"请选择食物分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="shiwutupianTap">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">食物图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.shiwutupian" :src="baseUrl+ruleForm.shiwutupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">食物热量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shiwureliang" v-model="ruleForm.shiwureliang" placeholder="食物热量"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">蛋白质</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.danbaizhi" v-model="ruleForm.danbaizhi" placeholder="蛋白质"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">食物脂肪</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shiwuzhifang" v-model="ruleForm.shiwuzhifang" placeholder="食物脂肪"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">碳水化合物</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.tanshuihuahewu" v-model="ruleForm.tanshuihuahewu" placeholder="碳水化合物"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">饮食量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yinshiliang" v-model="ruleForm.yinshiliang" placeholder="饮食量"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">定制时间</view>
				<picker  :disabled="ro.dingzhishijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.dingzhishijian" @change="dingzhishijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.dingzhishijian?ruleForm.dingzhishijian:"请选择定制时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">营养师账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yingyangshizhanghao" v-model="ruleForm.yingyangshizhanghao" placeholder="营养师账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">营养师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yingyangshixingming" v-model="ruleForm.yingyangshixingming" placeholder="营养师姓名"  type="text"></input>
			</view>
              
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","fontWeight":"500"}' class="title">定制详情</view>
				<xia-editor ref="dingzhixiangqing" :style='{"minHeight":"300rpx","width":"100%","padding":"20rpx","color":"#333","background":"#fff","height":"auto"}' v-model="ruleForm.dingzhixiangqing" placeholder="定制详情" @editorChange="dingzhixiangqingChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.814%,rgb(130, 98, 197) 97.456%)","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				yonghuzhanghao: '',
				yonghuxingming: '',
				shiwumingcheng: '',
				shiwufenlei: '',
				shiwutupian: '',
				shiwureliang: '',
				danbaizhi: '',
				shiwuzhifang: '',
				tanshuihuahewu: '',
				yinshiliang: '',
				dingzhishijian: '',
				dingzhixiangqing: '',
				yingyangshizhanghao: '',
				yingyangshixingming: '',
				},
				yonghuzhanghaoOptions: [],
				yonghuzhanghaoIndex: 0,
				shiwufenleiOptions: [],
				shiwufenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   shiwumingcheng : false,
				   shiwufenlei : false,
				   shiwutupian : false,
				   shiwureliang : false,
				   danbaizhi : false,
				   shiwuzhifang : false,
				   tanshuihuahewu : false,
				   yinshiliang : false,
				   dingzhishijian : false,
				   dingzhixiangqing : false,
				   yingyangshizhanghao : false,
				   yingyangshixingming : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.dingzhishijian = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.yingyangshizhanghao = this.user.yingyangshizhanghao
			this.ro.yingyangshizhanghao = true;
			this.ruleForm.yingyangshixingming = this.user.yingyangshixingming
			this.ro.yingyangshixingming = true;


			// 下2
			res = await this.$api.option(`yonghu`,`yonghuzhanghao`,{});
			this.yonghuzhanghaoOptions = res.data;
			// 下拉框
			res = await this.$api.option(`shiwufenlei`,`shiwufenlei`,{});
			this.shiwufenleiOptions = res.data;
			this.shiwufenleiOptions.unshift("请选择食物分类");

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`yinshidingzhi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='yonghuzhanghao'){
						this.ruleForm.yonghuzhanghao = obj[o];
						this.ro.yonghuzhanghao = true;
						continue;
					}
					if(o=='yonghuxingming'){
						this.ruleForm.yonghuxingming = obj[o];
						this.ro.yonghuxingming = true;
						continue;
					}
					if(o=='shiwumingcheng'){
						this.ruleForm.shiwumingcheng = obj[o];
						this.ro.shiwumingcheng = true;
						continue;
					}
					if(o=='shiwufenlei'){
						this.ruleForm.shiwufenlei = obj[o];
						this.ro.shiwufenlei = true;
						continue;
					}
					if(o=='shiwutupian'){
						this.ruleForm.shiwutupian = obj[o].split(",")[0];
						this.ro.shiwutupian = true;
						continue;
					}
					if(o=='shiwureliang'){
						this.ruleForm.shiwureliang = obj[o];
						this.ro.shiwureliang = true;
						continue;
					}
					if(o=='danbaizhi'){
						this.ruleForm.danbaizhi = obj[o];
						this.ro.danbaizhi = true;
						continue;
					}
					if(o=='shiwuzhifang'){
						this.ruleForm.shiwuzhifang = obj[o];
						this.ro.shiwuzhifang = true;
						continue;
					}
					if(o=='tanshuihuahewu'){
						this.ruleForm.tanshuihuahewu = obj[o];
						this.ro.tanshuihuahewu = true;
						continue;
					}
					if(o=='yinshiliang'){
						this.ruleForm.yinshiliang = obj[o];
						this.ro.yinshiliang = true;
						continue;
					}
					if(o=='dingzhishijian'){
						this.ruleForm.dingzhishijian = obj[o];
						this.ro.dingzhishijian = true;
						continue;
					}
					if(o=='dingzhixiangqing'){
						this.ruleForm.dingzhixiangqing = obj[o];
						this.ro.dingzhixiangqing = true;
						continue;
					}
					if(o=='yingyangshizhanghao'){
						this.ruleForm.yingyangshizhanghao = obj[o];
						this.ro.yingyangshizhanghao = true;
						continue;
					}
					if(o=='yingyangshixingming'){
						this.ruleForm.yingyangshixingming = obj[o];
						this.ro.yingyangshixingming = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			dingzhixiangqingChange(e) {
				this.ruleForm.dingzhixiangqing = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},
			// 下二随
			async yonghuzhanghaoChange (e) {
				this.yonghuzhanghaoIndex = e.target.value
				this.ruleForm.yonghuzhanghao = this.yonghuzhanghaoOptions[this.yonghuzhanghaoIndex]
				let res = await this.$api.follow(`yonghu`, `yonghuzhanghao`,{
					columnValue: this.ruleForm.yonghuzhanghao
				});
				if(res.data.yonghuxingming){
					this.ruleForm.yonghuxingming = res.data.yonghuxingming
				}
			},

			// 多级联动参数

			dingzhishijianChange(e) {
				this.ruleForm.dingzhishijian = e.target.value;
				this.$forceUpdate();
			},


			// 下拉变化
			shiwufenleiChange(e) {
				this.shiwufenleiIndex = e.target.value
				this.ruleForm.shiwufenlei = this.shiwufenleiOptions[this.shiwufenleiIndex]
			},

			shiwutupianTap() {
				let _this = this;
				if(this.ro.shiwutupian){
					return false
				}
				this.$api.upload(function(res) {
					_this.ruleForm.shiwutupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`yinshidingzhi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`yinshidingzhi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`yinshidingzhi`, this.ruleForm);
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`yinshidingzhi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`yinshidingzhi`, this.ruleForm);
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
