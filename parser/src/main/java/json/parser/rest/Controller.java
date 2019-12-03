package json.parser.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.parser.formatter.JSONReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequestMapping
@Slf4j
@RestController
public class Controller {

    private final JSONReader jsonReader;

    @Autowired
    public Controller(@Qualifier("JSONReader") JSONReader jsonReader){
        this.jsonReader = jsonReader;
    }

    @PostMapping(path = "beautifier", produces = "application/json")
    public JsonNode deminify(@RequestBody String json) throws IOException {

        return jsonReader.read(json);
    }

    @PostMapping(path = "minify", consumes = "application/json")
    public String minify(@RequestBody String json) throws IOException {

        JsonNode jsonNode = jsonReader.read(json);
        return jsonNode.toString();
    }

    @PostMapping(path = "diff", consumes = "application/json")
    public String diff(@RequestBody String json) throws IOException {


        return "";
    }
}
