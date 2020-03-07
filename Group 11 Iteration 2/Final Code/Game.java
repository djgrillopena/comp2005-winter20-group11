 


import java.awt.*;
import javax.swing.*;

public class Game
{
    JFrame frame;
    Container contentPane;
    firstPanel first;
    secondPanel second;
    thirdPanel third;
    JLabel gameImage;
    JPanel gridPanel;
    JButton[][] cocoPieces;
    public Game()
    {
        frame = new JFrame();
        frame.setBounds(100,100,800,400);
        frame.setResizable(false);
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        first = new firstPanel();

        JPanel holding = first.getHolding();
        contentPane.add(holding, BorderLayout.EAST);

        gameImage = new JLabel();
        gameImage.setIcon(new ImageIcon("image/zm2001_box_front.png"));
        contentPane.add(gameImage, BorderLayout.WEST);
        JButton play = first.getNewGame();
        play.addActionListener(ae -> go2Frame());




        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible( true);
    }

    public void go2Frame() {
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        second = new secondPanel();
        JPanel holding2 = second.getHolding2();
        contentPane.add(holding2, BorderLayout.EAST);
        contentPane.add(gameImage,BorderLayout.WEST);
        JButton next = second.getNext();
        next.addActionListener(ae->go3Frame());
        JButton previous = second.getPrevious();
        previous.addActionListener(ae -> go1Frame());
        frame.repaint();
        frame.revalidate();
    }

    public void go3Frame() {
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        third = new thirdPanel();
        JPanel holding3 = third.getHolding3();
        contentPane.add(holding3, BorderLayout.EAST);
        contentPane.add(gameImage, BorderLayout.WEST);
        JButton next = third.getNext();
        next.addActionListener(ae->Board());
        JButton previous = third.getPrevious();
        previous.addActionListener( ae -> goBack2Frame());
        frame.repaint();
        frame.revalidate();
    }

    public void goBack2Frame() {
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        JPanel holding2 = second.getHolding2();
        contentPane.add(holding2,BorderLayout.EAST);
        contentPane.add(gameImage,BorderLayout.WEST);
        frame.repaint();
        frame.revalidate();
    }

    public void go1Frame()
    {
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        JPanel holding = first.getHolding();
        contentPane.add(holding, BorderLayout.EAST);
        contentPane.add(gameImage, BorderLayout.WEST);
        frame.repaint();
        frame.revalidate();
    }
    public void Board()
    {
        /*gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(17,17));
        for(int c = 0; c<17;c++)
        {
            for(int r = 0;r<17;r++)
            {
                cocoPieces[c][r] = new JButton();
                gridPanel.add(cocoPieces[c][r]);
            }
        }
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        contentPane.add(gridPanel,BorderLayout.CENTER);*/
        JLabel imagine = new JLabel();
        imagine.setIcon(new ImageIcon("image/cnSyN6e.png"));
        BorderLayout layout = (BorderLayout)contentPane.getLayout();
        contentPane.remove(layout.getLayoutComponent(BorderLayout.EAST));
        contentPane.remove(layout.getLayoutComponent(BorderLayout.WEST));
        contentPane.add(imagine,BorderLayout.CENTER);
        frame.setSize(1000,999);
        frame.repaint();
        frame.revalidate();


    }
}
