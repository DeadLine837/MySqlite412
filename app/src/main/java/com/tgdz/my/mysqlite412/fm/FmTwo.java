package com.tgdz.my.mysqlite412.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.tgdz.my.mysqlite412.R;
import com.tgdz.my.mysqlite412.TabDb;

public class FmTwo extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        init();
        return view;
    }


    private void init() {
        ((TextView) view.findViewById(R.id.fm_text)).setText(TabDb.getTabsTxt()[1]);

        final View actionS = view.findViewById(R.id.action_save);
        final View actionQ = view.findViewById(R.id.action_query);
        actionS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "actionS", Toast.LENGTH_SHORT).show();
            }
        });
        actionQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "actionQ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
