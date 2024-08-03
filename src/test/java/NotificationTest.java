import desktop.notify.DesktopNotify;
import desktop.notify.NotificationBuilder;
import desktop.notify.model.Notify;
import desktop.notify.model.NotifyType;
import desktop.notify.theme.NotifyThemes;

import javax.imageio.ImageIO;
import java.awt.*;

public class NotificationTest {

    public static void main(String[] args) throws Exception {

        DesktopNotify.setDefaultWidth(400);

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
                .setTitle("Slim Theme").setMessage("Se eu fizer um story com a minha novinha\n" +
                        "Ela fica famosa\n" +
                        "Minha rivalidade com meus concorrentes\n" +
                        "Tem que ser uma coisa amistosa\n" +
                        "Eu pulei etapas, eles tão na mesma")
                .setType(NotifyType.INFORMATION).setTheme(NotifyThemes.SLIM_LIGHT.getTheme())
                        .setIcon(Toolkit.getDefaultToolkit().createImage(ImageIO.read(NotificationTest.class.getResourceAsStream("/img.png")).getSource()))
                .build());

        DesktopNotify.show(new NotificationBuilder()
                .setTitle("Slim Theme").setMessage("Minh")
                .setType(NotifyType.INFORMATION).setTheme(NotifyThemes.SLIM_LIGHT.getTheme())
                .setIcon(Toolkit.getDefaultToolkit().createImage(ImageIO.read(NotificationTest.class.getResourceAsStream("/img.png")).getSource()))
                .build());
    }
}
