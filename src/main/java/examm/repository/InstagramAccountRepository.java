package examm.repository;

import examm.model.Instagram_account;

/**
 * The golden boy
 */
public interface InstagramAccountRepository {
    String save (Instagram_account instagramAccount,Long userId);
    Instagram_account getById(Long id);
    Boolean existByEmail(String login);
    String changePassport(Long id ,String changePassport);
    Instagram_account updateById(Long id,Instagram_account newInstagramAccount);








}
