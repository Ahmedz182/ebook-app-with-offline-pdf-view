package learnhubstudio.physicsXI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Privacypolicy extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacypolicy);
        setTitle("Privacy Policy");
        try {
            WebView mWebView = null;
            mWebView = (WebView) findViewById(R.id.webview);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setBackgroundColor(32064);
            mWebView.loadUrl("file:///android_asset/privacy_policy.html");
            mWebView.setWebChromeClient(new WebChromeClient());
        } catch (Exception e) {
            // TODO: handle exception
            this.finish();
        }
    }

    public void agree(View view) {
     dismissDialog();
    }

    private void dismissDialog() {
        onBackPressed();
    }
}