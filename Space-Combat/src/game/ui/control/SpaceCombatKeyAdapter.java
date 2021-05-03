package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.StarshipAction;
import game.sprites.player_sprites.PlayerSprites;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private PlayerSprites player;
	
	public SpaceCombatKeyAdapter(PlayerSprites player)
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
        	player.starship.starshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
        	player.starship.starshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
        	player.starship.starshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
        	player.starship.starshipMove.moveTo(Direction.UP, action);
        }
    }
}
