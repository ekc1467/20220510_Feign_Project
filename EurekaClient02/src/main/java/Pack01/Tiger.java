package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tiger {
	
	@RequestMapping("/")// 루트경로
	public String f0() {
		System.out.println("f0 call");// 메인하면 들어왔다를 알려줌
		
		return "index" ;// 타이거 뷰로 간다.
	}
	
	
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "TigerView" ;// 타이거 뷰로 간다.
		//return "redirect:/"; // 루트경로로 가라
		
	}
}



@RestController
@RequestMapping("/app/500")
class AppController01{
	@GetMapping("")
	public String f1() {
		System.out.println(1000);
		
		return "정상";
		
	}
}


@RestController
@RequestMapping("/app/2000")
class AppController02{
	@GetMapping("")
	public String f1() {
		System.out.println(1000);
		
		try { Thread.sleep(2000); } catch (Exception e) { e.printStackTrace(); }
		return "장애";
		
	}
}