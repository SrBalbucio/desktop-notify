/*
 * DS Desktop Notify
 * A small utility to show small notifications in your Desktop anytime!
 */
package desktop.notify.theme;

import desktop.notify.DesktopNotify;
import desktop.notify.DesktopNotifyDriver;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * A <code>NotifyTheme</code> defines the aspect of a desktop notification. You
 * can specify custom colors, icons and fonts to use instead of the two default
 * themes.
 * <p>
 * By the way, the default themes included are <code>NotifyTheme.Dark</code>
 * and <code>NotifyTheme.Light</code>.
 *
 * @author DragShot
 * @since 0.8
 */
public class NotifyTheme {

    /**
     * The default set of icons
     */
    public static final Image[] defaultIconSet;

    //Load the default icon set and themes
    static {
        defaultIconSet = new Image[8];
        for (int i = 0; i < defaultIconSet.length; i++) {
            defaultIconSet[i] = new ImageIcon(Objects.requireNonNull(DesktopNotify.class
                    .getResource("/themes/default/" + (i + 1) + ".png"))).getImage();
        }
    }

    /**
     * The font to use in titles
     * -- GETTER --
     * <p>
     * <p>
     * -- SETTER --
     * Allows to set a font to be used for texts.
     *
     * @return The font being used for titles.
     * @param titleFont the font which will be used for titles.
     */
    @Setter
    @Getter
    protected Font titleFont;
    /**
     * The font to use in the description text
     * -- SETTER --
     * Allows to set a font to be used for texts.
     *
     * @param contentFont the font which will be used for texts.
     */
    @Setter
    @Getter
    protected Font contentFont;
    /**
     * The color to use to paint the notification border
     * -- GETTER --
     *
     * @return The color of the border for this theme.
     */
    @Getter
    protected Color borderColor;
    /**
     * The color to use to paint the title
     */
    @Getter
    protected Color titleColor;
    /**
     * The color to use to paint the description text
     */
    @Getter
    protected Color contentColor;
    /**
     * The colors to use to paint the background
     */
    @Getter
    protected Color[] bgGrad;
    /**
     * The set of icons to use for each notification type
     */
    @Getter
    protected Image[] iconSet;

    @Getter
    @Setter
    protected boolean transparent = true;

    /**
     * @return The background colors to use in the theme (regular background and
     * highlighted gradient), stored in an array.
     */
    public Color[] bgGrad() {
        return new Color[]{bgGrad[0], bgGrad[21]};
    }

    /**
     * Allows to define the background color in a notification. The gradient
     * colors are precalculated to save CPU later.
     *
     * @param base      The regular background color.
     * @param highlight The color to apply a gradient with when the mouse
     *                  pointer is on the notification.
     */
    public void setBgGrad(Color base, Color highlight) {
        this.bgGrad = new Color[22];//Base color + 21 gradient tones
        bgGrad[0] = base;
        for (int i = 0; i < bgGrad.length - 1; i++) {
            bgGrad[i + 1] = new Color(base.getRed() + (int) ((highlight.getRed() - base.getRed()) * i / 20.0F),
                    base.getGreen() + (int) ((highlight.getGreen() - base.getGreen()) * i / 20.0F),
                    base.getBlue() + (int) ((highlight.getBlue() - base.getBlue()) * i / 20.0F),
                    120 + (int) (135 * i / 20.0F));
        }
    }

    /**
     * Allows to set a collection of icons to be used in this theme.
     * The icons should have a resolution of 32x32 pixels. Images that don't
     * comply with this will be scaled during the painting.
     *
     * @param iconSet An array containing the set of icons which will be used in
     *                this theme.
     */
    public void setIconSet(Image[] iconSet) {
        if (iconSet.length < 8)
            throw new IllegalArgumentException("The supplied array of images "
                    + "must contain 8 icons!");
        this.iconSet = iconSet;
    }

    public int getLineHeight(Font font) {
        FontMetrics ftm = DesktopNotifyDriver.getFontMetrics(font);
        return ftm.getHeight() - ftm.getLeading();
    }

    /**
     * Allows to set a color for the borders of the notification.
     *
     * @param notifBorder The color of the border to be used in this theme.
     */
    public void setBorderColor(Color notifBorder) {
        this.borderColor = notifBorder;
    }

}
