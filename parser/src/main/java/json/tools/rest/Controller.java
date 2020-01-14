package json.tools.rest;

import com.fasterxml.jackson.databind.JsonNode;
import json.tools.diffutil.TextDiff;
import json.tools.formatter.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;


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

    @PostMapping(path = "/exclusive", consumes = "application/json", produces = "application/json")
    public String exclusiveFormat(@RequestBody Map<String, JsonNode> json) throws IOException {
        String flagstr = json.get("formatflags").toString();
        String data = json.get("data").toString();

        EnumSet<FormatterFlags> formatterFlags = EnumSet.copyOf(Arrays.asList(flagstr.split(","))
                .stream().map(FormatterFlags::valueOf).collect(Collectors.toList()));

        String result = new JSONExclusiveFormatter(new JSONBaseReader(), formatterFlags).read(data);
        logger.info("Exclusive Format");
        logger.debug(result);
        return result;
    }

    @PostMapping(path = "/inclusive", consumes = "application/json", produces = "application/json")
    public String inclusiveFormat(@RequestBody Map<String,  JsonNode> json) throws IOException {
        String flagstr = json.get("formatflags").toString();
        String data = json.get("data").toString();

        EnumSet<FormatterFlags> formatterFlags = EnumSet.copyOf(Arrays.asList(flagstr.split(","))
        .stream().map(FormatterFlags::valueOf).collect(Collectors.toList()));

        String result = new JSONExclusiveFormatter(new JSONBaseReader(), formatterFlags).read(data);
        logger.info("Inclusive Format");
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
