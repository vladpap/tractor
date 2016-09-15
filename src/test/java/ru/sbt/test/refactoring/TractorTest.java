package ru.sbt.test.refactoring;

import junit.framework.TestCase;

import static ru.sbt.test.refactoring.TypeMoving.FORWARD;
import static ru.sbt.test.refactoring.TypeMoving.TURNCLOCKWISE;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

	public void testShouldMoveForward(){
		Tractor tractor = new Tractor();
		tractor.move(FORWARD);
		assertEquals(0, tractor.getPositionX());
		assertEquals(1, tractor.getPositionY());
	}

	public void testShouldTurn(){
		Tractor tractor = new Tractor();
		tractor.move(TURNCLOCKWISE);
		assertEquals(Orientation.EAST, tractor.getOrientation());
		tractor.move(TURNCLOCKWISE);
		assertEquals(Orientation.SOUTH, tractor.getOrientation());
		tractor.move(TURNCLOCKWISE);
		assertEquals(Orientation.WEST, tractor.getOrientation());
		tractor.move(TURNCLOCKWISE);
		assertEquals(Orientation.NORTH, tractor.getOrientation());
	}

	public void testShouldTurnAndMoveInTheRightDirection(){
		Tractor tractor = new Tractor();
		tractor.move(TURNCLOCKWISE);
		tractor.move(FORWARD);
		assertEquals(1, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());
		tractor.move(TURNCLOCKWISE);
		tractor.move(FORWARD);
		assertEquals(1, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move(TURNCLOCKWISE);
		tractor.move(FORWARD);
		assertEquals(0, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move(TURNCLOCKWISE);
		tractor.move(FORWARD);
		assertEquals(0, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());		
	}
	
	public void testShouldThrowExceptionIfFallsOffPlateau(){
		Tractor tractor = new Tractor();
		tractor.move(FORWARD);
		tractor.move(FORWARD);
		tractor.move(FORWARD);
		tractor.move(FORWARD);
		tractor.move(FORWARD);
		try{
			tractor.move(FORWARD);
			fail("Tractor was expected to fall off the plateau");
		}catch(TractorInDitchException expected){
		}
	}
}
