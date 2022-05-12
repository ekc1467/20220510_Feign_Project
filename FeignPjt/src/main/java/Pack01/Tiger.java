package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.DefaultFeignLoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import feign.hystrix.FallbackFactory;

@Controller
public class Tiger {

	@RequestMapping("/") // 루트경로
	public String f0() {
		System.out.println("f0 call");// 메인하면 들어왔다를 알려줌

		return "index";// 타이거 뷰로 간다.
	}

	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");

		return "TigerView";// 타이거 뷰로 간다.
		// return "redirect:/"; // 루트경로로 가라

	}
}

//
//@FeignClient(name="tiger01",url="http://localhost:8765")// 내가 접근할곳 
//interface TestClient01{
//	@RequestMapping("/app/{status}")
//	String myfunc1(@PathVariable("status") int status); // 이 함수가 호출되면 해당url로 간다.
//	
//}
//
//
//@RestController
//class AppController01 {
//	@Autowired// 이거 해버리면 인터페이스 객체가 자동주입이 돤다.
//	TestClient01 testClient;
//	
//	@RequestMapping("/app2/{n}")
//	public String f1(@PathVariable String n) {
//		System.out.println("f1");
//		String str = testClient.myfunc1(Integer.parseInt(n));
//		
//		return "Test01"+str;
//	}
//	
//}

@FeignClient(name = "service01", url = "http://localhost:8765", fallbackFactory = FeignFactory.class) // 페인팩토리안에 들어있는
																										// 클래스
interface TestClient2 {
	@RequestMapping("/app/{num}")
	String myfunc1(@PathVariable("num") String num);
}

@Component
class FeignFactory implements FallbackFactory<TestClient2> {
	@Override
	public TestClient2 create(Throwable cause) {
		System.out.println("factory");
		return new TestClient2() {
			@Override
			public String myfunc1(String num) {
				return "오류 발생";
			}
		};
	}
}

@RestController
class AppController01 {
	@Autowired // 이거 해버리면 인터페이스 객체가 자동주입이 돤다.
	TestClient2 testClient;

	@RequestMapping("/app2/{num}")
	public String f1(@PathVariable String num) {
		System.out.println("f1");
		String str = testClient.myfunc1(num);

		return "Test02" + str;
	}
}




@FeignClient(name = "service02", url = "http://localhost:8765") // 내가 접근할곳
interface TestClient02 {
	@RequestMapping("/bpp")
	String myfunc(); // 이 함수가 호출되면 해당url로 간다.
}

@RestController
class AppController02 {
	@Autowired // 이거 해버리면 인터페이스 객체가 자동주입이 돤다.
	TestClient02 testClient;

	@RequestMapping("/bpp2")
	public String f2() {
		System.out.println("f2");
		String str = testClient.myfunc();

		return "Test02" + str;
	}
}
