package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.SpaceshipAction;
import game.objects.player.spaceship.logic.SpaceshipLogic;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private SpaceshipLogic starshipLogic;
	
	public SpaceCombatKeyAdapter(SpaceshipLogic starshipLogic)
	{
		this.starshipLogic = starshipLogic;
	}
	@Override
    public void keyReleased(KeyEvent e) {
		checkKeyInputs(e, SpaceshipAction.STOP);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    	checkKeyInputs(e, SpaceshipAction.START);
    }
    
    private void checkKeyInputs(KeyEvent e, SpaceshipAction action)
    {
    	if(e.getKeyCode() == Key.D.getKeyCode())
        {
    		starshipLogic.spaceshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
    		starshipLogic.spaceshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
    		starshipLogic.spaceshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
    		starshipLogic.spaceshipMove.moveTo(Direction.UP, action);
        }
//    	if(e.getKeyCode() == Key.E.getKeyCode()
//    	&& starshipLogic.freezeStarship == false)
//    	{
//    		starshipLogic.healthBarLogic.objectStats.kill();
//    	}
//    	if(e.getKeyCode() == Key.F.getKeyCode()
//    	&& e.getID() == KeyEvent.KEY_RELEASED
//    	&& starshipLogic.freezeStarship == false)
//    	{
//    		starshipLogic.healthBarLogic.objectStats.decreaseHealthBy(20);
//    	}
    	if(e.getKeyCode() == Key.SPACE.getKeyCode())
    	{
    		starshipLogic.spaceshipShoot.shoot = action;
    	}
    }
}
