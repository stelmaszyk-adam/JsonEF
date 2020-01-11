package json.tools.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class JSONMinifierTest {

    private JSONFormatter formatter;
    @Mock
    private JSONReader reader;

    @BeforeEach
    void setUp() {
        reader = mock(JSONReader.class);
        when(reader.read(anyString())).thenAnswer(i -> i.getArguments()[0]);
        formatter = new JSONMinifier(reader);
    }

    @Test
    void testReadMinimized() {
        String json = "{\"a\":\"bc\",\"d\":34}";
        String result = formatter.read(json);
        assertEquals(json, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadBeautified() {
        String json = "{\n" +
                "  \"a\" : \"bc\",\n" +
                "  \"d\" : 34\n" +
                "}";
        String formatted = "{\"a\":\"bc\",\"d\":34}";
        String result = formatter.read(json);
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadMixed() {
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\"a\":\"bc\",\"d\":34}";
        String result = formatter.read(json);
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
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

}