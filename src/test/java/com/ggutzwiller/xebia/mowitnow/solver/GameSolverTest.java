package com.ggutzwiller.xebia.mowitnow.solver;

import com.ggutzwiller.xebia.mowitnow.model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
@Test
public class GameSolverTest {
    private Lawn squareLawn;
    private Lawn rectangleLawn;
    private Mower bottomLeftMower;
    private Mower middleMower;
    private List<Instruction> easyInstructions;
    private List<Instruction> complexInstructions;

    @BeforeMethod
    public void setUp() {
        this.squareLawn = new Lawn(5, 5);
        this.rectangleLawn = new Lawn(3, 7);

        this.bottomLeftMower = new Mower(
                new Position(0, 0),
                Orientation.NORTH
        );
        this.middleMower = new Mower(
                new Position(1,2),
                Orientation.SOUTH
        );

        this.easyInstructions = List.of(
                Instruction.MOVE_FORWARD,
                Instruction.TURN_LEFT,
                Instruction.MOVE_FORWARD
        );

        this.complexInstructions = List.of(
                Instruction.MOVE_FORWARD,
                Instruction.TURN_RIGHT,
                Instruction.MOVE_FORWARD,
                Instruction.TURN_RIGHT,
                Instruction.MOVE_FORWARD,
                Instruction.TURN_LEFT,
                Instruction.MOVE_FORWARD,
                Instruction.TURN_LEFT,
                Instruction.MOVE_FORWARD
        );
    }

    @Test
    public void solve_easyProblem_shouldSolveWithoutError() {
        Game game = new Game();
        game.setLawn(squareLawn);
        middleMower.setInstructions(easyInstructions);
        game.setMowers(List.of(middleMower));

        GameSolver solver = new GameSolver(game);
        solver.solve();

        Assert.assertEquals(middleMower.getOrientation(), Orientation.EAST);
        Assert.assertEquals(middleMower.getPosition().getX(), 2);
        Assert.assertEquals(middleMower.getPosition().getY(), 1);
    }

    @Test
    public void solve_outsideGrid_shouldSolveWithoutError() {
        Game game = new Game();
        game.setLawn(squareLawn);
        bottomLeftMower.setInstructions(easyInstructions);
        game.setMowers(List.of(bottomLeftMower));

        GameSolver solver = new GameSolver(game);
        solver.solve();

        Assert.assertEquals(bottomLeftMower.getOrientation(), Orientation.WEST);
        Assert.assertEquals(bottomLeftMower.getPosition().getX(), 0);
        Assert.assertEquals(bottomLeftMower.getPosition().getY(), 1);
    }

    @Test
    public void solve_crash_shouldSolveWithoutError() {
        Game game = new Game();
        game.setLawn(rectangleLawn);
        bottomLeftMower.setInstructions(complexInstructions);
        middleMower.setInstructions(easyInstructions);
        game.setMowers(List.of(bottomLeftMower, middleMower));

        GameSolver solver = new GameSolver(game);
        solver.solve();

        Assert.assertEquals(game.getMowers().size(), 2);

        Assert.assertEquals(bottomLeftMower.getOrientation(), Orientation.NORTH);
        Assert.assertEquals(bottomLeftMower.getPosition().getX(), 2);
        Assert.assertEquals(bottomLeftMower.getPosition().getY(), 1);

        Assert.assertEquals(middleMower.getOrientation(), Orientation.EAST);
        Assert.assertEquals(middleMower.getPosition().getX(), 1);
        Assert.assertEquals(middleMower.getPosition().getY(), 1);
    }

}
