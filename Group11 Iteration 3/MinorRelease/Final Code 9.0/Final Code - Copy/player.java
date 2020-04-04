 

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class player
{
    private JButton bell;
    private String name;
    private Color  colour;          // integer for color. 0 == blue, 1 == red, 2 = green, 3 = yellow 4 = silver
    private Boolean human;

    public player()
    {
        bell = new JButton("Player");
        bell.setBackground(new Color(0xB12039));
        bell.setFont(new Font("Press Start 2P",Font.BOLD,12));
    }
    public void setColor(int color)
    {
        if(color == 0)
        {colour = new Color(0x87CEEB);
        bell.setBackground(colour);
        bell.setText("Player"+ Integer.toString(color+1));}

        else if(color== 1)
        {colour = new Color(0xD8072C);
            bell.setBackground(colour);
            bell.setText("Player"+ Integer.toString(color+1));}
        else if(color == 2)
        {
            colour = new Color(0x59D817);
            bell.setBackground(colour);
            bell.setText("Player"+ Integer.toString(color+1));
        }
        else if(color == 3)
        {
            colour = new Color(0xD7D822);
            bell.setBackground(colour);
            bell.setText("Player"+ Integer.toString(color+1));
        }
        else
        {
            colour = new Color(0x93ABAB);
            bell.setBackground(colour);
            bell.setText("Player"+ Integer.toString(color+1));
        }
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setHuman(Boolean value)
    {
        this.human = value;
    }
    public Color getColour()
    {
        return colour;
    }
    public String getName()
    {
        return name;
    }
    public JButton getBell() {
        return bell;
    }
    public Boolean getHuman()
    {
        return human;
    }
}
