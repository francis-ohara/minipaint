package minipaint.tools;

import java.awt.*;
import minipaint.MouseCursor;

/**
 * The Brush tool used for free-form drawing on the canvas.
 */
public class Brush extends Tool {
    /**
     * Constructs a new Brush tool with default stroke size and color.
     */
    public Brush() {
        this.strokeSize = 8f;
        this.color = Color.BLACK;
    }

    /**
     * Draws a single point when the mouse is pressed.
     * 
     * @param g2 The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    @Override
    public void onMousePressed(Graphics2D g2, MouseCursor cursor) {
        g2.setColor(this.getColor());
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        g2.drawLine(cursor.getLastX(), cursor.getLastY(), cursor.getLastX(), cursor.getLastY());
    }

    /**
     * Draws the final line segment when the mouse is released.
     * 
     * @param g2 The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    @Override
    public void onMouseReleased(Graphics2D g2, MouseCursor cursor) {
        g2.setColor(this.getColor());
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        g2.drawLine(cursor.getLastX(), cursor.getLastY(), cursor.getCurX(), cursor.getCurY());
    }

    /**
     * Draws a line segment from the last position to the current position while dragging.
     * 
     * @param g2 The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    @Override
    public void onMouseDragged(Graphics2D g2, MouseCursor cursor) {
        g2.setColor(this.getColor());
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(cursor.getLastX(), cursor.getLastY(), cursor.getCurX(), cursor.getCurY());
        cursor.setLastX(cursor.getCurX());
        cursor.setLastY(cursor.getCurY());
    }

}
