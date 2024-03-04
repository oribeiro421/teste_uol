package tavin.uol.jogadorcadastro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Getter
public class CodiNameService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;

    private List<String> avangersCodinameList = new ArrayList<>();
    private List<String> justiceLeagueCodinameList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void jsonLoad() throws JsonProcessingException {

            String codiNameResponse = restTemplate.getForObject((Objects.requireNonNull(env.getProperty("avangers"))), String.class);
            JsonNode jsonNode = objectMapper.readTree(codiNameResponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for(JsonNode item: avangers){
                this.avangersCodinameList.add(item.get("codinome").asText());
            }
    }
    @PostConstruct
    public void xmlLoad() throws ParserConfigurationException, IOException, SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));

            NodeList codinameList = document.getElementsByTagName("codinome");

            for(int i = 0; i <codinameList.getLength(); i++) {
                Element codinameElement = (Element) codinameList.item(i);
                String codiname = codinameElement.getTextContent();
                this.justiceLeagueCodinameList.add(codiname);
            }
    }
}
