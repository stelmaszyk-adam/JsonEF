package json.tools.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONBaseReaderTest {

    private JSONReader reader;

    @BeforeEach
    void setUp() {
        reader = new JSONBaseReader();
    }

    @Test
    void testRead() {
        String json = "some test string";
        String result = reader.read(json);
        assertEquals(json, result);
    }

    @Test
    void testReadNull() {
        String result = reader.read(null);
        assertNull(result);
    }

}
