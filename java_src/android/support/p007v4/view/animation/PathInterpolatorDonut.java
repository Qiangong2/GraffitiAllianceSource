package android.support.p007v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.view.animation.PathInterpolatorDonut */
public class PathInterpolatorDonut implements Interpolator {
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private final float[] f152mX;

    /* renamed from: mY */
    private final float[] f153mY;

    public PathInterpolatorDonut(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float pathLength = pathMeasure.getLength();
        int numPoints = ((int) (pathLength / PRECISION)) + 1;
        this.f152mX = new float[numPoints];
        this.f153mY = new float[numPoints];
        float[] position = new float[2];
        for (int i = 0; i < numPoints; i++) {
            pathMeasure.getPosTan((((float) i) * pathLength) / ((float) (numPoints - 1)), position, null);
            this.f152mX[i] = position[0];
            this.f153mY[i] = position[1];
        }
    }

    public PathInterpolatorDonut(float controlX, float controlY) {
        this(createQuad(controlX, controlY));
    }

    public PathInterpolatorDonut(float controlX1, float controlY1, float controlX2, float controlY2) {
        this(createCubic(controlX1, controlY1, controlX2, controlY2));
    }

    public float getInterpolation(float t) {
        if (t <= 0.0f) {
            return 0.0f;
        }
        if (t >= 1.0f) {
            return 1.0f;
        }
        int startIndex = 0;
        int endIndex = this.f152mX.length - 1;
        while (endIndex - startIndex > 1) {
            int midIndex = (startIndex + endIndex) / 2;
            if (t < this.f152mX[midIndex]) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex;
            }
        }
        float xRange = this.f152mX[endIndex] - this.f152mX[startIndex];
        if (xRange == 0.0f) {
            return this.f153mY[startIndex];
        }
        float startY = this.f153mY[startIndex];
        return ((this.f153mY[endIndex] - startY) * ((t - this.f152mX[startIndex]) / xRange)) + startY;
    }

    private static Path createQuad(float controlX, float controlY) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(controlX, controlY, 1.0f, 1.0f);
        return path;
    }

    private static Path createCubic(float controlX1, float controlY1, float controlX2, float controlY2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(controlX1, controlY1, controlX2, controlY2, 1.0f, 1.0f);
        return path;
    }
}
