package hiae.android.mensageiro.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hiae.android.mensageiro.R;


public class RecyclerView_Adapter extends RecyclerView
        .Adapter<RecyclerView_Adapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<RecyclerView_DataObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        TextView dateTime2;
        ImageView imageView;

        public DataObjectHolder(View itemView) {
            super(itemView);
            /*
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime =  (TextView) itemView.findViewById(R.id.textView2);
            dateTime2 =  (TextView) itemView.findViewById(R.id.textView3);
            imageView =  (ImageView) itemView.findViewById(R.id.imageView1);
            */
           // label  = (TextView) itemView.findViewById(R.id.person_age);
            //dateTime = (TextView) itemView.findViewById(R.id.thumbnail);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            //overflow = (ImageView) itemView.findViewById(R.id.overflow);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerView_Adapter(ArrayList<RecyclerView_DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycle_card_view, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

       // holder.label.setText(mDataset.get(position).getmText1());
        //holder.dateTime.setText(mDataset.get(position).getmText2());
        holder.imageView.setImageResource(mDataset.get(position).getmImageView());
    }

    public void addItem(RecyclerView_DataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}