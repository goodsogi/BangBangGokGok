/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.kr.app.bangbanggokgok.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;


public class PinnedHeaderListView extends ListView {


    public interface PinnedHeaderInterface {
        public static final int PINNED_HEADER_VISIBLE = 0;
        public static final int PINNED_HEADER_HIDDEN = 1;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        
        public int getPinnedHeaderState(int position);

        public View getPinnedHeaderView(int position);

    }


    private PinnedHeaderInterface pinnedHeaderInterface;
    

    private int mHeaderViewWidth;

    private int mHeaderViewHeight;
    
	private int alpha = 255;
	

    public PinnedHeaderListView(Context context) {
        super(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setPinnedHeaderInterface(PinnedHeaderInterface adapter) {
    	setFadingEdgeLength(0);
        pinnedHeaderInterface = adapter;
    }


	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (pinnedHeaderInterface != null) {
	        View headerView = pinnedHeaderInterface.getPinnedHeaderView(getFirstVisiblePosition());
	        if (headerView != null) {
	            measureChild(headerView, widthMeasureSpec, heightMeasureSpec);
	            mHeaderViewWidth = headerView.getMeasuredWidth();
	            mHeaderViewHeight = headerView.getMeasuredHeight();
	        }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (pinnedHeaderInterface != null) {
        	View headerView = pinnedHeaderInterface.getPinnedHeaderView(getFirstVisiblePosition());
        	if (headerView != null) {
        		headerView.layout(0, 0, mHeaderViewWidth, mHeaderViewHeight);
        	}
        }
    }
   

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (pinnedHeaderInterface != null) {
        	int position = getFirstVisiblePosition();
        	View headerView = pinnedHeaderInterface.getPinnedHeaderView(position);

        	if (headerView != null) {
        		ColorDrawable backgroundDrawable = (ColorDrawable) headerView.getBackground();
        		int state = pinnedHeaderInterface.getPinnedHeaderState(position);
        		switch(state) {
        		case PinnedHeaderInterface.PINNED_HEADER_PUSHED_UP:
        			headerView.setVisibility(View.VISIBLE);
        			View firstView = getChildAt(0);
        			int gap = firstView.getTop() + firstView.getHeight();
        			if (gap <= headerView.getHeight()) {
        				int pushGap = gap-headerView.getHeight();
        				
        				if (backgroundDrawable != null) {
            				int alpha = this.alpha - (int) ((float)(-1*pushGap)/headerView.getHeight() * this.alpha);
            				backgroundDrawable.setAlpha(alpha);
        				}
        				headerView.layout(0,pushGap,  mHeaderViewWidth, mHeaderViewHeight+pushGap);
        			}
        			else {
            			headerView.setVisibility(View.VISIBLE);
        				if (backgroundDrawable != null) {
        					headerView.getBackground().setAlpha(alpha);
        				}
            			headerView.layout(0, 0,  mHeaderViewWidth, mHeaderViewHeight);        				
        			}
            		drawChild(canvas, headerView, getDrawingTime());
        			break;
        		case PinnedHeaderInterface.PINNED_HEADER_HIDDEN:
        			headerView.setVisibility(View.GONE);
        			break;
        		case PinnedHeaderInterface.PINNED_HEADER_VISIBLE:
        			headerView.setVisibility(View.VISIBLE);
    				if (backgroundDrawable != null) {
    					headerView.getBackground().setAlpha(alpha);
    				}
        			headerView.layout(0, 0,  mHeaderViewWidth, mHeaderViewHeight);
            		drawChild(canvas, headerView, getDrawingTime());
        			break;
        		}
        	}
        }        
    }
}
