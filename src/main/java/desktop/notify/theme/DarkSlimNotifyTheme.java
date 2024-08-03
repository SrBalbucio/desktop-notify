package desktop.notify.theme;

import java.awt.*;

public class DarkSlimNotifyTheme extends NotifyTheme {
    {
        titleFont = new Font("Verdana", Font.BOLD, 14);
        contentFont = new Font("Verdana", Font.PLAIN, 12);
        borderColor = new Color(50, 50, 50);
        titleColor = Color.WHITE;
        contentColor = Color.WHITE;
        iconSet = defaultIconSet;
        setBgGrad(new Color(50, 50, 50), new Color(48, 79, 254));
        setTransparent(false);
    }
}
