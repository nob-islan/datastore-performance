package nob.example.easyapp.service;

import org.springframework.stereotype.Service;

import nob.example.easyapp.service.model.FetchUserInModel;
import nob.example.easyapp.service.model.FetchUserOutModel;
import nob.example.easyapp.service.model.RegistUserInModel;
import nob.example.easyapp.service.model.RegistUserOutModel;

/**
 * ユーザ情報向けサービスのインターフェースです。
 * 
 * @author nob
 */
@Service
public interface UserService {

    /**
     * 管理IDをキーとしてユーザ情報を検索します。
     * 
     * @param inModel ユーザ情報検索条件
     * @return 単一のユーザ情報
     */
    FetchUserOutModel fetch(FetchUserInModel inModel);

    /**
     * ユーザ情報を登録します。
     * 
     * @param inModel ユーザ情報
     * @return 登録成否
     */
    RegistUserOutModel regist(RegistUserInModel inModel);
}
