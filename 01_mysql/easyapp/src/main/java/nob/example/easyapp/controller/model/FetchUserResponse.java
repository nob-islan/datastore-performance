package nob.example.easyapp.controller.model;

/**
 * ユーザ検索処理向けレスポンスモデルです。
 * 
 * @param id       管理ID
 * @param name     ユーザ名
 * @param password パスワード
 * 
 * @author nob
 */
public record FetchUserResponse(String id, String name, String password) {
}
