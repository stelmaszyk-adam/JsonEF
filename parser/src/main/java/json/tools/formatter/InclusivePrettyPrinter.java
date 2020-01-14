package json.tools.formatter;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import java.util.EnumSet;

public class InclusivePrettyPrinter extends DefaultPrettyPrinter {
    public InclusivePrettyPrinter(EnumSet<FormatterFlags> formatterFlags) {
        super();
        String indents = "";
        String newline = "";
        String spaceBeforeColon = "";
        String spaceAfterColon = "";
        if(formatterFlags.contains(FormatterFlags.INDENTS)) indents = "  ";
        if(formatterFlags.contains(FormatterFlags.LINE_BREAKS)) newline = DefaultIndenter.SYS_LF;
        if(formatterFlags.contains(FormatterFlags.SPACES_BEFORE_COLON)) spaceBeforeColon = " ";
        if(formatterFlags.contains(FormatterFlags.SPACES_AFTER_COLON)) spaceAfterColon = " ";

        _objectFieldValueSeparatorWithSpaces = spaceBeforeColon + _separators.getObjectFieldValueSeparator() + spaceAfterColon;
        _objectIndenter = new DefaultIndenter(indents, newline);
    }
}
