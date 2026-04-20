package nob.example.easyapp03.controller.model;

/**
 * ユーザ登録処理向けリクエストモデルです。
 * 
 * @param name     ユーザ名
 * @param password パスワード
 * 
 * @author nob
 */
public record RegistUserRequest(String name, Integer age) {
}