package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain2dSnake extends Object2dFx {

    public Terrain2dSnake() {
        super();
        setTopLeftX(0);
        setTopLeftY(0);
    }

    @Override
    public void onAddedToWorld() {
        setWidth(getWorldWidth());
        setHeight(getWorldHeight());
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
        gc.setFill(Color.web("#1a2b1a"));
        gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }
}
