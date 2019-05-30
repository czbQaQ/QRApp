package controller;

import db.dbHelper;
import model.carInfo;
import model.loginInfo;
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
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginOperation",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView loginOperation(HttpServletRequest request, loginInfo login){

        carInfo car;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        if(login.getCarID()==null||login.getPass()==null)
            return mv;
        dbHelper db = new dbHelper();
        //判断用户是否存在
        if(db.isExist(login)) {
            //进行车辆信息查询
            car=db.selectCarInfo(login.getCarID());
            log.info(car.getCarID()+" "+car.getOwnerName()+" "+car.getCarType());
            mv.addObject("carID",car.getCarID());
            mv.addObject("ownerName",car.getOwnerName());
            mv.addObject("carType",car.getCarType());
            mv.addObject("carColor",car.getCarColor());
            mv.addObject("engineID",car.getEngineID());
            mv.setViewName("display");
            HttpSession session = request.getSession();
            session.setAttribute("car",car);
            return mv;
        }
        return mv;
    }
}
