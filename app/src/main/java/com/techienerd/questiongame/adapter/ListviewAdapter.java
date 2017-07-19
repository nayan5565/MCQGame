package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.CheckSystemActivity;
import com.techienerd.questiongame.activity.ListOptionActivity;
import com.techienerd.questiongame.model.MAllQuestion;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListviewAdapter extends RecyclerView.Adapter<ListviewAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MOption> mItems;
    private MOption mItem;
    public static int wa, ca;
    View view;


    public ListviewAdapter(Context context) {
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
        view = inflater.inflate(R.layout.option_row, parent, false);
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
        Button btnFav;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtOption);
            btnFav = (Button) itemView.findViewById(R.id.btnFav);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItem = mItems.get(getAdapterPosition());
                    if (mItem.getTag() == 1) {
                        Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

