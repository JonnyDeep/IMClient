package utils;

import Entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public int loginDB(User user) throws ClassNotFoundException,SQLException,Exception
    {
        Connection con = DBManager.getConnection();
        String sql = "select * from imdb.usertable where name = ? and password = ?";
        PreparedStatement psm = con.prepareStatement(sql);
        psm.setString(1,user.getName());
        psm.setString(2,MD5.md5(user.getPassword()));
        ResultSet rst = psm.executeQuery();
        if((rst.next())){
            System.out.println("name:"+rst.getString(2)+" password:"+rst.getString(3));
            rst.close();
            psm.close();
            return SystemValue.LOGINSUCCESS;
        }

        sql = "select * from imdb.usertable where name = ?";
        psm = con.prepareStatement(sql);
        psm.setString(1,user.getName());
        rst = psm.executeQuery();
        if(!rst.next()){
            rst.close();
            psm.close();
            return SystemValue.LOGIN_NAME_ERROR;
        }


        if(rst!=null)
            rst.close();
        if(psm!=null)
            psm.close();
        return SystemValue.LOGIN_PASSWORD_ERROR;


    }

}
