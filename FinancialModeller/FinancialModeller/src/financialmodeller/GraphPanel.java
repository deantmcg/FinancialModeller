package financialmodeller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author B00732293
 */
public class GraphPanel extends JPanel {

    private ArrayList<Transaction> transactions;
    double[] allBalances;
    int[] graphPoints;

    int topMargin = 80;
    int bottomMargin = 80;
    int leftMargin = 100;
    int rightMargin = 80;

    int yGrade = 200;
    int yGradeInPixels;

    int drawWidth;
    int xSpacing;
    int drawHeight;
    int ySpacing;

    double highestValue;
    double lowestValue;
    double absoluteNegative;
    double valuePerPixel;
    int positiveHeight;
    int negativeHeight;

    Font titleFont = new Font("Tahoma", Font.BOLD, 18);
    Font graphFont = new Font("Tahoma", Font.BOLD, 14); //Change of Font

    public GraphPanel(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setAllBalances();
        calculations();        
        calculateGraphPoints();

        drawBackground(g2);

        drawAxis(g2);
        drawNegativeAxis(g2);

        drawYPositiveMarks(g2);
        drawYNegativeMarks(g2);

        drawXMarks(g2);
        drawGraphPoints(g2);
        drawGraphLines(g2);
        

        g2.setFont(titleFont);
        drawTitle(g2);
        g2.setFont(graphFont);
        drawYLabel(g2);
        drawXLabel(g2);

    }

    public void setAllBalances() {
        allBalances = new double[transactions.size() + 1];

        //calculate start balance
        double startBalance = calculateStartBalance();
        allBalances[0] = startBalance;

        for (int i = 1; i < allBalances.length; i++) {
            allBalances[i] = transactions.get(i - 1).getBalanceAfter();

        }

    }
    
    public int setYGrade() {
        return (int) highestValue/10;
    }

    public double calculateStartBalance() {
        double firstAmount = transactions.get(0).getAmount();
        double firstBalanceAfter = transactions.get(0).getBalanceAfter();
        if (transactions.get(0).getType() == TransactionType.Deposit) {
            return firstBalanceAfter - firstAmount;
        } else {
            return firstBalanceAfter + firstAmount;
        }
    }

    public void calculations() {
        drawWidth = getWidth() - (leftMargin + rightMargin);
        xSpacing = drawWidth / transactions.size();
        drawHeight = getHeight() - (bottomMargin + topMargin);
        ySpacing = calculateYSpacing();
        highestValue = setHighestValue();
        lowestValue = setLowestValue();
        absoluteNegative = setAbsoluteNegative();
        valuePerPixel = setValuePerPixel();        
        positiveHeight = setPositiveHeight();
        negativeHeight = setNegativeHeight();
        yGrade = setYGrade();
        yGradeInPixels = setYGradeInPixels();

    }

    public void drawTitle(Graphics2D g2) {
        int x = leftMargin + drawWidth / 2 - 180;
        int y = topMargin / 2;
        g2.drawString("Graph of balance over time in number of months", x, y);
    }

    public void drawXLabel(Graphics2D g2) {
        //x = half drawWidth-whatever
        //y = half marin of draw height

        int drawX = leftMargin + drawWidth / 2 - 30;
        int drawY = topMargin + drawHeight + 50;

        g2.drawString("Number of Months", drawX, drawY);

    }

    public void drawYLabel(Graphics2D g2) {

        int drawX = leftMargin - 60;
        int drawY = topMargin + drawHeight / 2;

        //TD ROTATE TEXT 
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        //Font yFont = new Font("Tahoma", Font.BOLD, 14);
        Font rotatedFont = graphFont.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString("Balance £", leftMargin / 2 - 20, topMargin + drawHeight / 2 + 15);
        //affineTransform.rotate(Math.toRadians(90), 0, 0);
        g2.setFont(graphFont);

    }

    public double setHighestValue() {
        double highestValueSoFar = allBalances[0];
        for (int i = 0; i < allBalances.length; i++) {
            if (allBalances[i] > highestValueSoFar) {
                highestValueSoFar = allBalances[i];
            }
        }
        return highestValueSoFar;

    }

    public double setLowestValue() {
        double lowestValueSoFar = allBalances[0];
        for (int i = 0; i < allBalances.length; i++) {
            if (allBalances[i] < lowestValueSoFar) {
                lowestValueSoFar = allBalances[i];
            }
        }
        return lowestValueSoFar;

    }

    public double setAbsoluteNegative() {
        if (lowestValue < 0) {
            return (-1 * lowestValue);
        } else {
            return 0;
        }

    }

    public double setValuePerPixel() {
        return (highestValue + absoluteNegative) / drawHeight;
    }

    public int setPositiveHeight() {
        return (int) (highestValue / valuePerPixel);

    }

    public int setNegativeHeight() {
        if (absoluteNegative > 0) {
            return (int) (absoluteNegative / valuePerPixel);
        } else {
            return 0;
        }

    }

    public int setYGradeInPixels() {
        return (int) (yGrade / valuePerPixel);
    }

    //RENDERING
    public void drawBackground(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLACK);
    }

    public void drawAxis(Graphics2D g2) {
        g2.drawLine(leftMargin, getHeight() - bottomMargin, getWidth() - rightMargin, getHeight() - bottomMargin);
        g2.drawLine(leftMargin, topMargin, leftMargin, getHeight() - bottomMargin);
    }

    public void drawNegativeAxis(Graphics2D g2) {
        int x0 = leftMargin;
        int y0 = topMargin + drawHeight - negativeHeight;
        int x1 = leftMargin + drawWidth;
        int y1 = topMargin + drawHeight - negativeHeight;

        g2.drawLine(x0, y0, x1, y1);
    }

    public int calculateYSpacing() {
        return ySpacing = (int) (yGrade / valuePerPixel);
    }

    public void drawYPositiveMarks(Graphics2D g2) {
        int num = 0;
        int x0 = leftMargin - 10;
        int x1 = leftMargin;

        for (int i = (topMargin + drawHeight - negativeHeight); i >= topMargin; i = i - yGradeInPixels) {

            int y = i;

            g2.drawLine(x0, y, x1, y);
            g2.drawString(Integer.toString(num), leftMargin - 60, y);
            num = num + yGrade;
        }
    }

    public void drawYNegativeMarks(Graphics2D g2) {
        int num = 0;
        int x0 = leftMargin - 10;
        int x1 = leftMargin;

        for (int i = (topMargin + drawHeight - negativeHeight); i <= (topMargin + drawHeight); i = i + yGradeInPixels) {

            int y = i;

            g2.drawLine(leftMargin, y, leftMargin - 10, y);
            g2.drawString(Integer.toString(num), leftMargin - 60, y);

            num = num - yGrade;
        }
    }

    public void drawXMarks(Graphics2D g2) {
        //Drawing xScale demarcation
        for (int i = 0; i < graphPoints.length; i++) {
            g2.drawLine(leftMargin + i * xSpacing, getHeight() - bottomMargin, leftMargin + i * xSpacing, getHeight() - bottomMargin + 10);
            g2.drawString(Integer.toString(i), leftMargin + i * xSpacing, getHeight() - bottomMargin + 30);
        }
    }

    public void calculateGraphPoints() {
        graphPoints = new int[allBalances.length];
        for (int i = 0; i < allBalances.length; i++) {
            int yHeight = (int) (allBalances[i] / valuePerPixel);
            graphPoints[i] = topMargin + drawHeight - negativeHeight - yHeight;
            //if height is negative it will add to the pixels (down), if positive, will take away(up)
        }
    }

    public void drawGraphPoints(Graphics2D g2) {
        int circleDiameter = 12;
        g2.setColor(Color.RED);
        for (int i = 0; i < graphPoints.length; i++) {
            int xPixels = leftMargin + (i * xSpacing);
            int yPixels = graphPoints[i];
            g2.fillOval(xPixels - circleDiameter / 2, yPixels - circleDiameter / 2, circleDiameter, circleDiameter);
        }
        g2.setColor(Color.BLACK);
    }

    public void drawGraphLines(Graphics2D g2) {
        for (int i = 0; i < graphPoints.length; i++) {

            int next = i + 1;

            if (next < graphPoints.length) {
                int x0 = leftMargin + i * xSpacing;
                int y0 = graphPoints[i];
                int x1 = leftMargin + (next * xSpacing);
                int y1 = graphPoints[next];

                Stroke lineStroke = new BasicStroke(2f);
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(lineStroke);
                
                g2.drawLine(x0, y0, x1, y1);
                g2.setStroke(oldStroke);
            }

        }
    }

}

