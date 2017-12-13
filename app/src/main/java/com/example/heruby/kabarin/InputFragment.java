package com.example.heruby.kabarin;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {


    EditText label;
    EditText detail;
    TimePicker time;
    DatePicker date;
    Button save;
    String strDateTime;


    private komunikasiFragment komunikasiFragment;
    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        label = v.findViewById(R.id.edit_label);
        detail = v.findViewById(R.id.edit_detail);
        time = v.findViewById(R.id.timePicker);
        date = v.findViewById(R.id.datePicker);
        save = v.findViewById(R.id.btn_save);
        strDateTime = date.getYear() + "-" + (date.getMonth() + 1) + "-" + date.getDayOfMonth() + " "+ time.getCurrentHour() + ":" + time.getCurrentMinute();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                komunikasiFragment.kirimData(label.getText().toString(),detail.getText().toString(),strDateTime);
            }
        });
        return v;
    }

    public interface komunikasiFragment{
        void kirimData(String label,String detail, String date);

        String getLabel();
        String getDetail();
        String getTime();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            komunikasiFragment = (com.example.heruby.kabarin.InputFragment.komunikasiFragment)context;
        }catch (Exception e){

        }
    }
}


