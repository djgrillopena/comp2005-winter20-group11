import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Timer;

public class Game {
    private JFrame frame;
    private Container contentPane;
    private firstPanel first;
    private secondPanel second;
    private thirdPanel third;
    private JLabel gameImage;
    private boardPanel board;
    private JLabel lblTimeLeft;
    private Timer timer;
    private player[] players; //players
    private JPanel moves_panel; //contains the left right top and bottom.
    private JPanel bidPanel; // contain the buttons for pressing the bell.
    private JPanel targetPanel; //displays the target chip.
    private JButton targetImage;   // the button in the targetPanel that display the target chip.
    private JLabel targetName;     // contains the name of the image.
    private target currentTarget;   //contains the name of the square which the given target token is placed.

    //Non swing variables or logic variables
    private int turn = 2;             //There are 5 chances in the game.
    private boolean turn_over = true; // to control turn.
    private boolean set_timer = false; // to know when to set_timer
    private boolean game_over = false; // to know when to end game
    private int minutes = 1;
    private int seconds;
    private Integer[] moving;
    private JButton [] moves_button = new JButton[4]; //left right top bottom.
    private ArrayList<target> targets; // array list that contains the cordinates of all the targets.
    private ArrayList<target> tokens; //arrayList that would contain the default location of the tokens

    private JRadioButton[] bryg;    //The b = blue, r = red, y = yellow, g = green.
    private JButton submit;           //This will submit the answer
    private JButton reset;            //This will reset it to the previous
    private JLabel currentMoves;         //This will hold current numbers of moves
    private int numMoves;               //This will be the int that will be displayed on the currentMoves label.
    private int counter =0; //dont change this counter.
    private squareBoard[][] boardButton;
    private int[] currentPlayer;
    private int[] winner;
    public Game() {
        //creating the main frame and giving the default size of the frame. Also giving the frame a Border Layout.
        {
            frame = new JFrame();
            frame.setBounds(100, 100, 800, 400);
            frame.setResizable(false);
            contentPane = frame.getContentPane();
            contentPane.setLayout(new BorderLayout());
        }
        //creating first panel and adding it to the East end of the frame.
        {
            first = new firstPanel();

            //This is to create an data base of the cordinates of the target chips.
            makeTargets();

            JPanel holding = first.getHolding();
            contentPane.add(holding, BorderLayout.EAST);
        }
        //creating a game image that will be displayed from the game. Also adding actionListener to the playButton.
        {
            gameImage = new JLabel();
            gameImage.setIcon(new ImageIcon(getClass().getResource("image/zm2001_box_front.png")));
            contentPane.add(gameImage, BorderLayout.WEST);
            JButton play = first.getNewGame();
            play.addActionListener(ae -> from1to2());
        }
        //setting the preferred size and other essential for the frame.
        {
            frame.setPreferredSize(new Dimension(900, 800));
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }
    public void makeTargets()
    {
        targets = new ArrayList<target>();
        target one = new target(1,4);
        target two = new target(1,11);
        target three = new target(3,1);
        target four = new target(3,14);
        target five  = new target(4,9);
        target six = new target(5,5);
        target seven = new target(6,3);
        target eight = new target(6,12);
        target nine = new target(8,2);
        target ten = new target(9,5);
        target eleven = new target(10,1);
        target twelve  = new target(10,11);
        target thirteen = new target(11,13);
        target fourteen =  new target(12,4);
        target fifteen = new target(12,10);
        target sixteen = new target(13,12);
        target seventeen = new target(14,6);
        targets.add(one);
        targets.add(two);
        targets.add(three);
        targets.add(four);
        targets.add(five);
        targets.add(six);
        targets.add(seven);
        targets.add(eight);
        targets.add(nine);
        targets.add(ten);
        targets.add(eleven);
        targets.add(twelve);
        targets.add(thirteen);
        targets.add(fourteen);
        targets.add(fifteen);
        targets.add(sixteen);
        targets.add(seventeen);


    }
    public void makeTokens()
    {

        tokens = new ArrayList<target>();
        getXY("blue");
        getXY("red");
        getXY("yellow");
        getXY("green");
    }
    public boolean isBlack(Color ce)
    {
        if(ce == Color.BLACK)
        {
            return true;
        }
        else{return false;}
    }
    public void getXY(String colourToken)
    {
        String col = colourToken;
        Random rand = new Random();
        int x = rand.nextInt(15);
        int y  = rand.nextInt(15);
        boardButton = board.getBoard();
        String var = boardButton[x][y].getlocation();
        boolean mark = boardButton[x][y].getMark();
        Color c = boardButton[x][y].getBackground();
        boolean cb = this.isBlack(c);
        while(true)
        {
            if(var.equals("planeSquare") && !mark && !cb)
            {
                target token1 = new target(x,y,colourToken);
                tokens.add(token1);
                boardButton[x][y].setToker(token1.getTokenImage(),token1.getTokenName(),colourToken);
                boardButton[x][y].setMark(colourToken);
                break;
            }
            else
            {
               x = rand.nextInt(15);
               y = rand.nextInt(15);
               var = boardButton[x][y].getlocation();
               c = boardButton[x][y].getBackground();
               cb = this.isBlack(c);
            }
        }
    }
    public void from1to2() {
        //removing the previous panel
        {
            JPanel holding = first.getHolding();
            holding.setVisible(false);
        }
        //adding new panel
        {
            second = new secondPanel();
            JPanel holding2 = second.getHolding2();
            contentPane.add(holding2, BorderLayout.EAST);
        }
        //getting next and previous. Then adding action listener
        {
            JButton next = second.getNext();
            next.addActionListener(ae -> from2to3());

            //getting previous and adding action listener
            JButton previous = second.getPrevious();
            previous.addActionListener(ae -> from2to1());
        }
        //repainting and revalidating
        {
            frame.repaint();
            frame.revalidate();
        }
    }

    public void from2to3() {

        if(second.isPlayer() && second.isValidName())
        {
            //removing the elements of previous panel.
            {
                JPanel holding2 = second.getHolding2();
                holding2.setVisible(false);
            }
            //making the thirdPanel and adding it to the main panel.
            {
                third = new thirdPanel();
                JPanel holding3 = third.getHolding3();
                contentPane.add(holding3, BorderLayout.EAST);
            }
            //getting next and previous button and adding action listener
            {
                JButton next = third.getNext();
                next.addActionListener(ae -> Board());
                JButton previous = third.getPrevious();
                previous.addActionListener(ae -> from3to2());

                //repainting and revalidating
                frame.repaint();
                frame.revalidate();
            }
        }
        else{
            if(!second.isPlayer())
            {
                JOptionPane.showMessageDialog(frame, "There should be at least 1 player. ");
            }
            else if(!second.isValidName())
            {
                JOptionPane.showMessageDialog(frame,"The name entered are not valid.\nPlease enter valid name!\nThanks");
            }
            JButton previous = third.getPrevious();
            previous.addActionListener(ae -> from3to2());
        }

    }

    public void from3to2() {
        //removing the third panel
        {
            JPanel holding3 = third.getHolding3();
            holding3.setVisible(false);
        }
        //adding the second Panel
        {
            JPanel holding2 = second.getHolding2();
            holding2.setVisible(true);
        }
        //repaint and revalidating
        {
            frame.repaint();
            frame.revalidate();
        }
    }

    public void from2to1() {
        //removing the second Panel
        {
            JPanel holding2 = second.getHolding2();
            holding2.setVisible(false);
        }
        //adding the first panel
        {
            JPanel holding = first.getHolding();
            holding.setVisible(true);
        }
        //repaint and revalidate
        {
            frame.repaint();
            frame.revalidate();
        }
    }

    public void Board() {
        if(third.isSimpleOrComplex())
        {
            //Removing The image and third panel
            {
                    JPanel holding3 = third.getHolding3();
                    holding3.setVisible(false);
                    gameImage.setVisible(false);
                }
            //adding the board and other button.
            {
                board = new boardPanel();
                JPanel boardPanel = board.getHolding5();
                boardPanel.setBounds(0, 0, 70, 700);
                contentPane.add(boardPanel, BorderLayout.CENTER);
                boardButton = board.getBoard();
            }
            //Creating a Panel for to ring a bell for a turn and enter the no. of moves
            {
                moves_panel = new JPanel();
                moves_panel.setLayout(new GridLayout(5, 2));

                bidPanel = board.getbidPanel();
                bidPanel.setVisible(true);
                players = second.getPlayers();
                bidPanel.setLayout(new GridLayout(4, 1));
            }
            //making the player moves count
            {
                moving = new Integer[4];
                for(int c = 0; c<moving.length;c++)
                {
                    moving[c] = 5000;
                }
            }

            //adding functionality to the buttons
            {
            for (int i = 0; i < players.length; i++) {
                players[i].setColor(i);
                int finalI = i;
                players[i].getBell().addActionListener(e -> enterInput(finalI));
                bidPanel.add(players[i].getBell(), BorderLayout.CENTER);
                switch (i) {
                    case 0:
                        moves_button[i] = new JButton("UP");
                        moves_button[i].setEnabled(false);
                        moves_button[i].addActionListener(e -> upMove());
                        break;
                    case 1:
                        moves_button[i] = new JButton("DOWN");
                        moves_button[i].setEnabled(false);
                        moves_button[i].addActionListener(e -> downMove());

                        break;
                    case 2:
                        moves_button[i] = new JButton("RIGHT");
                        moves_button[i].setEnabled(false);
                        moves_button[i].addActionListener(e -> rightMove());
                        break;
                    case 3:
                        moves_button[i] = new JButton("LEFT");
                        moves_button[i].setEnabled(false);
                        moves_button[i].addActionListener(e -> leftMove());
                        break;
                }
                moves_panel.add(moves_button[i]);
            }
            //adding actionListener to the submit and reset buttons.

            //making and adding the token select radio buttons.
                {
                    bryg = new JRadioButton[4];
                    for(int x = 0; x<bryg.length; x++)
                    {
                        switch (x) {
                            case 0:
                                bryg[x] = new JRadioButton("Blue");
                                break;
                            case 1:
                                bryg[x] = new JRadioButton("Red");
                                break;
                            case 2:
                                bryg[x] = new JRadioButton("Yellow");
                                break;
                            case 3:
                                bryg[x] = new JRadioButton("Green");
                                break;
                        }
                        moves_panel.add(bryg[x]);
                        bryg[x].setEnabled(false);
                    }

                }
            //making and adding the submit and reset buttons.
                {
                    submit = new JButton("Submit");
                    reset = new JButton("reset");
                    submit.setEnabled(false);
                    reset.setEnabled(false);
                    moves_panel.add(submit);
                    moves_panel.add(reset);
                    submit.addActionListener(ae->submitButton());
                    reset.addActionListener(l->setReset());
                }
            contentPane.add(bidPanel, BorderLayout.EAST);
            contentPane.add(moves_panel, BorderLayout.WEST);
        }
            //Uploading random target chip.
            {
            targetPanel = new JPanel();
            targetImage = new JButton();
            targetName = new JLabel();
            targetPanel.setLayout(new GridLayout(1, 3));
            currentTarget = this.TargetChip();
            int x = currentTarget.getX();
            int y = currentTarget.getY();
            boardButton = board.getBoard();
            ImageIcon tempIcon = (ImageIcon) boardButton[x][y].getIcon();
            targetImage.setIcon(tempIcon);
            String loaction = boardButton[x][y].getlocation();
            targetName.setText("Target Chip is: "+ loaction);
            //this.TargetChip();
            numMoves = 0;
            currentMoves = new JLabel(Integer.toString(numMoves));
            targetPanel.add(currentMoves);
            targetPanel.add(targetImage);
            targetPanel.add(targetName);
            contentPane.add(targetPanel,BorderLayout.SOUTH);
            frame.repaint();
            frame.revalidate();
        }
        if(counter == 0){
            this.makeTokens();
            counter++;
        }

        JOptionPane.showMessageDialog(frame, "Players make a bid");
        }
        else{
            JOptionPane.showMessageDialog(frame,"Please select proper board.");
        }

    }

    public void enterInput(int number) {
        int i = -1;
        while (i < 0) {
            String input = JOptionPane.showInputDialog("Enter the no. of moves");
            if (input.length() > 0) {
                try{
                    int inp;
                    inp = Integer.parseInt(input);
                    i++;
                    moving[number] = inp;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        if(!set_timer){
            set_timer =true;
            lblTimeLeft = new JLabel(String.format("Time left:%02d:00", minutes));
            lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
            lblTimeLeft.setForeground(Color.BLACK);
            seconds = 0;
            timer = new Timer(1000, e-> {
                if(seconds >= minutes*60){
                    timer.stop();
                    for(int x =0; x< players.length;x++)
                    {
                        players[x].getBell().setEnabled(false);
                    }


                    set_timer = false;
                    //ask the user to make the move
                    findLowestPlayerBid();
                    JOptionPane.showMessageDialog(null, "Player"+ (currentPlayer[0]+1)+ " make you move.");

                    for(int j = 0; j < moves_button.length; j++ ) moves_button[j].setEnabled(true);
                    for(int x = 0; x < bryg.length; x++) bryg[x].setEnabled(true);
                    submit.setEnabled(true);
                    reset.setEnabled(true);

                }
                else{
                    seconds+=1;
                    lblTimeLeft.setBackground(Color.BLACK);
                    lblTimeLeft.setText("Time left:" + (String.format("%02d", (minutes * 60 - seconds) / 60)) + ":" + (String.format("%02d", (minutes * 60 - seconds) % 60)));
                }

            });
            timer.setRepeats(true);
            timer.start();
            frame.setPreferredSize(new Dimension(800,800));
            lblTimeLeft.setBounds(590, 64, 136, 14);
            contentPane.add(lblTimeLeft,BorderLayout.NORTH);
            frame.revalidate();
            frame.repaint();
        }
    }
    public void findLowestPlayerBid()
    {
        int size, pm, pn;
        pm = 5000;
        pn = 5000;
        size = moving.length;
        for(int i = 0; i<size; i++ ){
            if(moving[i]<pm)
            {
                pm = moving[i];
                pn = i;
            }
        }
        currentPlayer = new int[2];
        currentPlayer[0] = pn;
        currentPlayer[1] = pm;
    }
    public target TargetChip()
    {
        boardButton = board.getBoard();
        Random random = new Random();
        int n1 = random.nextInt(targets.size() - 1);
        target target1 = targets.get(n1);
        //int x = target1.getX();
        //int y = target1.getY();
        return target1;
    }
    public int [] findCord(squareBoard[][] boardButton, String colourToken){
        int x=0 ,y=0;
        for(int i = 0; i < boardButton.length; i++){
            for(int j = 0; j < boardButton.length; j++){
                if(boardButton[i][j].getToken() && colourToken.equals(boardButton[i][j].getTokenName()))
                {
                    x = i; y = j;
                    boardButton[i][j].removeToken();
                    break;
                }

            }
        }
        int [] arr = {x,y};
        return arr;
    }
    public boolean isBRYG()
    {
        if(bryg[0].isSelected() && (bryg[1].isSelected() || bryg[2].isSelected() || bryg[3].isSelected()))
        {
            return false;
        }
        else if(bryg[1].isSelected() && (bryg[0].isSelected() || bryg[2].isSelected() || bryg[3].isSelected()))
        {
           return false;
        }
        else if(bryg[2].isSelected() && (bryg[1].isSelected() || bryg[0].isSelected() || bryg[3].isSelected()))
        {
            return false;
        }
        else if(bryg[3].isSelected() && (bryg[1].isSelected() || bryg[2].isSelected() || bryg[0].isSelected()))
        {
            return false;
        }
        else if(!bryg[0].isSelected() && !bryg[1].isSelected() && !bryg[2].isSelected() && !bryg[3].isSelected())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void leftMove (){
        if(this.isBRYG()) {
            String colorToken = "";
            for(int l = 0; l<bryg.length;l++)
            {
                if(bryg[l].isSelected())
                {
                    if(l == 0){colorToken = "blue";}
                    else if(l==1){colorToken = "red";}
                    else if(l==2){colorToken = "yellow";}
                    else {colorToken = "green";}
                }

            }
            int[] arr = findCord(boardButton, colorToken);
            int x = arr[0];
            int y = arr[1];
            if (!boardButton[x][y].getLeftWall()) {

                int z = 0;
                y -= 1;
                boolean found = false;
                while (y >= 0) {
                    if (boardButton[x][y].getRightWall()) {
                        found = true;
                        if (y < boardButton.length - 1) {
                            z = y + 1;
                            boardButton[x][z].setToken(colorToken);
                        }
                        break;
                    }
                    else if(boardButton[x][y].getToken())
                    {
                        found = true;
                        if (y < boardButton.length - 1) {
                            z = y + 1;
                            boardButton[x][z].setToken(colorToken);
                        }
                        numMoves--;
                        break;

                    }
                    else {
                        if (y == 0) {
                            z = y;
                            boardButton[x][z].setToken(colorToken);
                            break;
                        }
                        y -= 1;
                    }
                }
                numMoves++;
                currentMoves.setText(Integer.toString(numMoves));
            }
            else
            {

                boardButton[x][y].setToken(colorToken);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"Please select proper token.");
        }
    }
    public void upMove(){
        if(this.isBRYG()) {
            String colorToken = "";
            for(int l = 0; l<bryg.length;l++)
            {
                if(bryg[l].isSelected())
                {
                    if(l == 0){colorToken = "blue";}
                    else if(l==1){colorToken = "red";}
                    else if(l==2){colorToken = "yellow";}
                    else {colorToken = "green";}
                }

            }
            int[] arr = findCord(boardButton, colorToken);
            int x = arr[0];
            int y = arr[1];

            if (!boardButton[x][y].getTopWall()) {

                x -= 1;
                int z = 0;
                boolean found = false;
                while (x >= 0) {
                    if (boardButton[x][y].getBottomWall()) {
                        found = true;
                        if (x < boardButton.length - 1) {
                            z = x + 1;
                            boardButton[z][y].setToken(colorToken);
                        }
                        break;
                    }
                    else if(boardButton[x][y].getToken()) {
                        found = true;
                        if (x < boardButton.length - 1) {
                            z = x + 1;
                            boardButton[z][y].setToken(colorToken);
                        }
                        numMoves--;
                        break;
                    }
                    else {
                        if (x == 0) {
                            z = x;
                            boardButton[z][y].setToken(colorToken);
                            break;
                        }
                    }
                    x -= 1;
                }
                numMoves++;
                currentMoves.setText(Integer.toString(numMoves));
            }
            else
            {
                boardButton[x][y].setToken(colorToken);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"Please select proper token.");
        }
    }
    public void downMove(){
        if(this.isBRYG()) {
            String colorToken = "";
            for(int l = 0; l<bryg.length;l++)
            {
                if(bryg[l].isSelected())
                {
                    if(l == 0){colorToken = "blue";}
                    else if(l==1){colorToken = "red";}
                    else if(l==2){colorToken = "yellow";}
                    else {colorToken = "green";}
                }

            }
            int[] arr = findCord(boardButton,colorToken);
            int x = arr[0];
            int y = arr[1];

            if (!boardButton[x][y].getBottomWall()) {
                x += 1;
                int z = 0;
                boolean found = false;
                while (x <= boardButton.length - 1) {
                    if (boardButton[x][y].getTopWall()) {
                        found = true;
                        if (x != 0) {
                            z = x - 1;
                            boardButton[z][y].setToken(colorToken);
                        }
                        break;
                    }
                    else if(boardButton[x][y].getToken()) {
                        found = true;
                        if (x != 0) {
                            z = x - 1;
                            boardButton[z][y].setToken(colorToken);
                        }
                        numMoves--;
                        break;
                    }
                    else {
                        if (x == boardButton.length - 1 || x == 0) {
                            z = x;
                            boardButton[z][y].setToken(colorToken);
                            break;
                        }
                    }
                    x += 1;
                    }
                numMoves++;
                currentMoves.setText(Integer.toString(numMoves));
                }
            else
            {
                boardButton[x][y].setToken(colorToken);
            }
            }
        else
        {
            JOptionPane.showMessageDialog(frame,"Please select proper token.");
        }
        }
    public void rightMove(){
        if(this.isBRYG()) {
            String colorToken = "";
            for(int l = 0; l<bryg.length;l++)
            {
                if(bryg[l].isSelected())
                {
                    if(l == 0){colorToken = "blue";}
                    else if(l==1){colorToken = "red";}
                    else if(l==2){colorToken = "yellow";}
                    else {colorToken = "green";}
                }

            }
            int[] arr = findCord(boardButton,colorToken);
            int x = arr[0];
            int y = arr[1];
            if (!boardButton[x][y].getRightWall()) {
                y += 1;
                int z = 0;
                boolean found = false;
                while (y <= boardButton.length - 1) {
                    if (boardButton[x][y].getLeftWall()) {
                        found = true;
                        if (y != 0) {
                            z = y - 1;
                            boardButton[x][z].setToken(colorToken);
                        }
                        break;
                    }
                    else if(boardButton[x][y].getToken()) {
                        found = true;
                        if (y != 0) {
                            z = y - 1;
                            boardButton[x][z].setToken(colorToken);
                        }
                        numMoves--;
                        break;
                    }
                    else {
                        if (y == boardButton.length - 1) {
                            z = y;
                            boardButton[x][z].setToken(colorToken);
                            break;
                        }
                    }
                    y += 1;
                }
                numMoves++;
                currentMoves.setText(Integer.toString(numMoves));
            }
            else
            {
                boardButton[x][y].setToken(colorToken);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"Please select proper token.");
        }
    }
    public int [] findJustCord(squareBoard[][] boardButton, String colourToken){
        int x=0 ,y=0;
        for(int i = 0; i < boardButton.length; i++){
            for(int j = 0; j < boardButton.length; j++){
                if(boardButton[i][j].getToken() && colourToken.equals(boardButton[i][j].getTokenName()))
                {
                    x = i; y = j;
                    break;
                }

            }
        }
        int [] arr = {x,y};
        return arr;
    }
    public void submitButton()
    {
        if(boardButton[currentTarget.getX()][currentTarget.getY()].getTokenName()!=null) {
            if (boardButton[currentTarget.getX()][currentTarget.getY()].getlocation().contains(boardButton[currentTarget.getX()][currentTarget.getY()].getTokenName())) //checking location and name
            {
                if (numMoves == currentPlayer[1] || numMoves<currentPlayer[1]) {
                    System.out.println(true);
                    players[currentPlayer[0]].incrementChips();//chip incremented.
                    if(isGame_over())
                    {
                        JOptionPane.showMessageDialog(frame,"Player "+winner[0]+" is the winner.");
                        JOptionPane.showMessageDialog(frame,"Game over!");
                        for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                        for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                        submit.setEnabled(false);
                        reset.setEnabled(false);
                        for (int x = 0; x < players.length; x++) {
                            players[x].getBell().setEnabled(false);
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Player " + (currentPlayer[0]+1)+"won");
                        //disabeling the non essential buttons
                        {
                            for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                            for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                            submit.setEnabled(false);
                            reset.setEnabled(false);
                            for (int x = 0; x < players.length; x++) {
                                players[x].getBell().setEnabled(false);
                            }
                        }
                        //getting and displaying the new target.
                        {
                            currentTarget = this.TargetChip();
                            int x = currentTarget.getX();
                            int y = currentTarget.getY();
                            boardButton = board.getBoard();
                            ImageIcon tempIcon = (ImageIcon) boardButton[x][y].getIcon();
                            targetImage.setIcon(tempIcon);
                            String loaction = boardButton[x][y].getlocation();
                            targetName.setText("Target Chip is: " + loaction);
                            //SETTING BACK TO ZERO;
                            numMoves = 0;
                            currentMoves.setText(Integer.toString(numMoves));
                        }
                        //asking to bid
                        JOptionPane.showMessageDialog(frame, "Players make a bid");
                        //disabeling the non essential buttons
                        {
                        for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                        for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                        submit.setEnabled(false);
                        reset.setEnabled(false);}
                        for (int x = 0; x < players.length; x++) {
                            players[x].getBell().setEnabled(true);
                        }
                        lblTimeLeft.setText("");

                        //setting the previous bids again to normal
                        { moving = new Integer[4];
                        for (int c = 0; c < moving.length; c++) {
                            moving[c] = 5000;
                        }
                        }
                        //setting the previous default location into new locations.
                        {
                            tokens = null;
                            tokens = new ArrayList<target>();
                            for (int j = 0; j < 4; j++) {
                                String col;
                                if (j == 0) {
                                    col = "blue";
                                } else if (j == 1) {
                                    col = "red";
                                } else if (j == 2) {
                                    col = "yellow";
                                } else {
                                    col = "green";
                                }
                                int[] arr = findJustCord(boardButton, col);
                                int x = arr[0];
                                int y = arr[1];
                                target token1 = new target(x, y, col);
                                tokens.add(token1);
                            }
                        }


                    }


                }
                else {
                    //telling the player they have the wrong answer.
                    JOptionPane.showMessageDialog(frame,"You have wrong answer and your chance is skipped.");
                    this.setReset();
                    moving[currentPlayer[0]] = 5000;
                    int size, pm, pn;
                    pm = 5000;
                    pn = 5000;
                    size = moving.length;
                    for(int i = 0; i<size; i++ ){
                        if(moving[i]<pm)
                        {
                            pm = moving[i];
                            pn = i;
                        }
                    }
                    currentPlayer[0] = pn;
                    currentPlayer[1] = pm;
                    if(currentPlayer[1] == 5000)
                    //setting everything back to normal
                    {
                        //disabeling the non essential buttons
                        {
                            for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                            for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                            submit.setEnabled(false);
                            reset.setEnabled(false);
                            for (int x = 0; x < players.length; x++) {
                                players[x].getBell().setEnabled(false);
                            }
                        }
                        //getting and displaying the new target.
                        {
                            currentTarget = this.TargetChip();
                            int x = currentTarget.getX();
                            int y = currentTarget.getY();
                            boardButton = board.getBoard();
                            ImageIcon tempIcon = (ImageIcon) boardButton[x][y].getIcon();
                            targetImage.setIcon(tempIcon);
                            String loaction = boardButton[x][y].getlocation();
                            targetName.setText("Target Chip is: " + loaction);
                            //SETTING BACK TO ZERO;
                            numMoves = 0;
                            currentMoves.setText(Integer.toString(numMoves));
                        }
                        //asking to bid
                        JOptionPane.showMessageDialog(frame, "Players make a bid");
                        //disabeling the non essential buttons
                        {
                            for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                            for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                            submit.setEnabled(false);
                            reset.setEnabled(false);}
                        for (int x = 0; x < players.length; x++) {
                            players[x].getBell().setEnabled(true);
                        }
                        lblTimeLeft.setText("");

                        //setting the previous bids again to normal
                        { moving = new Integer[4];
                            for (int c = 0; c < moving.length; c++) {
                                moving[c] = 5000;
                            }
                        }
                        //setting the previous default location into new locations.
                        {
                            tokens = null;
                            tokens = new ArrayList<target>();
                            for (int j = 0; j < 4; j++) {
                                String col;
                                if (j == 0) {
                                    col = "blue";
                                } else if (j == 1) {
                                    col = "red";
                                } else if (j == 2) {
                                    col = "yellow";
                                } else {
                                    col = "green";
                                }
                                int[] arr = findJustCord(boardButton, col);
                                int x = arr[0];
                                int y = arr[1];
                                target token1 = new target(x, y, col);
                                tokens.add(token1);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame,"Player " + (currentPlayer[0]+1) + "make you move");
                    }

                }

            }
            else
            {
                //telling the player they have the wrong answer.
                JOptionPane.showMessageDialog(frame,"You have wrong answer and your chance is skipped.");
                this.setReset();
                moving[currentPlayer[0]] = 5000;
                int size, pm, pn;
                pm = 5000;
                pn = 5000;
                size = moving.length;
                for(int i = 0; i<size; i++ ){
                    if(moving[i]<pm)
                    {
                        pm = moving[i];
                        pn = i;
                    }
                }
                currentPlayer[0] = pn;
                currentPlayer[1] = pm;
                if(currentPlayer[1] == 5000)
                //setting everything back to normal
                {
                    //disabeling the non essential buttons
                    {
                        for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                        for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                        submit.setEnabled(false);
                        reset.setEnabled(false);
                        for (int x = 0; x < players.length; x++) {
                            players[x].getBell().setEnabled(false);
                        }
                    }
                    //getting and displaying the new target.
                    {
                        currentTarget = this.TargetChip();
                        int x = currentTarget.getX();
                        int y = currentTarget.getY();
                        boardButton = board.getBoard();
                        ImageIcon tempIcon = (ImageIcon) boardButton[x][y].getIcon();
                        targetImage.setIcon(tempIcon);
                        String loaction = boardButton[x][y].getlocation();
                        targetName.setText("Target Chip is: " + loaction);
                        //SETTING BACK TO ZERO;
                        numMoves = 0;
                        currentMoves.setText(Integer.toString(numMoves));
                    }
                    //asking to bid
                    JOptionPane.showMessageDialog(frame, "Players make a bid");
                    //disabeling the non essential buttons
                    {
                        for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                        for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                        submit.setEnabled(false);
                        reset.setEnabled(false);}
                    for (int x = 0; x < players.length; x++) {
                        players[x].getBell().setEnabled(true);
                    }
                    lblTimeLeft.setText("");

                    //setting the previous bids again to normal
                    { moving = new Integer[4];
                        for (int c = 0; c < moving.length; c++) {
                            moving[c] = 5000;
                        }
                    }
                    //setting the previous default location into new locations.
                    {
                        tokens = null;
                        tokens = new ArrayList<target>();
                        for (int j = 0; j < 4; j++) {
                            String col;
                            if (j == 0) {
                                col = "blue";
                            } else if (j == 1) {
                                col = "red";
                            } else if (j == 2) {
                                col = "yellow";
                            } else {
                                col = "green";
                            }
                            int[] arr = findJustCord(boardButton, col);
                            int x = arr[0];
                            int y = arr[1];
                            target token1 = new target(x, y, col);
                            tokens.add(token1);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Player " + (currentPlayer[0]+1) + "make you move");
                }
            }
        }

        else
        {
            //telling the player they have the wrong answer.
            JOptionPane.showMessageDialog(frame,"You have wrong answer and your chance is skipped.");
            this.setReset();
            moving[currentPlayer[0]] = 5000;
            int size, pm, pn;
            pm = 5000;
            pn = 5000;
            size = moving.length;
            for(int i = 0; i<size; i++ ){
                if(moving[i]<pm)
                {
                    pm = moving[i];
                    pn = i;
                }
            }
            currentPlayer[0] = pn;
            currentPlayer[1] = pm;
            if(currentPlayer[1] == 5000)
            //setting everything back to normal
            {
                //disabeling the non essential buttons
                {
                    for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                    for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                    submit.setEnabled(false);
                    reset.setEnabled(false);
                    for (int x = 0; x < players.length; x++) {
                        players[x].getBell().setEnabled(false);
                    }
                }
                //getting and displaying the new target.
                {
                    currentTarget = this.TargetChip();
                    int x = currentTarget.getX();
                    int y = currentTarget.getY();
                    boardButton = board.getBoard();
                    ImageIcon tempIcon = (ImageIcon) boardButton[x][y].getIcon();
                    targetImage.setIcon(tempIcon);
                    String loaction = boardButton[x][y].getlocation();
                    targetName.setText("Target Chip is: " + loaction);
                    //SETTING BACK TO ZERO;
                    numMoves = 0;
                    currentMoves.setText(Integer.toString(numMoves));
                }
                //asking to bid
                JOptionPane.showMessageDialog(frame, "Players make a bid");
                //disabeling the non essential buttons
                {
                    for (int j = 0; j < moves_button.length; j++) moves_button[j].setEnabled(false);
                    for (int x = 0; x < bryg.length; x++) bryg[x].setEnabled(false);
                    submit.setEnabled(false);
                    reset.setEnabled(false);}
                for (int x = 0; x < players.length; x++) {
                    players[x].getBell().setEnabled(true);
                }
                lblTimeLeft.setText("");

                //setting the previous bids again to normal
                { moving = new Integer[4];
                    for (int c = 0; c < moving.length; c++) {
                        moving[c] = 5000;
                    }
                }
                //setting the previous default location into new locations.
                {
                    tokens = null;
                    tokens = new ArrayList<target>();
                    for (int j = 0; j < 4; j++) {
                        String col;
                        if (j == 0) {
                            col = "blue";
                        } else if (j == 1) {
                            col = "red";
                        } else if (j == 2) {
                            col = "yellow";
                        } else {
                            col = "green";
                        }
                        int[] arr = findJustCord(boardButton, col);
                        int x = arr[0];
                        int y = arr[1];
                        target token1 = new target(x, y, col);
                        tokens.add(token1);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Player " + (currentPlayer[0]+1) + "make you move");
            }
        }


    }
    public boolean isGame_over()
    {
        int[] chips = new int[4];
        for(int h=0;h<chips.length;h++)
        {
            chips[h] = players[h].getChips();
            if(chips[h] == turn)
            {
                game_over = true;
                winner = new int[1];
                winner[0] = h+1;
                return true;
            }
        }
        return false;

    }

    public void setReset()
    {
        findCord(board.getBoard(),"blue");
        findCord(board.getBoard(),"red");
        findCord(board.getBoard(),"green");
        findCord(board.getBoard(),"yellow");
        for (int i = 0; i < tokens.size(); i++) {
            int x = tokens.get(i).getX();
            int y = tokens.get(i).getY();
            String color = tokens.get(i).getTokenName();
            boardButton = board.getBoard();
            boardButton[x][y].setToken(color);
        }
        numMoves = 0;
        currentMoves.setText(Integer.toString(numMoves));

    }

}
