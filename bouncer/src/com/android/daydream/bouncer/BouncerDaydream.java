/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.daydream.bouncer;

import android.graphics.Color;
import android.service.dreams.DreamService;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class BouncerDaydream extends DreamService {
    public String message = "Bummer!";
    public int color = Color.WHITE;
    public float size = 20.0f;

    private Bouncer mBouncer;

    @Override
    public void onDreamingStarted() {
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(300, 300);

        mBouncer = new Bouncer(this);
        mBouncer.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
        mBouncer.setSpeed(200);
        
        for (int i=0; i<5; i++) {
            final ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.android);
            image.setBackgroundColor(0xFF004000);
            mBouncer.addView(image, lp);
        }

//        final TextView tv = new TextView(this);
//        tv.setTextSize(20.0f);
//        tv.setTextColor(Color.WHITE);
//        mBouncer.addView(tv, new FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
//        mBouncer.setDebugView(tv);
        setContentView(mBouncer);
    }

}
