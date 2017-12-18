package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	
	@SuppressWarnings("unused")
	private Date dataErro;
	@SuppressWarnings("unused")
	private String mensagem;
	
	@SuppressWarnings("unused")
	private InfoFault() {}
	
	public InfoFault(Date dataErro, String mensagem) {
		this.dataErro = dataErro;
		this.mensagem = mensagem;
	}
	
	
	

}
