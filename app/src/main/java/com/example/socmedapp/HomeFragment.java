package com.example.socmedapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModalClass> mList ;
    CustomAdapter customAdapter;



    public HomeFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= v.findViewById(R.id.recyclerViewId);

        customAdapter=new CustomAdapter(mList,getContext());
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity() ) );


        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mList =new ArrayList<>();
        mList.add(new ModalClass(R.drawable.oyuncak_ayi, "Peluş Ayı"));
        mList.add(new ModalClass(R.drawable.oyuncak_arimaya ,"Peluş Oyuncak Arı Maya"));
        mList.add(new ModalClass(R.drawable.oyuncak_aslan, "Peluş Aslan"));
        mList.add(new ModalClass(R.drawable.oyuncak_daire, "Oyuncak Toy"));
        mList.add(new ModalClass(R.drawable.oyuncak_kamyon, "Oyuncak Kamyon "));
        mList.add(new ModalClass(R.drawable.oyuncak_kirmiziaraba, "Oyuncak Kırmızı Araba"));
        mList.add(new ModalClass(R.drawable.oyuncak_sariaraba, "Oyuncak Sarı Araba "));
        mList.add(new ModalClass(R.drawable.oyuncak_motoraraba, "Oyuncak 4x4 Araba "));
        mList.add(new ModalClass(R.drawable.oyuncak_ucak, "Oyuncak Uçak"));
        mList.add(new ModalClass(R.drawable.oyuncak_lego, "Lego Oyuncak "));
        mList.add(new ModalClass(R.drawable.oyuncak_legoninjago, "Lego Ninjago Oyuncakları"));
        mList.add(new ModalClass(R.drawable.oyuncak_ninjakaplumbaga, "Ninja Kaplumbağalar Oyuncak"));


    }


}