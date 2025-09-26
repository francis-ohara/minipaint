package minipaint.tools;

import java.awt.Graphics;
import minipaint.MouseCursor;

/**
 * An interface for all tools that can draw a temporary "live preview" on the
 * canvas.
 * <p>
 * This is useful for showing feedback to the user during a mouse dragging
 * operation, without permanently altering the main drawing layer.
 */
public interface LivePreview {
    /**
     * Draws a temporary preview of the tool's effect onto the canvas.
     * 
     * @param g The {@link Graphics} context to draw the preview on.
     * @param cursor The current state of the mouse.
     */
    public void drawPreview(Graphics g, MouseCursor cursor);
}