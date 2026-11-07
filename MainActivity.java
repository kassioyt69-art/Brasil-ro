package br.com.brasilrp.game;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private WebView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(android.graphics.Color.rgb(16, 39, 29));
        getWindow().setNavigationBarColor(android.graphics.Color.rgb(11, 21, 17));

        gameView = new WebView(this);
        gameView.setBackgroundColor(android.graphics.Color.rgb(12, 23, 19));
        WebSettings settings = gameView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        gameView.setWebViewClient(new WebViewClient());
        gameView.setWebChromeClient(new WebChromeClient());
        setContentView(gameView);
        gameView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (gameView != null && gameView.canGoBack()) gameView.goBack();
        else super.onBackPressed();
    }
}
