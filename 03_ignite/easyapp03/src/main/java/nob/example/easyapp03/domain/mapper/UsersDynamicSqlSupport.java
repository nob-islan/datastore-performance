package nob.example.easyapp03.domain.mapper;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

/**
 * usersテーブルのsqlSupportクラスです。
 *
 * @author nob
 */
public class UsersDynamicSqlSupport {

    public static final Users users = new Users();

    public static final SqlColumn<String> id = users.id;
    public static final SqlColumn<String> name = users.name;
    public static final SqlColumn<Integer> age = users.age;

    public static final class Users extends SqlTable {

        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);
        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public Users() {
            super("users");
        }
    }
}