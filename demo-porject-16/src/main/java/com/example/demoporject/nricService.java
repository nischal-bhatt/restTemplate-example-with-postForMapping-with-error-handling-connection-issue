package com.example.demoporject;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class nricService {

	
	private RestTemplate restTemplate = new RestTemplate();
	
	public ReturnFromCpf sendMedisave(List<String> nrics) throws URISyntaxException
	{
		print();
		print(nrics);
		URI uri = new URI("http://localhost:8081/checkMedisave");
		SendToMedisave a = new SendToMedisave();
		a.setNrics(nrics);
		
		HttpEntity<SendToMedisave> httpEntity = new HttpEntity<>(a);
		ReturnFromCpf aab = null;
		
		try {
		 aab =this.restTemplate.postForObject(uri, httpEntity, ReturnFromCpf.class);
		}catch (RestClientException e)
		{
		   System.out.println("well damn shit");	
		}
		
		System.out.println("printing in 16");
		if (aab != null) {
		System.out.println(aab.getX());
		}
		return aab;
	}
	
	private void print(List<String> nrics) {
		for (int i =0; i<nrics.size(); i++)
		{
			System.out.println(nrics.get(i));
		}
		
	}

	private void print()
	{
		System.out.println("inside service method");
	}
}
