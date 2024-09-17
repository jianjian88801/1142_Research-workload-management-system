const base = {
    get() {
        return {
            url : "http://localhost:8080/keyangongzuoliang/",
            name: "keyangongzuoliang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/keyangongzuoliang/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "科研工作量管理系统"
        } 
    }
}
export default base
