package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import snake.commun.enums.DirectionSnake;

public class Serpent2d extends Object2dFx {

	private static final double VITESSE = 150;
	private int longueur = 1;

	private double angleTete = 0;
	private Image teteSnake = new Image(getClass().getResourceAsStream("/images/snake.png"));

	public Serpent2d() {
		super();
		setWidth(20);
		setHeight(20);
	}

	@Override
	public void onAddedToWorld() {
		setTopLeftX(getWorldWidth() / 2);
		setTopLeftY(getWorldHeight() / 2);
		setSpeedY(VITESSE);
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (getTopLeftX() <= 0) {
			setTopLeftX(0);
		}

		if (getTopLeftY() <= 0) {
			setTopLeftY(0);
		}

		if (getTopLeftX() + getWidth() >= getWorldWidth()) {
			setTopLeftX(getWorldWidth() - getWidth());
		}

		if (getTopLeftY() + getHeight() >= getWorldHeight()) {
			setTopLeftY(getWorldHeight() - getHeight());
		}
	}

	public void changerDirection(DirectionSnake direction) {
		if (direction == DirectionSnake.HAUT) {
			setSpeedX(0);
			setSpeedY(-VITESSE);
			angleTete = 180;
		} else if (direction == DirectionSnake.BAS) {
			setSpeedX(0);
			setSpeedY(VITESSE);
			angleTete = 0;
		} else if (direction == DirectionSnake.GAUCHE) {
			setSpeedX(-VITESSE);
			setSpeedY(0);
			angleTete = 90;
		} else if (direction == DirectionSnake.DROITE) {
			setSpeedX(VITESSE);
			setSpeedY(0);
			angleTete = -90;
		}
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		gc.translate(getTopLeftX() + getWidth() / 2, getTopLeftY() + getHeight() / 2);
		gc.rotate(angleTete);
		gc.drawImage(teteSnake, -getWidth() / 2, -getHeight() / 2, getWidth(), getHeight());
		gc.restore();
	}
}
