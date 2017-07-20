package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.utils.DatabaseHelper;

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
    private DatabaseHelper db;


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
        if (mItem.getFav() == 1) {
            holder.btnFav.setText("Un Fav");
        } else {
            holder.btnFav.setText(" Fav");
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button btnFav;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtFav);
            btnFav = (Button) itemView.findViewById(R.id.btnFav);
            btnFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MOption mItem = mItems.get(getAdapterPosition());
                    if (mItem.getFav() == 0) {
                        mItem.setFav(1);

                    } else {
                        mItem.setFav(0);
                    }
                    db = new DatabaseHelper(context);
                    db.addFavData(mItem);
//                    mItems.get(getAdapterPosition()).setFav(mItem.getFav());
                    mItems = db.getFavData();
                    notifyDataSetChanged();

                }
            });

        }
    }
}

