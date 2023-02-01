package examm.service.servece;

import examm.model.Instagram_account;
import examm.repository.InstagramAccountRepository;
import examm.repository.repositoryImpl.InstagramAccountRepositoryImpl;
import examm.service.InstagramAccountService;

/**
 * The golden boy
 */
public class InstagramAccountServiceImpl implements InstagramAccountService {
    InstagramAccountRepositoryImpl instagramAccountRepository = new InstagramAccountRepositoryImpl();

    @Override
    public String save(Instagram_account instagramAccount, Long userID) {

        return instagramAccountRepository.save(instagramAccount, userID);
    }

    @Override
    public Instagram_account getById(Long id) {
        return instagramAccountRepository.getById(id);
    }

    @Override
    public Boolean existByEmail(String login) {
        return instagramAccountRepository.existByEmail(login);
    }

    @Override
    public String changePassport(Long id, String changePassport) {
        return instagramAccountRepository.changePassport(id,changePassport);
    }

    @Override
    public Instagram_account updateById(Long id, Instagram_account newInstagramAccount) {
        return instagramAccountRepository.updateById(id,newInstagramAccount);
    }
}
