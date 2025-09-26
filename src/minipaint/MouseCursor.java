package minipaint;

/**
 * A data class that encapsulates the state of the mouse cursor on the canvas.
 * <p>
 * This includes its starting, last, and current coordinates, as well as
 * whether the mouse is currently being dragged. It provides methods to update
 * its state in response to mouse events.
 */
public class MouseCursor {
    /** The coordinates where the mouse was first pressed. */
    private int startX, startY;
    /** The coordinates of the mouse from the previous event. */
    private int lastX, lastY;
    /** The current coordinates of the mouse.  */
    private int curX, curY;
    /** A flag indicating if the mouse is currently being dragged. */
    private boolean dragging;
    
    /**
     * Gets the starting X coordinate of the mouse press.
     * @return The starting X coordinate.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Sets the starting X coordinate of the mouse press.
     * @param startX The new starting X coordinate.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Gets the starting Y coordinate of the mouse press.
     * @return The starting Y coordinate.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Sets the starting Y coordinate of the mouse press.
     * @param startY The new starting Y coordinate.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Gets the last known X coordinate of the mouse.
     * @return The last X coordinate.
     */
    public int getLastX() {
        return lastX;
    }

    /**
     * Sets the last known X coordinate of the mouse.
     * @param lastX The new last X coordinate.
     */
    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    /**
     * Gets the last known Y coordinate of the mouse.
     * @return The last Y coordinate.
     */
    public int getLastY() {
        return lastY;
    }

    /**
     * Sets the last known Y coordinate of the mouse.
     * @param lastY The new last Y coordinate.
     */
    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    /**
     * Gets the current X coordinate of the mouse.
     * @return The current X coordinate.
     */
    public int getCurX() {
        return curX;
    }

    /**
     * Sets the current X coordinate of the mouse.
     * @param curX The new current X coordinate.
     */
    public void setCurX(int curX) {
        this.curX = curX;
    }

    /**
     * Gets the current Y coordinate of the mouse.
     * @return The current Y coordinate.
     */
    public int getCurY() {
        return curY;
    }

    /**
     * Sets the current Y coordinate of the mouse.
     * @param curY The new current Y coordinate.
     */
    public void setCurY(int curY) {
        this.curY = curY;
    }

    /**
     * Checks if the mouse is currently being dragged.
     * @return {@code true} if the mouse is being dragged, {@code false} otherwise.
     */
    public boolean getDragging(){
        return this.dragging;
    }

    /**
     * Sets the dragging state of the mouse.
     * @param dragging The new dragging state.
     */
    public void setDragging(boolean dragging){
        this.dragging = dragging;
    }
}
