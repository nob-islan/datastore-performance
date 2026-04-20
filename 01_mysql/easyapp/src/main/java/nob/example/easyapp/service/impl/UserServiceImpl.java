package nob.example.easyapp.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import nob.example.easyapp.domain.entity.Users;
import nob.example.easyapp.repository.UsersRepository;
import nob.example.easyapp.service.UserService;
import nob.example.easyapp.service.model.FetchUserInModel;
import nob.example.easyapp.service.model.FetchUserOutModel;
import nob.example.easyapp.service.model.RegistUserInModel;
import nob.example.easyapp.service.model.RegistUserOutModel;

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
