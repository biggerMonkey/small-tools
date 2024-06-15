package pers.hwj.small.tools.charConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: huangwenjun16
 * @date: 2023/9/11 09:53
 * @description:
 */
public class CharConverterDialog {
    private JPanel jpanel;
    private JTextArea input;
    private JTextPane output;
    private JButton changeLowerHump;
    private JButton changeBigHump;
    private JButton changeUnderline;

    public CharConverterDialog() {
        this.input.setRows(6);
        this.input.setColumns(35);
        this.input.setLineWrap(true);
        changeLowerHump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //大驼峰
                output.setText(CharConvertUtils.smallHump(input.getText()));
            }
        });
        changeBigHump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //大驼峰
                output.setText(CharConvertUtils.bigHump(input.getText()));
            }
        });
        changeUnderline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //下划线
                output.setText(CharConvertUtils.changeUnderline(input.getText()));
            }
        });
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JTextArea getInput() {
        return input;
    }

    public void setInput(JTextArea input) {
        this.input = input;
    }

    public JTextPane getOutput() {
        return output;
    }

    public void setOutput(JTextPane output) {
        this.output = output;
    }

    public JButton getChangeLowerHump() {
        return changeLowerHump;
    }

    public void setChangeLowerHump(JButton changeLowerHump) {
        this.changeLowerHump = changeLowerHump;
    }

    public JButton getChangeBigHump() {
        return changeBigHump;
    }

    public void setChangeBigHump(JButton changeBigHump) {
        this.changeBigHump = changeBigHump;
    }

    public JButton getChangeUnderline() {
        return changeUnderline;
    }

    public void setChangeUnderline(JButton changeUnderline) {
        this.changeUnderline = changeUnderline;
    }
}
