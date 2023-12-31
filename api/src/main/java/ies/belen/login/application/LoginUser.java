package ies.belen.login.application;

import java.util.Optional;

import ies.belen.users.application.UserDto;
import ies.belen.users.domain.User;
import ies.belen.users.domain.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class LoginUser {

    @Inject
    private UserRepository userRepository;

    public Optional<UserDto> login(UserDto userDto) {
        final User userInput = UserDto.toUser(userDto);
        return userRepository.findByName(userInput.getUsername())
                .flatMap(userDB -> User.equalsCredentials(userInput, userDB)
                        ? Optional.of(User.toUserDto(userDB))
                        : Optional.empty());
    }

}
