package threads.pingpong;

import javafx.scene.shape.Rectangle;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;
    int limitX = 300;
    int limitY = 300;
    int velX;
    int velY;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
        this.velX = 5;
        this.velY = 5;
    }

    @Override
    public void run() {
        while (true) {
            if (this.rect.getX() >= limitX) {
                this.rect.setX(295);
                this.velX *= -1;
            }
            if (this.rect.getX() <= 0) {
                this.rect.setX(5);
                this.velX *= -1;
            }
            this.rect.setX(this.rect.getX() + velX);
            if (this.rect.getY() >= limitY) {
                this.rect.setY(295);
                this.velY *= -1;
            }
            if (this.rect.getY() <= 0) {
                this.rect.setY(5);
                this.velY *= -1;
            }
            this.rect.setY(this.rect.getY() + velY);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
