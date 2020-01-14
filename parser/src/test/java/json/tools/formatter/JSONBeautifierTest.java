package json.tools.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JSONBeautifierTest {

    private JSONFormatter formatter;
    @Mock
    private JSONReader reader;

    @BeforeEach
    void setUp() {
        reader = mock(JSONReader.class);
        when(reader.read(anyString())).thenAnswer(i -> i.getArguments()[0]);
        formatter = new JSONBeautifier(reader);
    }

    @Test
    void testReadMinimized() {
        String json = "{\"a\":\"bc\",\"d\":34}";
        String formatted = "{\n" +
                "  \"a\" : \"bc\",\n" +
                "  \"d\" : 34\n" +
                "}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
    }

    @Test
    void testReadBeautified() {
        String json = "{\n" +
                "  \"a\" : \"bc\",\n" +
                "  \"d\" : 34\n" +
                "}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(json, result);
    }

    @Test
    void testReadMixed() {
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\n" +
                "  \"a\" : \"bc\",\n" +
                "  \"d\" : 34\n" +
                "}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
    }

    @Test
    void testReadNull() {
        assertThrows(IllegalArgumentException.class, () -> formatter.read(null));
    }

    @Test
    void testReadInvalidJSON() {
        String json = "json";
        assertThrows(IllegalArgumentException.class, () -> formatter.read(json));
    }

    @Test
    void testInternalReaderReadCall() {
        String json = "{}";
        formatter.read(json);
        verify(reader, times(1)).read(anyString());
    }

}