package com.samsam.bsl.popularbookpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ppBookPageController {

	@GetMapping("/popularBookPage")
	@ResponseBody
	public String main() {
		
		return "Hello World";
	}
	
}
