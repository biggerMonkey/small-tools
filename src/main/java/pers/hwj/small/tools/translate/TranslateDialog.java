package pers.hwj.small.tools.translate;

import com.intellij.openapi.externalSystem.service.notification.callback.OpenProjectJdkSettingsCallback;
import org.apache.commons.collections.MapUtils;
import org.apache.http.client.HttpClient;
import pers.hwj.small.tools.translate.enums.LanguageTypeEnum;
import pers.hwj.small.tools.translate.enums.TranslateSourceEnum;
import pers.hwj.small.tools.translate.utils.TranslateRequest;
import pers.hwj.small.tools.translate.utils.TranslateResponse;
import pers.hwj.small.tools.translate.utils.TranslateUtilsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * @author: huangwenjun16
 * @date: 2023/9/7 18:12
 * @description:
 */
public class TranslateDialog {
    private JComboBox inputLanguage;
    private JComboBox outputLanguage;
    private JTextArea input;
    private JButton exchange;
    private JButton translate;
    private JPanel jpanel;

    private JTextPane output;

    private TranslateUtilsManager translateUtilsManager;

    public TranslateDialog() {
        this.translateUtilsManager = new TranslateUtilsManager();
        for (LanguageTypeEnum typeEnum : LanguageTypeEnum.values()) {
            this.inputLanguage.addItem(typeEnum.getMsg());
            this.outputLanguage.addItem(typeEnum.getMsg());
            this.outputLanguage.setSelectedItem(LanguageTypeEnum.EN.getMsg());
        }

        translate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputStr = input.getText();
                if (inputStr.length() > 1000) {
                    output.setText("输入字符超过1000，请缩短重试");
                    return;
                }
                TranslateRequest request = new TranslateRequest();
                request.setFrom(LanguageTypeEnum.getEnumByMsg((String) inputLanguage.getSelectedItem()));
                request.setTo(LanguageTypeEnum.getEnumByMsg((String) outputLanguage.getSelectedItem()));
                request.setContent(inputStr);
                Map<TranslateSourceEnum, TranslateResponse> responseMap = translateUtilsManager.translate(request);
                if (MapUtils.isEmpty(responseMap)) {
                    output.setText("翻译失败,请重试");
                    return;
                }
                StringBuilder responseStr = new StringBuilder();
                for (Map.Entry<TranslateSourceEnum, TranslateResponse> responseEntry : responseMap.entrySet()) {
                    responseStr.append(responseEntry.getKey().getMsg()).append(":").append(Constants.DEFAULT_SEPARATOR);
                    responseStr.append(responseEntry.getValue().getTarget()).append(Constants.DEFAULT_SEPARATOR);
                }
                output.setText(responseStr.toString());
            }
        });
        this.input.setRows(6);
        this.input.setColumns(35);
        this.input.setLineWrap(true);
//        input.setPreferredSize(new Dimension(jpanel.getWidth() - 100, jpanel.getHeight() - 100));
        exchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputMsg = (String) inputLanguage.getSelectedItem();
                inputLanguage.setSelectedItem(outputLanguage.getSelectedItem());
                outputLanguage.setSelectedItem(inputMsg);
            }
        });
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JComboBox getInputLanguage() {
        return inputLanguage;
    }

    public void setInputLanguage(JComboBox inputLanguage) {
        this.inputLanguage = inputLanguage;
    }

    public JComboBox getOutputLanguage() {
        return outputLanguage;
    }

    public void setOutputLanguage(JComboBox outputLanguage) {
        this.outputLanguage = outputLanguage;
    }

    public JTextArea getInput() {
        return input;
    }

    public void setInput(JTextArea input) {
        this.input = input;
    }

    public JButton getExchange() {
        return exchange;
    }

    public void setExchange(JButton exchange) {
        this.exchange = exchange;
    }

    public JButton getTranslate() {
        return translate;
    }

    public void setTranslate(JButton translate) {
        this.translate = translate;
    }

    public JTextPane getOutput() {
        return output;
    }

    public void setOutput(JTextPane output) {
        this.output = output;
    }
}
