package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.World2dFx;
import snake.commun.enums.DirectionSnake;

public class MondeSnake2d extends World2dFx {

    private Serpent2d serpent = new Serpent2d();

    public MondeSnake2d() {
        super();

        addObject2d("terrain", 1, new Terrain2dSnake());
        addObject2d("serpent", 2, serpent);
    }

    @Override
    protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
    }

    public void changerDirection(DirectionSnake direction) {
        serpent.changerDirection(direction);
    }
}
