package com.wd.wd_healthy.model.util;

import static com.kd.easybarrage.BarrageTools.getScreenWidth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kd.easybarrage.AnimationHelper;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageTools;
import com.kd.easybarrage.BarrageView;
import com.kd.easybarrage.BorderTextView;
import com.wd.wd_healthy.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.util</p>
 * @author 赵某某
 * @date 2022/9/29
 */
public class BaseBar extends BarrageView {
    private Set<Integer> existMarginValues = new HashSet<>();
    private int linesCount;

    private int validHeightSpace;
    private int INTERVAL = 500;

    private Random random = new Random(System.currentTimeMillis());
    private int maxBarrageSize;
    private int maxTextSize;
    private int minTextSize;
    private int lineHeight;
    private int borderColor;
    private boolean random_color;
    private boolean allow_repeat;
    private final int DEFAULT_BARRAGESIZE = 5;
    private final int DEFAULT_MAXTEXTSIZE = 20;
    private final int DEFAULT_MINTEXTSIZE = 14;
    private final int DEFAULT_LINEHEIGHT = 16;
    private final int DEFAULT_BORDERCOLOR = 0xff000000;
    private final boolean DEFAULT_RANDOMCOLOR = false;
    private final boolean DEFAULT_ALLOWREPEAT = false;

    private List<Barrage> barrages = new ArrayList<>();
    private List<Barrage> cache = new ArrayList<>();

    public BaseBar(Context context) {
        this(context, null);
    }

    public BaseBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BarrageView, 0, 0);
        try {
            maxBarrageSize = typedArray.getInt(R.styleable.BarrageView_size, DEFAULT_BARRAGESIZE);
            maxTextSize = typedArray.getInt(R.styleable.BarrageView_max_text_size, DEFAULT_MAXTEXTSIZE);
            minTextSize = typedArray.getInt(R.styleable.BarrageView_min_text_size, DEFAULT_MINTEXTSIZE);
            lineHeight = typedArray.getDimensionPixelSize(R.styleable.BarrageView_line_height, BarrageTools.dp2px(context, DEFAULT_LINEHEIGHT));
            borderColor = typedArray.getColor(R.styleable.BarrageView_border_color, DEFAULT_BORDERCOLOR);
            random_color = typedArray.getBoolean(R.styleable.BarrageView_random_color, DEFAULT_RANDOMCOLOR);
            allow_repeat = typedArray.getBoolean(R.styleable.BarrageView_allow_repeat, DEFAULT_ALLOWREPEAT);
        } finally {
            typedArray.recycle();
        }
    }

    public void setBarrages(List<Barrage> list) {
        if (!list.isEmpty()) {
            barrages.clear();
            barrages.addAll(list);
            mHandler.sendEmptyMessageDelayed(0, INTERVAL);
        }
    }

    public void addBarrage(Barrage tb) {
        barrages.add(tb);
        if (!mHandler.hasMessages(0)) {
            mHandler.sendEmptyMessageDelayed(0, INTERVAL);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            checkBarrage();
            sendEmptyMessageDelayed(0, INTERVAL);
        }
    };

    public void checkBarrage() {
        int index = (int) (Math.random() * barrages.size());
        Barrage barrage = barrages.get(index);
        if (allow_repeat) {
            if (cache.contains(barrage))
                return;
            cache.add(barrage);
        }
        showBarrage(barrage);
    }

    private void showBarrage(final Barrage tb) {
        if (linesCount != 0 && getChildCount() >= linesCount)
            return;
        if (getChildCount() > maxBarrageSize)
            return;
        final TextView textView = tb.isShowBorder() ? new BorderTextView(getContext(), borderColor) : new TextView(getContext());
        textView.setTextSize((int) (minTextSize + (maxTextSize - minTextSize) * Math.random()));
        textView.setText(tb.getContent());
        textView.setTextColor(random_color ? Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)) : getResources().getColor(tb.getColor()));
        int leftMargin = getRight() - getLeft() - getPaddingLeft();
        int verticalMargin = getRandomTopMargin();
        textView.setTag(verticalMargin);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.topMargin = verticalMargin;
        textView.setLayoutParams(params);
        Animation anim = AnimationHelper.createTranslateAnim(getContext(), leftMargin, -getScreenWidth(getContext()));
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (allow_repeat)
                    cache.remove(tb);
                removeView(textView);
                int verticalMargin = (int) textView.getTag();
                existMarginValues.remove(verticalMargin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        textView.startAnimation(anim);
        addView(textView);
    }

    private int getRandomTopMargin() {
        if (validHeightSpace == 0) {
            validHeightSpace = getBottom() - getTop() - getPaddingTop() - getPaddingBottom();
        }
        if (linesCount == 0) {
            linesCount = validHeightSpace / lineHeight;
            if (linesCount == 0) {
                throw new RuntimeException("Not enough space to show text.");
            }
        }
        while (true) {
            int randomIndex = (int) (Math.random() * linesCount);
            int marginValue = randomIndex * (validHeightSpace / linesCount);
            if (!existMarginValues.contains(marginValue)) {
                existMarginValues.add(marginValue);
                return marginValue;
            }
        }
    }

    public void destroy() {
        if (mHandler.hasMessages(0))
            mHandler.removeMessages(0);
        barrages.clear();
        cache.clear();
    }
}
