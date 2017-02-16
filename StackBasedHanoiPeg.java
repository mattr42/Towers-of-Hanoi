package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 * 
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	StackInterface<HanoiRing> rings;
	
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		rings = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(!rings.isEmpty() && rings.peek().getSize() <= ring.getSize()) throw new IllegalHanoiMoveException("Attempt to place larger or equal ring on top of smaller ring.");
		
		if(ring == null) throw new NullPointerException("Attempt to add ring with null value.");
		
		rings.push(ring);

	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
        if(rings.isEmpty()) throw new IllegalHanoiMoveException("Attempt to remove ring from empty peg.");
        
        return rings.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
        if(rings.isEmpty()) throw new IllegalHanoiMoveException("Attempt to get top ring of empty peg.");
	
		return rings.peek();
	}

	@Override
	public boolean hasRings() {
        return !rings.isEmpty();
	}
}
