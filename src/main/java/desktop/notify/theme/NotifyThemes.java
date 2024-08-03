package desktop.notify.theme;

import lombok.Getter;

public enum NotifyThemes {

    DARK(new DarkNotifyTheme()), LIGHT(new LightNotifyTheme()), SLIM_DARK(new DarkSlimNotifyTheme());

    @Getter
    private NotifyTheme theme;

    NotifyThemes(NotifyTheme theme) {
        this.theme = theme;
    }
}
