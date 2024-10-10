import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToeWinnerChecker {
    public static boolean checkWinner(TicTacToeUI ui) {
        JButton[] buttons = ui.getButtons();
        
        
        for (int i = 0; i < 3; i++) {
            
            if (buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText()) &&
                buttons[i * 3].getText().equals(buttons[i * 3 + 2].getText()) &&
                !buttons[i * 3].isEnabled()) {
                showWinner(buttons[i * 3].getText());
                return true;
            }
            
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                buttons[i].getText().equals(buttons[i + 6].getText()) &&
                !buttons[i].isEnabled()) {
                showWinner(buttons[i].getText());
                return true;
            }
        }

        
        if (buttons[0].getText().equals(buttons[4].getText()) &&
            buttons[0].getText().equals(buttons[8].getText()) &&
            !buttons[0].isEnabled()) {
            showWinner(buttons[0].getText());
            return true;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) &&
            buttons[2].getText().equals(buttons[6].getText()) &&
            !buttons[2].isEnabled()) {
            showWinner(buttons[2].getText());
            return true;
        }

        
        boolean tie = true;
        for (JButton button : buttons) {
            if (button.isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(ui.getFrame(), "Tie game");
            return true;
        }

        return false;
    }

    private static void showWinner(String winner) {
        JOptionPane.showMessageDialog(null, winner + " wins!");
    }
}
