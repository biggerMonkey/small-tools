package pers.hwj.small.tools.translate.utils;

import pers.hwj.small.tools.translate.enums.LanguageTypeEnum;
import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:01
 * @description:
 */
public class TranslateRequest {
    private LanguageTypeEnum from;
    private LanguageTypeEnum to;
    private String content;
    private TranslateSourceEnum translateSourceEnum;

    public LanguageTypeEnum getFrom() {
        return from;
    }

    public void setFrom(LanguageTypeEnum from) {
        this.from = from;
    }

    public LanguageTypeEnum getTo() {
        return to;
    }

    public void setTo(LanguageTypeEnum to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TranslateSourceEnum getTranslateSourceEnum() {
        return translateSourceEnum;
    }

    public void setTranslateSourceEnum(TranslateSourceEnum translateSourceEnum) {
        this.translateSourceEnum = translateSourceEnum;
    }
}
