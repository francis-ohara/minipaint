package minipaint.tools;

import java.awt.*;
import minipaint.MouseCursor;

/**
 * Abstract parent class for all drawing tools in the MiniPaint application.
 */
public abstract class Tool {
    /** The size of the strokes drawn by the tool. */
    protected float strokeSize;
    /** The color used by the tool for drawing. */
    protected Color color;

    /**
     * Sets the stroke size for the tool.
     * 
     * @param strokeSize The new stroke size.
     */
    public void setStrokeSize(float strokeSize) {
        this.strokeSize = strokeSize;
    }

    /**
     * Gets the current stroke size of the tool.
     * 
     * @return The current stroke size.
     */
    public float getStrokeSize() {
        return this.strokeSize;
    }

    /**
     * Sets the color for the tool.
     * 
     * @param color The new color to be used for drawing.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the current color of the tool.
     * 
     * @return The current color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Handles the mouse pressed event.
     * @param g2 The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    public abstract void onMousePressed(Graphics2D g2, MouseCursor cursor);

    /**
     * Handles the mouse released event.
     * @param g2 The graphics context to draw on.
     * @param cursor the state of the mouse cursor.
     */
    public abstract void onMouseReleased(Graphics2D g2, MouseCursor cursor);

    /**
     * Handles the mouse dragged event.
     * @param g2 The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    public abstract void onMouseDragged(Graphics2D g2, MouseCursor cursor);
}