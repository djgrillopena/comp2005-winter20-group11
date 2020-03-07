 

import javax.swing.*;
import java.awt.*;

public class thirdPanel
{
    JRadioButton simpleBoard;
    JRadioButton complexBoard;
    JLabel simple;
    JLabel complex;
    JPanel holding3;
    JButton next;
    JButton previous;

    public thirdPanel()
    {
        simple = new JLabel("Simple Board: ");
        complex = new JLabel("Complex Board:");
        simpleBoard = new JRadioButton();
        complexBoard = new JRadioButton();
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
}
