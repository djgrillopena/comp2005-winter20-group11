import javax.swing.*;

public class target
{

    private int x;
    private int y;
    private ImageIcon tokenImage;
    private String tokenName;
    private static String blue = "image/blue.png";
    private static String red = "image/red.png";
    private static String yellow = "image/yellow.png";
    private static String green = "image/green.png";

    public target(int x,int y, String tokenName)
    {
        this.x = x;
        this.y = y;
        this.tokenName = tokenName;
        if(tokenName.equals("blue"))
        {
            tokenImage = new ImageIcon(getClass().getResource(blue));
        }
        else if(tokenName.equals("red"))
        {
            tokenImage = new ImageIcon((getClass().getResource(red)));
        }
        else if(tokenName.equals("yellow"))
        {
            tokenImage = new ImageIcon((getClass().getResource(yellow)));
        }
        else if(tokenName.equals("green"))
        {
            tokenImage = new ImageIcon((getClass().getResource(green)));
        }
    }

    public target(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public ImageIcon getTokenImage()
    {
        return this.tokenImage;
    }

    public String getTokenName() {
        return tokenName;
    }
}
