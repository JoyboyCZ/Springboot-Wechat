<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
		<view :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>用户账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.yonghuxingming" placeholder="用户姓名"></input>
			</view>
			<view v-if="tableName=='yonghu'" :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>手机号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.shoujihao" placeholder="手机号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.zhanghao" placeholder="账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.xingming" placeholder="姓名"></input>
			</view>
			<view v-if="tableName=='jianshenzhuanjia'" :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="jianshenzhuanjiaxingbieChange" :value="jianshenzhuanjiaxingbieIndex" :range="jianshenzhuanjiaxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>联系方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.lianxifangshi" placeholder="联系方式"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" @tap="jianshenzhuanjiatouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>营养师账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.yingyangshizhanghao" placeholder="营养师账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>营养师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.yingyangshixingming" placeholder="营养师姓名"></input>
			</view>
			<view v-if="tableName=='yingyangzhuanjia'" :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yingyangzhuanjiaxingbieChange" :value="yingyangzhuanjiaxingbieIndex" :range="yingyangzhuanjiaxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>联系电话</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#333","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0  0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" @tap="yingyangzhuanjiatouxiangTap" class="">
				<view class="title" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#727272","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"center","display":"flex","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.814%,rgb(130, 98, 197) 97.456%)","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"2rpx solid rgb(161, 131, 229)","padding":"0px","margin":"0 0 24rpx 0","color":"#A183E5","borderRadius":"40rpx","background":"none","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>

    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				yonghuxingbieOptions: [],
				yonghuxingbieIndex: 0,
				jianshenzhuanjiaxingbieOptions: [],
				jianshenzhuanjiaxingbieIndex: 0,
				yingyangzhuanjiaxingbieOptions: [],
				yingyangzhuanjiaxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect,
			xiaEditor
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let that = this
			let res = {}
			this.tableName = table;
			this.getSession()
			// 自定义下拉框值
			if(this.tableName=='yonghu'){
				this.yonghuxingbieOptions = "男,女".split(',');
				this.yonghuxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yonghuxingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='jianshenzhuanjia'){
				this.jianshenzhuanjiaxingbieOptions = "男,女".split(',');
				this.jianshenzhuanjiaxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.jianshenzhuanjiaxingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='yingyangzhuanjia'){
				this.yingyangzhuanjiaxingbieOptions = "男,女".split(',');
				this.yingyangzhuanjiaxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yingyangzhuanjiaxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let res = await this.$api.session(this.tableName)
				this.ruleForm = res.data;
				uni.setStorageSync('userSession',JSON.stringify(res.data))
			},
            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
			yonghutouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            jianshenzhuanjiaxingbieChange(e) {
                    this.jianshenzhuanjiaxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.jianshenzhuanjiaxingbieOptions[this.jianshenzhuanjiaxingbieIndex]
            },
			jianshenzhuanjiatouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            yingyangzhuanjiaxingbieChange(e) {
                    this.yingyangzhuanjiaxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yingyangzhuanjiaxingbieOptions[this.yingyangzhuanjiaxingbieIndex]
            },
			yingyangzhuanjiatouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('. .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.clearStorageSync()
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {

				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}

				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}


				if(`yonghu` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
					this.$utils.msg(`手机号应输入手机格式`);
					return
				}


				if((!this.ruleForm.zhanghao) && `jianshenzhuanjia` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `jianshenzhuanjia` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}

				if((!this.ruleForm.xingming) && `jianshenzhuanjia` == this.tableName){
					this.$utils.msg(`姓名不能为空`);
					return
				}


				if(`jianshenzhuanjia` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}


				if((!this.ruleForm.yingyangshizhanghao) && `yingyangzhuanjia` == this.tableName){
					this.$utils.msg(`营养师账号不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `yingyangzhuanjia` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}

				if((!this.ruleForm.yingyangshixingming) && `yingyangzhuanjia` == this.tableName){
					this.$utils.msg(`营养师姓名不能为空`);
					return
				}


				if(`yingyangzhuanjia` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}

				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
				this.getSession()
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
