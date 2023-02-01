package examm.service.servece;

import examm.model.User;
import examm.repository.repositoryImpl.UserRepositoryImpl;
import examm.service.UserService;

/**
 * The golden boy
 */
public class UserServiceImpl implements UserService {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    @Override
    public String save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User updateById(Long id, User newUser) {
        return userRepository.updateById(id,newUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }
}
