package pers.hwj.small.tools.timestamp.enums;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 16:55
 * @description:
 */
public enum TimeTypeEnum {
    SECOND(1,"秒"),
    MILLISECOND(1,"毫秒"),;
    private Integer code;
    private String msg;

    TimeTypeEnum(Integer code, String msg) {
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
