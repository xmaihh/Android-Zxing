package xmaihh.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import java.util.Map;


public class MainActivity extends AppCompatActivity {
    AlipayClient alipayClient;
    String APP_ID = "20191204678463243";
    String APP_PRIVATE_KEY = "MIIEpAIBAAKCAQEA4whMfMM+W8UZd0pJPu1rmgbh5saVqwhuTkwFyo087lakr+8w\n" +
            "H8CP9w1NasQrowHS1qOY+ACUM0hKjx9fFW1XBkvcUuSpWurMhQ7wp/re8dBPt0tQ\n" +
            "XHKNK0jYqcYStK665FH9PNZpDrH8rZDtvOn47OI9U++cKpA4TU8FEXHqQECtzYa3\n" +
            "zkzGgQ92gSUNXsQHE/oTqRWWL1B3qkIvDRCVxWUCunS8NqkpZtaJe/+hXjqQN+QR\n" +
            "79sFFmwVCFQ+CpuEK0Mef+GwcqL/8tJKJ474JGMiXv31or9P2+YWp9mifv5J+T0a\n" +
            "bk/xFJ6LL0lWTDnIMaMzGoMkKHQp3Aaetrn5vwIDAQABAoIBADuVgf18gHE1WWml\n" +
            "ZXPOe98Az2jx1XX90HVcHmj6iHNE6hQCgm7S6vW72AWdVpaBdARBC3SLMloDLw5A\n" +
            "/YNyHtTYNArNWGU0GlkRgreTb8+nDETez0h0B/jENZjZEy+4a/RgUEYXP5tLuzUS\n" +
            "RFLAVURWXCIbULEbCKvBgWMCsqgJ0wg2Ula6btg/uB17HZrd46Ft3ydHmBp5qEFy\n" +
            "Cuo9h9HNRzg8rL6rMpqsnTwvNt0MynqlKYQ8SGumGwDqB9H5k1VkIFnX48EJGQM2\n" +
            "5raxVR1J6ufWT7v6wJ5cXiCnHlAVq+XRv4x+FPHcstMnSjTTeudAaohdHu+Hmoe+\n" +
            "G/ntlQECgYEA8UsDu+02xjJCZGAsR/IRe152hebWP4347XVrsU9YwE/+dBtONyBV\n" +
            "wgE/W+TP1ZYVSgbKjwSgA10lKS3wyOeFBgPsQcS5Mgk4+dL196sVAaU6PGIS/p0J\n" +
            "/BC4kFE9xZBUDFG+S3IwjCbbT76UrHlObLUCcoIGTRcw5irckBGjimkCgYEA8N7F\n" +
            "RI5C7Td8GROWfiHAJF3bLjAq3hnQeV8Sy24NxYNf/jofEDrhjeNXADaODc1UjUjr\n" +
            "QBmU1cm7CM03RZGQV1owrKg49hAon8eDHDnqbVlPWuNrNZ5wFFAaw5WjQr+xNOkE\n" +
            "zRsdtLTSpDlOinKB3ZbkmHUhDDjvSiGs+oWCzecCgYAFIPQOXYdphQ32NjkaumF2\n" +
            "vtZEGFj7dtgQrAtC9I3NYKXm7+GkuFI6Um53VJC6WHtRXH2XtqB0EdnFW02f55Pj\n" +
            "QdgWuci58Io+fSZvQjqrE0j+mZMPyGS679wMbT2j4mJ29JHX5rBzeiv1MPbWB6oM\n" +
            "E3je2DasEs8eRVD02vsf6QKBgQChzYPGYaojn7oFPltBr3pa85FgnYquV7jrTypY\n" +
            "7TzjCTVamcB0LpmFrsmqovsZ2myJ3AnrrUOFuVWiu/f9C6NiintYAEkDQieH7YXt\n" +
            "WBpaCjx8WXiTNDMl8gmIiOR62jo3yLAo96Yk1bMKDlTsO69xIwO8RjJE+5oCukxw\n" +
            "nW8Y0QKBgQCI+C9g4fSgPGy5emJ/vYgzYZLVwUONlnz4BKaePzee5Tdd6LrwufFM\n" +
            "VTYQ2FAQHUg65n4xf3Xr35rlOeFjw21ARIjWGPYOaBgnQ/ouA0Xh1xSLg3FzK4J3\n" +
            "8rrWsX4bs6vpwTQNsYu6vDUW5Q+nOqTS7z9AEGudImcitR57PGpQHw==";
    String CHARSET = "UTF-8";
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4whMfMM+W8UZd0pJPu1r\n" +
            "mgbh5saVqwhuTkwFyo087lakr+8wH8CP9w1NasQrowHS1qOY+ACUM0hKjx9fFW1X\n" +
            "BkvcUuSpWurMhQ7wp/re8dBPt0tQXHKNK0jYqcYStK665FH9PNZpDrH8rZDtvOn4\n" +
            "7OI9U++cKpA4TU8FEXHqQECtzYa3zkzGgQ92gSUNXsQHE/oTqRWWL1B3qkIvDRCV\n" +
            "xWUCunS8NqkpZtaJe/+hXjqQN+QR79sFFmwVCFQ+CpuEK0Mef+GwcqL/8tJKJ474\n" +
            "JGMiXv31or9P2+YWp9mifv5J+T0abk/xFJ6LL0lWTDnIMaMzGoMkKHQp3Aaetrn5\n" +
            "vwIDAQAB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AlipaySignature
        alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
//
//
//        tradePrecreatePay();


//        JPay jPay = JPay.getIntance(this);
//        String payParameters = "        {\n" +
//                "            \"appId\":\"123\",\n" +
//                "                \"partnerId\":\"456\",\n" +
//                "                \"prepayId\":\"789\",\n" +
//                "                \"sign\":\"110221\",\n" +
//                "                \"nonceStr\" :\"1122\",\n" +
//                "                \"timeStamp\":\"1155555551111\"\n" +
//                "        }";
//
//
//        jPay.toPay(JPay.PayMode.ALIPAY, payParameters, new JPay.JPayListener() {
//            @Override
//            public void onPaySuccess() {
//                Log.d("521", "onPaySuccess: ");
//            }
//
//            @Override
//            public void onPayError(int error_code, String message) {
//                Log.d("521", "onPayError: "+error_code+"\t"+message);
//            }
//
//            @Override
//            public void onPayCancel() {
//                Log.d("521", "onPayCancel: ");
//            }
//
//            @Override
//            public void onUUPay(String dataOrg, String sign, String mode) {
//            }
//        });


        try {
            String s1 = AlipaySignature.rsaSign(ss, APP_PRIVATE_KEY, CHARSET, "RSA2");
            Log.d("521", "onCreate: " + s1);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


        Map<String, String> authInfoMap = OrderInfoUtil2_0.buildAuthInfoMap("", "20191204678463243", "123", true);
        String info = OrderInfoUtil2_0.buildOrderParam(authInfoMap);

        String sign = OrderInfoUtil2_0.getSign(authInfoMap, APP_PRIVATE_KEY, true);
        final String authInfo = info + "&" + sign;

    }

    /**
     * 扫码支付
     * https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.i0UVZn&treeId=193&articleId=105170&docType=1#s4
     *
     * @param notifyUrl
     * @return
     * @throws AlipayApiException
     */
    public String tradePrecreatePay(AlipayTradePrecreateModel model, String notifyUrl) throws AlipayApiException {
        AlipayTradePrecreateResponse response = tradePrecreatePayToResponse(model, notifyUrl);
        return response.getBody();
    }

    AlipayTradePrecreateResponse tradePrecreatePayToResponse(AlipayTradePrecreateModel model, String notifyUrl) throws AlipayApiException {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);
        return alipayClient.execute(request);
    }


    /**
     * 扫码支付
     */
    public void tradePrecreatePay() {
        String subject = "支付宝扫码支付测试";
        String totalAmount = "86";
        String storeId = "123";
        String notifyUrl = "";

        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setSubject(subject);
        model.setTotalAmount(totalAmount);
        model.setStoreId(storeId);
        model.setTimeoutExpress("5m");
        model.setOutTradeNo("1231564546456456878792145456");
        try {
            String resultStr = tradePrecreatePay(model, notifyUrl);
            Log.d("522", "tradePrecreatePay: " + resultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String ss = "app_id=20191204678463243&biz_content=\n" +
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

//    private  String getRSA(String s) {

//        return s;
//    }

}