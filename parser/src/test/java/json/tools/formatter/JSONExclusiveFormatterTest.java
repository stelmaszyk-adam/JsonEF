package json.tools.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class JSONExclusiveFormatterTest {

    private JSONFormatter formatter;
    @Mock
    private JSONReader reader;

    @BeforeEach
    void setUp() {
        reader = mock(JSONReader.class);
        when(reader.read(anyString())).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    void testReadWithIndentsRemoved() {
        formatter = new JSONExclusiveFormatter(reader, EnumSet.of(FormatterFlags.INDENTS));
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\n" +
                "\"a\":\"bc\", \n" +
                "\"d\": 34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadWithLineBreaksAndIndentsRemoved() {
        formatter = new JSONExclusiveFormatter(reader, EnumSet.of(FormatterFlags.LINE_BREAKS, FormatterFlags.INDENTS));
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\"a\":\"bc\", \"d\": 34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadWithSpacesBeforeColonRemoved() {
        formatter = new JSONExclusiveFormatter(reader, EnumSet.of(FormatterFlags.SPACES_BEFORE_COLON));
        String json = "{\n" +
                "  \"a\" :\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadWithSpacesAfterColonRemoved() {
        formatter = new JSONExclusiveFormatter(reader, EnumSet.of(FormatterFlags.SPACES_AFTER_COLON));
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\":34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadWithAllFlags() {
        formatter = new JSONExclusiveFormatter(reader, FormatterFlags.ALL);
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String formatted = "{\"a\":\"bc\",\"d\":34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(formatted, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadWithNoFlags() {
        formatter = new JSONExclusiveFormatter(reader, FormatterFlags.NONE);
        String json = "{\n" +
                "  \"a\":\"bc\", \n" +
                "  \"d\": 34}";
        String result = formatter.read(json)
                .replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");
        assertEquals(json, result);
        verify(reader, times(1)).read(anyString());
    }

    @Test
    void testReadNull() {
        formatter = new JSONExclusiveFormatter(reader, FormatterFlags.NONE);
        assertThrows(IllegalArgumentException.class, () -> formatter.read(null));
    }

    @Test
    void testReadInvalidJSON() {
        formatter = new JSONExclusiveFormatter(reader, FormatterFlags.NONE);
        String json = "json";
        assertThrows(IllegalArgumentException.class, () -> formatter.read(json));
    }

}