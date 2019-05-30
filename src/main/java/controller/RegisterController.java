package controller;


import db.dbHelper;
import model.registerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/QRApp")
public class RegisterController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/registerOperation",method = {RequestMethod.POST,RequestMethod.GET})
    public String registerOperation(HttpServletResponse response, registerInfo register){

        //log.info("车主名"+register.getOwnerName()+"车辆类型"+register.getCarType());
        dbHelper db= new dbHelper();
        if(db.insertInfo(register))
            return "login";
        return "register";
    }
}
