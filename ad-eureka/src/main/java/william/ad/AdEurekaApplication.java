package william.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/2/16 10:26
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class AdEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdEurekaApplication.class,args);
    }
}
