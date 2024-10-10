import javax.swing.*;
import java.awt.*;

public class TicTacToeUI {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];

    public TicTacToeUI() {
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        TicTacToeGame game = new TicTacToeGame(this);
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            
            
            final int index = i;
            buttons[i].addActionListener(e -> game.buttonClicked(buttons[index]));
            
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    
    public JButton[] getButtons() {
        return buttons;
    }

    
    public JPanel getPanel() {
        return panel;
    }

    
    public JFrame getFrame() {
        return frame;
    }
}
