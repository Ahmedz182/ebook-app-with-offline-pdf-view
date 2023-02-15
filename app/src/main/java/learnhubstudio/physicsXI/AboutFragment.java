package learnhubstudio.physicsXI;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {
LinearLayout share,rating,whatsapp,instagram,facebook,mail;
CardView more,advertisment,cardad;
    LinearLayout adContainer;
    private AdView bannerAdView;
    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);



//        adView = v.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
        this.bannerAdView = new AdView(getContext());
        bannerAdView.setAdSize(AdSize.BANNER);
        bannerAdView.setAdUnitId(getString(R.string.banner_ad_unit_id));

        this.adContainer = (LinearLayout) v.findViewById(R.id.adContainer);
        this.adContainer.addView(this.bannerAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        this.bannerAdView.loadAd(adRequest);
        this.bannerAdView.setAdListener(new AdListener() {

//            @Override
//            public void onAdFailedToLoad(int adError) {
//                AdRequest adRequest = new AdRequest.Builder().build();
//                bannerAdView.loadAd(adRequest);
//            }

            @Override
            public void onAdLoaded() {
                AboutFragment.this.adContainer.setVisibility(View.VISIBLE);
            }
        });


        share = v.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=learnhubstudio.physicsXI");
                intent.putExtra(Intent.EXTRA_SUBJECT, "");

                startActivity(Intent.createChooser(intent,
                        getString(R.string.share_via)));
            }
        });
        rating=v.findViewById(R.id.feedback);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=learnhubstudio.physicsXI")));
                } catch (ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=learnhubstudio.physicsXI")));
                }

            }
        });
        more=v.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://search?q=pub:Learn+Hub+Studio")));
                } catch (ActivityNotFoundException anfe) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/developer?id=Learn+Hub+Studio")));
                }
            }
        });
//        advertisment=v.findViewById(R.id.advertisment);
//        advertisment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://saleonhy.pk/"));
//                startActivity(browserIntent);
//            }
//        });
        whatsapp=v.findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+"+923357035717";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        instagram=v.findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/Ahmedz182"));
                startActivity(browserIntent);

            }
        });
        facebook=v.findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/LearnHubStudio/"));
                startActivity(browserIntent);
            }
        });

        mail=v.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Physics xi By LHS"+ "&body=" + "" + "&to=" + "ahmedmughal3182@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));

            }
        });


        return v;
    }

}
