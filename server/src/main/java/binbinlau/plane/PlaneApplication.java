package binbinlau.plane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan("binbinlau.plane")
@MapperScan("binbinlau.plane.xo.dao")
public class PlaneApplication {

	protected final static Log logger = LogFactory.getLog(PlaneApplication.class);

	public static void main(String[] args) {
		logger.info("开始启动springboot项目");
		SpringApplication.run(PlaneApplication.class, args);
		logger.info("springboot项目初始化成功");
	}
}
