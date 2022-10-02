package com.iapp.calculator.view;

import com.iapp.calculator.controller.Controller;
import com.iapp.calculator.model.WrongInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * Graphical display of the calculator in the desktop window
 * @author Igor Ivanov
 * @version 1.0
 * */
public class CalculatorFrame extends JFrame {

    /** business logic */
    private final Controller controller;
    /** fields for entering a mathematical expression */
    private final JTextField textField;
    /** buttons for adding and deleting text, performing calculations */
    private final JButton sin, tg, degree, removal,
                            cos, ctg, squareRoot, division,
                                b7, b8, b9, multiplication,
                                    b4, b5, b6, minus,
                                        b1, b2, b3, plus,
                                            brackets, b0, comma, calculation;

    /** initialization and configuration of graphic components */
    public CalculatorFrame(Controller controller, String title) {
        super(title);
        this.controller = controller;

        textField = new JTextField("",15);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("font", Font.PLAIN,40));

        sin = new JButton("sin");
        sin.setFont(new Font("font", Font.PLAIN,30));
        tg = new JButton("tg");
        tg.setFont(new Font("font", Font.PLAIN,30));
        degree = new JButton("^");
        degree.setFont(new Font("font", Font.PLAIN,30));
        removal = new JButton("<");
        removal.setFont(new Font("font", Font.PLAIN,30));

        cos = new JButton("cos");
        cos.setFont(new Font("font", Font.PLAIN,30));
        ctg = new JButton("ctg");
        ctg.setFont(new Font("font", Font.PLAIN,30));
        squareRoot = new JButton("√");
        squareRoot.setFont(new Font("font", Font.PLAIN,30));
        division = new JButton(":");
        division.setFont(new Font("font", Font.PLAIN,30));

        b7 = new JButton("7");
        b7.setFont(new Font("font", Font.PLAIN,30));
        b8 = new JButton("8");
        b8.setFont(new Font("font", Font.PLAIN,30));
        b9 = new JButton("9");
        b9.setFont(new Font("font", Font.PLAIN,30));
        multiplication = new JButton("*");
        multiplication.setFont(new Font("font", Font.PLAIN,30));

        b4 = new JButton("4");
        b4.setFont(new Font("font", Font.PLAIN,30));
        b5 = new JButton("5");
        b5.setFont(new Font("font", Font.PLAIN,30));
        b6 = new JButton("6");
        b6.setFont(new Font("font", Font.PLAIN,30));
        minus = new JButton("-");
        minus.setFont(new Font("font", Font.PLAIN,30));

        b1 = new JButton("1");
        b1.setFont(new Font("font", Font.PLAIN,30));
        b2 = new JButton("2");
        b2.setFont(new Font("font", Font.PLAIN,30));
        b3 = new JButton("3");
        b3.setFont(new Font("font", Font.PLAIN,30));
        plus = new JButton("+");
        plus.setFont(new Font("font", Font.PLAIN,30));

        brackets = new JButton("()");
        brackets.setFont(new Font("font", Font.PLAIN,30));
        b0 = new JButton("0");
        b0.setFont(new Font("font", Font.PLAIN,30));
        comma = new JButton(",");
        comma.setFont(new Font("font", Font.PLAIN,30));
        calculation = new JButton("=");
        calculation.setFont(new Font("font", Font.PLAIN,30));

        initializeJFrame();
        initializeListeners();
    }

    /** adding graphical components to a window and displaying the window */
    public void showFrame() {
        initialize();
        setVisible(true);
    }

    private void initialize() {
        var content = new JPanel(new GridLayout(7, 1));
        var padding = BorderFactory.createEmptyBorder(1, 1, 0, 1);
        content.setBorder(padding);

        content.add(textField);

        var line1 = new JPanel(new GridLayout(1, 4));
        line1.add(sin);
        line1.add(tg);
        line1.add(degree);
        line1.add(removal);
        content.add(line1);

        var line2 = new JPanel(new GridLayout(1, 4));
        line2.add(cos);
        line2.add(ctg);
        line2.add(squareRoot);
        line2.add(division);
        content.add(line2);

        var line3 = new JPanel(new GridLayout(1, 4));
        line3.add(b7);
        line3.add(b8);
        line3.add(b9);
        line3.add(multiplication);
        content.add(line3);

        var line4 = new JPanel(new GridLayout(1, 4));
        line4.add(b4);
        line4.add(b5);
        line4.add(b6);
        line4.add(minus);
        content.add(line4);

        var line5 = new JPanel(new GridLayout(1, 4));
        line5.add(b1);
        line5.add(b2);
        line5.add(b3);
        line5.add(plus);
        content.add(line5);

        var line6 = new JPanel(new GridLayout(1, 4));
        line6.add(brackets);
        line6.add(b0);
        line6.add(comma);
        line6.add(calculation);
        content.add(line6);

        add(content);
    }

    private void initializeListeners() {
        sin.addActionListener(e -> addAction(sin.getText()));
        tg.addActionListener(e -> addAction(tg.getText()));
        degree.addActionListener(e -> addAction(degree.getText()));
        removal.addActionListener(e -> removeCharacter());

        cos.addActionListener(e -> addAction(cos.getText()));
        ctg.addActionListener(e -> addAction(ctg.getText()));
        squareRoot.addActionListener(e -> addAction(squareRoot.getText()));
        division.addActionListener(e -> addAction(division.getText()));

        b7.addActionListener(e -> addAction(b7.getText()));
        b8.addActionListener(e -> addAction(b8.getText()));
        b9.addActionListener(e -> addAction(b9.getText()));
        multiplication.addActionListener(e -> addAction(multiplication.getText()));

        b4.addActionListener(e -> addAction(b4.getText()));
        b5.addActionListener(e -> addAction(b5.getText()));
        b6.addActionListener(e -> addAction(b6.getText()));
        minus.addActionListener(e -> addAction(minus.getText()));

        b1.addActionListener(e -> addAction(b1.getText()));
        b2.addActionListener(e -> addAction(b2.getText()));
        b3.addActionListener(e -> addAction(b3.getText()));
        plus.addActionListener(e -> addAction(plus.getText()));

        brackets.addActionListener(e -> addAction(defineBracket()));
        b0.addActionListener(e -> addAction(b0.getText()));
        comma.addActionListener(e -> addAction(comma.getText()));
        calculation.addActionListener(e -> countExpression());
    }

    private void countExpression() {
        var text = textField.getText();
        String result;
        try {
            result = controller.calculate(text);
        } catch (WrongInputException e) {
            e.printStackTrace();
            Arrays.stream(e.getSuppressed()).forEach(Throwable::printStackTrace);
            textField.setText("");
            return;
        }
        textField.setText(result);
        textField.getCaret().setVisible(true);
        textField.setCaretPosition(result.length());
    }

    private void addAction(String action) {
        var text = textField.getText();
        var caretStart = textField.getSelectionStart();
        var caretEnd = textField.getSelectionEnd();

        textField.setText(text.substring(0, caretStart) +
                action + text.substring(caretEnd));
        textField.setCaretPosition(caretStart);
        textField.getCaret().setVisible(true);
    }

    private void removeCharacter() {
        var text = textField.getText();
        var caretStart = textField.getSelectionStart();
        var caretEnd = textField.getSelectionEnd();

        if (caretStart == caretEnd) {
            if (caretStart == 0) return;
            textField.setText(remove(text, caretStart - 1));
        } else {
            textField.setText(text.substring(0, caretStart) + text.substring(caretEnd));
        }
        textField.setCaretPosition(caretStart - 1);
        textField.getCaret().setVisible(true);
    }

    private String defineBracket() {
        var text = textField.getText();
        var opening = text.chars().filter(c -> c == '(').count();
        var closing = text.chars().filter(c -> c == ')').count();

        return opening > closing ? ")" : "(";
    }

    private String remove(String text, int index) {
        var arr = text.toCharArray();
        var builder = new StringBuilder();
        for (int i = 0; i  < arr.length; i++) {
            if (i != index) builder.append(arr[i]);
        }
        return builder.toString();
    }

    private void initializeJFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                System.exit(0);
            }
        });

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) countExpression();
            }
        });
        textField.setFocusable(true);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Throwable t) {
            JOptionPane.showMessageDialog(null, "View of your OS isn't connected: " + t,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



