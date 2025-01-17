/*
 * DS Desktop Notify
 * A small utility to show small notifications in your Desktop anytime!
 */
package desktop.notify;

import desktop.notify.model.Notify;
import desktop.notify.model.NotifyDirection;
import desktop.notify.model.NotifyType;
import desktop.notify.theme.NotifyTheme;

import java.awt.Image;
import java.awt.event.ActionListener;

/**
 * Utilitary object that allows easy and flexible build of notifications that
 * fit any of your evil interests. For those who want to keep more control
 * on what their notifications show or didn't find any static method that did
 * the trick.<br><br>
 * <b>HOW-TO:</b><br>
 * <ol>
 * <li>Instance an object of this class.<br>
 *     {@code NotificationBuilder builder = new NotificationBuilder();}</li>
 * <li>Append all the stuff you want into the builder. For instace:<br>
 *     {@code builder.setTitle("My title").setMessage("Random message").setIcon(myIcon);}<br>
 *     Just look at how easy is to chain calls with this thing.</li>
 * <li>Build your notification by calling {@link #build()}.<br>
 *     {@code DesktopNotify notification = builder.build();}</li>
 * <li>When you're ready to show the notification, call {@link Notify#show()}.<br>
 *     {@code notification.show();}<br>
 *     You may prefer to chain the calls if you want to show it right now.<br>
 *     {@code builder.build().show();}<br>
 *     Before you ask, yeah, you can spawn as many notifications as you please
 *     at this point, and they'll all look the same.</li>
 * <li>Once you're done, call {@link #reset()} to begin from scratch if you need
 *     to.<br>
 *     {@code builder.reset();}<br>
 *     There's the method {@link #buildAndReset()}, if you want to fetch your
 *     new notification and erase all the contents set in the builder.<br>
 *     {@code DesktopNotify notification = builder.buildAndReset();}<br>
 *     It works just like {@link #build()}, you can even chain calls with this.
 *     <br>
 *     {@code builder.buildAndReset().show();}</li>
 * </ol>
 * This class is reusable and not thread-safe.
 *
 * @author DragShot
 * @since 05/21/2016 (0.8)
 */
public class NotificationBuilder {

    private String title;
    private String message;
    private Image icon;
    private NotifyType type;
    private NotifyDirection orientation;
    private long timeOut;
    private ActionListener action;
    private NotifyTheme theme;

    /**
     * Default constructor.
     */
    public NotificationBuilder() {
        type = NotifyType.NONE;
        orientation = DesktopNotify.defTextOrientation;
        timeOut = 0L;
    }

    /**
     * Sets the title for the notification to build.
     *
     * @param title The title.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the message for the notification to build.
     *
     * @param message The message.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Sets the icon for the notification to build.
     *
     * @param icon The icon.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setIcon(Image icon) {
        this.icon = icon;
        return this;
    }

    /**
     * Sets the type of notification to build.
     *
     * @param type The type of notification.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setType(NotifyType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the prefered orientation of the text to be displayed, this
     * determines the default text alignment.
     *
     * @param orientation The text orientation, either
     *                    {@link DesktopNotify#LEFT_TO_RIGHT} or
     *                    {@link DesktopNotify#RIGHT_TO_LEFT}.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setTextOrientation(NotifyDirection orientation) {
        this.orientation = orientation;
        return this;
    }

    /**
     * Sets the timeout for the notification to build. Setting 0 will make the
     * built notification to stay on screen until the user clicks it.
     *
     * @param timeOut The maximum time in milliseconds this notification will
     *                stay on screen.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setTimeOut(long timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    /**
     * Sets the ActionListener to use in the notification to build.
     *
     * @param action The ActionListener to use in the notification.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setAction(ActionListener action) {
        this.action = action;
        return this;
    }

    /**
     * Sets the theme to use in the notification to build.
     *
     * @param theme The theme to use in the notification.
     * @return This builder, just to chain calls.
     */
    public NotificationBuilder setTheme(NotifyTheme theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Builds a new <code>DesktopNotify</code> object. Once you've got to this
     * point, apend a call to {@link Notify#show} to make it appear
     * inmmediately or just hold onto it until you need to show it.
     * You may continue from the current state in order to customize and build
     * a new notification.
     *
     * @return A brand new and fully customized <code>DesktopNotify</code>
     * object for it to be used in any of your evil interests.
     */
    public Notify build() {
        if (title == null && message == null)
            throw new IllegalStateException("The notification lacks of any "
                    + "text to show!");
        Notify pane = new Notify(title, message, type, orientation, icon);
        pane.setTimeout(timeOut);
        pane.setAction(action);
        pane.setTheme(theme);
        return pane;
    }

    /**
     * Clears all saved data and sets this builder in blank, so you can start
     * from scratch again.
     */
    public void reset() {
        title = null;
        message = null;
        icon = null;
        type = NotifyType.NONE;
        timeOut = 0L;
        action = null;
        theme = null;
    }

    /**
     * Builds a new <code>DesktopNotify</code> object, and then resets this
     * builder for you to begin bilding the next one from scratch. Once you've
     * got to this point, apend a call to {@link Notify#show} to make it
     * appear inmmediately or just hold onto it until you need to show it.
     *
     * @return A brand new and fully customized <code>DesktopNotify</code>
     * object for it to be used in any of your evil interests.
     */
    public Notify buildAndReset() {
        Notify pane = build();
        reset();
        return pane;
    }
}