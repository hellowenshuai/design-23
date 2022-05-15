package org.example.D06_decorator.passport.old;

/**
 * Created by Tom on 2018/3/17.
 */
public interface ISigninService {
    public ResultMsg regist(String username, String password);


    public ResultMsg login(String username, String password);
}
