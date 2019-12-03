package json.parser.rest;

import json.parser.diffutil.TextDiff;
import json.parser.formatter.JSONBaseReader;
import json.parser.formatter.JSONBeautifier;
import json.parser.formatter.JSONMinimizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequestMapping
@Slf4j
@RestController
public class Controller {

    @PostMapping(path = "beautify", produces = "application/json")
    public String beautify(@RequestBody String json) throws IOException {
        return new JSONBeautifier(new JSONBaseReader()).read(json);
    }

    @PostMapping(path = "minify", consumes = "application/json")
    public String minify(@RequestBody String json) throws IOException {
        return new JSONMinimizer(new JSONBaseReader()).read(json);
    }

    @PostMapping(path = "diff", consumes = "application/json")
    public String diff(@RequestBody String json1,@RequestBody String json2) throws IOException {
        return TextDiff.diff(json1, json2);
    }
}
