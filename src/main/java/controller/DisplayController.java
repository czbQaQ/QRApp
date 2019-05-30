package controller;


import db.dbHelper;
import function.QRCodeUtil;
import model.carInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/QRApp")
public class DisplayController {

    private static Logger log = LoggerFactory.getLogger(DisplayController.class);

    @RequestMapping(value = "/display",method = RequestMethod.GET)
    public String display(){
        return "display";
    }

    @RequestMapping(value = "/displayOperation",method = RequestMethod.POST)
    public ModelAndView displayOperation(HttpServletRequest request, HttpServletResponse response, String selectBtn){

        HttpSession session=request.getSession();
        carInfo car= (carInfo) session.getAttribute("car");
        dbHelper db =new dbHelper();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("display");
        mv.addObject("carID",car.getCarID());
        mv.addObject("ownerName",car.getOwnerName());
        mv.addObject("carType",car.getCarType());
        mv.addObject("carColor",car.getCarColor());
        mv.addObject("engineID",car.getEngineID());
        log.info("selectBtn"+selectBtn);

        if(selectBtn.equals("生成二维码")){

            String comment="车牌号:"+car.getCarID()+
                    " 车主:"+car.getOwnerName()+
                    " 车辆类型:"+car.getCarType()+
                    " 颜色:"+car.getCarColor()+
                    " 发动机编号:"+car.getEngineID();
            try {
                ServletOutputStream stream = response.getOutputStream();
                QRCodeUtil.encode(comment,stream);
                mv.setViewName("success");
                //QRCodeUtil.encode(comment,"E:\\");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mv;
        }
        else if(selectBtn.equals("注销")){
            boolean isExec = false;
            isExec = db.delCarInfo(car.getCarID());
            if(isExec){
                mv.clear();
                mv.setViewName("login");
                return mv;
            }
        }else if(selectBtn.equals("修改密码")){
            mv.setViewName("updatePass");
            return mv;
        }
        return mv;
    }
}
