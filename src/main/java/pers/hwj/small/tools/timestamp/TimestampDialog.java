package pers.hwj.small.tools.timestamp;

import org.apache.commons.lang3.math.NumberUtils;
import pers.hwj.small.tools.timestamp.enums.TimeTypeEnum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 16:03
 * @description:
 */
public class TimestampDialog {
    private JPanel jpanel;
    private JComboBox timeFormatType;
    private JComboBox timeType;
    private JTextField input;
    private JButton change;
    private JTextPane output;


    public TimestampDialog() {
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String inputStr = input.getText();
                    if (NumberUtils.isDigits(inputStr)) {
                        long inputLong = Long.parseLong(inputStr);
                        if (TimeTypeEnum.SECOND.getMsg().equals(String.valueOf(timeType.getSelectedItem()))) {
                            inputLong = inputLong * 1000;
                        }
                        //数字->时间戳
                        output.setText(dateFormat.format(new Date(inputLong)));
                        return;
                    }
                    //非数字 日期格式
                    String dateStr = String.valueOf(dateFormat.parse(inputStr).getTime());
                    output.setText(dateStr);
                } catch (Exception ex) {
                    output.setText("格式异常\n" +
                            "日期格式：yyyy-MM-dd HH:mm:ss \n" +
                            "时间戳格式：纯数字");
                }
            }
        });
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JComboBox getTimeFormatType() {
        return timeFormatType;
    }

    public void setTimeFormatType(JComboBox timeFormatType) {
        this.timeFormatType = timeFormatType;
    }

    public JComboBox getTimeType() {
        return timeType;
    }

    public void setTimeType(JComboBox timeType) {
        this.timeType = timeType;
    }

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public JButton getChange() {
        return change;
    }

    public void setChange(JButton change) {
        this.change = change;
    }

    public JTextPane getOutput() {
        return output;
    }

    public void setOutput(JTextPane output) {
        this.output = output;
    }
}
