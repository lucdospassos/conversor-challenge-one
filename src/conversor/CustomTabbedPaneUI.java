package conversor;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class CustomTabbedPaneUI extends BasicTabbedPaneUI {


    private Color selectedBackgroundColor;
    private Color selectedTextColor;
    private Color unselectedBackgroundColor;
    private Color unselectedTextColor;

    public CustomTabbedPaneUI(Color selectedBgColor, Color selectedTextColor, Color unselectedBgColor, Color unselectedTextColor) {
        this.selectedBackgroundColor = selectedBgColor;
        this.selectedTextColor = selectedTextColor;
        this.unselectedBackgroundColor = unselectedBgColor;
        this.unselectedTextColor = unselectedTextColor;
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        if (isSelected) {
            g.setColor(selectedBackgroundColor);
        } else {
            g.setColor(unselectedBackgroundColor);
        }
        g.fillRect(x, y, w, h);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        if (isSelected) {
            g.setColor(selectedTextColor);
        } else {
            g.setColor(unselectedTextColor);
        }
        super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
    }
}
