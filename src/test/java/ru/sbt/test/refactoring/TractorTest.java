package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.command.MoveForward;
import ru.sbt.test.refactoring.command.TurnClockwise;
import ru.sbt.test.refactoring.position.Orientation;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

	public void testShouldMoveForward(){
		Tractor tractor = new Tractor();
		tractor.move(new MoveForward());
		assertEquals(0, tractor.getPositionX());
		assertEquals(1, tractor.getPositionY());
	}

	public void testShouldTurn(){
		Tractor tractor = new Tractor();
		TurnClockwise turnClockwise = new TurnClockwise();
		tractor.move(turnClockwise);
		assertEquals(Orientation.EAST, tractor.getOrientation());
		tractor.move(turnClockwise);
		assertEquals(Orientation.SOUTH, tractor.getOrientation());
		tractor.move(turnClockwise);
		assertEquals(Orientation.WEST, tractor.getOrientation());
		tractor.move(turnClockwise);
		assertEquals(Orientation.NORTH, tractor.getOrientation());
	}

	public void testShouldTurnAndMoveInTheRightDirection(){
		Tractor tractor = new Tractor();
		TurnClockwise turnClockwise = new TurnClockwise();
		MoveForward moveForward = new MoveForward();
		tractor.move(turnClockwise);
		tractor.move(moveForward);
		assertEquals(1, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());
		tractor.move(turnClockwise);
		tractor.move(moveForward);
		assertEquals(1, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move(turnClockwise);
		tractor.move(moveForward);
		assertEquals(0, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move(turnClockwise);
		tractor.move(moveForward);
		assertEquals(0, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());		
	}
	
	public void testShouldThrowExceptionIfFallsOffPlateau(){
		Tractor tractor = new Tractor();
		MoveForward moveForward = new MoveForward();
		tractor.move(moveForward);
		tractor.move(moveForward);
		tractor.move(moveForward);
		tractor.move(moveForward);
		tractor.move(moveForward);
		try{
			tractor.move(moveForward);
			fail("Tractor was expected to fall off the plateau");
		}catch(TractorInDitchException expected){
		}
	}
}
