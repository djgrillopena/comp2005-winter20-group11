 

import javax.swing.*;
import java.awt.*;

public class thirdPanel
{
    private JRadioButton simpleBoard;
    private JRadioButton complexBoard;
    private JLabel simple;
    private JLabel complex;
    private JPanel holding3;
    private JButton next;
    private JButton previous;

    public thirdPanel()
    {
        simple = new JLabel("Simple Board: ");
        complex = new JLabel("Complex Board:");
        simple.setFont(new Font("Segoe UI",Font.BOLD,11));
        complex.setFont(new Font("Segoe UI",Font.BOLD,11));
        simple.setForeground(Color.WHITE);
        simple.setBackground(Color.DARK_GRAY);
        complex.setForeground(Color.WHITE);
        complex.setBackground(Color.DARK_GRAY);
        simpleBoard = new JRadioButton();
        complexBoard = new JRadioButton();
        simpleBoard.setBackground(Color.DARK_GRAY);
        complexBoard.setBackground(Color.DARK_GRAY);
        holding3 = new JPanel();
        holding3.setLayout(new GridLayout(3,2));
        holding3.add(simple);
        holding3.add(simpleBoard);
        holding3.add(complex);
        holding3.add(complexBoard);
        next = new JButton("next");
        previous = new JButton("Previous");
        holding3.add(previous);
        holding3.add(next);
        holding3.setBackground(Color.DARK_GRAY);
    }

    public JPanel getHolding3() {
        return holding3;
    }

    public JLabel getComplex() {
        return complex;
    }

    public JLabel getSimple() {
        return simple;
    }

    public JRadioButton getComplexBoard() {
        return complexBoard;
    }

    public JRadioButton getSimpleBoard() {
        return simpleBoard;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getPrevious() {
        return previous;
    }
    public boolean isSimpleOrComplex()
    {
        boolean b1,b2;
        b1 = simpleBoard.isSelected();
        b2 = complexBoard.isSelected();
        return (!b1 || !b2) && (b1 || b2);

    }
}
