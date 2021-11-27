package com.example.testapp.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.R;
import com.example.testapp.adapter.ContactAdapter;
import com.example.testapp.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private RecyclerView recyclerView;

    private HomeAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void initView(View view){

        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setHasFixedSize(true);

        FillData();


        ChangeStatusBar();

    }




    private void ChangeStatusBar(){
        if (Build.VERSION.SDK_INT >= 21) {
            //getActivity().getWindow().setNavigationBarColor(getResources().getColor(R.color.newYellowDark));
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.newYellowDark));
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

        }

    }


    public   class HomeModel{

        private String title;
        private int drawable;


        public HomeModel(String title, int drawable) {
            this.title = title;
            this.drawable = drawable;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDrawable() {
            return drawable;
        }

        public void setDrawable(int drawable) {
            this.drawable = drawable;
        }
    }

    private void FillData(){


        ArrayList<HomeModel> listData=new ArrayList<>();



        listData.add( new HomeModel("آلارم ها",R.drawable.ic_baseline_notifications_24));
        listData.add(new HomeModel("اندروید",R.drawable.ic_baseline_android_24));
        listData.add(new HomeModel("پشتیبانی",R.drawable.ic_baseline_support_agent_24));
        listData.add(new HomeModel("کتاب ها",R.drawable.ic_baseline_android_24));
        listData.add(new HomeModel("داده ها",R.drawable.ic_baseline_assistant_direction_24));
        listData.add(new HomeModel("دوربین",R.drawable.ic_baseline_settings_24));
        listData.add(new HomeModel("دانلود ها",R.drawable.ic_baseline_star_24));
        listData.add(new HomeModel("موسیقی ها",R.drawable.ic_baseline_music_note_24));
        listData.add(new HomeModel("ویدئو ها",R.drawable.ic_baseline_settings_24));
        listData.add(new HomeModel("واتس آپ",R.drawable.ic_baseline_star_24));
        listData.add(new HomeModel("تلگرام",R.drawable.ic_baseline_support_agent_24));
        listData.add(new HomeModel("صدای ها",R.drawable.ic_baseline_music_note_24));
        listData.add(new HomeModel("زنگ های هشدار",R.drawable.ic_baseline_settings_24));
        listData.add(new HomeModel(" فونت ها",R.drawable.ic_baseline_android_24));
        listData.add(new HomeModel("مورد علاقه ها",R.drawable.ic_baseline_star_24));

        adapter=new HomeAdapter(listData,getActivity());
        recyclerView.setAdapter(adapter);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_file, container, false);

        initView(view);
        return view;

    }



}