package nob.example.easyapp.service.model;

/**
 * ユーザ登録処理向け入力モデルです。
 * 
 * @param name     ユーザ名
 * @param password パスワード
 * 
 * @author nob
 */
public record RegistUserInModel(String name, String password) {
}
