package nob.example.easyapp01.service.model;

/**
 * ユーザ検索処理向け出力モデルです。
 * 
 * @param id   管理ID
 * @param name ユーザ名
 * @param age  年齢
 * 
 * @author nob
 */
public record FetchUserOutModel(String id, String name, Integer age) {
}
