package pers.hwj.small.tools.translate.enums;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:02
 * @description:
 */
public enum TranslateSourceEnum {
    GOOGLE(1,"谷歌翻译"),
    YOUDAO(2,"有道翻译"),
    BAIDU(3,"百度翻译"),
    ;

    private Integer code;

    private String msg;

    TranslateSourceEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
