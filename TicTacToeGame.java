import javax.swing.JButton;
import java.awt.Component; 

public class TicTacToeGame {
    private TicTacToeUI ui;
    private boolean xTurn = true;

    public TicTacToeGame(TicTacToeUI ui) {
        this.ui = ui;
    }

    public void buttonClicked(JButton button) {
        if (xTurn) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        button.setEnabled(false);
        xTurn = !xTurn;
        checkForWinner();
    }

    public void checkForWinner() {
        
        if (TicTacToeWinnerChecker.checkWinner(ui)) {
            resetGame();
        }
    }

    public void resetGame() {
        for (Component comp : ui.getPanel().getComponents()) {
            if (comp instanceof JButton) { 
                JButton button = (JButton) comp;
                button.setText("");
                button.setEnabled(true);
            }
        }
        xTurn = true;
    }
}
