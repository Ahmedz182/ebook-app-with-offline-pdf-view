package kzeedesigns.peerkamil1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class HomeActivity extends AppCompatActivity {

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    RelativeLayout content_mainRelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        content_mainRelativeLayout = (RelativeLayout) findViewById(R.id.content_main);
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Snackbar.make(content_mainRelativeLayout, "Press Once More Time To Exit! ", Snackbar.LENGTH_LONG).show();
        }
        back_pressed = System.currentTimeMillis();
    }

    public void exit(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to Exit");
        alert.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog al = alert.create();
        al.show();

    }

    public void about(View view) {
        Intent i = new Intent(HomeActivity.this, AboutActivity.class);
        startActivity(i);
    }

    public void peer(View view) {
        Intent starts = new Intent(HomeActivity.this, StartActivity.class);
        startActivity(starts);
    }

    public void scnd(View view) {
        Intent starts = new Intent(HomeActivity.this, scndhalf.class);
        startActivity(starts);
    }
}