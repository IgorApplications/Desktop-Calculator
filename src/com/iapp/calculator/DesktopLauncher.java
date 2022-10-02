package com.iapp.calculator;

import com.iapp.calculator.controller.Controller;
import com.iapp.calculator.view.CalculatorFrame;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class DesktopLauncher {

    public static void main(String[] args) {
        List<Image> icons = List.of(
                new ImageIcon(Objects.requireNonNull(DesktopLauncher.class.getResource("/icon_16x16.png"))).getImage(),
                new ImageIcon(Objects.requireNonNull(DesktopLauncher.class.getResource("/icon_32x32.png"))).getImage(),
                new ImageIcon(Objects.requireNonNull(DesktopLauncher.class.getResource("/icon_64x64.png"))).getImage(),
                new ImageIcon(Objects.requireNonNull(DesktopLauncher.class.getResource("/icon_128x128.png"))).getImage());

        var controller = new Controller();
        var frame = new CalculatorFrame(controller,"Calculator");
        frame.setSize(400, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImages(icons);
        SwingUtilities.invokeLater(frame::showFrame);
    }
}


