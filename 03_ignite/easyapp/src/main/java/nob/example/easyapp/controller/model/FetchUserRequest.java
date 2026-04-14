package nob.example.easyapp.controller.model;

/**
 * ユーザ検索処理向けリクエストモデルです。
 * 
 * @param id 管理ID
 * 
 * @author nob
 */
public record FetchUserRequest(String id) {
}