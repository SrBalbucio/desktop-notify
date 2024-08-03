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
                .setTitle("Slim Theme").setMessage("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
                .setType(NotifyType.INFORMATION).setTheme(NotifyThemes.SLIM_LIGHT.getTheme())
                .setIcon(Toolkit.getDefaultToolkit().createImage(ImageIO.read(NotificationTest.class.getResourceAsStream("/img.png")).getSource()))
                .build());
    }
}
