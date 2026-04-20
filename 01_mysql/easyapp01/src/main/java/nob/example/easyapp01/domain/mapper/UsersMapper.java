package nob.example.easyapp01.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import nob.example.easyapp01.domain.entity.Users;

/**
 * usersテーブルのmapperクラスです。
 *
 * @author nob
 */
@Mapper
public interface UsersMapper {

    /**
     * select
     *
     * @param selectStatement
     * @return
     */
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "usersResult", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
    })
    List<Users> select(SelectStatementProvider selectStatement);

    /**
     * insert
     *
     * @param insertStatement
     * @return
     */
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<Users> insertStatement);
}