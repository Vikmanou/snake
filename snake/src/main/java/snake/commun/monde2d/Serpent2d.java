package snake.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import snake.commun.enums.DirectionSnake;
import snake.frontal.utils.MathUtils;

public class Serpent2d extends Object2dFx {

	public static final double TAILLE_SERPENT = 20;

	private static final double VITESSE = 135.0;

	private int longueur = 25;
	private DirectionSnake direction = DirectionSnake.DROITE;

	private double angleTete = 0;
	private Image teteSnake = new Image(getClass().getResourceAsStream("/images/snake.png"));

	private List<double[]> positionHistory = new ArrayList<>();
	private static final Color COULEUR_QUEUE = Color.web("#85a32a");

	public Serpent2d() {
		super();
		setWidth(TAILLE_SERPENT);
		setHeight(TAILLE_SERPENT);
	}

	@Override
	public void onAddedToWorld() {
		setTopLeftX(getWorldWidth() / 4);
		setTopLeftY(getWorldHeight() / 2);

		positionHistory.clear();
		positionHistory.add(new double[] { getTopLeftX(), getTopLeftY() });

		changerDirection(direction);
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

		enregistrerPosition();
	}

	private void enregistrerPosition() {
		double currentX = getTopLeftX();
		double currentY = getTopLeftY();

		if (!positionHistory.isEmpty()) {
			double[] derniere = positionHistory.get(0);

			double distance = MathUtils.distance(currentX, currentY, derniere[0], derniere[1]);

			if (distance < 1.0)
				return;
		}

		positionHistory.add(0, new double[] { currentX, currentY });

		double distanceMax = longueur * TAILLE_SERPENT + TAILLE_SERPENT;
		double distanceCumulee = 0;
		int indexMax = 0;

		for (int i = 1; i < positionHistory.size(); i++) {
			double[] pos1 = positionHistory.get(i - 1);
			double[] pos2 = positionHistory.get(i);

			distanceCumulee += MathUtils.distance(pos1[0], pos1[1], pos2[0], pos2[1]);
			indexMax = i;

			if (distanceCumulee >= distanceMax) {
				break;
			}
		}

		while (positionHistory.size() > indexMax + 1) {
			positionHistory.remove(positionHistory.size() - 1);
		}
	}

	private double[] trouverPositionQueue(double distanceDeLaTete) {
		double distanceParcourue = 0;

		for (int i = 1; i < positionHistory.size(); i++) {
			double[] pos1 = positionHistory.get(i - 1);
			double[] pos2 = positionHistory.get(i);

			double distanceX = pos2[0] - pos1[0];
			double distanceY = pos2[1] - pos1[1];

			double distanceSegment = MathUtils.distance(pos1[0], pos1[1], pos2[0], pos2[1]);

			if (distanceParcourue + distanceSegment >= distanceDeLaTete) {
				double ratio = (distanceDeLaTete - distanceParcourue) / distanceSegment;
				return new double[] { pos1[0] + ratio * distanceX, pos1[1] + ratio * distanceY };
			}

			distanceParcourue += distanceSegment;
		}

		if (!positionHistory.isEmpty()) {
			double[] derniere = positionHistory.get(positionHistory.size() - 1);
			return new double[] { derniere[0], derniere[1] };
		}

		return new double[] { getTopLeftX(), getTopLeftY() };
	}

	public void changerDirection(DirectionSnake direction) {
		DirectionSnake ancienneDirection = this.direction;

		boolean snapX = false;
		boolean snapY = false;

		double ajoutX = 0;
		double ajoutY = 0;

		if (direction == DirectionSnake.HAUT) {
			setSpeedX(0);
			setSpeedY(-VITESSE);
			angleTete = 180;

			if (ancienneDirection == DirectionSnake.GAUCHE || ancienneDirection == DirectionSnake.DROITE) {
				snapX = true;
			}
		} else if (direction == DirectionSnake.BAS) {
			setSpeedX(0);
			setSpeedY(VITESSE);
			angleTete = 0;

			if (ancienneDirection == DirectionSnake.GAUCHE || ancienneDirection == DirectionSnake.DROITE) {
				snapX = true;
			}
		} else if (direction == DirectionSnake.GAUCHE) {
			setSpeedX(-VITESSE);
			setSpeedY(0);
			angleTete = 90;

			if (ancienneDirection == DirectionSnake.HAUT || ancienneDirection == DirectionSnake.BAS) {
				snapY = true;
			}
		} else if (direction == DirectionSnake.DROITE) {
			setSpeedX(VITESSE);
			setSpeedY(0);
			angleTete = -90;

			if (ancienneDirection == DirectionSnake.HAUT || ancienneDirection == DirectionSnake.BAS) {
				snapY = true;
			}
		}

		if (snapX) {
			double newX = MathUtils.snap(getTopLeftX(), TAILLE_SERPENT);
			setTopLeftX(newX);
		}

		if (snapY) {
			double newY = MathUtils.snap(getTopLeftY(), TAILLE_SERPENT);
			setTopLeftY(newY);
		}

		this.direction = direction;
	}

	public void augmenterLongueur() {
		longueur++;
	}

	public int getLongueur() {
		return longueur;
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		// dessiner la queue
		for (int i = longueur - 1; i >= 1; i--) {
			double distance = i * TAILLE_SERPENT;
			double[] pos = trouverPositionQueue(distance);

			double taille = TAILLE_SERPENT * 1;
			double offset = (TAILLE_SERPENT - taille) / 2;

			gc.setFill(COULEUR_QUEUE);

			if (i == longueur - 1) {
				gc.fillOval(pos[0] + offset, pos[1] + offset, taille, taille);
			} else {
				gc.fillRoundRect(pos[0] + offset, pos[1] + offset, taille, taille, 0, 0);
			}
		}

		// dessiner la tete
		gc.save();
		gc.translate(getTopLeftX() + getWidth() / 2, getTopLeftY() + getHeight() / 2);
		gc.rotate(angleTete);
		gc.drawImage(teteSnake, -getWidth() / 2, -getHeight() / 2, getWidth(), getHeight());
		gc.restore();
	}
}
