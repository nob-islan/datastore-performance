package nob.example.easyapp.service.model;

/**
 * ユーザ検索処理向け出力モデルです。
 * 
 * @param id       管理ID
 * @param name     ユーザ名
 * @param password パスワード
 * 
 * @author nob
 */
public record FetchUserOutModel(String id, String name, String password) {
}
