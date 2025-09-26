package minipaint.tools;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import minipaint.MouseCursor;

/**
 * A tool for drawing a dashed rectangular selection area.
 * <p>
 * This tool provides a live preview of the selection rectangle while the user
 * is dragging the mouse. The final rectangle is drawn on the canvas when the
 * mouse is released.
 */
public class Selection extends Tool implements LivePreview {
    /**
     * Constructs a new Selection tool with default stroke size and color.
     */
    public Selection() {
        this.strokeSize = 1.5f;
        this.color = Color.BLACK;
        try {
            this.cursorIcon = ImageIO.read(new File("assets/selection_icon.png"));
        } catch (IOException e) {
            System.out.println("Error setting Selection tool icon: " + e.getMessage());
        }
    }

    /**
     * This action is intentionally left empty for the Selection tool.
     */
    @Override
    public void onMousePressed(Graphics2D g2, MouseCursor cursor) {
    }

    /**
     * This action is intentionally left empty for the Selection tool.
     */
    @Override
    public void onMouseDragged(Graphics2D g2, MouseCursor cursor) {
    }

    /**
     * Draws the final dashed selection rectangle onto the buffered image layer.
     */
    @Override
    public void onMouseReleased(Graphics2D g2, MouseCursor cursor) {
        g2.setColor(this.getColor());
        float[] dash = { 6f, 6f };
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10f, dash, 0f));
        g2.drawRect(Math.min(cursor.getStartX(), cursor.getCurX()), Math.min(cursor.getStartY(), cursor.getCurY()),
                Math.abs(cursor.getCurX() - cursor.getStartX()), Math.abs(cursor.getCurY() - cursor.getStartY()));
    }

    /**
     * Draws a temporary dashed rectangle for previewing the selection border while
     * dragging the mouse.
     */
    public void drawPreview(Graphics g, MouseCursor cursor) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = Math.min(cursor.getStartX(), cursor.getCurX());
        int y = Math.min(cursor.getStartY(), cursor.getCurY());
        int w = Math.abs(cursor.getCurX() - cursor.getStartX());
        int h = Math.abs(cursor.getCurY() - cursor.getStartY());
        float[] dash = { 6f, 6f };
        g2.setColor(this.getColor());
        g2.setStroke(new BasicStroke(this.getStrokeSize(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f,
                dash, 0f));
        g2.drawRect(x, y, w, h);
        g2.dispose();
    }
}
