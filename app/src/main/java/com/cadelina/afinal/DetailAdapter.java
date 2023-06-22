package com.cadelina.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DetailAdapter extends ArrayAdapter<HistoryDetail> {
    public DetailAdapter(Context context, List<HistoryDetail> historyDetail) {
        super(context, 0, historyDetail);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HistoryDetail HistoryDetail = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.detail_cell, parent, false);

            TextView td = convertView.findViewById(R.id.titleDate);
            TextView dd = convertView.findViewById(R.id.detailDetail);

            td.setText(HistoryDetail.getTitleDate());
            dd.setText(HistoryDetail.getDetailDate());

        return convertView;
    }
}
