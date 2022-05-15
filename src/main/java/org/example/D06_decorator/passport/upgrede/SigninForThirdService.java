package org.example.D06_decorator.passport.upgrede;


import org.example.D06_decorator.passport.old.ISigninService;
import org.example.D06_decorator.passport.old.ResultMsg;

/**
 * Created by Tom on 2018/3/17.
 */
public class SigninForThirdService implements ISigninForThirdService {

    private ISigninService service;
    public SigninForThirdService(ISigninService service){
        this.service = service;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        System.out.println("开始注册");
        return service.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        System.out.println("开始登录");
        return service.login(username,password);
    }

    @Override
    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }
    @Override
    public ResultMsg loginForWechat(String openId){
        return null;
    }
    @Override
    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }
    @Override
    public ResultMsg loginForTelphone(String telphone,String code){

        return null;
    }
    @Override
    public ResultMsg loginForRegist(String username,String password){
        this.regist(username,null);
        return this.login(username,null);
    }

}
