package learnhubstudio.physicsXI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class term extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        setTitle("Terms & Conditions");

        try {
            WebView mWebView = null;
            mWebView = (WebView) findViewById(R.id.webview);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setBackgroundColor(32064);
            mWebView.loadUrl("file:///android_asset/terms_and_conditions.html");
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