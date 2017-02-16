package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	
	private HanoiPeg[] pegs;


	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	public ArrayBasedHanoiBoard(int n) {
		if(n < 0) throw new IllegalArgumentException("Can't make HanoiBoard with negative rings");
		
		pegs = new StackBasedHanoiPeg[3];
		for(int i = 0; i < pegs.length; i ++)
			pegs[i] = new StackBasedHanoiPeg();
		
		for(int i = 0; i < n; i ++){
			pegs[0].addRing(new HanoiRing(n-i));
		}
	}

	public HanoiPeg[] getPegs(){
		return pegs;
	}
	
	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if(!isLegalMove(move)) throw new IllegalHanoiMoveException("Attempt to make illegal move.");
		
		HanoiRing movedRing = pegs[move.getFromPeg()].remove();
		pegs[move.getToPeg()].addRing(movedRing);
	}

	@Override
	public boolean isSolved() {
        return !pegs[0].hasRings() && !pegs[1].hasRings();
	}

	/**
	 * <p>
	 * A {@link HanoiMove} is not legal if either is true:
	 * 
	 * <ul>
	 * <li>The from peg has no rings</li>
	 * <li>The to peg has rings AND the ring to be moved has a size larger than
	 * the topmost ring on the to peg.</li>
	 * </ul>
	 * 
	 * Otherwise, the move is legal.
	 * </p>
	 */
	@Override
	public boolean isLegalMove(HanoiMove move) {
        if(move == null) throw new NullPointerException("Testing legality of null move");
        
        if(!pegs[move.getFromPeg()].hasRings()) return false;
        if(move.getFromPeg() == move.getToPeg()) return false;
		if(pegs[move.getToPeg()].hasRings() && pegs[move.getFromPeg()].getTopRing().getSize() > pegs[move.getToPeg()].getTopRing().getSize()) return false;
		
		return true;
        
        
	}
}
