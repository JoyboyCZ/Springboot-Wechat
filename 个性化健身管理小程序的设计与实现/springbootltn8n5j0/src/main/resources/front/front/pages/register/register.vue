<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100%","padding":"280rpx 80rpx 0 80rpx","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250113/6c5ff6dcaef142d0a9694e27bd65b32c.png) no-repeat top center, #25193d","display":"flex","width":"100%","height":"auto"}'>
		<view :style='{"width":"100%","padding":"0","position":"relative","borderRadius":"20rpx","background":"none","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">用户账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">用户姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#6B6153","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">手机号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.shoujihao"  type="text"  class="uni-input" name="" placeholder="手机号" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.zhanghao"  type="text"  class="uni-input" name="" placeholder="账号" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","display":"flex","height":"auto"}' v-if="tableName=='jianshenzhuanjia'"  @change="jianshenzhuanjiaxingbieChange" :value="jianshenzhuanjiaxingbieIndex" :range="jianshenzhuanjiaxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#6B6153","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">联系方式：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxifangshi"  type="text"  class="uni-input" name="" placeholder="联系方式" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jianshenzhuanjia'" @tap="jianshenzhuanjiatouxiangTap" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">营养师账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yingyangshizhanghao"  type="text"  class="uni-input" name="" placeholder="营养师账号" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">营养师姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yingyangshixingming"  type="text"  class="uni-input" name="" placeholder="营养师姓名" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","display":"flex","height":"auto"}' v-if="tableName=='yingyangzhuanjia'"  @change="yingyangzhuanjiaxingbieChange" :value="yingyangzhuanjiaxingbieIndex" :range="yingyangzhuanjiaxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#6B6153","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" class="uni-form-item uni-column">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">联系电话：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#fff","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yingyangzhuanjia'" @tap="yingyangzhuanjiatouxiangTap" class="">
				<view :style='{"padding":"0","color":"#fff","borderRadius":"0px 60rpx 60rpx 0px","textAlign":"center","background":"none","flex":"none","width":"160rpx","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"linear-gradient(126.77deg, rgb(178, 149, 247) 2.814%,rgb(130, 98, 197) 97.456%)","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
                jianshenzhuanjiaxingbieOptions: [],
                jianshenzhuanjiaxingbieIndex: 0,
                yingyangzhuanjiaxingbieOptions: [],
                yingyangzhuanjiaxingbieIndex: 0,
				ruleForm: {
                yonghuzhanghao: '',
                mima: '',
                yonghuxingming: '',
                xingbie: '',
                shoujihao: '',
                touxiang: '',
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                lianxifangshi: '',
                touxiang: '',
                yingyangshizhanghao: '',
                mima: '',
                yingyangshixingming: '',
                xingbie: '',
                lianxidianhua: '',
                touxiang: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='jianshenzhuanjia'){
                this.jianshenzhuanjiaxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.jianshenzhuanjiaxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='yingyangzhuanjia'){
                this.yingyangzhuanjiaxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yingyangzhuanjiaxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

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
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
                if(`jianshenzhuanjia` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
                if(`yingyangzhuanjia` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
