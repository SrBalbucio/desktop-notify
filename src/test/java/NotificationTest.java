import desktop.notify.DesktopNotify;
import desktop.notify.NotificationBuilder;
import desktop.notify.model.NotifyType;
import desktop.notify.theme.NotifyThemes;

public class NotificationTest {

    public static void main(String[] args) {
        DesktopNotify.show(new NotificationBuilder()
                .setTitle("De fato").setMessage("Mensagem de sucesso bem foda!")
                .setType(NotifyType.SUCCESS).setTheme(NotifyThemes.LIGHT.getTheme())
                .build());
        DesktopNotify.show(new NotificationBuilder()
                .setTitle("Dark Theme").setMessage("Mensagem aleatório")
                .setType(NotifyType.FAIL).setTheme(NotifyThemes.DARK.getTheme())
                .build());
        DesktopNotify.show(new NotificationBuilder()
                .setTitle("Slim Theme").setMessage("Mensagem aleatório")
                .setType(NotifyType.WARNING).setTheme(NotifyThemes.SLIM_DARK.getTheme())
                .build());
        DesktopNotify.show(new NotificationBuilder()
                .setTitle("Slim Theme").setMessage("Mensagem aleatório")
                .setType(NotifyType.INFORMATION).setTheme(NotifyThemes.SLIM_LIGHT.getTheme())
                .build());
    }
}
