package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import snake.commun.enums.DirectionSnake;

public class Serpent2d extends Object2dFx {

	private static final double VITESSE = 150;

	public Serpent2d() {
		super();
		setWidth(20);
		setHeight(20);
	}

	@Override
	public void onAddedToWorld() {
		setTopLeftX(getWorldWidth() / 2);
		setTopLeftY(getWorldHeight() / 2);
		setSpeedX(VITESSE);
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (getTopLeftX() + getWidth() <= 0) {
			setTopLeftX(getWorldWidth());
		}
		if (getTopLeftX() >= getWorldWidth()) {
			setTopLeftX(0);
		}
		if (getTopLeftY() + getHeight() <= 0) {
			setTopLeftY(getWorldHeight());
		}
		if (getTopLeftY() >= getWorldHeight()) {
			setTopLeftY(0);
		}
	}

	public void changerDirection(DirectionSnake direction) {
		if (direction == DirectionSnake.HAUT) {
			setSpeedX(0);
			setSpeedY(-VITESSE);
		} else if (direction == DirectionSnake.BAS) {
			setSpeedX(0);
			setSpeedY(VITESSE);
		} else if (direction == DirectionSnake.GAUCHE) {
			setSpeedX(-VITESSE);
			setSpeedY(0);
		} else if (direction == DirectionSnake.DROITE) {
			setSpeedX(VITESSE);
			setSpeedY(0);
		}
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.setFill(Color.web("#4ade80"));
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
	}
}
