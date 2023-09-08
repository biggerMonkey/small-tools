package pers.hwj.small.tools.translate.utils;

import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;
import pers.hwj.small.tools.translate.utils.baidu.BaiduTranslateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 10:00
 * @description:
 */
public class TranslateUtilsManager {

    private List<TranslateUtils> translateUtilsList;

    public TranslateUtilsManager() {
        //初始化
        this.translateUtilsList = new ArrayList<>();
        this.translateUtilsList.add(new BaiduTranslateUtils());
    }

    public Map<TranslateSourceEnum, TranslateResponse> translate(TranslateRequest request) {
        Map<TranslateSourceEnum, TranslateResponse> response = new HashMap<>();
        for (TranslateUtils translateUtils : translateUtilsList) {
            if (request.getTranslateSourceEnum() == null) {
                TranslateResponse tempResponse = translateUtils.translate(request);
                if (tempResponse == null) {
                    continue;
                }
                response.put(translateUtils.getSupportType(), tempResponse);
                continue;
            }
            if (request.getTranslateSourceEnum().equals(translateUtils.getSupportType())) {
                response.put(translateUtils.getSupportType(), translateUtils.translate(request));
                return response;
            }
        }
        return response;
    }
}
