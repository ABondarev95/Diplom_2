package order;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class OrderApi {
    //Создание заказа с авторизацией
    public static Response createOrderWithLogin(Order order, String userToken) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", userToken)
                .body(order)
                .when()
                .post(ORDER_API);
    }

    //Создание заказа без авторизации
    public static Response createOrderWithoutLogin(Order order) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(ORDER_API);
    }

    //Получить заказы с авторизацией
    public static Response getOrdersWithLogin(String userToken) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", userToken)
                .when()
                .get(ORDER_API);
    }

    //Получить заказы без авторизации
    public static Response getOrdersWithoutLogin() {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(ORDER_API);
    }

    //Получить ингридиенты заказа
    public static List<String> getIngredients() {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(ORDER_API_INGREDIENTS)
                .then()
                .extract().path("data._id");
    }
}