package game.field.logic.combat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.field.logic.FieldLogic;
import game.objects.player.laser.LaserLogic;

public class CombatLogic {
	
	public List<LaserLogic> laserLogic;
	public FieldLogic fieldLogic;
	
	public CombatLogic(int winWidth, int winHeight) throws IOException
	{
		fieldLogic = new FieldLogic(winWidth, winHeight);
		laserLogic = new ArrayList<>();
	}
}