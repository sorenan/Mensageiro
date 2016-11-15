package hiae.android.mensageiro.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerView_VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

//    private final int verticalSpaceHeight;

    public RecyclerView_VerticalSpaceItemDecoration(int verticalSpaceHeight) {
//        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
//        outRect.bottom = verticalSpaceHeight;
    }
}