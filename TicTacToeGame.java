import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.NORTH;

public class TicTacToeGame extends JFrame
{
    JFrame gameFrame = new JFrame();
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel buttonPanel;
    JPanel gamePanel;

    JButton quitButton;
    JLabel titleLabel;

    boolean done;

    TicTacToeBoard TicTacToeBoard = new TicTacToeBoard();

    public TicTacToeGame()
    {
        mainPanel = new JPanel();

        createTitlePanel();
        createButtonPanel();
        createGamePanel();
        createCommandPanel();

        add(mainPanel);

        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createTitlePanel()
    {
        titlePanel = new JPanel();
        titleLabel = new JLabel("TIC TAC TOE", JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        mainPanel.add(titleLabel, NORTH);
    }

    private void createButtonPanel()
    {
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3,3));
        mainPanel.add(gamePanel, BorderLayout.CENTER);
    }

    private void createGamePanel()
    {
        for
        (int row = 0; row < 3; row++) for (int col = 0; col < 3; col++)
        {
            gamePanel.add(TicTacToeBoard.getBoard()[row][col]);
            TicTacToeBoard.getBoard()[row][col].addActionListener((ActionEvent ae) ->
            {
                Object source = ae.getSource();
                if (source instanceof JButton)
                {
                    JButton buttonClick = (JButton) source;

                    if (buttonClick.getText().equals(" "))
                    {
                        buttonClick.setText(TicTacToeBoard.getPlayer());
                        TicTacToeBoard.setMoves(TicTacToeBoard.getMoves() + 1);
                        if (TicTacToeBoard.getMoves() >= TicTacToeBoard.getMOVES_FOR_WIN())
                        {
                            if (isWin(TicTacToeBoard.getPlayer()))
                            {
                                int a = JOptionPane.showConfirmDialog(gameFrame, TicTacToeBoard.getPlayer() + " wins! Do you wanna play again?");
                                if(a == JOptionPane.YES_OPTION)
                                {
                                    TicTacToeBoard.clearBoard();
                                }
                                else if (a == JOptionPane.NO_OPTION)
                                {
                                    System.exit(0);
                                }
                            }
                        }
                        if (TicTacToeBoard.getMoves() >= TicTacToeBoard.getMOVES_FOR_TIE())
                        {
                            if (TicTacToeBoard.isTie())
                            {
                                int a = JOptionPane.showConfirmDialog(gameFrame, "Tie game! Do you want to play again?");
                                if (a == JOptionPane.YES_OPTION)
                                {
                                    TicTacToeBoard.clearBoard();
                                }
                                else if (a == JOptionPane.NO_OPTION)
                                {
                                    System.exit(0);
                                }
                            }
                        }
                        if (TicTacToeBoard.getPlayer().equals("x") && !done)
                        {
                            TicTacToeBoard.setPlayer("o");
                        }
                        else
                        {
                            TicTacToeBoard.setPlayer("x");
                        }
                        done = false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(gameFrame, "Its an invalid move,Please TRY AGAIN");
                    }
                }
            });
        }
    }
    private boolean isWin(String player)
    {
        if (TicTacToeBoard.isColWin(player) || TicTacToeBoard.isRowWin(player) || TicTacToeBoard.isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    public void createCommandPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.GREEN);
        buttonPanel.add(quitButton);
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
    }
}