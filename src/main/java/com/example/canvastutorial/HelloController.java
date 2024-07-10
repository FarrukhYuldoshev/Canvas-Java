package com.example.canvastutorial;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML Canvas canvas;
    double lastX = -1;
    double lastY = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill((Color.MEDIUMBLUE));
        gc.setLineCap(StrokeLineCap.SQUARE);
        canvas.setOnMousePressed(event -> {
            System.out.println(lastX);
            if(lastX!=-1&&lastY!=-1)
            {
                double x=event.getX();
                double y=event.getY();
                System.out.println(x);
                    double masofa=Math.sqrt(Math.pow((lastX-x),2)+Math.pow((lastY-y),2));
                    if(masofa>=4.0)
                    {
                        int rate=(int)masofa/4;
                        double addtoX=Math.abs(x-lastX)/(double) rate;
                        double addtoY=Math.abs(y-lastY)/(double)rate;
                        for(int i=0; i<rate; i++)
                        {
                            if(lastX>x) lastX-=addtoX;
                            else lastX+=addtoX;
                            if(lastY>y) lastY-=addtoY;
                            else lastY+=addtoY;
                            gc.fillOval(lastX, lastY, 2.0, 2.0);
                        }
                    }
            }
            lastX = event.getX();
            lastY = event.getY();
            gc.fillOval(lastX, lastY, 2.5, 2.5);
        });

        canvas.setOnMouseDragged(event -> {
            if (lastX != -1 && lastY != -1) {
                double currentX = event.getX();
                double currentY = event.getY();

                if(Math.abs(lastX-currentX)>=4.0||Math.abs(lastY-currentY)>=4.0) {
                    gc.fillOval(currentX, currentY, 2, 2);
                    lastX = currentX;
                    lastY = currentY;
                }
            }
        });
    }
}