 

import javax.swing.*;
import java.awt.*;

public class boardPanel
{
    private JPanel holding5;              //this holds the board and player
    private GridLayout layout;            //this is the border layout
    private int i;                        //this is the number for x
    private int j;                        //this is the number for y
    private squareBoard[][] board;
    private JPanel bidPanel;              //this pannel is used for bidding
    public boardPanel()
    {
        holding5 = new JPanel();
        bidPanel = new JPanel();
        makingGrid();
    }
    public void makingGrid()
    {
        holding5.setLayout(new GridLayout(16,16));
        board = new squareBoard[16][16];
        for(i = 0;i<16;i++)
        {
            for(j = 0;j<16;j++)
            {


                board[i][j] = new squareBoard(i,j);
                holding5.add(board[i][j]);
            }
        }
        i = 0;
        j = 0;
    }
    public JPanel getHolding5()
    {
        return holding5;
    }
    public JPanel getbidPanel()
    {
        return bidPanel;
    }
    public squareBoard [][] getBoard()
    {
        return board;
    }
}
