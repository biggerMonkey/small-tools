package pers.hwj.small.tools.translate.utils.google;

import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.entity.ContentType;
import pers.hwj.small.tools.common.HttpUtils;
import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;
import pers.hwj.small.tools.translate.utils.TranslateRequest;
import pers.hwj.small.tools.translate.utils.TranslateResponse;
import pers.hwj.small.tools.translate.utils.TranslateUtils;
import pers.hwj.small.tools.translate.utils.baidu.BaiduResponse;
import pers.hwj.small.tools.translate.utils.baidu.BaiduTranslateRes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:05
 * @description:
 */
public class GoogleTranslateUtils implements TranslateUtils {


    @Override
    public TranslateResponse translate(TranslateRequest request) {
        return null;
    }


    @Override
    public TranslateSourceEnum getSupportType() {
        return TranslateSourceEnum.GOOGLE;
    }
}
