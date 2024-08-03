package desktop.notify.theme;

import java.awt.*;

public class LightSlimNotifyTheme extends NotifyTheme{
    {
        titleFont = new Font("Verdana", Font.BOLD, 14);
        contentFont = new Font("Verdana", Font.PLAIN, 12);
        borderColor = new Color(200, 200, 200);
        titleColor = Color.BLACK;
        contentColor = Color.BLACK;
        iconSet = defaultIconSet;
        setBgGrad(new Color(240, 240, 240), new Color(235, 235, 235));
        setTransparent(false);
    }
}
