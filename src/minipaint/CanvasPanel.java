package minipaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import minipaint.tools.*;

/**
 * The main drawing area for the MiniPaint application.
 * <p>
 * This is a {@link JPanel} that facilitates the drawing in the application by
 * handling mouse input, maintaining a {@link BufferedImage} which is used as
 * the drawing surface.
 * It delegates the actual drawing logic to the currently selected {@link Tool}.
 */
class CanvasPanel extends JPanel {
    /** The currently selected tool. */
    private Tool currentTool = new Selection();
    /**
     * The buffered image acting as a surface where all permanent drawings are made.
     */
    private BufferedImage layer;
    /** The object that tracks the position and state of the mouse cursor. */
    private MouseCursor cursor = new MouseCursor();

    /**
     * Constructs a new CanvasPanel.
     * Initializes the background color, sets up a component listener to handle
     * resizing the canvas and several mouse listeners to handle drawing based on
     * mouse input.
     */
    public CanvasPanel() {
        setBackground(Color.WHITE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ensureLayer();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ensureLayer();
                cursor.setStartX(e.getX());
                cursor.setStartY(e.getY());
                cursor.setLastX(cursor.getStartX());
                cursor.setLastY(cursor.getStartY());
                cursor.setCurX(cursor.getStartX());
                cursor.setCurY(cursor.getStartY());
                cursor.setDragging(true);
                Graphics2D g2 = layer.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                currentTool.onMousePressed(g2, cursor);
                g2.dispose();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                cursor.setCurX(e.getX());
                cursor.setCurY(e.getY());
                cursor.setDragging(false);
                Graphics2D g2 = layer.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                currentTool.onMouseReleased(g2, cursor);
                g2.dispose();
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                cursor.setCurX(e.getX());
                cursor.setCurY(e.getY());
                Graphics2D g2 = layer.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                currentTool.onMouseDragged(g2, cursor);
                g2.dispose();
                cursor.setLastX(cursor.getCurX());
                cursor.setLastY(cursor.getCurY());
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                cursor.setCurX(e.getX());
                cursor.setCurY(e.getY());
                repaint();
            }
        });
    }

    /**
     * Sets the current drawing tool.
     * 
     * @param tool The new {@link Tool} to use for drawing.
     */
    public void setCurrentTool(Tool tool) {
        this.currentTool = tool;
    }

    /**
     * Ensures that the {@link BufferedImage} drawing layer exists and matches the
     * panel's size.
     * It makes sure that if the panel is resized, a new larger buffer matching the
     * panel's size is created and copies the contents of the old buffer to the
     * new larger buffer.
     */
    private void ensureLayer() {
        int w = Math.max(1, getWidth());
        int h = Math.max(1, getHeight());
        if (layer == null || layer.getWidth() != w || layer.getHeight() != h) {
            BufferedImage newLayer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = newLayer.createGraphics();
            if (layer != null) {
                g2.drawImage(layer, 0, 0, null);
            } else {
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, w, h);
            }
            g2.dispose();
            layer = newLayer;
        }
    }

    /**
     * Draws the canvas content.
     * <p>
     * This method first draws the permanent {@link BufferedImage} layer, and if the
     * user is draggin the mouse with a tool that supports live previews (such as
     * the Selection tool) it draws the preview on top.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ensureLayer();
        g.drawImage(layer, 0, 0, null);
        currentTool.renderIcon(g, cursor);

        if (cursor.getDragging() && currentTool instanceof LivePreview) {
            ((LivePreview) currentTool).drawPreview(g, cursor);
        }
    }
}