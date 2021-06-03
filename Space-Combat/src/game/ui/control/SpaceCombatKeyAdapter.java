package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.StarshipAction;
import game.objects.player.starship.logic.StarshipLogic;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private StarshipLogic starshipLogic;
	
	public SpaceCombatKeyAdapter(StarshipLogic starshipLogic)
	{
		this.starshipLogic = starshipLogic;
	}
	@Override
    public void keyReleased(KeyEvent e) {
		checkKeyInputs(e, StarshipAction.HANG);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    	checkKeyInputs(e, StarshipAction.FLY);
    }
    
    private void checkKeyInputs(KeyEvent e, StarshipAction action)
    {
    	if(e.getKeyCode() == Key.D.getKeyCode())
        {
    		starshipLogic.starshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
    		starshipLogic.starshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
    		starshipLogic.starshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
    		starshipLogic.starshipMove.moveTo(Direction.UP, action);
        }
    	if(e.getKeyCode() == Key.E.getKeyCode()
    	&& starshipLogic.freezeStarship == false)
    	{
    		starshipLogic.healthBarLogic.objectStats.kill();
    	}
    }
}
