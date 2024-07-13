package designPattern.lld.oms;

import designPattern.lld.oms.user.User;

import java.util.List;

public class UserController {
    List<User> userList;

    public UserController(List<User> userList){
        this.userList=userList;
    }

    public User getUser(int userId){
        return userList.get(userId);
    }


}
