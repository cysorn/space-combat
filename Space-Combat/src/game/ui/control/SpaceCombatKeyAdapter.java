package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.SpaceshipAction;
import game.objects.spaceship.logic.SpaceshipLogic;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private SpaceshipLogic spaceshipLogic;
	
	public SpaceCombatKeyAdapter(SpaceshipLogic spaceshipLogic)
	{
		this.spaceshipLogic = spaceshipLogic;
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
    		spaceshipLogic.spaceshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
    		spaceshipLogic.spaceshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
    		spaceshipLogic.spaceshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
    		spaceshipLogic.spaceshipMove.moveTo(Direction.UP, action);
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
    	if(e.getKeyCode() == Key.SPACE.getKeyCode() && spaceshipLogic.spaceshipExplosion.animationPlays() == false)
    	{
    		spaceshipLogic.spaceshipShoot.shoot = action;
    	}
    }
}
