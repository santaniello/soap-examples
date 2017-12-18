package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return itensResultado;
	}

	@WebMethod(operationName="CadastrarItem") 
	@WebResult(name="item")
	public Item cadastrarItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, @WebParam(name="item") Item item) throws AutorizacaoException {
	  System.out.println("Cadastrando " + item + ", " + token);//imprimindo o token tbm
	  
      //novo
	  boolean valido = new TokenDao().ehValido(token); //o que faremos se o token for invalido? 

	  if(!valido) {
		  throw new AutorizacaoException("Token invalido");
	  }
	  
	  this.dao.cadastrar(item);
	  return item;
	}

}
