package json.parser.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequestMapping
@Slf4j
@RestController
public class Controller {

    private ObjectMapper objectMapper;

    @Autowired
    public Controller(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @PostMapping(path = "extend", produces = "application/json")
    public JsonNode deminify(@RequestBody String json) throws IOException {

        return objectMapper.readTree(json);
    }

    @PostMapping(path = "minimize", consumes = "application/json")
    public String minify(@RequestBody String json) throws IOException {

        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.toString();
    }
}
