package json.tools.formatter;

import java.util.EnumSet;

public enum FormatterFlags {
    LINE_BREAKS,
    INDENTS,
    SPACES_BEFORE_COLON,
    SPACES_AFTER_COLON;

    public static final EnumSet<FormatterFlags> NONE = EnumSet.noneOf(FormatterFlags.class);
    public static final EnumSet<FormatterFlags> ALL = EnumSet.allOf(FormatterFlags.class);
}
