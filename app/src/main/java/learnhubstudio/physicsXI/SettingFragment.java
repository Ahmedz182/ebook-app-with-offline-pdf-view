package learnhubstudio.physicsXI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    CardView cardView;
    Switch aSwitch;
    private AdView adView;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        adView = v.findViewById(R.id.adView0);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView.loadAd(adRequest1);
        cardView = v.findViewById(R.id.privacy);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Privacypolicy.class);
                startActivity(intent);


            }
        });
        cardView = v.findViewById(R.id.term);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), term.class);
                startActivity(intent);


            }
        });
        cardView = v.findViewById(R.id.suggest);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactForm.class);
                startActivity(intent);


            }
        });
        cardView = v.findViewById(R.id.thanks);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), special_thanks.class);
                startActivity(intent);


            }
        });
//        aSwitch  =v.findViewById(R.id.nightmode);
//        aSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                final AlertDialog.Builder alert =new AlertDialog.Builder(getContext());
////                alert.setMessage("We are working Hard on it. Coming soon");
////                alert.setTitle("Dark Mode");
////                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////dialogInterface.dismiss();
////                    }
////                });
////alert.show();
//
//
//
//
//            }
//        });
        return v;
    }
    }

