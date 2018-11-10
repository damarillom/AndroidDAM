package com.example.ausias.pt13;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.text.TextUtils.isEmpty;

public class NavegadorPropi extends AppCompatActivity {

    WebView myWebView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navegador_propi);

            Intent intent = getIntent();
            Uri url = intent.getData();


            myWebView = (WebView) findViewById(R.id.ourNav);

            myWebView.setWebViewClient(new WebViewClient());

            //myWebView.setWebViewClient(new MyWebViewClient());

            /*myWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //Log.d("test","test, la url es: " + url);

                    if (Uri.parse(url).getHost().contains("escoladeltreball")) {
                        Log.d("test","contiene escoladeltreball:" + url);
                        return false;
                    }
                    Log.d("test","antes de:"+url);

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    startActivity(intent);
                    Log.d("test","la creo:"+url);

                    return true;
                }
            });
*/

            Log.d("test","loadurl: "+ url);
            //recuperar web pasada de proves

            myWebView.loadUrl(String.valueOf(url));

            //myWebView.setScrollBarStyle(1);
            //myWebView.loadUrl("http://escoladeltreball.org");
            Log.d("test","after loadurl: "+ url);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("test",e.getMessage());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //Si la url es la de l'institut, la carrega MyWebViewClient
            if (Uri.parse(url).getHost().contains("escoladeltreball")) {
                Log.d("test","shouldOverride no:"+url);
                return false;

            }
            //Si es una altre url, l'activitat la inicia l'aplicació del sistema android que pugui llegir URLs
            Log.d("test","shouldOverride: yes "+url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }

}