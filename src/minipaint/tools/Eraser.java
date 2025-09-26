package minipaint.tools;

import java.awt.*;
import minipaint.MouseCursor;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Eraser extends Tool {
    public Eraser() {
        this.strokeSize = 18f;
        this.color = Color.WHITE;
        try {
            this.cursorIcon = ImageIO.read(new File("assets/eraser_icon.png"));
        } catch (IOException e) {
            System.out.println("Error setting Erasor tool icon: " + e.getMessage());
        }
    }

    /**
     * Draws a single point with the default color of the canvas (white) when the
     * mouse is pressed.
     * 
     * @param g2     The graphics context to draw on.
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
     * Draws a final line segment with the default color of the canvas (white) when
     * the mouse is released.
     * 
     * @param g2     The graphics context to draw on.
     * @param cursor The state of the mouse cursor.
     */
    @Override
    public void onMouseReleased(Graphics2D g2, MouseCursor cursor) {
        g2.setColor(this.getColor());
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(cursor.getLastX(), cursor.getLastY(), cursor.getCurX(), cursor.getCurY());
    }

    /**
     * Draws a line segment with the default color of the canvas (white) from the
     * last position to the current position while dragging.
     * 
     * @param g2     The graphics context to draw on.
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
