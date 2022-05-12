package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 유레카 클라이언트 활성화 시키기, 프로그램이 시작ㅈ되면ㄱ서 유레카 클랑이언트가 활성화가 된다.
public class EurekaClient04Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient04Application.class, args);
	}

}
