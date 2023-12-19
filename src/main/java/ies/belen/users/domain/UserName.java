package ies.belen.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class UserName {

    @Column(name = "username")
    private String username;

    public UserName(String value) {
        this.username = value;
    }

}
