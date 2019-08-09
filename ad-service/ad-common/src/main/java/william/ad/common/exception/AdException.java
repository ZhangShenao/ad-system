package william.ad.common.exception;

/**
 * @Description 自定义广告异常
 * @Author ZhangShenao
 * @Date 2019/8/9 下午6:00
 */
public class AdException extends RuntimeException {
    public AdException(String message){
        super(message);
    }
}
