package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableDiscoveryClient==@EnableZuulProxy
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulFeignPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulFeignPjtApplication.class, args);
	}

}
