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
 *  login filter
 * @Author LiuBin
 * @Date 2019/5/28  16:14
 * @Param
 * @return
 **/
@Component
public class LoginFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Login 过滤器");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Login init 过滤器");
    }
}
