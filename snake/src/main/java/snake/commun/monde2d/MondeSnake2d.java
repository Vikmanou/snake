package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.World2dFx;
import snake.commun.enums.DirectionSnake;

public class MondeSnake2d extends World2dFx {

	private Serpent2d serpent = new Serpent2d();
	private Fruit2d fruit = new Fruit2d();

	public MondeSnake2d() {
		super();

		addObject2d("terrain", 1, new Terrain2dSnake());
		addObject2d("fruit", 2, fruit);
		addObject2d("serpent", 3, serpent);

		fruit.respawn(serpent);
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (fruit.estMange(serpent)) {
			serpent.augmenterLongueur();
			fruit.respawn(serpent);
		}
	}

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
	}

	public void changerDirection(DirectionSnake direction) {
		serpent.changerDirection(direction);
	}
}
