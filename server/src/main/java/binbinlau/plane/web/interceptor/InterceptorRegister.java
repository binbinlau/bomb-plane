package binbinlau.plane.web.interceptor;

import binbinlau.plane.web.interceptor.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author LiuBin
 * @Date 2019/7/11 14:16
 **/
@Component
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    Author author;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(author);
    }
}
