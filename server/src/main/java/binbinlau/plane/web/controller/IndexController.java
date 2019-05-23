package binbinlau.plane.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  首页控制器
 * @Author LiuBin
 * @Date 2019/5/21  16:33
 * @Param
 * @return
 **/
//@RestController  //如果是写接口可以直接使用该注释，返回json字符串，不需要在方法上加 "@ResponseBody"
@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     *  测试首页接口
     * @Author LiuBin
     * @Date 2019/5/21  16:45
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        logger.info("start enter index controller!");
        return "hello word";
    }
}
