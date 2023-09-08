package pers.hwj.small.tools.translate.utils.baidu;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.http.entity.ContentType;
import pers.hwj.small.tools.common.HttpUtils;
import pers.hwj.small.tools.translate.enums.LanguageTypeEnum;
import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;
import pers.hwj.small.tools.translate.utils.TranslateRequest;
import pers.hwj.small.tools.translate.utils.TranslateResponse;
import pers.hwj.small.tools.translate.utils.TranslateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:05
 * @description:
 */
public class BaiduTranslateUtils implements TranslateUtils {

    private String appId = "20230908001809374";
    private String secretKey = "BoP3qGBEb5Ef_gx5VI8c";

    @Override
    public TranslateResponse translate(TranslateRequest request) {
        try {
            String translateUrl = "https://fanyi-api.baidu.com/api/trans/vip/translate";
            long salt = new Date().getTime();
            Map<String, String> param = new HashMap<>();
            param.put("q", request.getContent());
            param.put("from", request.getFrom().getCode());
            param.put("to", request.getTo().getCode());
            param.put("appid", appId);
            param.put("salt", salt + "");
            param.put("sign", DigestUtils.md5Hex(appId + request.getContent() + salt + secretKey));

            Map<String, String> header = new HashMap<>();
            header.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());

            HttpUtils httpUtils = new HttpUtils();
            String response = httpUtils.get(translateUrl, header, param);
            System.out.println("百度翻译响应：" + response);
            BaiduResponse baiduResponse = new Gson().fromJson(response, BaiduResponse.class);
            return buildTranslateResponse(baiduResponse);
        } catch (Exception e) {
            return null;
        }
    }

    private TranslateResponse buildTranslateResponse(BaiduResponse baiduResponse) {
        TranslateResponse translateResponse = new TranslateResponse();
        translateResponse.setFrom(baiduResponse.getFrom());
        translateResponse.setFrom(baiduResponse.getTo());
        if (CollectionUtils.isEmpty(baiduResponse.getTrans_result())) {
            return translateResponse;
        }
        BaiduTranslateRes translateRes = baiduResponse.getTrans_result().get(0);
        if (translateRes != null) {
            translateResponse.setSource(translateRes.getSrc());
            translateResponse.setTarget(translateRes.getDst());
        }
        return translateResponse;
    }

    @Override
    public TranslateSourceEnum getSupportType() {
        return TranslateSourceEnum.BAIDU;
    }
}
