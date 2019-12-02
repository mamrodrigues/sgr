package br.com.sgr.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.sgr.domain.Endereco;

public class EnderecoDeserealizer extends JsonDeserializer<Endereco> {

	@Override
	public Endereco deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = p.getCodec().readTree(p);
		
		int id =  node.get("endereco").get("enderecoId").asInt();
		
		Endereco endereco = new Endereco();
		endereco.setEnderecoId(id);
				
		return endereco;
	}
}