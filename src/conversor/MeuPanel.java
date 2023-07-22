package conversor;

import javax.swing.*;
import java.awt.*;

public class MeuPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -3279320393111655858L;
	private boolean selected;

    public MeuPanel() {
        selected = false;
        setPreferredSize(new Dimension(200, 200));
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (selected) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.cyan);
        }

        g.fillRect(0, 0, getWidth(), getHeight());
    }
   

}
