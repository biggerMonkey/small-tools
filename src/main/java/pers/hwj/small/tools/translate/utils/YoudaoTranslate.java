package pers.hwj.small.tools.translate.utils;

import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:05
 * @description:
 */
public class YoudaoTranslate implements TranslateUtils {

    @Override
    public TranslateResponse translate(TranslateRequest request) {
        return null;
    }

    @Override
    public TranslateSourceEnum getSupportType() {
        return TranslateSourceEnum.YOUDAO;
    }
}
