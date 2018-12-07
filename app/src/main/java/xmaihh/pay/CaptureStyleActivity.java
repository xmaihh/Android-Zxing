package xmaihh.pay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 选择扫描样式界面
 * 默认三种扫描样式: 默认样式,支付宝AR样式,微信扫描二维码样式
 */
public class CaptureStyleActivity extends AppCompatActivity {
    Button bt_default;
    Button bt_alipay;
    Button bt_wechat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_capture);
        //*
        bt_default = findViewById(R.id.bt_default);
        bt_alipay = findViewById(R.id.bt_alipay);
        bt_wechat = findViewById(R.id.bt_wechat);

        bt_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaptureStyleActivity.this, DefaultCaptureActivity.class));
            }
        });

        bt_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaptureStyleActivity.this, AliPayCaptureActivity.class));
            }
        });

        bt_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaptureStyleActivity.this, WeChatCaptureActivity.class));
            }
        });
    }
}
