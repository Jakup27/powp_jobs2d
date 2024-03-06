package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;


public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver{
    private int startX = 0, startY = 0;
    private DrawPanelController drawer;
    private int lineType;

    /**
     * @param drawer
     * @param lineType
     */
    public LineDrawerAdapter(DrawPanelController drawer, int lineType) {
        super();
        this.drawer = drawer;
        this.lineType = lineType;
    }

    /**
     * @param x new position on the X axis.
     * @param y new position on the Y axis.
     */
    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    /**
     * @param x end of the line in X axis.
     * @param y end of the line in Y axis.
     */
    @Override
    public void operateTo(int x, int y) {
        ILine line;
        if (lineType == 2) {
            line = LineFactory.getDottedLine();
        } else {
            line = LineFactory.getSpecialLine();
        }
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        startX = x;
        startY = y;

        drawer.drawLine(line);
    }

    /**
     * @return some string
     */
    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}