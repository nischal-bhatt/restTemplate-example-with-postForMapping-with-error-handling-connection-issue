package com.example.demoporject;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nricController {

	@Autowired
	nricService NricService;
	
	@PostMapping("/business-registrations")
	public ResultCode checkMedisave(@RequestBody RequestReturn requestReturn) throws URISyntaxException
	{
		ReturnFromCpf a =this.NricService.sendMedisave(requestReturn.getNrics());
		//print(requestReturn.getLodgerId());
		//print(requestReturn.getNrics());
		
		ResultCode ab = new ResultCode();
		if (a!= null)
		{
		ab.setC(a.getX());
		}else
		{
			ab.setError("cannot connect la dude");
		}
		return ab;
	}

	private void print(List<String> nrics) {
		for (int i =0; i<nrics.size(); i++)
		{
			System.out.println(nrics.get(i));
		}
		
	}

	private void print(String lodgerId) {
		System.out.println(lodgerId);
		
	}
}
