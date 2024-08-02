import ds.desktop.notify.DesktopNotify;

public class NotificationTest {

    public static void main(String[] args) {
        DesktopNotify.showDesktopMessage(
                "This is a notification",
                "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
                DesktopNotify.SUCCESS);
        DesktopNotify.showDesktopMessage(
                "This is a notification",
                "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
                DesktopNotify.INFORMATION);
        DesktopNotify.showDesktopMessage(
                "This is a notification",
                "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
                DesktopNotify.ERROR);
    }
}
