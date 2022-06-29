package suport.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import support.domain.Order;
import support.domain.Pet;

import static io.restassured.RestAssured.given;

public class StoreApi {

    private static final String CREATE_ORDER_ENDPOINT = "/v3/store/order";
    private static final String GET_ORDER_BY_ID_ENDPOINT = "/v3/store/order/{orderId}";

    public Order createOrder(Order order) {
        return given().
                    body(order).
                when().
                    post(CREATE_ORDER_ENDPOINT).
                then().
                    statusCode(HttpStatus.SC_OK).
                    extract().body().as(Order.class);
    }

    public Response getOrderResponseByID(Integer id) {
        return given().
                    pathParam("orderId", id).
                when().
                    get(GET_ORDER_BY_ID_ENDPOINT);


    }

}
