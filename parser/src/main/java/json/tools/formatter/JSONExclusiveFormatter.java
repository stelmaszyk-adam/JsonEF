package json.tools.formatter;

import java.util.EnumSet;

public class JSONExclusiveFormatter extends JSONFormatter {

    private EnumSet<FormatterFlags> formatterFlags;

    public JSONExclusiveFormatter(JSONReader reader, EnumSet<FormatterFlags> flags) {
        super(reader);
        formatterFlags = flags;
    }

    private String format(String json) {
        // TODO: formatting
        return json;
    }

    @Override
    public String read(String json) {
        json = jsonReader.read(json);
        return format(json);
    }

}
