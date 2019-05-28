package binbinlau.plane.web.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 *  web filter
 * @Author LiuBin
 * @Date 2019/5/28  16:00
 * @Param
 * @return
 **/
@Component
public class WebFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("网站过滤器");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("网站过滤器 init 方法");
    }

}
