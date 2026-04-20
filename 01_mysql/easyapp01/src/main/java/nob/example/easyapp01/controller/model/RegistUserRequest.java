package nob.example.easyapp01.controller.model;

/**
 * ユーザ登録処理向けリクエストモデルです。
 * 
 * @param name ユーザ名
 * @param age  年齢
 * 
 * @author nob
 */
public record RegistUserRequest(String name, Integer age) {
}
