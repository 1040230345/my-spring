package test.java.cn.springframework.test.bean;

public class UserService {

    private GoodsService goodsService;

    private String name;

    public void queryUserInfo(){
        System.out.println(name+":查询用户信息");
    }

    UserService(String name){
        this.name = name;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
