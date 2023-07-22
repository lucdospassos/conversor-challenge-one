package conversor;

import javax.swing.*;
import java.awt.*;

public class MeuFramePrincipal extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5449670298285246169L;
	private boolean selected;

    public MeuFramePrincipal() {
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
