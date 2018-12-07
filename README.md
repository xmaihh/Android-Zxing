# Android-Zxing
** 自用Android 二维码扫描 / 生成 **

适用于Android的二维码(条形码)扫描/二维码生成，使用[ZXing](https://github.com/zxing/zxing/)进行解码。
该项目基于[ZxingLite](https://github.com/yangxixi88/ZxingLite)，见Fork。实现基本的Android 二维码生成与扫描功能.
有关更多高级用法，可参考[zxing-android-embedded](https://github.com/journeyapps/zxing-android-embedded)

[![Download](https://api.bintray.com/packages/xmaihh/maven/zxinglite/images/download.svg?version=1.0) ](https://bintray.com/xmaihh/maven/zxinglite/1.0/link)[![GitHub issues](https://img.shields.io/github/issues/xmaihh/Android-Zxing.svg)](https://github.com/xmaihh/Android-Zxing/issues)[![GitHub forks](https://img.shields.io/github/forks/xmaihh/Android-Zxing.svg)](https://github.com/xmaihh/Android-Zxing/network)[![GitHub stars](https://img.shields.io/github/stars/xmaihh/Android-Zxing.svg)](https://github.com/xmaihh/Android-Zxing/stargazers)[![GitHub license](https://img.shields.io/github/license/xmaihh/Android-Zxing.svg)](https://github.com/xmaihh/Android-Zxing/blob/master/LICENSE)

# 使用依赖
1. `Gradle`引用
```
implementation 'tp.xmaihh:zxinglite:1.0'
```
2. `Maven`引用
```
<dependency>
  <groupId>tp.xmaihh</groupId>
  <artifactId>zxinglite</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

* Min SDK
14 (Android 4.0 Ice Cream Sandwich)

# 用法
1. 二维码/条形码生成[QRCodeUtil](https://github.com/xmaihh/Android-Zxing/blob/master/app/src/main/java/xmaihh/pay/zxing/QRCodeUtil.java)
```
 boolean success = QRCodeUtil.createQRImage(et_url.getText().toString().trim(), 800, 800,
                                checkBox.isChecked() ? BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher) :
                                        null,
                                filePath);
```
2. 二维码图片识别[QRcodeActivity](https://github.com/xmaihh/Android-Zxing/blob/master/app/src/main/java/xmaihh/pay/QRcodeActivity.java)
```
 Bitmap obmp = ((BitmapDrawable) (iv_qrcode).getDrawable()).getBitmap();
                int width = obmp.getWidth();
                int height = obmp.getHeight();
                int[] data = new int[width * height];
                obmp.getPixels(data, 0, width, 0, 0, width, height);
                RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);
                BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
                QRCodeReader reader = new QRCodeReader();
                Result re = null;
                try {
                    re = reader.decode(bitmap1);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                } catch (ChecksumException e) {
                    e.printStackTrace();
                } catch (FormatException e) {
                    e.printStackTrace();
                }
```
3. 二维码扫描
请参考[DefaultCaptureActivity](https://github.com/xmaihh/Android-Zxing/blob/master/app/src/main/java/xmaihh/pay/DefaultCaptureActivity.java)
# 声明权限
```
    <!--生成\识别二维码到本地需要开启读写权限-->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <!--扫描二维码需要开启以下权限-->
    <uses-permission android:name="android.permission.CAMERA"/>
    <uses-permission android:name="android.permission.VIBRATE"/>
```
> 适配Android6.0及以上需自行处理以上权限
# 演示效果
<img src="https://github.com/xmaihh/Android-Zxing/raw/master/arts/QRcode.png" width="270" height="480" alt="演示效果"/>
<img src="https://github.com/xmaihh/Android-Zxing/raw/master/arts/DefaultCapture.png" width="270" height="480" alt="演示效果"/>
<!--<img src="https://github.com/xmaihh/Android-Zxing/raw/master/arts/AlipayARCapture.png" width="270" height="480" alt="演示效果"/>-->
<!--<img src="https://github.com/xmaihh/Android-Zxing/raw/master/arts/WeChatCapture.png" width="270" height="480" alt="演示效果"/>-->
