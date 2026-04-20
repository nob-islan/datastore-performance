package nob.example.easyapp03.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import nob.example.easyapp03.domain.entity.Users;

/**
 * usersテーブル向けのrepositoryインターフェースです。
 * 
 * @author nob
 */
@Repository
public interface UsersRepository {

    /**
     * 管理IDをキーにしてユーザを検索します。
     * 
     * @param id 管理ID
     * @return ユーザエンティティ
     */
    public Optional<Users> findById(String id);

    /**
     * ユーザを保存します。
     * 
     * @param users ユーザエンティティ
     */
    public void save(Users users);
}