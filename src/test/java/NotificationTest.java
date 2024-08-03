import desktop.notify.DesktopNotify;
import desktop.notify.NotificationBuilder;
import desktop.notify.model.NotifyType;
import desktop.notify.theme.NotifyThemes;

public class NotificationTest {

    public static void main(String[] args) {
        DesktopNotify.showDesktopMessage(
                "This is a notification sucess",
                "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
                NotifyType.SUCCESS);
        DesktopNotify.showDesktopMessage(
                "This is a notification",
                "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
                NotifyType.INFORMATION);
        DesktopNotify.show(new NotificationBuilder()
                .setTitle("Slim Theme").setMessage("Mensagem aleatório")
                .setType(NotifyType.WARNING).setTheme(NotifyThemes.SLIM_DARK.getTheme())
                .build());
    }
}
