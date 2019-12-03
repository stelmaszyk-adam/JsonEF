package json.parser.diffutil;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.Patch;

import java.util.Arrays;
import java.util.List;


public class TextDiff {
    public static String diff(String text1, String text2) {
        try {
            List<String> lines1 = Arrays.asList(text1.split("\\r?\\n"));
            List<String> lines2 = Arrays.asList(text2.split("\\r?\\n"));
            Patch<String> diff = DiffUtils.diff(lines1, lines2);
            List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("text1", "text2", lines1, diff, 0);
            return String.join("\r\n", unifiedDiff);
        } catch (DiffException e)  {
            throw new IllegalStateException("Error applying diff");
        }
    }
}
