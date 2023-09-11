package pers.hwj.small.tools.charConverter;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: huangwenjun16
 * @date: 2023/9/11 15:44
 * @description:
 */
public class CharConvertUtils {
    private final static char UNICORN_UNDERLINE = '_';
    private final static char UNICORN_SPACE = ' ';

    private final static String LINE_FEED = "\n";

    public static String smallHump(String input) {
        return commonHump(input, 2);
    }

    public static String bigHump(String input) {
        return commonHump(input, 1);
    }

    public static String commonHump(String input, int mode) {
        String inputStr = StringUtils.trim(input);
        if (StringUtils.isEmpty(inputStr)) {
            return "";
        }
        inputStr = inputStr.replaceAll(" +", " ");
        String[] inputArr = inputStr.split(LINE_FEED);
        StringBuilder sb = new StringBuilder(inputStr.length());
        for (String tempStr : inputArr) {
            int len = tempStr.length();
            for (int i = 0; i < len; i++) {
                if (mode == 1 && i == 0) {
                    sb.append(Character.toUpperCase(inputStr.charAt(i)));
                    continue;
                }
                char c = Character.toLowerCase(tempStr.charAt(i));
                if (c == UNICORN_UNDERLINE || c == UNICORN_SPACE) {
                    if (++i < len) {
                        sb.append(Character.toUpperCase(tempStr.charAt(i)));
                    }
                } else {
                    sb.append(c);
                }
            }
            sb.append(LINE_FEED);
        }
        return sb.toString();
    }

    public static String changeUnderline(String input) {
        String inputStr = StringUtils.trim(input);
        if (StringUtils.isEmpty(inputStr)) {
            return "";
        }
        inputStr = inputStr.replaceAll(" +", " ");
        Pattern TPATTERN = Pattern.compile("[A-Z0-9\\s]");
        Matcher matcher = TPATTERN.matcher(inputStr);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        inputStr = StringUtils.removeStart(sb.toString(), "_");
        return StringUtils.deleteWhitespace(inputStr);
    }
}
