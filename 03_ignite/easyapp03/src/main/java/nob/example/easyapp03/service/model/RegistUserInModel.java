package nob.example.easyapp03.service.model;

/**
 * ユーザ登録処理向け入力モデルです。
 * 
 * @param name ユーザ名
 * @param age  年齢
 * 
 * @author nob
 */
public record RegistUserInModel(String name, Integer age) {
}