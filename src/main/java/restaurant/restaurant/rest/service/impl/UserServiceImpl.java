package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.UserType.UserType;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseUser;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.repository.UserRepository;
import restaurant.restaurant.rest.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(ResponseUser responseUser) {
        User user = UserMapper.mapToUser(responseUser);
        user.setUserType(UserType.USER);
        userRepository.save(user);

    }

    @Override
    public RequestUser findById(Long id) {
        return UserMapper.mapToRequestUser(userRepository.findById(id).get());
    }


    @Override
    public List<RequestUser> findAll() {
        return null;
    }

    @Override
    public Optional<RequestUser> findByLogin(String login) {
        Optional<User> user=userRepository.findByLogin(login);
        return user.map(reqUser -> UserMapper.mapToRequestUser(reqUser));
    }
}
