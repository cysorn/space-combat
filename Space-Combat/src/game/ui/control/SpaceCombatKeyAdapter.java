package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.StarshipAction;
import game.sprites.player_sprites.PlayerSprites;
import game.sprites.player_sprites.starship.StarshipMove;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private StarshipMove starshipMove;
	
	public SpaceCombatKeyAdapter(StarshipMove starshipMove)
	{
		this.starshipMove = starshipMove;
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
        	starshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
        	starshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
        	starshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
        	starshipMove.moveTo(Direction.UP, action);
        }
    }
}
