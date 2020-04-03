 

import javax.swing.*;
import java.awt.*;

public class secondPanel
{
    private JPanel holding2;                                        //Panel for holding all the player panel.
    private JPanel[] p;                                     //Panel for each player.
    private JButton next;                                           //next.
    private JButton previous;                                       //previous.
    private String[] colorsList = {"None","Blue","Red","Green","Yellow"};  //list of colours players are allowed to select.
    private JComboBox com1,com2,com3,com4;                          //combobox containing the colourlist
    private JTextField[] t;                                 //text field for name
    private JLabel n1,n2,n3,n4;                                     //label for prompting user to write name
    private JRadioButton[] r;                               //ratiobutton defing human or not
    private JLabel c1,c2,c3,c4,na1,na2,na3,na4;
    private player[] players; // players


    public secondPanel()
    {
        makingHolding2();
        makingButtons();
        makingPLayerPanels();
        makingTextfield();
        makingRatio();
        makingCombo();
        designing();
        players = new player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new player();}
    }
    private void makingHolding2()
    {
        holding2 = new JPanel();
        holding2.setLayout(new GridLayout(3,2));
    }
    private void makingButtons()
    {

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
        p = new JPanel[4];
        for(int x = 0; x< p.length; x++)
        {
            p[x] = new JPanel();
            p[x].setLayout(new GridLayout(2, 1));
            holding2.add(p[x]);
        }

        holding2.add(previous);
        holding2.add(next);


    }
    private void makingTextfield()
    {
        t = new JTextField[4];
        for(int x = 0; x< t.length; x++)
        {
            t[x] = new JTextField("Enter Name",9);
            t[x].setForeground(Color.WHITE);
            t[x].setBackground(Color.DARK_GRAY);
        }




    }
    private void makingRatio()
    {
        r = new JRadioButton[4];
        for(int x = 0; x< t.length; x++)
        {
            r[x] = new JRadioButton("Playing");
            r[x].setForeground(Color.WHITE);
            r[x].setBackground(Color.DARK_GRAY);
        }



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

    private void designing()
    {
        for(int x = 0; x<p.length;x++)
        {
            p[x].add(r[x]);
            p[x].add(t[x]);
        }

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
    public boolean isPlayer()
    {
        boolean hu1,hu2,hu3,hu4;
        hu1 = r[0].isSelected();
        hu2 = r[1].isSelected();
        hu3 = r[2].isSelected();
        hu4 = r[3].isSelected();

        return hu1 != false || hu2 != false || hu3 != false || hu4 != false;


    }
    public boolean isValidName()
    {
        String na1,na2,na3,na4;
        na1 = t[0].getText();
        na2 = t[1].getText();
        na3 = t[2].getText();
        na4 = t[3].getText();
        boolean hu1,hu2,hu3,hu4;
        hu1 = r[0].isSelected();
        hu2 = r[1].isSelected();
        hu3 = r[2].isSelected();
        hu4 = r[3].isSelected();

        if((hu1==true && na1.equals("Enter Name")) || (hu2 == true && na2.equals("Enter Name")) || (hu3 == true && na3.equals("Enter Name")) || (hu4 == true && na4.equals("Enter Name")))
        {
            return false;
        }
        else if(na1.isEmpty() || na2.isEmpty() || na3.isEmpty() || na4.isEmpty())
        {
            return false;
        }
        else
            {
                return true;
            }
    }
    public player[] getPlayers()
    {
        for(int i = 0; i<players.length; i++)
        {
            players[i].setName(t[i].getText());
            players[i].setHuman(r[i].isSelected());
        }
        return this.players;
    }
//    public boolean isUniqueColor()
//    {
//        int co1,co2,co3,co4;
//        co1 = com1.getSelectedIndex();
//        co2 = com2.getSelectedIndex();
//        co3 = com3.getSelectedIndex();
//        co4 = com4.getSelectedIndex();
//        if(co1 == co2 || co1 == co3 || co1 == co4)
//        {
//            return false;
//        }
//        else if(co2 == co3 || co2 == co4)
//        {
//            return false;
//        }
//        else if(co3 == co4)
//        {
//            return false;
//        }
//        else{return true;}
//
//    }

}
