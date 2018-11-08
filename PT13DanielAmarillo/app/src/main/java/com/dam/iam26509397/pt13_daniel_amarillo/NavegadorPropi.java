package com.dam.iam26509397.pt13_daniel_amarillo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavegadorPropi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_propi);


        /**Intent intent = getIntent();
        Uri url = intent.getData();*/


        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.escoladeltreball.org");

        /**WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.google.es");
        myWebView.setWebViewClient();*/
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            //try {
                if (Uri.parse(url).getHost().contains("escoladeltreball")) {
                    // This is my website, so do not override; let my WebView load the page
                    Log.d("Escola del treball", "Escola del treball");
                    return false;
                }
                Log.d("Escola del treball", "No es escola del treball");
                // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            //} catch (Exception e) {
            //    e.printStackTrace();
            //}
        }

    }
}
