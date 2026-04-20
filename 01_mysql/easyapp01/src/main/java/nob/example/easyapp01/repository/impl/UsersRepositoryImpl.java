package nob.example.easyapp01.repository.impl;

import java.util.Optional;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import nob.example.easyapp01.domain.entity.Users;
import nob.example.easyapp01.domain.mapper.UsersDynamicSqlSupport;
import nob.example.easyapp01.domain.mapper.UsersMapper;
import nob.example.easyapp01.repository.UsersRepository;

/**
 * UsersRepositoryの実装です。
 * 
 * @author nob
 */
@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @NonNull
    private UsersMapper usersMapper;

    public UsersRepositoryImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Optional<Users> findById(String id) {

        SelectStatementProvider selectStatement = SqlBuilder.select(UsersDynamicSqlSupport.users.allColumns())
                .from(UsersDynamicSqlSupport.users)
                .where(UsersDynamicSqlSupport.users.id, SqlBuilder.isEqualToWhenPresent(id))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return Optional.of(usersMapper.select(selectStatement).get(0));
    }

    @Override
    public void save(Users users) {

        InsertStatementProvider<Users> insertStatement = SqlBuilder.insert(users)
                .into(UsersDynamicSqlSupport.users)
                .map(UsersDynamicSqlSupport.id).toProperty("id")
                .map(UsersDynamicSqlSupport.name).toProperty("name")
                .map(UsersDynamicSqlSupport.age).toProperty("age")
                .build()
                .render(RenderingStrategies.MYBATIS3);

        usersMapper.insert(insertStatement);
    }
}
