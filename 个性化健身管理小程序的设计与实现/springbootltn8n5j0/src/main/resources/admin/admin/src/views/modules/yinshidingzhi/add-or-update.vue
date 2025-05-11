<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="select" v-if="type!='info'" label="用户账号" prop="yonghuzhanghao" >
					<el-select :disabled="ro.yonghuzhanghao" @change="yonghuzhanghaoChange" v-model="ruleForm.yonghuzhanghao" placeholder="请选择用户账号">
						<el-option
							v-for="(item,index) in yonghuzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yonghuzhanghao" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="食物名称" prop="shiwumingcheng" >
					<el-input v-model="ruleForm.shiwumingcheng" placeholder="食物名称" clearable  :readonly="ro.shiwumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="食物名称" prop="shiwumingcheng" >
					<el-input v-model="ruleForm.shiwumingcheng" placeholder="食物名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="食物分类" prop="shiwufenlei" >
					<el-select :disabled="ro.shiwufenlei" v-model="ruleForm.shiwufenlei" placeholder="请选择食物分类" >
						<el-option
							v-for="(item,index) in shiwufenleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="食物分类" prop="shiwufenlei" >
					<el-input v-model="ruleForm.shiwufenlei"
						placeholder="食物分类" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.shiwutupian" label="食物图片" prop="shiwutupian" >
					<file-upload
						tip="点击上传食物图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.shiwutupian?ruleForm.shiwutupian:''"
						@change="shiwutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.shiwutupian" label="食物图片" prop="shiwutupian" >
					<img v-if="ruleForm.shiwutupian.substring(0,4)=='http'&&ruleForm.shiwutupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shiwutupian" width="100" height="100">
					<img v-else-if="ruleForm.shiwutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shiwutupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shiwutupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="食物热量" prop="shiwureliang" >
					<el-input v-model="ruleForm.shiwureliang" placeholder="食物热量" clearable  :readonly="ro.shiwureliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="食物热量" prop="shiwureliang" >
					<el-input v-model="ruleForm.shiwureliang" placeholder="食物热量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="蛋白质" prop="danbaizhi" >
					<el-input v-model="ruleForm.danbaizhi" placeholder="蛋白质" clearable  :readonly="ro.danbaizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="蛋白质" prop="danbaizhi" >
					<el-input v-model="ruleForm.danbaizhi" placeholder="蛋白质" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="食物脂肪" prop="shiwuzhifang" >
					<el-input v-model="ruleForm.shiwuzhifang" placeholder="食物脂肪" clearable  :readonly="ro.shiwuzhifang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="食物脂肪" prop="shiwuzhifang" >
					<el-input v-model="ruleForm.shiwuzhifang" placeholder="食物脂肪" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="碳水化合物" prop="tanshuihuahewu" >
					<el-input v-model="ruleForm.tanshuihuahewu" placeholder="碳水化合物" clearable  :readonly="ro.tanshuihuahewu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="碳水化合物" prop="tanshuihuahewu" >
					<el-input v-model="ruleForm.tanshuihuahewu" placeholder="碳水化合物" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="饮食量" prop="yinshiliang" >
					<el-input v-model="ruleForm.yinshiliang" placeholder="饮食量" clearable  :readonly="ro.yinshiliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="饮食量" prop="yinshiliang" >
					<el-input v-model="ruleForm.yinshiliang" placeholder="饮食量" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="定制时间" prop="dingzhishijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.dingzhishijian" 
						type="date"
						:readonly="ro.dingzhishijian"
						placeholder="定制时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.dingzhishijian" label="定制时间" prop="dingzhishijian" >
					<el-input v-model="ruleForm.dingzhishijian" placeholder="定制时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="营养师账号" prop="yingyangshizhanghao" >
					<el-input v-model="ruleForm.yingyangshizhanghao" placeholder="营养师账号" clearable  :readonly="ro.yingyangshizhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="营养师账号" prop="yingyangshizhanghao" >
					<el-input v-model="ruleForm.yingyangshizhanghao" placeholder="营养师账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="营养师姓名" prop="yingyangshixingming" >
					<el-input v-model="ruleForm.yingyangshixingming" placeholder="营养师姓名" clearable  :readonly="ro.yingyangshixingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="营养师姓名" prop="yingyangshixingming" >
					<el-input v-model="ruleForm.yingyangshixingming" placeholder="营养师姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="定制详情" prop="dingzhixiangqing" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.dingzhixiangqing" 
					class="editor"
					myQuillEditor="dingzhixiangqing"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.dingzhixiangqing" label="定制详情" prop="dingzhixiangqing" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.dingzhixiangqing"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
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
				shiwufenleiOptions: [],

				rules: {
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					shiwumingcheng: [
					],
					shiwufenlei: [
					],
					shiwutupian: [
					],
					shiwureliang: [
					],
					danbaizhi: [
					],
					shiwuzhifang: [
					],
					tanshuihuahewu: [
					],
					yinshiliang: [
					],
					dingzhishijian: [
					],
					dingzhixiangqing: [
					],
					yingyangshizhanghao: [
					],
					yingyangshixingming: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.dingzhishijian = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.shiwutupian = obj[o];
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
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.yingyangshizhanghao!=''&&json.yingyangshizhanghao) || json.yingyangshizhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yingyangshizhanghao = json.yingyangshizhanghao
							this.ro.yingyangshizhanghao = true;
						}
						if(((json.yingyangshixingming!=''&&json.yingyangshixingming) || json.yingyangshixingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yingyangshixingming = json.yingyangshixingming
							this.ro.yingyangshixingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/yonghu/yonghuzhanghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.yonghuzhanghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/shiwufenlei/shiwufenlei`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.shiwufenleiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			yonghuzhanghaoChange () {
				this.$http({
					url: `follow/yonghu/yonghuzhanghao?columnValue=`+ this.ruleForm.yonghuzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yonghuxingming){
							this.ruleForm.yonghuxingming = data.data.yonghuxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `yinshidingzhi/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.dingzhixiangqing = this.ruleForm.dingzhixiangqing.replace(reg,'../../../springbootltn8n5j0/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.shiwutupian!=null) {
						this.ruleForm.shiwutupian = this.ruleForm.shiwutupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `yinshidingzhi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.yinshidingzhiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.yinshidingzhiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			shiwutupianUploadChange(fileUrls) {
				this.ruleForm.shiwutupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		padding: 40px 30px;
		background: #fff;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #6e6e6e;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 15px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #7841f0;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #39c9ee;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #9e46d1;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #70478e;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #b49be2;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
