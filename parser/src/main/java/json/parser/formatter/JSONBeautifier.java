package json.parser.formatter;

/**
 * A <code>JSONBeautifier</code> adds formatting functionality to another JSON reader.
 * Specifically, it allows an input JSON string to be read
 * and formatted for readability.
 *
 * @author Agere98
 * @version 0.1
 * @since 0.1
 */
public class JSONBeautifier extends JSONFormatter {

    /**
     * Creates a <code>JSONBeautifier</code>
     * and stores its argument, reader, for functionality extension.
     *
     * @param reader the underlying JSON reader.
     */
    public JSONBeautifier(JSONReader reader) {
        super(reader);
    }

    /**
     * Reads a JSON string and returns its formatted representation.
     * Transforms the input JSON to a form that is more readable by humans
     * (for example by inserting spaces or splitting lines).
     * The resulting string is formatted as follows:
     * TODO: specify the format of output string
     *
     * @return formatted JSON string.
     */
    @Override
    public String read() {
        return null;
    }
}
