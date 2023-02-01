package examm.service;

import examm.model.User;

/**
 * The golden boy
 */
public interface UserService {
    String save (User user);
    User getById(Long id);

    User updateById(Long id,User newUser);
    void deleteById(Long id);
}
