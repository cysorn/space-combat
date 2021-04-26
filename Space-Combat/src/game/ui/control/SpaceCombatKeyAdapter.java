package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.StarshipAction;
import game.logic.player.Player;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	Player player;
	
	public SpaceCombatKeyAdapter(Player player)
	{
		this.player = player;
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
        	player.starship.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
        	player.starship.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
        	player.starship.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
        	player.starship.moveTo(Direction.UP, action);
        }
    }
}
