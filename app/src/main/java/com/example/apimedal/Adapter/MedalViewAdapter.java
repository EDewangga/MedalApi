package com.example.apimedal.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apimedal.EditActivity;
import com.example.apimedal.Model.Medal;
import com.example.apimedal.R;

import java.util.List;

public class MedalViewAdapter extends RecyclerView.Adapter<MedalViewAdapter.MyViewHolder>{
    List<Medal> mMedalList;

    public MedalViewAdapter(List <Medal> MedalList) {
        mMedalList = MedalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medal_row, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewPosition.setText(String.valueOf(mMedalList.get(position).getId()));
        holder.mTextViewNegara.setText(String.valueOf(mMedalList.get(position).getNegara()));
        holder.mTextViewGold.setText(String.valueOf(mMedalList.get(position).getGold()));
        holder.mTextViewSilver.setText(String.valueOf(mMedalList.get(position).getSilver()));
        holder.mTextViewBronze.setText(String.valueOf(mMedalList.get(position).getBronze()));
        holder.mTextViewTotal.setText(String.valueOf(mMedalList.get(position).getTotal()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Position", String.valueOf(mMedalList.get(position).getId()));
                mIntent.putExtra("Country", String.valueOf(mMedalList.get(position).getNegara()));
                mIntent.putExtra("Gold", String.valueOf(mMedalList.get(position).getGold()));
                mIntent.putExtra("Silver", String.valueOf(mMedalList.get(position).getSilver()));
                mIntent.putExtra("Bronze", String.valueOf(mMedalList.get(position).getBronze()));
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mMedalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewPosition, mTextViewNegara, mTextViewGold, mTextViewSilver, mTextViewBronze, mTextViewTotal;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewPosition= itemView.findViewById(R.id.id);
            mTextViewNegara = itemView.findViewById(R.id.negara);
            mTextViewGold = itemView.findViewById(R.id.gold);
            mTextViewSilver = itemView.findViewById(R.id.silver);
            mTextViewBronze = itemView.findViewById(R.id.bronze);
            mTextViewTotal= itemView.findViewById(R.id.total);
        }
    }
}
