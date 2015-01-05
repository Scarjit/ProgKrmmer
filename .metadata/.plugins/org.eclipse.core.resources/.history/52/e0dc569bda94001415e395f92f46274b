package demo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main
{
    public static void main(String[] args) {
        String[] labels = {
                "Text1",
                "Text2",
                "Text3",
                "Text4"
        };
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String s: labels) {
            panel.add(new JLabel(s));
        }
        frame.add(panel);
        JButton button = new JButton("Remove");
        button.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	System.out.println(e.getActionCommand());
                if (panel.getComponentCount() > 0)
                    panel.remove(0);
                	panel.getComponent(0).setVisible(false);
                frame.repaint();
                frame.pack();
            }
        });
        frame.add(button, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}