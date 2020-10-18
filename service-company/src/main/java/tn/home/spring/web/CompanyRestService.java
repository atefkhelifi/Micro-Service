package tn.home.spring.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CompanyRestService {

	@Value("${xParam}")
	private int xParam;
	@Value("${yParam}")
	private int yParam;
	
	@GetMapping("/myConfig")
	public Map<String, Object> myConfig(){
		Map<String, Object> params=new HashMap<>();
		params.put("xParam",xParam);
		params.put("yParam",yParam);
		params.put("threadName",Thread.currentThread().getName());
		return params;
	}
}
