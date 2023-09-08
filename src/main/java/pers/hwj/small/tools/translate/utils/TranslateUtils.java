package pers.hwj.small.tools.translate.utils;

import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:00
 * @description:
 */
public interface TranslateUtils {

    public TranslateResponse translate(TranslateRequest request);


    public TranslateSourceEnum getSupportType();

}
