package minipaint;

import javax.swing.*;
import java.awt.*;
import minipaint.tools.*;

/**
 * The main application window for the MiniPaint application.
 * <p>
 * This class extends {@link JFrame} and sets up the user interface for the application including the toolbar for selecting tools and the canvas for drawing.
 */
public class MiniPaint extends JFrame {
    private final Tool selectionTool = new Selection();
    private final Tool brushTool = new Brush();
    private final Tool eraserTool = new Eraser();

    /**
     * Constructs the MiniPaint application window and initializes all its components.
     */
    public MiniPaint() {
        setTitle("Mini Paint — Good Design");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        CanvasPanel canvas = new CanvasPanel();

        JPanel tools = new JPanel();
        JButton selection = new JButton("Selection");
        JButton brush = new JButton("Brush");
        JButton eraser = new JButton("Eraser");

        selection.addActionListener(e -> canvas.setCurrentTool(selectionTool));
        brush.addActionListener(e -> canvas.setCurrentTool(brushTool));
        eraser.addActionListener(e -> canvas.setCurrentTool(eraserTool));

        tools.add(selection);
        tools.add(brush);
        tools.add(eraser);

        add(tools, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    /**
     * The main entry point for the MiniPaint application.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniPaint().setVisible(true));
    }      
}
