package db;

import model.carInfo;
import model.loginInfo;
import model.newPass;
import model.registerInfo;

import java.sql.*;

public class dbHelper {

    private static String user ="root";
    private static String pass = "Czb&&123";
    private static String url="jdbc:mysql://39.97.46.221/QRcar?characterEncoding=UTF-8";
    private static String Driver = "com.mysql.jdbc.Driver";

    //查询登录的用户
    public boolean isExist(loginInfo login){

        String sql ="SELECT * FROM car_user";
        try{
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(login.getCarID().equals(rs.getString(1)))
                    if(login.getPass().equals(rs.getString(2)))
                        return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    //用户注册
    public boolean insertInfo(registerInfo regiser){

        String sql1="insert into car_user(carID,password) values(?,?)";
        String sql2="insert into car_info(carID,ownerName,carType,carColor,engineID) values(?,?,?,?,?)";

        if(regiser.getPass().equals(regiser.getRePass())) {
            try {
                Class.forName(Driver);
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setString(1, regiser.getCarID());
                ps1.setString(2, regiser.getPass());
                if(ps1.executeUpdate()!=0){
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1,regiser.getCarID());
                    ps2.setString(2,regiser.getOwnerName());
                    ps2.setString(3,regiser.getCarType());
                    ps2.setString(4,regiser.getCarColor());
                    ps2.setString(5,regiser.getEngineID());
                    if(ps2.executeUpdate()!=0)
                        return true;

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //查询车辆信息
    public carInfo selectCarInfo(String carID){
        carInfo car;

        String sql = "SELECT * FROM car_info where carID='"+carID+"'";
        try {
            //加载驱动
            Class.forName(Driver);
            //连接数据库
            Connection conn = DriverManager.getConnection(url,user,pass);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                car = new carInfo();
                car.setCarID(rs.getString(1));
                car.setOwnerName(rs.getString(2));
                car.setCarType(rs.getString(3));
                car.setCarColor(rs.getString(4));
                car.setEngineID(rs.getString(5));
                return car;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //用户注销
    public boolean delCarInfo(String carID){
        String sql1="DELETE FROM car_info WHERE carID='"+carID+"'";
        String sql2="DELETE FROM car_user WHERE carID='"+carID+"'";

        try {
            //加载驱动
            Class.forName(Driver);
            //连接数据库
            Connection conn = DriverManager.getConnection(url,user,pass);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            if(stmt.executeUpdate(sql1)!=0){
                if(stmt.executeUpdate(sql2)!=0)
                    return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    //密码修改
    public boolean updatePass(String carID, newPass newpass) {
        String sql="UPDATE car_user SET PASSWORD='"+newpass.getNewPass()+"' WHERE carID='"+carID+"'";
        if(newpass.getNewPass().equals(newpass.getReNewPass())) {
            try {
                //加载驱动
                Class.forName(Driver);
                //连接数据库
                Connection conn = DriverManager.getConnection(url, user, pass);
                //创建Statement对象
                Statement stmt = conn.createStatement();
                if (stmt.executeUpdate(sql) != 0) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
