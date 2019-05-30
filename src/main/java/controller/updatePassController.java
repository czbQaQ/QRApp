package controller;

import db.dbHelper;
import model.carInfo;
import model.loginInfo;
import model.newPass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/QRApp")
public class updatePassController {

    private static Logger log = LoggerFactory.getLogger(DisplayController.class);

    @RequestMapping(value = "/updatePass", method = RequestMethod.GET)
    public String display() {
        return "updatePass";
    }

    @RequestMapping(value = "/updatePassOperation", method = RequestMethod.POST)
    public ModelAndView updatePassOperation(HttpServletRequest request, HttpServletResponse response, newPass pass) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updatePass");
        HttpSession session=request.getSession();
        carInfo car= (carInfo) session.getAttribute("car");
        dbHelper db=new dbHelper();
        loginInfo li=new loginInfo();
        li.setCarID(car.getCarID());
        li.setPass(pass.getOldPass());
        if(!(db.isExist(li))){
            mv.clear();
            mv.setViewName("updatePass");
            return mv;
        }
        if(db.updatePass(car.getCarID(),pass)){
            mv.clear();
            mv.setViewName("login");
            return mv;
        }
        log.info("旧密码是："+pass.getOldPass());
        log.info("车牌号是："+car.getCarID());
        return mv;
    }
}
