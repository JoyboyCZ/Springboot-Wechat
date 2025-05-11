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
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">计划标题</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jihuabiaoti" v-model="ruleForm.jihuabiaoti" placeholder="计划标题"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">运动类型</view>
				<picker :disabled="ro.yundongleixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="yundongleixingChange" :value="yundongleixingIndex" :range="yundongleixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.yundongleixing?ruleForm.yundongleixing:"请选择运动类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">训练方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xunlianfangshi" v-model="ruleForm.xunlianfangshi" placeholder="训练方式"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">训练频率</view>
				<picker :disabled="ro.xunlianpinlv" :style='{"width":"100%","flex":"1","height":"auto"}' @change="xunlianpinlvChange" :value="xunlianpinlvIndex" :range="xunlianpinlvOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.xunlianpinlv?ruleForm.xunlianpinlv:"请选择训练频率"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">训练天数</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xunliantianshu" v-model="ruleForm.xunliantianshu" placeholder="训练天数"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">计划时间</view>
				<picker  :disabled="ro.jihuashijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.jihuashijian" @change="jihuashijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666"}' class="uni-input">{{ruleForm.jihuashijian?ruleForm.jihuashijian:"请选择计划时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhanghao" v-model="ruleForm.zhanghao" placeholder="账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="姓名"  type="text"></input>
			</view>
               
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">预期目标</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.yuqimubiao" placeholder="预期目标" :maxlength="-1"></textarea>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 2rpx 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","fontWeight":"500"}' class="title">计划详情</view>
				<xia-editor ref="jihuaxiangqing" :style='{"minHeight":"300rpx","width":"100%","padding":"20rpx","color":"#333","background":"#fff","height":"auto"}' v-model="ruleForm.jihuaxiangqing" placeholder="计划详情" @editorChange="jihuaxiangqingChange"></xia-editor>
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
				jihuabiaoti: '',
				yundongleixing: '',
				tupian: '',
				xunlianfangshi: '',
				xunlianpinlv: '',
				yuqimubiao: '',
				xunliantianshu: '',
				jihuaxiangqing: '',
				jihuashijian: '',
				zhanghao: '',
				xingming: '',
				shhf: '',
				},
				yonghuzhanghaoOptions: [],
				yonghuzhanghaoIndex: 0,
				yundongleixingOptions: [],
				yundongleixingIndex: 0,
				xunlianpinlvOptions: [],
				xunlianpinlvIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   jihuabiaoti : false,
				   yundongleixing : false,
				   tupian : false,
				   xunlianfangshi : false,
				   xunlianpinlv : false,
				   yuqimubiao : false,
				   xunliantianshu : false,
				   jihuaxiangqing : false,
				   jihuashijian : false,
				   zhanghao : false,
				   xingming : false,
				   sfsh : false,
				   shhf : false,
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
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.zhanghao = this.user.zhanghao
			this.ro.zhanghao = true;
			this.ruleForm.xingming = this.user.xingming
			this.ro.xingming = true;


			// 下2
			res = await this.$api.option(`yonghu`,`yonghuzhanghao`,{});
			this.yonghuzhanghaoOptions = res.data;
			// 下拉框
			res = await this.$api.option(`yundongleixing`,`yundongleixing`,{});
			this.yundongleixingOptions = res.data;
			this.yundongleixingOptions.unshift("请选择运动类型");
			// 自定义下拉框值
			this.xunlianpinlvOptions = "一周一次,一周两次,一周三次,一周四次,一周五次,一周六次,一周七次".split(',')

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
				res = await this.$api.info(`jianshendingzhi`, this.ruleForm.id);
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
					if(o=='jihuabiaoti'){
						this.ruleForm.jihuabiaoti = obj[o];
						this.ro.jihuabiaoti = true;
						continue;
					}
					if(o=='yundongleixing'){
						this.ruleForm.yundongleixing = obj[o];
						this.ro.yundongleixing = true;
						continue;
					}
					if(o=='tupian'){
						this.ruleForm.tupian = obj[o].split(",")[0];
						this.ro.tupian = true;
						continue;
					}
					if(o=='xunlianfangshi'){
						this.ruleForm.xunlianfangshi = obj[o];
						this.ro.xunlianfangshi = true;
						continue;
					}
					if(o=='xunlianpinlv'){
						this.ruleForm.xunlianpinlv = obj[o];
						this.ro.xunlianpinlv = true;
						continue;
					}
					if(o=='yuqimubiao'){
						this.ruleForm.yuqimubiao = obj[o];
						this.ro.yuqimubiao = true;
						continue;
					}
					if(o=='xunliantianshu'){
						this.ruleForm.xunliantianshu = obj[o];
						this.ro.xunliantianshu = true;
						continue;
					}
					if(o=='jihuaxiangqing'){
						this.ruleForm.jihuaxiangqing = obj[o];
						this.ro.jihuaxiangqing = true;
						continue;
					}
					if(o=='jihuashijian'){
						this.ruleForm.jihuashijian = obj[o];
						this.ro.jihuashijian = true;
						continue;
					}
					if(o=='zhanghao'){
						this.ruleForm.zhanghao = obj[o];
						this.ro.zhanghao = true;
						continue;
					}
					if(o=='xingming'){
						this.ruleForm.xingming = obj[o];
						this.ro.xingming = true;
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
			jihuaxiangqingChange(e) {
				this.ruleForm.jihuaxiangqing = e
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

			jihuashijianChange(e) {
				this.ruleForm.jihuashijian = e.target.value;
				this.$forceUpdate();
			},


			// 下拉变化
			yundongleixingChange(e) {
				this.yundongleixingIndex = e.target.value
				this.ruleForm.yundongleixing = this.yundongleixingOptions[this.yundongleixingIndex]
			},
			// 下拉变化
			xunlianpinlvChange(e) {
				this.xunlianpinlvIndex = e.target.value
				this.ruleForm.xunlianpinlv = this.xunlianpinlvOptions[this.xunlianpinlvIndex]
			},

			tupianTap() {
				let _this = this;
				if(this.ro.tupian){
					return false
				}
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
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
					let res = await this.$api.list(`jianshendingzhi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`jianshendingzhi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`jianshendingzhi`, this.ruleForm);
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
						await this.$api.update(`jianshendingzhi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`jianshendingzhi`, this.ruleForm);
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
