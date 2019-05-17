package binbinlau.plane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaneApplication {

	protected final static Log logger = LogFactory.getLog(PlaneApplication.class);

	public static void main(String[] args) {
		logger.info("开始启动springboot项目");
		SpringApplication.run(PlaneApplication.class, args);
	}
}
