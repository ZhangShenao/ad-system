package william.ad.common.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>统一响应 </p>
 *
 * @author ZhangShenao
 * @date 2018年4月12日
 */
@Getter
@Setter
public class CommonResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static CommonResponse success() {
        CommonResponse response = new CommonResponse();
        response.success = true;
        response.message = "success";
        return response;
    }

    public static <T> CommonResponse success(T data) {
        CommonResponse response = success();
        response.data = data;
        return response;
    }

    public static CommonResponse error(String message) {
        CommonResponse response = new CommonResponse();
        response.success = false;
        response.message = message;
        return response;
    }

    public static <T> CommonResponse error(T data, String message) {
        CommonResponse response = error(message);
        response.data = data;
        return response;
    }

}
