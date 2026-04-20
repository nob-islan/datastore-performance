package nob.example.easyapp01.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * usersテーブルのentityクラスです。
 *
 * @author nob
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    /** ユーザID */
    private String id;

    /** ユーザ名 */
    private String name;

    /** 年齢 */
    private Integer age;
}