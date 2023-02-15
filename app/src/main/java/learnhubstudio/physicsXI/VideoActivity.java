package learnhubstudio.physicsXI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class VideoActivity extends AppCompatActivity {

    List<String> ChildList;
    Map<String, List<String>> ParentListItems;
    ExpandableListView expandablelistView;
    videoid videos;

    // Assign Parent list items here.
    List<String> ParentList = new ArrayList<>();

    {
        ParentList.add("Introduction Complete Book");
        ParentList.add("Measurements");
        ParentList.add("Vector and Equilibrium");
        ParentList.add("Motion and Force");
        ParentList.add("Work and Energy");
        ParentList.add("Circular Motion");
        ParentList.add("Fluid Dynamics");
        ParentList.add("Oscillations");
        ParentList.add("Waves");
        ParentList.add("Physical Optics");
        ParentList.add("Optical Instruments");
        ParentList.add("Heat and Thermodynamics");

    }

    // Assign children list element using string array.
    String[] Introduction_Complete_Book = {"Complete Book Introduction", "Introduction to Physics"};

    String[] Measurements = {"1.1 : Introduction to Physics", "Introduction and Branches of Physics",
            "1.2 : Physical Quantities(1)", "Physical Quantities(2)",
            "1.3 : International System of Units (1)", "International System of Units (2)", "Scientific Notations(1)", "Scientific Notations(2)",
            "1.4 : Errors and Uncertainties",  "1.5 : Significant Figures",
            "1.6 : Precision and Accuracy", "1.7 : Assessment of Total Uncertainty in the Final Result", "1.8 : Dimension of Physical Quantities",
            "Example no 1 to 4", "Example no 1.1 to 1.4",
            "Example no 1.5 and 1.6", "Example no 5 and 6",
            "Question no 1 to 3", " Question no 1 to 3",
            "Question no 4", "Question no 4 to 9", "Question no 5 to 9", "Problem no 1.1 to 1.4", "Problem no 1.5", "Problem no 1.6",
            "Problem no 1.7 to 1.10", "Numerical no 1 to 4", "Numerical no 5",
            "Numerical no 6", "Numerical no 7 to 10"};

    String[] Vector_and_Equilibrium = {
            "2.1 : Basic Concepts of Vector", "Basic Concepts of Vector", "Addition of Vectors", "Unit Vector", "Rectangular Components of Vectors",
            "2.2 : Vector Addition by Rectangular Components", "Vector Addition by Rectangular Components",
            "2.3 : Product of two Vectors", "Vector or Cross Product", "Product of two Vector",
            "2.4 : Define Torque", "Torque", "2.5 : Equilibrium of Forces", "Equilibrium of Forces", "2.6 : Equilibrium of Torques",
            "Problem no 2.1 to 2.6", "Problem no 2.7 to 2.11", "Problem no 2.12 and 2.13", "Problem no 2.14 to 2.16", "Problem no 2.17 and 2.18",
            "Question no 2.1 and 2.2", "Question no 2.3 and 2.4", "Question no 2.5 to 2.8", "Question no 2.9 to 2.12",
            "Question no 2.13 and 2.14", "Question no 2.15 to 2.18","Question to 2.19 to 2.21",
            "Numerical 2.1 to 2.6", "Numerical 2.7 to 2.11", "Numerical 2.12 to 2.15", "Numerical 2.17 & 2.18",
            "Example 2.3 to 2.5", "Example 2.6 to 2.8"};

    String[] Motion_and_Force = {"Displacement", "Define Displacement", "Define Velocity", "Velocity",
            "Define Acceleration", "Acceleration", "Velocity-Time Graph", "Velocity Time Graph",
            "Review Equation of Uniformly Accelerated Motion","Review of Equations of Uniformly Acceleration Motion",
            "Newton's Law of Motion","Newton's Law of Motions","Momentum",
            "Define Momentum", "Define Impulse","Law of Conservations of Momentum",
            "Elastic and Inelastic Collision", "Special Cases of Elastic Collision in 1D", "Elastic & Inelastic Collision",
            "Force Due to Water Flow","Force Due TO Water Flows","Momentum and Explosive Force",
            "Momentum & Explosive Force","Rocket Propulsion","Rocket Propulsions","Projectile Motion", "Exercise Numerical no 3.1 to 3.3",
            "Exercise Numerical no 3.4 to 3.6" , "Exercise Numerical no 3.7 and 3.8" , "Exercise Numerical no 3.9 to 3.11" , "Exercise Numerical no 3.12 to 3.15" ,
            "Exercise Question no 3.1 and 3.2" , "Exercise Question no 3.3 and 3.4" , "Exercise Question no 3.5 and 3.6" ,
            "Exercise Question no 3.7 and 3.8" , "Exercise Question no 3.9 to 3.12" , "Exercise Question no 3.13 and 3.14" ,
            "Physics Chapter 3 Exercise Example no 3.1" , "Physics Chapter 3 Exercise Example no 3.2" ,
            "Physics Chapter 3 Exercise Example no 3.3" , "Physics Chapter 3 Exercise Example no 3.4" ,
            "Exercise Example 3.1" , "Exercise Example 3.2 and 3.3" , "Exercise Example 3.4 and 3.5" , "Exercise Example 3.6"};
    String[] Work_and_Energy = {
            "Work Done By a Contant Force", "Work Done by Constant Forces", "Work Done By A Variable Force",
            "Work Done by Variable Forces", "Work Done by Gravitational Field","Work Done By Gravitational Fields",
            "Power and Velocity", "Power and Velocity 2", "Define Escape Velocity", "Define Energy",
            "Energy & Types of Energy","Work Energy Principle","Absolute Potential Energy",
            "Absolute P.E", "Escape Velocity", "Interconversion of P.E and K.E",
            "Interconversion of Potential & Kinetic Energy",
            "Conversation of Energy", "Conservation of Energy 2","Non Convententional Energy Source", "Energy From Waves",
            "Explain Solar Energy", "Energy From Biomass", "Energy From Waste Product", "Non-Conventional Energy Sources",
            "Physics Chapter 4 Exercise Example 4.1", "Physics Chapter 4 Exercise Example 4.2",
            "Physics Chapter 4 Exercise Example 4.3", "Exercise Example 4.1 to 4.3",
            "Physics Chapter 4 Exercise Question 4.1 to 4.5", "Physics Chapter 4 Exercise Question 4.6 to 4.8",
            "Exercise Question 4.1 to 4.5", "Exercise Question no 4.6", "Exercise Question no 4.7",
            "Exercise Question no 4.8", "Exercise Question no 4.9", "Exercise Question no 4.10",
            "Numerical 4.1 to 4.3", "Numerical 4.4 & 4.5",
            "Numerical 4.6 to 4.8","Numerical 4.9 and 4.10",};
    String[] Circular_Motion = {"Angular Displacement","Angular Velocity","Relation Between Angular & Linear Velocities","Centripetal Force",
             "Moment of Inertia","Angular Momentum","Law of Conservation of Angular Momentum","Rotational Kinetic Energy of Disc and Hoop",
            "Artificial Settelites","Real and Apparent Weight","Weightlessness in Settelite & Gravity Free System","Orbital Velocity",
"Artificial Gravity","Geostationary Orbits","Communication Satellite","Newton's & Einstein's","Examples 5.1 and 5.2","Examples 5.3 and 5.5",
            "Examples 5.6 and 5.7","Exercise question 5.1 and 5.3","Exercise question 5.4 and 5.9","Exercise question 5.10 and 5.13",
            "Numerical 5.1 and 5.4","Numerical 5.5 and 5.7","Numerical 5.8 and 5.10"};
    String[] Fluid_Dynamics = {"Vescosity & Stroke's Law","Terminal Velocity","Fluid Flow","Equation of Continuity","Bernoulli's Equation",
            "Torricelli's Theorem","Relation Between Speed and Pressure of the Fluid","Blood Flow","Venturi Relation","Exercise question 1 to 3",
            "Exercise question 4 to 8","Exercise question 9 to 12","Numerical 6.1 to 6.3","Numerical 6.4 to 6.6","Numerical 6.7 to 6.9",
            "Example 6.1","Example 6.2","Example 6.3"};
    String[] Oscillations = {"Simple Harmonic Motion","Instantaneous Velocity","SHM and Circular Motion",
            "Phase","A Horizontal Mass Spring System","Simple Pendulum","Energy Conservation in SHM",
"Free and Forced Oscillation","Resonance","Damped Oscillations","Sharpness of Resonance","Exercise question 7.1 to 7.2",
            "Exercise question 7.3 to 7.4","Exercise question 7.5 to 7.6","Exercise question 7.7 to 7.8",
            "Exercise question 7.9 to 7.10","Exercise question 7.11 to 7.13","Numerical NO.7.1","Numerical NO.7.2",
            "Numerical NO.7.3","Numerical NO.7.4 and 7.5","Numerical NO.7.6 and 7.7","Numerical NO.7.8","Examples 7.1 to 7.3"};
    String[] Waves = {"Progressive Waves","Periodic Waves","Speed of Sound in Air","Principle of Superposition",
"Interference Waves","Beats Waves","Reflection of Waves","Stationary Waves","Stationary Waves in Stretched String",
            "Stationary Waves in Air Columns","Doppler Effect","Application of Doppler Effect","Exercise question 8.1 to 8.3",
            "Exercise question 8.4 to 8.5","Exercise question 8.6 to 8.7","Exercise question 8.9 to 8.11","Examples 8.1 to 8.2","Examples 8.4 to 8.5",
            "Numerical NO.8.1 to 8.5","Numerical NO.8.6 to 8.10"};
    String[] Physical_Optics = {"Wave Fronts","Huygen's Principle","Interference of Light","Young's Double Slit Experiment",
            "Interference in the Film","Newton's Ring","Michelson's Interferometer","Diffraction of Light",
            "Diffraction Due to a Narrow Slit.","Diffraction Grating.","Diffraction of X-Rays by Crystals","Polarization",
            "Optical Rotation","Exercise Question No. 9.1","Exercise Question No. 9.2 and 9.3","Exercise Question No. 9.4","Exercise Question No. 9.5",
            "Exercise Question No. 9.6 and 9.7","Exercise Question No. 9.8","Exercise Question No. 9.9","Exercise Question No. 9.10",
            "Example No. 9.1","Example No. 9.2","Example No. 9.3","Numerical No. 9.1 and 9.4","Numerical No. 9.5 and 9.7","Numerical No. 9.8 and 9.10"};
    String[] Optical_Instruments = {"Least Distance of District Vision","Magnifying & Resolving Power of an Optical Instrument",
            "Simple Microscope Magnification","Compound Microscope","Astronomical Telescope","Physics Spectrometer",
            "Speed of Light","Introduction to Fiber Optics","Fibre Optics Principle","Continuous Refraction","Types of Optical Fibres",
            "Signal Transmittion & Conversion to Sound","Losses of Power Physics","Question 10.1 to 10.3","Question 10.4 to 10.6","Question 10.7",
            "Question 10.8 to 10.11","Examples 10.1","Examples 10.2", "Numerical no 10.1 and 10.2","Numerical no 10.3 and 10.5",
            "Numerical no 10.6 and 10.8","Numerical no 10.9 and 10.10"};
    String[] Heat_and_Thermodynamics = {"Kinetic Theory of Gases","Internal Energy","Work and Heat in Physics", "First Law of Thermodynamics",
            "Isothermal Process Constant Temperature","Molar Specific Heat of Gas","Reversible and Irreversible Process","Heat Engine",
            "Second Law of Thermodynamics","Carnot's Engine & Theorem","Thermodynamics Scale of Temperature","Petro Engine","Entropy",
            "Environmental Crisis as Entropy Crisis","Exercise Question No. 11.1","Exercise Question No. 11.2 and 11.3","Exercise Question No. 11.4 and 11.5",
            "Exercise Question No. 11.6 and 11.7","Exercise Question No. 11.8 and 11.10","Exercise Question No. 11.11 and 11.12","Exercise Question No. 11.13 and 11.16",
            "Examples 11.1 to 11.3","Examples 11.4 to 11.5","Numerical no 11.1 and 11.2","Numerical no 11.3 and 11.4","Numerical no 11.5 and 11.6",
            "Numerical no 11.7 and 11.9","Numerical no 11.10 and 11.11"};
    //////Chapters end here

    String[] ByDefalutMessage = {"Items Loading"};
AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
 setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

adView=findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView.loadAd(adRequest1);

        videos = new videoid();
        ParentListItems = new LinkedHashMap<>();

        for (String HoldItem : ParentList) {
            switch (HoldItem) {
                case "Introduction Complete Book":
                    loadChild(Introduction_Complete_Book);
                    break;
                case "Measurements":
                    loadChild(Measurements);
                    break;
                case "Vector and Equilibrium":
                    loadChild(Vector_and_Equilibrium);
                    break;
                case "Motion and Force":
                    loadChild(Motion_and_Force);
                    break;
                case "Work and Energy":
                    loadChild(Work_and_Energy);
                    break;
                case "Circular Motion":
                    loadChild(Circular_Motion);
                    break;
                case "Fluid Dynamics":
                    loadChild(Fluid_Dynamics);
                    break;
                case "Oscillations":
                    loadChild(Oscillations);
                    break;
                case "Waves":
                    loadChild(Waves);
                    break;
                case "Physical Optics":
                    loadChild(Physical_Optics);
                    break;
                case "Optical Instruments":
                    loadChild(Optical_Instruments);
                    break;
                case "Heat and Thermodynamics":
                    loadChild(Heat_and_Thermodynamics);
                    break;
                default:
                    loadChild(ByDefalutMessage);
                    break;
            }

            ParentListItems.put(HoldItem, ChildList);
        }

        expandablelistView = findViewById(R.id.expandableListView1);
        final ExpandableListAdapter expListAdapter = new learnhubstudio.physicsXI.ExpandableListAdapter(this, ParentList, ParentListItems);
        expandablelistView.setAdapter(expListAdapter);

        expandablelistView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.

                Intent intent;
                switch (selected) {
                    case "Complete Book Introduction":
                        videos.setVideourl("RU07Wh4H_Zs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "Introduction to Physics":
                        videos.setVideourl("l0_auGmsbbc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    /////Intro  end here


                    case "1.1 : Introduction to Physics":
                        videos.setVideourl("E-PF2Opc_iA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "Introduction and Branches of Physics":
                        videos.setVideourl("hUJB-8UALLI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "1.2 : Physical Quantities(1)":
                        videos.setVideourl("xr23_CLtqhk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Physical Quantities(2)":
                        videos.setVideourl("xr23_CLtqhk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "1.3 : International System of Units (1)":
                        videos.setVideourl("Ltdi_EDElu0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "International System of Units (2)":
                        videos.setVideourl("UlsmQHlP8YU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Scientific Notations(1)":
                        videos.setVideourl("ASSvmoreizE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Scientific Notations(2)":
                        videos.setVideourl("YMnj_ahg8_M");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "1.4 : Errors and Uncertainties":
                        videos.setVideourl("vO4x0QpDscE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "1.5 : Significant Figures":
                        videos.setVideourl("kPUFPRMWKqc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "1.6 : Precision and Accuracy":
                        videos.setVideourl("lxuZcf9ClCY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "1.7 : Assessment of Total Uncertainty in the Final Result":
                        videos.setVideourl("0-fGTs0KcGw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "1.8 : Dimension of Physical Quantities":
                        videos.setVideourl("T2utyxMO85w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example no 1 to 4":
                        videos.setVideourl("Jb_AFwfKjx8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example no 1.1 to 1.4":
                        videos.setVideourl("OdVBsUZD0nQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example no 1.5 and 1.6":
                        videos.setVideourl("Ol7YoxT12_k");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example no 5 and 6":
                        videos.setVideourl("8bzTzbn7VI0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Question no 1 to 3":
                        videos.setVideourl("2TUxiskdQgM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  " Question no 1 to 3":
                        videos.setVideourl("ZzboYsTFdfo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 4":
                        videos.setVideourl("h4n9EtD0v7A");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 4 to 9":
                        videos.setVideourl("slcmeQhTT8M");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 5 to 9":
                        videos.setVideourl("cTocQnQ30Yc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 1.1 to 1.4":
                        videos.setVideourl("FUCvgSEXZWQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Problem no 1.5":
                        videos.setVideourl("T3vyA8KwHik");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Problem no 1.6":
                        videos.setVideourl("qlXiw01Zn28");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Problem no 1.7 to 1.10":
                        videos.setVideourl("t9vOpSuybdU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 1 to 4":
                        videos.setVideourl("l0V-czDBxYk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 5":
                        videos.setVideourl("0dvTFu3hZPI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 6":
                        videos.setVideourl("ibz_s63ahwc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 7 to 10":
                        videos.setVideourl("XuGWgk6XDCA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    ///////end here chapter 1
                    case  "2.1 : Basic Concepts of Vector":
                        videos.setVideourl("6iOLL6wXbPY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Basic Concepts of Vector":
                        videos.setVideourl("qkMV68QfVH4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Addition of Vectors":
                        videos.setVideourl("zBSgRqVbEao");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Unit Vector":
                        videos.setVideourl("7JBHiOgeSJ0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Rectangular Components of Vectors":
                        videos.setVideourl("sKxml3ignAQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "2.2 : Vector Addition by Rectangular Components":
                        videos.setVideourl("6SOt6_sSydk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Vector Addition by Rectangular Components":
                        videos.setVideourl("m7YxslRT79Y");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "2.3 : Product of two Vectors":
                        videos.setVideourl("dP7ETMcrGAk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Vector or Cross Product":
                        videos.setVideourl("hcc_F2-3bB8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Product of two Vector":
                        videos.setVideourl("s7zTUKr2aIs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "2.4 : Define Torque":
                        videos.setVideourl("T5vZWYj21u4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Torque":
                        videos.setVideourl("nSuGaET3gLo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "2.5 : Equilibrium of Forces":
                        videos.setVideourl("WfuPWRWxxuc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Equilibrium of Forces":
                        videos.setVideourl("Bo5fbOi--3o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "2.6 : Equilibrium of Torques":
                        videos.setVideourl("Ht_yhmj-PSE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 2.1 to 2.6":
                        videos.setVideourl("wzJ1qwU42Io");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 2.7 to 2.11":
                        videos.setVideourl("gXhFGB8my9k");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 2.12 and 2.13":
                        videos.setVideourl("YpKuSawj4QU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 2.14 to 2.16":
                        videos.setVideourl("fgdhh7P_KCA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Problem no 2.17 and 2.18":
                        videos.setVideourl("aFDPbi6QdD0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.1 and 2.2":
                        videos.setVideourl("_CjGHWJJ_BI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.3 and 2.4":
                        videos.setVideourl("3-bXBfu2dZY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.5 to 2.8":
                        videos.setVideourl("jNudAaHYNxM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.9 to 2.12":
                        videos.setVideourl("vHmVaRM3O0I");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.13 and 2.14":
                        videos.setVideourl("x-fk_MH5tpg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question no 2.15 to 2.18":
                        videos.setVideourl("2Uqqh1Buu90");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Question to 2.19 to 2.21":
                        videos.setVideourl("17IxCSIPHCg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 2.1 to 2.6":
                        videos.setVideourl("_YOrDBl7N3Y");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 2.7 to 2.11":
                        videos.setVideourl("lEPqqnrh4eA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 2.12 to 2.15":
                        videos.setVideourl("8Ei-eR_X5IE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 2.17 & 2.18":
                        videos.setVideourl("5QMEsjKuzHE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example 2.3 to 2.5":
                        videos.setVideourl("q-iHIQKjyVI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example 2.6 to 2.8":
                        videos.setVideourl("_huyifwi7Vw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    //// Chapter 2 end here

                    case  "Displacement":
                        videos.setVideourl("kDcBd4-kKy8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Define Displacement":
                        videos.setVideourl("_Uzg5iaSNB8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Define Velocity":
                        videos.setVideourl("C6xIHoO2NcY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Velocity":
                        videos.setVideourl("aGixaP9zQYs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Define Acceleration":
                        videos.setVideourl("s2RV9fVbhCQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Acceleration":
                        videos.setVideourl("SwCuvKPwWl4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Velocity-Time Graph":
                        videos.setVideourl("9qEHEfKB1NQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Velocity Time Graph":
                        videos.setVideourl("oy-R4usSv_o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Review Equation of Uniformly Accelerated Motion":
                        videos.setVideourl("eXc4F4t7Uzc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Review of Equations of Uniformly Acceleration Motion":
                        videos.setVideourl("F-_CVZ34LkI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Newton's Law of Motion":
                        videos.setVideourl("kg6io7K55QU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Newton's Law of Motions":
                        videos.setVideourl("sHkOAEIhMp8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Momentum":
                        videos.setVideourl("6esyabnQcVk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Define Momentum":
                        videos.setVideourl("oRIhx2MG9gA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Define Impulse":
                        videos.setVideourl("7kJuvQ9q1FA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Law of Conservations of Momentum":
                        videos.setVideourl("EKS93TOUBjE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Elastic and Inelastic Collision":
                        videos.setVideourl("rtIKOeexe1Q");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Special Cases of Elastic Collision in 1D":
                        videos.setVideourl("bW1FaRaP8ho");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Elastic & Inelastic Collision":
                        videos.setVideourl("7yn3Yv342kw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Force Due to Water Flow":
                        videos.setVideourl("By3nAVEZM1A");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Force Due to Water Flows":
                        videos.setVideourl("EL0hqmvz_EA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Momentum and Explosive Force":
                        videos.setVideourl("OF3J4TOSGYk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Momentum & Explosive Force":
                        videos.setVideourl("_iDEFK6E7-4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Rocket Propulsion":
                        videos.setVideourl("mxooukQ3lHc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Rocket Propulsions":
                        videos.setVideourl("BTybRqFMvvw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Projectile Motion":
                        videos.setVideourl("TOvA3hURkCU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Numerical no 3.1 to 3.3":
                        videos.setVideourl("64J_Xk_o5gU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Numerical no 3.4 to 3.6":
                        videos.setVideourl("K0Lew2OtpBQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Numerical no 3.7 and 3.8":
                        videos.setVideourl("XGGbjYxBwvI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case   "Exercise Numerical no 3.9 to 3.11":
                        videos.setVideourl("sVwYxMpik34");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Numerical no 3.12 to 3.15":
                        videos.setVideourl("nK9sISgvbO0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Exercise Question no 3.1 and 3.2":
                        videos.setVideourl("r5GBIEBfvcE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question no 3.3 and 3.4":
                        videos.setVideourl("ZustkHRKRbs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "Exercise Question no 3.5 and 3.6":
                        videos.setVideourl("x68vpaNS0gw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question no 3.7 and 3.8":
                        videos.setVideourl("8E9yJNR8B90");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question no 3.9 and 3.12":
                        videos.setVideourl("fw1j2ELxIRE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question no 3.13 and 3.14":
                        videos.setVideourl("o3WHM0TVM5U");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Physics Chapter 3 Exercise Example no 3.1":
                        videos.setVideourl("7SRTYSgHSlA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Physics Chapter 3 Exercise Example no 3.2":
                        videos.setVideourl("LB1S66APch0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Physics Chapter 3 Exercise Example no 3.3":
                        videos.setVideourl("RFD7ykj8uwQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;


                    case  "Physics Chapter 3 Exercise Example no 3.4":
                        videos.setVideourl("VdxHLJiXLiE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Example 3.1":
                        videos.setVideourl("ldP3Frf6Nwo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Example 3.2 and 3.3":
                        videos.setVideourl("TI4MmBJmZgM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Example 3.4 and 3.5":
                        videos.setVideourl("1Wzcxi8EtiY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Example 3.6":
                        videos.setVideourl("koLcKdCnU58");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        /////// Chapter 3 end here

                    case  "Work Done By a Contant Force":
                        videos.setVideourl("5ybtqJOmq88");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Work Done by Constant Forces":
                        videos.setVideourl("SuUoMqsbBDw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Work Done By A Variable Force":
                        videos.setVideourl("cO1ChBW14dU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Work Done by Variable Forces":
                        videos.setVideourl("5bB1FMKNypY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Work Done by Gravitational Field":
                        videos.setVideourl("pINm-Qc7u3o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Work Done by Gravitational Fields":
                        videos.setVideourl("k3glBc1Uz5g");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Power and Velocity":
                        videos.setVideourl("xDAtF9U3XN0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Power and Velocity 2":
                        videos.setVideourl("5t1SwZ6zxBU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Define Escape Velocity":
                        videos.setVideourl("hB9Aot9wDTU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Define Energy":
                        videos.setVideourl("4vbkhlEBrPg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Energy & Types of Energy":
                        videos.setVideourl("NPk9uvUNewo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Work Energy Principle":
                        videos.setVideourl("6OW-SP3O1tk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Absolute Potential Energy":
                        videos.setVideourl("h1uK-x7Q1Rg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Absolute P.E":
                        videos.setVideourl("DKGUHGce7is");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Escape Velocity":
                        videos.setVideourl("Bx0e4Wy4YyI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Interconversion of P.E and K.E":
                        videos.setVideourl("Eyluf_4FIt0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Interconversion of Potential & Kinetic Energy":
                        videos.setVideourl("6pLvJ5NOZq0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Conversation of Energy":
                        videos.setVideourl("HsezGuHGo-U");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Conversation of Energy 2":
                        videos.setVideourl("fKh2OPlh-nA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Non Convententional Energy Source":
                        videos.setVideourl("_quQ_fbEmMw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Energy From Waves":
                        videos.setVideourl("Wg6bx7qQDBY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Explain Solar Energy":
                        videos.setVideourl("pUvJBSinIiM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Energy From Biomass":
                        videos.setVideourl("sIy7z4WUEYo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Energy From Waste Product":
                        videos.setVideourl("CEweMxnvOhk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Non-Conventional Energy Sources":
                        videos.setVideourl("S9Crv5-LDQg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Physics Chapter 4 Exercise Example 4.1":
                        videos.setVideourl("E7HiNKqIJBA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Physics Chapter 4 Exercise Example 4.2":
                        videos.setVideourl("KXuHnR14T08");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Physics Chapter 4 Exercise Example 4.3":
                        videos.setVideourl("2l_Miqh0p0w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case "Exercise Example 4.1 to 4.3":
                        videos.setVideourl("Nzz3Fsqdp9w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Physics Chapter 4 Exercise Question 4.1 to 4.5":
                        videos.setVideourl("fTaXAwEnwXg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Physics Chapter 4 Exercise Question 4.6 to 4.8":
                        videos.setVideourl("mkqK534JGQM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question 4.1 to 4.5":
                        videos.setVideourl("Qr-OAeTqu_U");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question no 4.6":
                        videos.setVideourl("wW-Gt2h7rGc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Exercise Question no 4.7":
                        videos.setVideourl("oXjis4o60W0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question no 4.8":
                        videos.setVideourl("TzFLX6hl1Vg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Exercise Question no 4.9":
                        videos.setVideourl("fEJVuXIWCZ0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Exercise Question no 4.10":
                        videos.setVideourl("9tYV9r0GmBE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Numerical 4.1 to 4.3":
                        videos.setVideourl("TjYAGGAm_Hs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Numerical 4.4 & 4.5":
                        videos.setVideourl("5Jk35-CkqyQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Numerical 4.6 to 4.8":
                        videos.setVideourl("evT3Fm7_n3Q");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        case  "Numerical 4.9 and 4.10":
                        videos.setVideourl("06uLus2SbOI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        ///chapter 4 end here
                    case  "Angular Displacement":
                        videos.setVideourl("-tCcQou-y6o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Angular Velocity":
                        videos.setVideourl("ejykjjiCn8Y");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Relation Between Angular & Linear Velocities":
                        videos.setVideourl("Az84GarfWIw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Centripetal Force":
                        videos.setVideourl("NeQTB7ruy4E");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Moment of Inertia":
                        videos.setVideourl("I1a82nWbpPA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Angular Momentum":
                        videos.setVideourl("GokkN0fTABo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Law of Conservation of Angular Momentum":
                        videos.setVideourl("jp1vO7n6kwY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Rotational Kinetic Energy of Disc and Hoop":
                        videos.setVideourl("Dx2gfYYHW5M");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Artificial Settelites":
                        videos.setVideourl("94mug8ASgLU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Real and Apparent Weight":
                        videos.setVideourl("QAn3F5H0EGs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Weightlessness in Settelite & Gravity Free System":
                        videos.setVideourl("SM9oBgCgBTQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Orbital Velocity":
                        videos.setVideourl("bkQM34ksxd0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Artificial Gravity":
                        videos.setVideourl("gswKengtQt8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Geostationary Orbits":
                        videos.setVideourl("mEEbLsfirs0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Communication Satellite":
                        videos.setVideourl("JVX6cgq9L0Q");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Newton's & Einstein's":
                        videos.setVideourl("muE2MSSeqwE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Examples 5.1 and 5.2":
                        videos.setVideourl("VZ1xcOJg1S4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Examples 5.3 and 5.5":
                        videos.setVideourl("bSpoojg-l2A");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Examples 5.6 and 5.7":
                        videos.setVideourl("zafUmxD8_Ho");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 5.1 and 5.3":
                        videos.setVideourl("KD-2n5j4Y8o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 5.4 and 5.9":
                        videos.setVideourl("MLg8IDkDoxk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 5.10 and 5.13":
                        videos.setVideourl("czyLNeYwRg0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 5.1 and 5.4":
                        videos.setVideourl("IPVGGVaKsXw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 5.5 and 5.7":
                        videos.setVideourl("ZLX4R0QlvAo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 5.8 and 5.10":
                        videos.setVideourl("00vdD_xwaKw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        /////chapter 5 end here
                    case  "Vescosity & Stroke's Law":
                        videos.setVideourl("GdXxAtbYrGs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Terminal Velocity":
                        videos.setVideourl("9-pyVhcJdkQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Fluid Flow":
                        videos.setVideourl("KEfGEi4okPs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Equation of Continuity":
                        videos.setVideourl("OQUeegZK61w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Bernoulli's Equation":
                        videos.setVideourl("WIu1IeRNQ0E");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Torricelli's Theorem":
                        videos.setVideourl("vO65SvKW1Yo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Relation Between Speed and Pressure of the Fluid":
                        videos.setVideourl("WuBrXTlBCQQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Blood Flow":
                        videos.setVideourl("UTaZJzyyK80");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Venturi Relation":
                        videos.setVideourl("V0TiwDsv6vA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 1 to 3":
                        videos.setVideourl("toMdvzvcrIg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 4 to 8":
                        videos.setVideourl("nlX9N4vusZo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 9 to 12":
                        videos.setVideourl("IF3nbWxTWpo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 6.1 to 6.3":
                        videos.setVideourl("XiO8vbYtsb4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 6.4 to 6.6":
                        videos.setVideourl("ooSRbRWzkz4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical 6.7 to 6.9":
                        videos.setVideourl("nggOoTipAWs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example 6.1":
                        videos.setVideourl("jTAr6Z_s1iM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example 6.2":
                        videos.setVideourl("MwlKjO55Vl8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example 6.3":
                        videos.setVideourl("Um_1o7GsoIU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                        /////Chapter 6 end here
                    case  "Simple Harmonic Motion":
                        videos.setVideourl("aJcD1fdbgqQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "SHM and Circular Motion":
                        videos.setVideourl("fJxScZilW-0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Instantaneous Velocity":
                        videos.setVideourl("CLvphLCMHXI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Phase":
                        videos.setVideourl("_98U7FCBOdE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "A Horizontal Mass Spring System":
                        videos.setVideourl("nLIVXhk5JDw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Simple Pendulum":
                        videos.setVideourl("2EcYP-ZTBRA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Energy Conservation in SHM":
                        videos.setVideourl("jTf54E04_Qw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Free and Forced Oscillation":
                        videos.setVideourl("ccGs82P81vc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case "Resonance":
                        videos.setVideourl("MXn8KbzsKos");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Damped Oscillations":
                        videos.setVideourl("LVCWcAyzePY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Sharpness of Resonance":
                        videos.setVideourl("1rfwNcV_HLc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 7.1 to 7.2":
                        videos.setVideourl("AsXSxtBq54s");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 7.3 to 7.4":
                        videos.setVideourl("qahubIDcaWA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 7.5 to 7.6":
                        videos.setVideourl("2hmjBcpiyiA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 7.7 to 7.8":
                        videos.setVideourl("knpv5kVcD9w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise question 7.9 to 7.10":
                        videos.setVideourl("7y4rNRYODkE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise question 7.11 to 7.13":
                        videos.setVideourl("I0am-kgvBRM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical NO.7.1":
                        videos.setVideourl("US5kChJ24_k");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical NO.7.2":
                        videos.setVideourl("lvluWmF9u8I");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical NO.7.3":
                        videos.setVideourl("frsAVk4QYvc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical NO.7.4 and 7.5":
                        videos.setVideourl("XuTmIOIq7RU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical NO.7.6 and 7.7":
                        videos.setVideourl("lnyDEaY47BM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical NO.7.8":
                        videos.setVideourl("IDcgx6J-hOE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Examples 7.1 to 7.3":
                        videos.setVideourl("8-WXGVxB1xA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                        //////Chapter 7 End here
                    case  "Progressive Waves":
                        videos.setVideourl("1YJBlFjPQIQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Periodic Waves":
                        videos.setVideourl("A6WWXko8HtY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Speed of Sound in Air":
                        videos.setVideourl("Hp7SCtdehwk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Principle of Superposition":
                        videos.setVideourl("aEqY8CozuqM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Interference Waves":
                        videos.setVideourl("BgWxsArAGQk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Beats Waves":
                        videos.setVideourl("LuEVxCaSB_4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Reflection of Waves":
                        videos.setVideourl("r-oqjEhGwjM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Stationary Waves":
                        videos.setVideourl("kE65Q9Szr2o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Stationary Waves in Stretched String":
                        videos.setVideourl("0P6F0ao_pPg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Stationary Waves in Air Columns":
                        videos.setVideourl("RwDavRSnNr0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Doppler Effect":
                        videos.setVideourl("8Zhg1MIZJn8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Application of Doppler Effect":
                        videos.setVideourl("pVNo0tUjqGE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise question 8.1 to 8.3":
                        videos.setVideourl("TVNQnDW4i7Q");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "Exercise question 8.4 to 8.5":
                        videos.setVideourl("chprTRUf2Uo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise question 8.6 to 8.7":
                        videos.setVideourl("4V__MOWO4BE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise question 8.9 to 8.11":
                        videos.setVideourl("EdtnijpTUtg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 8.1 to 8.2":
                        videos.setVideourl("26FFTNSFAp4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 8.4 to 8.5":
                        videos.setVideourl("rCT7kGEyNoI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical NO.8.1 to 8.5":
                        videos.setVideourl("TCPkSe-vmYs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical NO.8.6 to 8.10":
                        videos.setVideourl("uAGOKeUswkk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        /////Chapter 8 End here
                    case  "Wave Fronts":
                        videos.setVideourl("Im3NqnDvZpo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Huygen's Principle":
                        videos.setVideourl("xVwFSMB2XVg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Interference of Light":
                        videos.setVideourl("8SVlOhcxQJE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Young's Double Slit Experiment":
                        videos.setVideourl("GZzpWjvB10s");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Interference in the Film":
                        videos.setVideourl("Y7oragntYsc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Newton's Ring":
                        videos.setVideourl("rEhWTt8Mibk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Michelson's Interferometer":
                        videos.setVideourl("5W7gmqE7wD8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Diffraction of Light":
                        videos.setVideourl("TAniCKpjob0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Diffraction Due to a Narrow Slit.":
                        videos.setVideourl("ddPY6k8ay4U");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Diffraction Grating.":
                        videos.setVideourl("uIjo8Eqvo7Y");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Diffraction of X-Rays by Crystals":
                        videos.setVideourl("JDxjEjC5fkI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Polarization":
                        videos.setVideourl("8lprSk6kmK4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Optical Rotation":
                        videos.setVideourl("8DLSuuAjs3I");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.1":
                        videos.setVideourl("ztaQWKxF3RE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.2 and 9.3":
                        videos.setVideourl("GDl4HANR9BI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.4":
                        videos.setVideourl("doaVTSpSnyA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.5":
                        videos.setVideourl("aScA9vxcIjg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        case  "Exercise Question No. 9.6 and 9.7":
                        videos.setVideourl("4hmCiz2pD_o");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.8":
                        videos.setVideourl("yIHiHar5NEU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.9":
                        videos.setVideourl("_dNxYB7gpsk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 9.10":
                        videos.setVideourl("4GviT2J7aKY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example No. 9.1":
                        videos.setVideourl("hubX2QLqb9w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example No. 9.2":
                        videos.setVideourl("jmnmx0vv6VM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Example No. 9.3":
                        videos.setVideourl("eOcK9h8tBz0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical No. 9.1 and 9.4":
                        videos.setVideourl("0rHPP-IGf9Q");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Numerical No. 9.5 and 9.7":
                        videos.setVideourl("zX8JCw4a_Bw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical No. 9.8 and 9.10":
                        videos.setVideourl("uHiCcn90Pl4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                        ////// Chapter 9 End here

                    case  "Least Distance of District Vision":
                        videos.setVideourl("7eg4-yI7F0E");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Magnifying & Resolving Power of an Optical Instrument":
                        videos.setVideourl("0jmO5qAzGvA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Simple Microscope Magnification":
                        videos.setVideourl("oKlvix9OI00");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Compound Microscope":
                        videos.setVideourl("n70PmLXS4aE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Astronomical Telescope":
                        videos.setVideourl("dF7FGL9DOvE");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Physics Spectrometer":
                        videos.setVideourl("ZkR3szMIPW8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Speed of Light":
                        videos.setVideourl("zZZw9lvtxi0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Introduction to Fiber Optics":
                        videos.setVideourl("PQZCUs0q0tY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case "Fibre Optics Principle":
                        videos.setVideourl("rsHbtIYs0HI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Continuous Refraction":
                        videos.setVideourl("C0fGnHrguYo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Types of Optical Fibres":
                        videos.setVideourl("sxH85tEhmSs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Signal Transmittion & Conversion to Sound":
                        videos.setVideourl("jpVQPx7VPgA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Losses of Power Physics":
                        videos.setVideourl("l5jV7Ssdpa4");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Question 10.1 to 10.3":
                        videos.setVideourl("5roUTI2f62w");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Question 10.4 to 10.6":
                        videos.setVideourl("IPi5CCmV3H0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Question 10.7":
                        videos.setVideourl("SYXE5m4UzHg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Question 10.8 to 10.11":
                        videos.setVideourl("W6vYZJ_uy3A");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 10.1":
                        videos.setVideourl("rw0jH9ThJqw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 10.2":
                        videos.setVideourl("aygLaSj5fnQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 10.1 and 10.2":
                        videos.setVideourl("6Wo9uykbqlI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 10.3 and 10.5":
                        videos.setVideourl("sOb_ONC3VyM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 10.6 and 10.8":
                        videos.setVideourl("hLdKYI7kLss");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 10.9 and 10.10":
                        videos.setVideourl("-s_ykuKJhfg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        //////////Chapter 10 END here

                    case  "Kinetic Theory of Gases":
                        videos.setVideourl("wXduSwhu7Eo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Internal Energy":
                        videos.setVideourl("XlYweVayK5c");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Work and Heat in Physics":
                        videos.setVideourl("lPfqHLeojqw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "First Law of Thermodynamics":
                        videos.setVideourl("HkaAJ_lZfmY");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Isothermal Process Constant Temperature":
                        videos.setVideourl("RZpnJg_ULgU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Molar Specific Heat of Gas":
                        videos.setVideourl("92I4g0gq5Pw");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Reversible and Irreversible Process":
                        videos.setVideourl("V3PfBE9dKdk");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Heat Engine":
                        videos.setVideourl("BBNcQ4R1DX0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Second Law of Thermodynamics":
                        videos.setVideourl("qtuj-cySxFg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Carnot's Engine & Theorem":
                        videos.setVideourl("xJqSGxJWU1A");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Thermodynamics Scale of Temperature":
                        videos.setVideourl("q18H58jatJ0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Petro Engine":
                        videos.setVideourl("-kZWrt8ZnlA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Entropy":
                        videos.setVideourl("WMCtbd0kNRM");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Environmental Crisis as Entropy Crisis":
                        videos.setVideourl("aWm711RlNwQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.1":
                        videos.setVideourl("EtTZDmAobTg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.2 and 11.3":
                        videos.setVideourl("pFLxNXOQOLo");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.4 and 11.5":
                        videos.setVideourl("GtTtNBikfCU");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                    case  "Exercise Question No. 11.6 and 11.7":
                        videos.setVideourl("7Mva8Hlfr6U");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.8 and 11.10":
                        videos.setVideourl("2ZY58zVoaPs");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.11 and 11.12":
                        videos.setVideourl("2xnGu6o49d8");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Exercise Question No. 11.13 and 11.16":
                        videos.setVideourl("ZvIhruir2z0");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 11.1 to 11.3":
                        videos.setVideourl("aWm711RlNwQ");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Examples 11.4 to 11.5":
                        videos.setVideourl("tfkQmhFD7rc");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 11.1 and 11.2":
                        videos.setVideourl("TH5_1-zAICg");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 11.3 and 11.4":
                        videos.setVideourl("pjv8BcQZr-k");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 11.5 and 11.6":
                        videos.setVideourl("h2bzCWMGeTA");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 11.7 and 11.9":
                        videos.setVideourl("8RqwbEg0sMI");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;

                    case  "Numerical no 11.10 and 11.11":
                        videos.setVideourl("sovlAvF4c7c");
                        intent = new Intent(VideoActivity.this, ytplayer1.class);
                        startActivity(intent);
                        break;
                        //////Chapter 11 END here
                }

                return true;
            }
        });

    }


    private void loadChild(String[] ParentElementsName) {
        ChildList = new ArrayList<>();
        ChildList.addAll(Arrays.asList(ParentElementsName));
    }

}


