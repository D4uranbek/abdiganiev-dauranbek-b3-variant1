package uz.d4uranbek;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.d4uranbek.entity.AuthUser;

import java.util.Objects;

@Getter
@Setter
@Component
public class SecurityContextHolder {

    private AuthUser session;

    public boolean isLoggedIn() {
        return Objects.isNull(session);
    }
}
