package com.techienerd.questiongame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.questiongame.R;
import com.techienerd.questiongame.activity.MainActivity;
import com.techienerd.questiongame.model.MOption;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/12/2017.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MOption> mItems;
    private MOption mItem;
    public static int wa, ca;


    public QuestionAdapter(Context context) {
        this.context = context;
        mItems = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MOption> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }
    public void notifyData(){
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mItem = mItems.get(position);
        holder.textView.setText(mItem.getOption() + "");

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItem = mItems.get(getAdapterPosition());
                    if (mItem.getTag() == 1) {
                        ca++;
                        MainActivity.getInstance().setCount(ca +" : "+wa);
                        Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
//                        itemView.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                MainActivity.getInstance().prepareDisplay();
//                            }
//                        }, 2000);
                    } else {
                        wa++;
                        MainActivity.getInstance().setCount(ca +" : "+wa);
//                        MainActivity.getInstance().setCount(wa + "");
                        Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
