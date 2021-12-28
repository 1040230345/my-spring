package test.java.cn.springframework.test.bean;

public class UserService {

    private String name;

    public void queryUserInfo(){
        System.out.println(name+":查询用户信息");
    }

    UserService(String name){
        this.name = name;
    }
}
