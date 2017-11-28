package courses.event;

import courses.domain.entity.UserEntity;
import org.springframework.context.ApplicationEvent;

public class OnSignUpSuccessEvent extends ApplicationEvent {
    private String appUrl;
    private String locale;
    private UserEntity user;

    public OnSignUpSuccessEvent(UserEntity user, String locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
