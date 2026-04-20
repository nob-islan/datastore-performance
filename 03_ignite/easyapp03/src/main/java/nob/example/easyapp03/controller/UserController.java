package nob.example.easyapp03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import nob.example.easyapp03.controller.model.FetchUserRequest;
import nob.example.easyapp03.controller.model.FetchUserResponse;
import nob.example.easyapp03.controller.model.RegistUserRequest;
import nob.example.easyapp03.controller.model.RegistUserResponse;
import nob.example.easyapp03.service.UserService;
import nob.example.easyapp03.service.model.FetchUserInModel;
import nob.example.easyapp03.service.model.FetchUserOutModel;
import nob.example.easyapp03.service.model.RegistUserInModel;

/**
 * ユーザ情報向けコントローラーです。
 * 
 * @author nob
 */
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @NonNull
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 管理IDをキーにしてユーザ情報を検索する処理を呼び出します。
     * 
     * @param request 検索条件
     * @return ユーザ情報
     */
    @GetMapping(value = "")
    FetchUserResponse fetch(FetchUserRequest request) {

        FetchUserOutModel outModel = userService.fetch(new FetchUserInModel(request.id()));
        return new FetchUserResponse(outModel.id(), outModel.name(), outModel.age());
    }

    /**
     * ユーザ登録処理を呼び出します。
     * 
     * @param request ユーザ情報
     * @return 登録成否
     */
    @PostMapping(value = "")
    RegistUserResponse regist(@RequestBody RegistUserRequest request) {

        return new RegistUserResponse(
                userService.regist(new RegistUserInModel(request.name(), request.age())).id());
    }
}