package com.example.socmedapp;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModalClass> mList;
    CustomAdapter customAdapter ;
    SearchView searchView;


    public SearchFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = v.findViewById(R.id.recyclerViewId2);
        searchView =v.findViewById(R.id.searchView);
        searchView.clearFocus();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity() ) );

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);

                return true;
            }
        });


        mList=new ArrayList<>();
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

        customAdapter =new CustomAdapter(mList,getContext());
        recyclerView.setAdapter(customAdapter);
        return v;



    }

    private void filterList(String text) {
        List<ModalClass>filteredList = new ArrayList<>();
        for (ModalClass item: mList) {
            if(item.getText().toLowerCase().contains(text.toLowerCase() ) ){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(getActivity(),"Aranan ürün bulunamadı",Toast.LENGTH_SHORT).show();
        }else {
            customAdapter.setFilteredList(filteredList);
        }

    }

}