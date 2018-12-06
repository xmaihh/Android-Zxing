package xmaihh.pay;

import android.util.Log;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import java.util.Map;

public class getRsa {
    static String APP_ID = "20191204678463243";
    static String APP_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjCEx8wz5bxRl3\n" +
            "Skk+7WuaBuHmxpWrCG5OTAXKjTzuVqSv7zAfwI/3DU1qxCujAdLWo5j4AJQzSEqP\n" +
            "H18VbVcGS9xS5Kla6syFDvCn+t7x0E+3S1Bcco0rSNipxhK0rrrkUf081mkOsfyt\n" +
            "kO286fjs4j1T75wqkDhNTwURcepAQK3NhrfOTMaBD3aBJQ1exAcT+hOpFZYvUHeq\n" +
            "Qi8NEJXFZQK6dLw2qSlm1ol7/6FeOpA35BHv2wUWbBUIVD4Km4QrQx5/4bByov/y\n" +
            "0konjvgkYyJe/fWiv0/b5han2aJ+/kn5PRpuT/EUnosvSVZMOcgxozMagyQodCnc\n" +
            "Bp62ufm/AgMBAAECggEAO5WB/XyAcTVZaaVlc8573wDPaPHVdf3QdVweaPqIc0Tq\n" +
            "FAKCbtLq9bvYBZ1WloF0BEELdIsyWgMvDkD9g3Ie1Ng0Cs1YZTQaWRGCt5Nvz6cM\n" +
            "RN7PSHQH+MQ1mNkTL7hr9GBQRhc/m0u7NRJEUsBVRFZcIhtQsRsIq8GBYwKyqAnT\n" +
            "CDZSVrpu2D+4HXsdmt3joW3fJ0eYGnmoQXIK6j2H0c1HODysvqsymqydPC823QzK\n" +
            "eqUphDxIa6YbAOoH0fmTVWQgWdfjwQkZAzbmtrFVHUnq59ZPu/rAnlxeIKceUBWr\n" +
            "5dG/jH4U8dyy0ydKNNN650BqiF0e74eah74b+e2VAQKBgQDxSwO77TbGMkJkYCxH\n" +
            "8hF7XnaF5tY/jfjtdWuxT1jAT/50G043IFXCAT9b5M/VlhVKBsqPBKADXSUpLfDI\n" +
            "54UGA+xBxLkyCTj50vX3qxUBpTo8YhL+nQn8ELiQUT3FkFQMUb5LcjCMJttPvpSs\n" +
            "eU5stQJyggZNFzDmKtyQEaOKaQKBgQDw3sVEjkLtN3wZE5Z+IcAkXdsuMCreGdB5\n" +
            "XxLLbg3Fg1/+Oh8QOuGN41cANo4NzVSNSOtAGZTVybsIzTdFkZBXWjCsqDj2ECif\n" +
            "x4McOeptWU9a42s1nnAUUBrDlaNCv7E06QTNGx20tNKkOU6KcoHdluSYdSEMOO9K\n" +
            "Iaz6hYLN5wKBgAUg9A5dh2mFDfY2ORq6YXa+1kQYWPt22BCsC0L0jc1gpebv4aS4\n" +
            "UjpSbndUkLpYe1FcfZe2oHQR2cVbTZ/nk+NB2Ba5yLnwij59Jm9COqsTSP6Zkw/I\n" +
            "ZLrv3AxtPaPiYnb0kdfmsHN6K/Uw9tYHqgwTeN7YNqwSzx5FUPTa+x/pAoGBAKHN\n" +
            "g8ZhqiOfugU+W0GvelrzkWCdiq5XuOtPKljtPOMJNVqZwHQumYWuyaqi+xnabInc\n" +
            "CeutQ4W5VaK79/0Lo2KKe1gASQNCJ4fthe1YGloKPHxZeJM0MyXyCYiI5HraOjfI\n" +
            "sCj3piTVswoOVOw7r3EjA7xGMkT7mgK6THCdbxjRAoGBAIj4L2Dh9KA8bLl6Yn+9\n" +
            "iDNhktXBQ42WfPgEpp4/N57lN13ouvC58UxVNhDYUBAdSDrmfjF/devfmuU54WPD\n" +
            "bUBEiNYY9g5oGCdD+i4DReHXFIuDcXMrgnfyutaxfhuzq+nBNA2xi7q8NRblD6c6\n" +
            "pNLvP0AQa50iZyK1Hns8alAf\n" +
            "-----END PRIVATE KEY-----\n";
    static String CHARSET = "UTF-8";
    static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4whMfMM+W8UZd0pJPu1r\n" +
            "mgbh5saVqwhuTkwFyo087lakr+8wH8CP9w1NasQrowHS1qOY+ACUM0hKjx9fFW1X\n" +
            "BkvcUuSpWurMhQ7wp/re8dBPt0tQXHKNK0jYqcYStK665FH9PNZpDrH8rZDtvOn4\n" +
            "7OI9U++cKpA4TU8FEXHqQECtzYa3zkzGgQ92gSUNXsQHE/oTqRWWL1B3qkIvDRCV\n" +
            "xWUCunS8NqkpZtaJe/+hXjqQN+QR79sFFmwVCFQ+CpuEK0Mef+GwcqL/8tJKJ474\n" +
            "JGMiXv31or9P2+YWp9mifv5J+T0abk/xFJ6LL0lWTDnIMaMzGoMkKHQp3Aaetrn5\n" +
            "vwIDAQAB";

    static String ss = "app_id=20191204678463243&biz_content=\n" +
            "  {\n" +
            "\"out_trade_no\":\"20180320010101001\",\n" +
            "\"scene\":\"bar_code\",\n" +
            "\"auth_code\":\"28763443825664394\",\n" +
            "\"product_code\":\"FACE_TO_FACE_PAYMENT\",\n" +
            "\"subject\":\"Iphone6 16G\",\n" +
            "\"buyer_id\":\"2088202954065786\",\n" +
            "\"seller_id\":\"2088102146225135\",\n" +
            "\"total_amount\":88.88,\n" +
            "\"trans_currency\":\"USD\",\n" +
            "\"settle_currency\":\"USD\",\n" +
            "\"discountable_amount\":8.88,\n" +
            "\"body\":\"Iphone6 16G\",\n" +
            "      \"goods_detail\":[{\n" +
            "        \"goods_id\":\"apple-01\",\n" +
            "\"goods_name\":\"ipad\",\n" +
            "\"quantity\":1,\n" +
            "\"price\":2000,\n" +
            "\"goods_category\":\"34543238\",\n" +
            "\"categories_tree\":\"124868003|126232002|126252004\",\n" +
            "\"body\":\"特价手机\",\n" +
            "\"show_url\":\"http://www.alipay.com/xxx.jpg\"\n" +
            "        }],\n" +
            "\"operator_id\":\"yx_001\",\n" +
            "\"store_id\":\"NJ_001\",\n" +
            "\"terminal_id\":\"NJ_T_001\",\n" +
            "\"extend_params\":{\n" +
            "\"sys_service_provider_id\":\"2088511833207846\",\n" +
            "\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\",\n" +
            "\"card_type\":\"S0JP0000\"\n" +
            "    },\n" +
            "\"timeout_express\":\"90m\",\n" +
            "\"auth_confirm_mode\":\"COMPLETE：转交易支付完成结束预授权;NOT_COMPLETE：转交易支付完成不结束预授权\",\n" +
            "\"terminal_params\":\"{\\\"key\\\":\\\"value\\\"}\",\n" +
            "\"promo_params\":{\n" +
            "\"actual_order_time\":\"2018-12-04 22:47:33\"\n" +
            "    }\n" +
            "  }" + "&version=1.0";


    static String key = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjCEx8wz5bxRl3\n" +
            "Skk+7WuaBuHmxpWrCG5OTAXKjTzuVqSv7zAfwI/3DU1qxCujAdLWo5j4AJQzSEqP\n" +
            "H18VbVcGS9xS5Kla6syFDvCn+t7x0E+3S1Bcco0rSNipxhK0rrrkUf081mkOsfyt\n" +
            "kO286fjs4j1T75wqkDhNTwURcepAQK3NhrfOTMaBD3aBJQ1exAcT+hOpFZYvUHeq\n" +
            "Qi8NEJXFZQK6dLw2qSlm1ol7/6FeOpA35BHv2wUWbBUIVD4Km4QrQx5/4bByov/y\n" +
            "0konjvgkYyJe/fWiv0/b5han2aJ+/kn5PRpuT/EUnosvSVZMOcgxozMagyQodCnc\n" +
            "Bp62ufm/AgMBAAECggEAO5WB/XyAcTVZaaVlc8573wDPaPHVdf3QdVweaPqIc0Tq\n" +
            "FAKCbtLq9bvYBZ1WloF0BEELdIsyWgMvDkD9g3Ie1Ng0Cs1YZTQaWRGCt5Nvz6cM\n" +
            "RN7PSHQH+MQ1mNkTL7hr9GBQRhc/m0u7NRJEUsBVRFZcIhtQsRsIq8GBYwKyqAnT\n" +
            "CDZSVrpu2D+4HXsdmt3joW3fJ0eYGnmoQXIK6j2H0c1HODysvqsymqydPC823QzK\n" +
            "eqUphDxIa6YbAOoH0fmTVWQgWdfjwQkZAzbmtrFVHUnq59ZPu/rAnlxeIKceUBWr\n" +
            "5dG/jH4U8dyy0ydKNNN650BqiF0e74eah74b+e2VAQKBgQDxSwO77TbGMkJkYCxH\n" +
            "8hF7XnaF5tY/jfjtdWuxT1jAT/50G043IFXCAT9b5M/VlhVKBsqPBKADXSUpLfDI\n" +
            "54UGA+xBxLkyCTj50vX3qxUBpTo8YhL+nQn8ELiQUT3FkFQMUb5LcjCMJttPvpSs\n" +
            "eU5stQJyggZNFzDmKtyQEaOKaQKBgQDw3sVEjkLtN3wZE5Z+IcAkXdsuMCreGdB5\n" +
            "XxLLbg3Fg1/+Oh8QOuGN41cANo4NzVSNSOtAGZTVybsIzTdFkZBXWjCsqDj2ECif\n" +
            "x4McOeptWU9a42s1nnAUUBrDlaNCv7E06QTNGx20tNKkOU6KcoHdluSYdSEMOO9K\n" +
            "Iaz6hYLN5wKBgAUg9A5dh2mFDfY2ORq6YXa+1kQYWPt22BCsC0L0jc1gpebv4aS4\n" +
            "UjpSbndUkLpYe1FcfZe2oHQR2cVbTZ/nk+NB2Ba5yLnwij59Jm9COqsTSP6Zkw/I\n" +
            "ZLrv3AxtPaPiYnb0kdfmsHN6K/Uw9tYHqgwTeN7YNqwSzx5FUPTa+x/pAoGBAKHN\n" +
            "g8ZhqiOfugU+W0GvelrzkWCdiq5XuOtPKljtPOMJNVqZwHQumYWuyaqi+xnabInc\n" +
            "CeutQ4W5VaK79/0Lo2KKe1gASQNCJ4fthe1YGloKPHxZeJM0MyXyCYiI5HraOjfI\n" +
            "sCj3piTVswoOVOw7r3EjA7xGMkT7mgK6THCdbxjRAoGBAIj4L2Dh9KA8bLl6Yn+9\n" +
            "iDNhktXBQ42WfPgEpp4/N57lN13ouvC58UxVNhDYUBAdSDrmfjF/devfmuU54WPD\n" +
            "bUBEiNYY9g5oGCdD+i4DReHXFIuDcXMrgnfyutaxfhuzq+nBNA2xi7q8NRblD6c6\n" +
            "pNLvP0AQa50iZyK1Hns8alAf\n" +
            "-----END PRIVATE KEY-----";

    public static void main(String[] args) {
        Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap("456", "20191204678463243", "123", true);
        String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);
        key = key.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "").replaceAll("\\r+", "").replaceAll("\\n+", "");
        String sign = OrderInfoUtil2_0.getSign(authInfoMap, key, true);
        System.out.println(sign);
    }
}
