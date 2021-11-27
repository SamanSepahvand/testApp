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
import com.example.testapp.adapter.FileAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";





    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView recyclerView;
    private FileAdapter fileAdapter;




    public FileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FileFragment newInstance(String param1, String param2) {
        FileFragment fragment = new FileFragment();
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
   //    ChangeStatusBar();
    }

    private void ChangeStatusBar(){
        if (  getActivity()!=null) {
            if (Build.VERSION.SDK_INT >= 21) {
                //getActivity().getWindow().setNavigationBarColor(getResources().getColor(R.color.newYellowDark));
                getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.newBlue));
                getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser);
          //  ChangeStatusBar();
    }

    private void FillData(){


        ArrayList<String> listData=new ArrayList<>();



        listData.add("آلارم ها");
        listData.add("اندروید");
        listData.add("پشتیبانی");
        listData.add("کتاب ها");
        listData.add("داده ها");
        listData.add("دوربین");
        listData.add("دانلود ها");
        listData.add("موسیقی ها");
        listData.add("ویدئو ها");
        listData.add("واتس آپ");
        listData.add("تلگرام");
        listData.add("صدای ها");
        listData.add("زنگ های هشدار");
        listData.add(" فونت ها");
        listData.add("مورد علاقه ها");

        fileAdapter=new FileAdapter(listData,getActivity());
        recyclerView.setAdapter(fileAdapter);

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