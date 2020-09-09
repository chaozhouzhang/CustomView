package androidstack.progress.rv.partrv;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidstack.progress.R;

public class PartRvActivity extends AppCompatActivity {



    private PartRvAdapter mPartRvAdapter;
    private RecyclerView mRvPart;
    private RecyclerView mRvPart1;
    private RecyclerView mRvPart2;
    private List<String> mParts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_rv);
        mRvPart = findViewById(R.id.rv_part);
        mRvPart1 = findViewById(R.id.rv_part_1);
        mRvPart2 = findViewById(R.id.rv_part_2);

        mPartRvAdapter = new PartRvAdapter(this);

        mParts = new ArrayList<>();
        for (int i=0;i<20;i++){
            mParts.add(getString(R.string.app_name)+" - "+i);
        }

        mPartRvAdapter.setParts(mParts);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,5);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,5);
        gridLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);


        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,5);
        gridLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);

        mRvPart.setHasFixedSize(true);
        mRvPart1.setHasFixedSize(true);
        mRvPart2.setHasFixedSize(true);
        mRvPart.setLayoutManager(gridLayoutManager);
        mRvPart1.setLayoutManager(gridLayoutManager1);
        mRvPart2.setLayoutManager(gridLayoutManager2);
        mRvPart.setAdapter(mPartRvAdapter);
        mRvPart1.setAdapter(mPartRvAdapter);
        mRvPart2.setAdapter(mPartRvAdapter);

    }
}
