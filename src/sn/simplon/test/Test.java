package sn.simplon.test;

import sn.simplon.dao.IUser;
import sn.simplon.dao.UserImpl;
import sn.simplon.entities.User;

public class Test {

    public static void main(String[] args){
        IUser userdao = new UserImpl();
        User user = new User();
        user.setNom("Fall");
        user.setPrenom("Fallou");
        user.setEmail("fallfallou@gmail.com");
        user.setPassword("passer");




        int ok = userdao.add(user);
        System.out.println(ok);
    }
}
