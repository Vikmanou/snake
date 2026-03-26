package snake.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import snake.commun.enums.DirectionSnake;
import snake.frontal.utils.MathUtils;

public class Serpent2d extends Object2dFx {

	private static final double TAILLE_SERPENT = Terrain2dSnake.TAILLE_CASE;

	private static final double VITESSE = 135.0;

	private int longueur = 3;
	private DirectionSnake direction = DirectionSnake.DROITE;

	private double angleTete = 0;
	private Image teteSnake = new Image(getClass().getResourceAsStream("/images/snake.png"));

	private List<double[]> positionHistory = new ArrayList<>();
	private static final Color COULEUR_CORPS = Color.web("#4AAD1E");

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

	public void changerDirection(DirectionSnake direction) {
		DirectionSnake ancienneDirection = this.direction;

		boolean snapX = false;
		boolean snapY = false;

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
			double newX = Terrain2dSnake.caseAPosition(getTopLeftX());
			setTopLeftX(newX);

			while (!positionHistory.isEmpty()) {
				double[] pos = positionHistory.get(0);
				boolean overshoot = (ancienneDirection == DirectionSnake.DROITE && pos[0] > newX)
						|| (ancienneDirection == DirectionSnake.GAUCHE && pos[0] < newX);
				if (overshoot) {
					positionHistory.remove(0);
				} else {
					break;
				}
			}
			positionHistory.add(0, new double[] { newX, getTopLeftY() });
		}

		if (snapY) {
			double newY = Terrain2dSnake.caseAPosition(getTopLeftY());
			setTopLeftY(newY);

			while (!positionHistory.isEmpty()) {
				double[] pos = positionHistory.get(0);
				boolean overshoot = (ancienneDirection == DirectionSnake.HAUT && pos[1] < newY)
						|| (ancienneDirection == DirectionSnake.BAS && pos[1] > newY);
				if (overshoot) {
					positionHistory.remove(0);
				} else {
					break;
				}
			}

			positionHistory.add(0, new double[] { getTopLeftX(), newY });
		}

		this.direction = direction;
	}

	public void augmenterLongueur() {
		longueur++;
	}

	public int getLongueur() {
		return longueur;
	}

	public boolean occupeCase(double cellX, double cellY) {
		double distanceMax = (longueur - 1) * TAILLE_SERPENT;
		double distanceParcourue = 0;
		double[] prevPos = new double[] { getTopLeftX(), getTopLeftY() };

		if (Terrain2dSnake.caseAPosition(prevPos[0]) == cellX && Terrain2dSnake.caseAPosition(prevPos[1]) == cellY) {
			return true;
		}

		for (double[] pos : positionHistory) {
			double distance = MathUtils.distance(prevPos[0], prevPos[1], pos[0], pos[1]);

			if (Terrain2dSnake.caseAPosition(pos[0]) == cellX && Terrain2dSnake.caseAPosition(pos[1]) == cellY) {
				return true;
			}

			distanceParcourue += distance;
			if (distanceParcourue >= distanceMax) {
				break;
			}
			prevPos = pos;
		}

		return false;
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	private static final double RAYON_SERPENT = TAILLE_SERPENT / 2.0;

	private void dessinerCorpsSerpent(GraphicsContext gc) {
		double distanceMax = (longueur - 1) * TAILLE_SERPENT;

		gc.setStroke(COULEUR_CORPS);
		gc.setLineWidth(TAILLE_SERPENT);
		gc.setLineCap(StrokeLineCap.ROUND);
		gc.setLineJoin(StrokeLineJoin.ROUND);

		gc.beginPath();
		gc.moveTo(getTopLeftX() + RAYON_SERPENT, getTopLeftY() + RAYON_SERPENT);

		double distanceParcourue = 0;
		double[] prevPos = new double[] { getTopLeftX(), getTopLeftY() };

		for (int i = 0; i < positionHistory.size(); i++) {
			double[] pos = positionHistory.get(i);
			double distance = MathUtils.distance(prevPos[0], prevPos[1], pos[0], pos[1]);

			if (distanceParcourue + distance >= distanceMax) {
				// Utiliser le ratio pour dessiner un segment partiel à la fin du corps
				double ratio = distance > 0 ? (distanceMax - distanceParcourue) / distance : 0;
				gc.lineTo(prevPos[0] + ratio * (pos[0] - prevPos[0]) + RAYON_SERPENT,
						prevPos[1] + ratio * (pos[1] - prevPos[1]) + RAYON_SERPENT);
				break;
			}

			// Dessiner une ligne jusqu'à la position actuelle
			gc.lineTo(pos[0] + RAYON_SERPENT, pos[1] + RAYON_SERPENT);
			distanceParcourue += distance;
			prevPos = pos;
		}

		gc.stroke();
	}

	private void dessinerTeteSerpent(GraphicsContext gc) {
		gc.save();
		gc.translate(getTopLeftX() + getWidth() / 2, getTopLeftY() + getHeight() / 2);
		gc.rotate(angleTete);
		gc.drawImage(teteSnake, -getWidth() / 2, -getHeight() / 2, getWidth(), getHeight());
		gc.restore();
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		dessinerCorpsSerpent(gc);
		dessinerTeteSerpent(gc);
	}
}
