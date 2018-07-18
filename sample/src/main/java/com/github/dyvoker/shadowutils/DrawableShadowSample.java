package com.github.dyvoker.shadowutils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;

import com.github.dyvoker.shadow_lib.CanvasWithShadow;
import com.github.dyvoker.shadow_lib.ShadowUtils;

/**
 * Drawable for testing shadows.
 * Simply draw some primitives on canvas and add shadow by mask.
 */
public class DrawableShadowSample extends Drawable {

	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public DrawableShadowSample() {
		paint.setColor(Color.WHITE);
	}

	@Override
	public void draw(@NonNull Canvas canvas) {
		CanvasWithShadow shadow = new CanvasWithShadow(canvas);
		Canvas tempCanvas = shadow.getCanvas();

		// Draw primitives.
		float centerX = tempCanvas.getWidth() / 2;
		float centerY = tempCanvas.getHeight() / 2;
		float radius = Math.min(centerX, centerY) - 50.0f;
		tempCanvas.drawCircle(centerX, centerY, radius, paint);
		tempCanvas.drawRect(centerX, centerY, centerX + radius, centerY + radius, paint);

		// Draw shadow.
		shadow.draw(canvas, 0x80000000, 3, 2, 2);
	}

	@Override
	public void setAlpha(int alpha) {
		paint.setAlpha(alpha);
	}

	@Override
	public void setColorFilter(@Nullable ColorFilter colorFilter) {
		paint.setColorFilter(colorFilter);
	}

	@Override
	public int getOpacity() {
		return PixelFormat.OPAQUE;
	}
}
