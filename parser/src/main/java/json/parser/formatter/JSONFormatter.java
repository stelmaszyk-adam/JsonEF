package json.parser.formatter;

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
public abstract class JSONFormatter extends JSONReader {

    /**
     * The reader object that is extended by this formatter.
     */
    protected  JSONReader reader;

    /**
     * Initializes a <code>JSONFormatter</code>
     * and stores its argument, reader, for functionality extension.
     *
     * @param reader the underlying JSON reader.
     */
    protected JSONFormatter(JSONReader reader) {
        this.reader = reader;
    }
}

