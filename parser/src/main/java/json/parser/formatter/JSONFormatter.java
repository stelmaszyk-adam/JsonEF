package json.parser.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The abstract base class for JSON formatters
 * which allow to format a JSON file while reading it.
 * <code>JSONFormatter</code> incorporates the Decorator pattern
 * to extend the functionality of a <code>JSONReader</code>.
 * <p>
 * An instance of any concrete subclass of <code>JSONFormatter</code>
 * wraps a <code>JSONReader</code> object passed to it in the constructor
 * (possibly another <code>JSONFormatter</code>)
 * and performs its formatting functionality inside its <code>read</code> method.
 *
 * @author Agere98
 * @version 0.1
 * @since 0.1
 */
public abstract class JSONFormatter implements JSONReader {

    /**
     * The reader object that is extended by this formatter.
     */
    protected ObjectMapper objectMapper;

    /**
     * Initializes a <code>JSONFormatter</code>
     * and stores its argument, reader, for functionality extension.
     *
     * @param objectMapper the underlying JSON reader.
     */
    protected JSONFormatter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}

