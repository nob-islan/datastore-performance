package nob.example.easyapp01.controller.model;

/**
 * ユーザ検索処理向けレスポンスモデルです。
 * 
 * @param id   管理ID
 * @param name ユーザ名
 * @param age  年齢
 * 
 * @author nob
 */
public record FetchUserResponse(String id, String name, Integer age) {
}
