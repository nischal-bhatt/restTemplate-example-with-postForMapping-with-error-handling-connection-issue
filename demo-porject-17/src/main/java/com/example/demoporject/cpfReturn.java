package com.example.demoporject;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cpfReturn {

	@PostMapping("/checkMedisave")
	public ReturnFromCpf checkMedisave(@RequestBody SendToMedisave rr) 
	{
		ReturnFromCpf a = new ReturnFromCpf();
		print(rr);
		Character[] x = new Character[10];
		
		x[0] = 'A';
		x[1] = 'B';
		x[2] = 'C';
		x[3] = 'D';
		x[4] = 'E';
		x[5] = 'F';
		x[6] = 'G';
		x[7] = 'H';
		x[8] = 'I';
		x[9] = 'J';
		
		int x1 = new Random().nextInt(0,10);
		
		a.setX(x[x1]);
		System.out.println(x[x1]);
		return a;
	}

	private void print(SendToMedisave rr) {
	 List<String> nrics = rr.getNrics();
	 
	 for (int i =0; i<nrics.size(); i++)
	 {
		 System.out.println(nrics.get(i));
	 }
		
	}
}
