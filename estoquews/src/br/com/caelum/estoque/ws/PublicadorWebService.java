package br.com.caelum.estoque.ws;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

public class PublicadorWebService {	
	
	public static void main(String[] args) {
		  try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			EstoqueWS service = new EstoqueWS();
			String url = "http://"+ip.getHostAddress()+":8080/estoquews";		
			System.out.println("Servico rodando " + url + "?wsdl");				
			Endpoint.publish(url, service); 

		  } catch (UnknownHostException e) {
			  e.printStackTrace();
		  }
	}
}
