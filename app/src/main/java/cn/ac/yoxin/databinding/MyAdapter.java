package cn.ac.yoxin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.ac.yoxin.databinding.api.BusInfo;

/**
 * Created by zhengyoxin on 16-8-31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<BusInfo.Bus> mDataset;


    public MyAdapter(List<BusInfo.Bus> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.get.setText(mDataset.get(position).getName());
//        holder.tel.setText(mDataset.get(position).getTel());
//        holder.adds.setText(mDataset.get(position).getAdds());
        BusInfo.Bus bus = mDataset.get(position);
        holder.getBinding().setVariable(cn.ac.yoxin.databinding.BR.bus, bus);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
//        public View view;
//        public TextView name;
//        public TextView tel;
//        public TextView adds;

        public ViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
//            view = v;
//            name = (TextView) v.findViewById(R.id.bus_name);
//            tel = (TextView) v.findViewById(R.id.bus_tel);
//            adds = (TextView) v.findViewById(R.id.bus_adds);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
