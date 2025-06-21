const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootp89xk/",
            name: "springbootp89xk",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootp89xk/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "家乡特色推荐系统"
        } 
    }
}
export default base
