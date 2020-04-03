 

import javax.swing.*;
import java.awt.*;

public class firstPanel
{
    private JButton newGame; //Button containing text play.
    private JButton load;    //Button containing text load.
    private JButton options; //Button containing info about the game.
    private JPanel holding;  //Panel holding both the button.

    public firstPanel()
    {

        holding = new JPanel();
        holding.setLayout(new GridLayout(3,1,10,10));
        makingButtons();
        addingButtons();

    }
    public void makingButtons()
    {
        //Making the Buttons first.
        newGame = new JButton("Play");
        load = new JButton("Load");
        options = new JButton("Options");

        //Adding white color to ForGround. (here foreground is the color of the text)
        newGame.setForeground(Color.WHITE);
        load.setForeground(Color.WHITE);
        options.setForeground(Color.WHITE);

        //Adding Font as the Arcade games. (like 2000's)
        newGame.setFont(new Font("Press Start 2P",Font.BOLD,12));
        load.setFont(new Font("Press Start 2P",Font.BOLD,12));
        options.setFont(new Font("Press Start 2P",Font.BOLD,12));

        //Adding BackGround like Facebook.
        newGame.setBackground(new Color(59,89,182));
        load.setBackground(new Color(59,89,182));
        options.setBackground(new Color(59,89,182));
    }
    public void addingButtons()
    {
        holding.add(newGame);
        holding.add(load);
        holding.add(options);
    }
    public JPanel getHolding()
    {return holding;}
   public JButton getLoad()
    {return load;}

    public JButton getNewGame() {
        return newGame;
    }
    public JButton getOptions()
    {
        return options;
    }
}
