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
import com.example.testapp.adapter.FileAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;

    ContactAdapter adapter;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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

    private void initView(View view) {

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        FillData();

   //    ChangeStatusBar();

    }


    private void FillData() {

        adapter = new ContactAdapter(new ContactModel().FillData(), getActivity());
        recyclerView.setAdapter(adapter);

    }


    public class ContactModel {

        Random r = new Random();

        int[] picList = new int[]{
                R.drawable.f1,
                R.drawable.f2,
                R.drawable.f3,
                R.drawable.f4
        };



        private String title;
        private int randImageResources;


        public ContactModel() {
        }

        public ContactModel(String title, int randImageResources) {
            this.title = title;
            this.randImageResources = randImageResources;
        }

        public String getTitle() {
            return title;
        }

        public int getRandImageResources() {
            return randImageResources;
        }

        private ArrayList<ContactModel> FillData() {
            ArrayList<ContactModel> contactModels=new ArrayList<>();
            for (int i = 0; i <= 13; i++) {
                this.title = i + " ساعت پیش ";
                this.randImageResources = picList[r.nextInt(picList.length)];
                contactModels.add(new ContactModel(this.title, this.randImageResources));

            }
            return  contactModels;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        initView(view);
        return view;

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser);
        // ChangeStatusBar();
    }

    private void ChangeStatusBar(){
        if (Build.VERSION.SDK_INT >= 21) {
            //getActivity().getWindow().setNavigationBarColor(getResources().getColor(R.color.newYellowDark));
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.cherryLight));
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

        }

    }


}