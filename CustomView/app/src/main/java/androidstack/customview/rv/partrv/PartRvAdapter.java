package androidstack.customview.rv.partrv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidstack.customview.R;

public class PartRvAdapter extends RecyclerView.Adapter<PartRvAdapter.PartRvHolder> {


    private List<String> mParts;


    private Context mContext;

    public PartRvAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setParts(List<String> parts) {
        this.mParts = parts;
    }

    @NonNull
    @Override
    public PartRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_part_rv, parent, false);
        return new PartRvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartRvHolder holder, int position) {
        holder.textView.setText(mParts.get(position));
    }

    @Override
    public int getItemCount() {
        return mParts == null ? 0 : mParts.size();
    }

    class PartRvHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public PartRvHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_part_rv);
        }
    }
}
