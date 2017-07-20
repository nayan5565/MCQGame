package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.CheckBoxCategoryActivity;
import com.techienerd.questiongame.activity.ListViewCategoryActivity;
import com.techienerd.questiongame.activity.ListViewOptionActivity;
import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.utils.Global;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/19/2017.
 */
public class ListViewOptionAdapter extends RecyclerView.Adapter<ListViewOptionAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MOption> mItems;
    private MOption mItem;
    View view;


    public ListViewOptionAdapter(Context context) {
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
        if (Global.color == 1)
            if (mItem.getTag() == 1) {
                holder.textView.setTextColor(Color.GREEN);
            } else if (mItem.getTag() == 2) {
                holder.textView.setTextColor(Color.RED);
            }

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
                    Global.color = 1;
                    ListViewOptionActivity.getInstance().stop++;
                    ListViewOptionActivity.getInstance().colorChange();
                    notifyDataSetChanged();
                    if (ListViewCategoryActivity.getInstance().pos > 1)
                        return;
                    if (mItem.getTag() == 1) {
                        ListViewOptionActivity.getInstance().correct++;
                    } else {
                        mItem.setTag(2);
                        notifyDataSetChanged();
                        ListViewOptionActivity.getInstance().wrong++;
                    }

                    ListViewOptionActivity.getInstance().txtResult.setText(ListViewOptionActivity.getInstance().correct + " : " + ListViewOptionActivity.getInstance().wrong);
                }
            });
        }
    }
}

