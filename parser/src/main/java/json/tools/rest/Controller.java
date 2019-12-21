package json.tools.rest;

import com.fasterxml.jackson.databind.JsonNode;
import json.tools.diffutil.TextDiff;
import json.tools.formatter.JSONBaseReader;
import json.tools.formatter.JSONBeautifier;
import json.tools.formatter.JSONMinifier;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RequestMapping
@Slf4j
@RestController
public class Controller {


    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping(path = "/beautify", consumes = "application/json", produces = "application/json")
    public String beautify(@RequestBody String json) throws IOException {
        String result = new JSONBeautifier(new JSONBaseReader()).read(json);
        logger.info("Beautify");
        logger.debug(result);
        return result;
    }

    @PostMapping(path = "/minify", consumes = "application/json", produces = "application/json")
    public String minify(@RequestBody String json) throws IOException {
        String result = new JSONMinifier(new JSONBaseReader()).read(json);
        logger.info("Minify");
        logger.debug(result);
        return result;
    }

    @PostMapping(path = "/diff", consumes = "application/json")
    public String diff(@RequestBody Map<String, JsonNode> json) throws IOException {
        String result = TextDiff.diff(json.get("key1").toString(), json.get("key2").toString());
        logger.debug(result);
        return result;
    }
}
