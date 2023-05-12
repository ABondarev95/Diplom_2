package user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class UserApi {

    //Создание пользователя
    public static Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(USER_API_CREATE);
    }

    //Авторизация
    public static Response loginUser(UserCredentials credentials) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body(credentials)
                .when()
                .post(USER_API_LOGIN);
    }

    //Удаление пользователя
    public static Response deleteUser(String userToken) {
        return given()
                .header("Authorization", userToken)
                .contentType(ContentType.JSON)
                .and()
                .when()
                .delete(USER_API);
    }

    //Редактирование информации с авторизацией
    public static Response editUserInfoWithLogin(String userToken, UserData userData) {
        return given()
                .header("authorization", userToken)
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .patch(USER_API);
    }

    //Изменение информации без авторизации
    public static Response editUserInfoWithoutLogin(UserData userData) {
        return given()
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .patch(USER_API);
    }
}
