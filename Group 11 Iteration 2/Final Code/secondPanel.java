 

import javax.swing.*;
import java.awt.*;

public class secondPanel
{
    private JPanel holding2;                                        //Panel for holding all the player panel.
    private JPanel p1,p2,p3,p4;                                     //Panel for each player.
    private player player1,player2,player3,player4;                 //players.
    private JButton next;                                           //next.
    private JButton previous;                                       //previous.
    private String[] colorsList = {"Blue","Red","Green","Yellow"};  //list of colours players are allowed to select.
    private JComboBox com1,com2,com3,com4;                          //combobox containing the colourlist
    private JTextField t1,t2,t3,t4;                                 //text field for name
    private JLabel n1,n2,n3,n4;                                     //label for prompting user to write name
    private JRadioButton r1,r2,r3,r4;                               //ratiobutton defing human or not
    private JLabel c1,c2,c3,c4,na1,na2,na3,na4;

    public secondPanel()
    {
        makingHolding2();
        makingButtons();
        makingPLayerPanels();
        makingTextfield();
        makingRatio();
        makingCombo();
        designing();
    }
    private void makingHolding2()
    {
        holding2 = new JPanel();
        holding2.setLayout(new GridLayout(3,2));
    }
    private void makingButtons()
    {
        player1 = new player();
        player2 = new player();
        player3 = new player();
        player4 = new player();
        next = new JButton("Next");
        next.setFont(new Font("Segoe UI",Font.BOLD,11));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.DARK_GRAY);
        previous = new JButton("Previous");
        previous.setForeground(Color.WHITE);
        previous.setBackground(Color.DARK_GRAY);
        previous.setFont(new Font("Segoe UI",Font.BOLD,11));

    }
    private void makingPLayerPanels() {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        p1.setLayout(new GridLayout(3, 2));
        p2.setLayout(new GridLayout(3, 2));
        p3.setLayout(new GridLayout(3, 2));
        p4.setLayout(new GridLayout(3, 2));

        p1.setBackground(Color.DARK_GRAY);
        p2.setBackground(Color.DARK_GRAY);
        p3.setBackground(Color.DARK_GRAY);
        p4.setBackground(Color.DARK_GRAY);

        holding2.add(p1);
        holding2.add(p2);
        holding2.add(p3);
        holding2.add(p4);
        holding2.add(previous);
        holding2.add(next);


    }
    private void makingTextfield()
    {
        t1 = new JTextField("Enter Name",9);
        t2 = new JTextField("Enter Name",9);
        t3 = new JTextField("Enter Name",9);
        t4 = new JTextField("Enter Name",9);

        t1.setForeground(Color.WHITE);
        t1.setBackground(Color.DARK_GRAY);
        t1.setFont(new Font("Segoe UI",Font.BOLD,9));

        t2.setForeground(Color.WHITE);
        t2.setBackground(Color.DARK_GRAY);
        t2.setFont(new Font("Segoe UI",Font.BOLD,9));

        t3.setForeground(Color.WHITE);
        t3.setBackground(Color.DARK_GRAY);
        t3.setFont(new Font("Segoe UI",Font.BOLD,9));

        t4.setForeground(Color.WHITE);
        t4.setBackground(Color.DARK_GRAY);
        t4.setFont(new Font("Segoe UI",Font.BOLD,9));


    }
    private void makingRatio()
    {
        r1 = new JRadioButton();
        n1 = new JLabel("Human");
        n1.setForeground(Color.WHITE);
        n1.setFont(new Font("Segoe UI",Font.BOLD,9));
        r1.setBackground(Color.DARK_GRAY);

        r2 = new JRadioButton();
        n2 = new JLabel("Human");
        n2.setForeground(Color.WHITE);
        n2.setFont(new Font("Segoe UI",Font.BOLD,9));
        r2.setBackground(Color.DARK_GRAY);

        r3 = new JRadioButton();
        n3 = new JLabel("Human");
        n3.setForeground(Color.WHITE);
        n3.setFont(new Font("Segoe UI",Font.BOLD,9));
        r3.setBackground(Color.DARK_GRAY);

        r4 = new JRadioButton();
        n4 = new JLabel("Human");
        n4.setForeground(Color.WHITE);
        n4.setFont(new Font("Segoe UI",Font.BOLD,9));
        r4.setBackground(Color.DARK_GRAY);

    }
    private void makingCombo()
    {
        com1 = new JComboBox(colorsList);
        com2 = new JComboBox(colorsList);
        com3 = new JComboBox(colorsList);
        com4 = new JComboBox(colorsList);
        com1.setFont(new Font("Segoe UI",Font.BOLD, 9));
        com2.setFont(new Font("Segoe UI",Font.BOLD, 9));
        com3.setFont(new Font("Segoe UI",Font.BOLD, 9));
        com4.setFont(new Font("Segoe UI",Font.BOLD, 9));
        com1.setForeground(Color.WHITE);
        com1.setBackground(Color.DARK_GRAY);
        com2.setForeground(Color.WHITE);
        com2.setBackground(Color.DARK_GRAY);
        com3.setForeground(Color.WHITE);
        com3.setBackground(Color.DARK_GRAY);
        com4.setForeground(Color.WHITE);
        com4.setBackground(Color.DARK_GRAY);

        c1 = new JLabel("Color");
        c1.setBackground(Color.DARK_GRAY);
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Segoe UI",Font.BOLD,9));
        c2 = new JLabel("Color");
        c2.setForeground(Color.WHITE);
        c2.setBackground(Color.DARK_GRAY);
        c2.setFont(new Font("Segoe UI",Font.BOLD,9));
        c3 = new JLabel("Color");
        c3.setForeground(Color.WHITE);
        c3.setBackground(Color.DARK_GRAY);
        c3.setFont(new Font("Segoe UI",Font.BOLD,9));
        c4 = new JLabel("Color");
        c4.setForeground(Color.WHITE);
        c4.setBackground(Color.DARK_GRAY);
        c4.setFont(new Font("Segoe UI",Font.BOLD,9));
    }
    public player getPlayer(int number)
    {
        if(number == 1)
        {return player1;}
        else if(number == 2)
        {return player2;}
        else if(number == 3)
        {return player3;}
        else
        {return player4;}
    }
    private void designing()
    {
        p1.add(n1);
        p1.add(r1);
        p1.add(c1);
        p1.add(com1);
        na1 = new JLabel("Enter Name");
        na1.setFont(new Font("Segoe UI",Font.BOLD,9));
        na1.setForeground(Color.WHITE);
        p1.add(na1);
        p1.add(t1);

        p2.add(n2);
        p2.add(r2);
        p2.add(c2);
        p2.add(com2);
        na2 = new JLabel("Enter Name");
        na2.setFont(new Font("Segoe UI",Font.BOLD,9));
        na2.setForeground(Color.WHITE);
        p2.add(na2);
        p2.add(t2);

        p3.add(n3);
        p3.add(r3);
        p3.add(c3);
        p3.add(com3);
        na3 = new JLabel("Enter Name");
        na3.setFont(new Font("Segoe UI",Font.BOLD,9));
        na3.setForeground(Color.WHITE);
        p3.add(na3);
        p3.add(t3);

        p4.add(n4);
        p4.add(r4);
        p4.add(c4);
        p4.add(com4);
        na4 = new JLabel("Enter Name");
        na4.setFont(new Font("Segoe UI",Font.BOLD,9));
        na4.setForeground(Color.WHITE);
        p4.add(na4);
        p4.add(t4);
    }
    public JPanel getHolding2()
    {
        return holding2;
    }
    public JButton getNext()
    {
        return next;
    }
    public JButton getPrevious()
    {
        return previous;
    }


}
