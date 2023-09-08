package pers.hwj.small.tools.timestamp;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;
import pers.hwj.small.tools.translate.TranslateDialog;

import javax.swing.*;
import java.awt.*;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 15:59
 * @description:
 */
public class TimestampConverterAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        JFrame frame = new JFrame("时间戳转换");
        frame.setContentPane((new TimestampDialog()).getJpanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        frame.setSize(350,230);

        int windowWidth = frame.getWidth(); //获得窗口宽
        int windowHeight = frame.getHeight(); //获得窗口高

        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
    }

    public static void main(String[] args) {

    }
}
