const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootltn8n5j0/",
            name: "springbootltn8n5j0",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootltn8n5j0/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "个性化健身管理小程序的设计与实现"
        } 
    }
}
export default base
