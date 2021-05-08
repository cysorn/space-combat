package game.ui.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Direction;
import game.StarshipAction;
import game.sprites.player_sprites.starship.Starship;

public class SpaceCombatKeyAdapter extends KeyAdapter {
	
	private Starship starship;
	
	public SpaceCombatKeyAdapter(Starship starship)
	{
		this.starship = starship;
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
    		starship.starshipMove.moveTo(Direction.RIGHT, action);
        }
    	if(e.getKeyCode() == Key.S.getKeyCode())
        {
    		starship.starshipMove.moveTo(Direction.DOWN, action);
        }
    	if(e.getKeyCode() == Key.A.getKeyCode())
        {
    		starship.starshipMove.moveTo(Direction.LEFT, action);
        }
    	if(e.getKeyCode() == Key.W.getKeyCode())
        {
    		starship.starshipMove.moveTo(Direction.UP, action);
        }
    	if(e.getKeyCode() == Key.SPACE.getKeyCode()
    	&& starship.freezeStarship == false)
    	{
    		starship.starshipExplosion.startExplosion();
    	}
    }
}
