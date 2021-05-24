package game.objects.combat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.objects.player.laser.LaserLogic;
import game.objects.player.starship.logic.StarshipLogic;

public class CombatLogic {
	public StarshipLogic starshipLogic;
	public List<LaserLogic> laserLogic;
	
	public CombatLogic(int windowWidth, int windowHeight) throws IOException
	{
		starshipLogic = new StarshipLogic(windowWidth, windowHeight);
		laserLogic = new ArrayList<>();
	}
}