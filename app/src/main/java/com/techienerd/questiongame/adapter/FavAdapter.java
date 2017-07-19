package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.ListViewOptionActivity;
import com.techienerd.questiongame.model.MAllQuestion;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/20/2017.
 */
public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MOption> mItems;
    private MOption mItem;
    private View view;


    public FavAdapter(Context context) {
        this.context = context;
        mItems = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MOption> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.fav_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mItem = mItems.get(position);
        holder.textView.setText(mItem.getOption());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtFav);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}

