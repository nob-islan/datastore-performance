package nob.example.easyapp01.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import nob.example.easyapp01.domain.entity.Users;
import nob.example.easyapp01.repository.UsersRepository;
import nob.example.easyapp01.service.UserService;
import nob.example.easyapp01.service.model.FetchUserInModel;
import nob.example.easyapp01.service.model.FetchUserOutModel;
import nob.example.easyapp01.service.model.RegistUserInModel;
import nob.example.easyapp01.service.model.RegistUserOutModel;

/**
 * UserServiceの実装です。
 * 
 * @author nob
 */
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public FetchUserOutModel fetch(FetchUserInModel inModel) {

        Optional<Users> optUsers = usersRepository.findById(inModel.id());
        if (optUsers.isEmpty()) {
            return new FetchUserOutModel("", "John doe", 0);
        }
        return new FetchUserOutModel(optUsers.get().getId(), optUsers.get().getName(), optUsers.get().getAge());
    }

    @Override
    public RegistUserOutModel regist(RegistUserInModel inModel) {

        String id = UUID.randomUUID().toString();
        usersRepository.save(new Users(id, inModel.name(), inModel.age()));

        return new RegistUserOutModel(id);
    }
}
