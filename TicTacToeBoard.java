import javax.swing.*;
import java.awt.*;

public class TicTacToeBoard extends JFrame
{
    private TicTacToeTile[][] board = new TicTacToeTile[3][3];
    private int moves;
    private String player = "x";

    private final int TIE_MOVES = 7;
    private final int WIN_MOVES = 5;

    public TicTacToeBoard()
    {
        for
        (int row = 0; row < 3; row++) for (int col= 0; col < 3; col++)
        {
            board[row][col] = new TicTacToeTile(row, col);
            board[row][col].setText(" ");
            board[row][col].setFont(new Font("Times New Roman", Font.BOLD, 40));
        }
    }

    public TicTacToeTile[][] getBoard()
    {
        return board;
    }

    public void setBoard(TicTacToeTile[][] board)
    {
        this.board = board;
    }

    public int getMoves()
    {
        return moves;
    }

    public void setMoves(int moves)
    {
        this.moves = moves;
    }

    public String getPlayer()
    {
        return player;
    }

    public void setPlayer(String player) {

        this.player = player;
    }

    public int getMOVES_FOR_TIE()
    {
        return TIE_MOVES;
    }

    public int getMOVES_FOR_WIN()
    {
        return WIN_MOVES;
    }


    public void clearBoard()
    {
        for
        (int row = 0; row < 3; row++) for (int col= 0; col < 3; col++)
        {
            board[row][col].setText(" ");
        }
    }

    public boolean isColWin(String player)
    {
        for
        (int col=0; col < 3; col++)
        {
            if (board[0][col].getText().equals(player) && board[1][col].getText().equals(player) && board[2][col].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalWin(String player)
    {
        if (board[0][0].getText().equals(player) && board[1][1].getText().equals(player) && board[2][2].getText().equals(player))
        {
            return true;
        }
        if (board[0][2].getText().equals(player) && board[1][1].getText().equals(player) && board[2][0].getText().equals(player))
        {
            return true;
        }
        return false;
    }

    public boolean isRowWin(String player)
    {
        for
        (int row=0; row < 3; row++)
        {
            if (board[row][0].getText().equals(player) && board[row][1].getText().equals(player) && board[row][2].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }


    public boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;

        for(int row=0; row < 3; row++)
        {
            if
            (board[row][0].getText().equals("X") || board[row][1].getText().equals("X") || board[row][2].getText().equals("X"))
            {
                xFlag = true;
            }
            if
            (board[row][0].getText().equals("O") || board[row][1].getText().equals("O") || board[row][2].getText().equals("O"))
            {
                oFlag = true;
            }

            if
            (!(xFlag && oFlag))
            {
                return false;
            }
            xFlag = oFlag = false;
        }

        for (int col=0; col < 3; col++)
        {
            if
            (board[0][col].getText().equals("X") || board[1][col].getText().equals("X") || board[2][col].getText().equals("X"))
            {
                xFlag = true;
            }
            if
            (board[0][col].getText().equals("O") || board[1][col].getText().equals("O") || board[2][col].getText().equals("O"))
            {
                oFlag = true;
            }

            if (!(xFlag && oFlag))
            {
                return false;
            }
        }
        xFlag = oFlag = false;

        if

        (board[0][0].getText().equals("X") || board[1][1].getText().equals("X") || board[2][2].getText().equals("X"))
        {
            xFlag = true;
        }
        if
        (board[0][0].getText().equals("O") || board[1][1].getText().equals("O") || board[2][2].getText().equals("O"))
        {
            oFlag = true;
        }
        if
        (!(xFlag && oFlag))
        {
            return false;
        }
        xFlag = oFlag = false;

        if (board[0][2].getText().equals("X") || board[1][1].getText().equals("X") || board[2][0].getText().equals("X"))
        {
            xFlag =  true;
        }
        if (board[0][2].getText().equals("O") || board[1][1].getText().equals("O") || board[2][0].getText().equals("O"))
        {
            oFlag =  true;
        }
        if (!(xFlag && oFlag))
        {
            return false;
        }
        return true;
    }
}
