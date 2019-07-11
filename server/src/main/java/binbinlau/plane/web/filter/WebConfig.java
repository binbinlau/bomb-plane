package binbinlau.plane.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册 filter
 * @Author LiuBin
 * @Date 2019/5/28  16:04
 * @Param
 * @return
 **/
@Configuration
public class WebConfig {

    Logger logger = LoggerFactory.getLogger(WebConfig.class);
    @Autowired
    private WebFilter webFilter;

    @Bean
    public FilterRegistrationBean init() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(webFilter);
        filterRegistrationBean.setName("WebFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

//    @Bean
//    public ServletListenerRegistrationBean getListenerBean() {
//        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
////        bean.setListener();
//        return bean;
//    }

}
