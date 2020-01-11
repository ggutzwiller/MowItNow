package com.ggutzwiller.xebia.mowitnow.solver;

import com.ggutzwiller.xebia.mowitnow.model.Game;
import com.ggutzwiller.xebia.mowitnow.model.Instruction;
import com.ggutzwiller.xebia.mowitnow.model.Mower;
import com.ggutzwiller.xebia.mowitnow.model.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
public class GameSolver {
    private Game game;
    private Map<Position, Boolean> unavailablePositions;

    public GameSolver(Game game) {
        this.game = game;

        this.unavailablePositions = new HashMap<>();
        this.game.getMowers().forEach(m -> unavailablePositions.put(m.getPosition(), true));
    }

    /**
     * Solve the "game" by moving mowers according the instructions and game rules
     */
    public void solve() {
        List<Mower> mowers = game.getMowers();

        for (Mower mower : mowers) {
            this.unavailablePositions.put(mower.getPosition(), false);
            for (Instruction instruction : mower.getInstructions()) {
                this.playInstructionOnMower(mower, instruction);
            }
            this.unavailablePositions.put(mower.getPosition(), true);
        }
    }

    private boolean isPositionAvailable(Position nextPosition) {
        return !outsideLawn(nextPosition) && !alreadyTakenByMower(nextPosition);
    }

    private boolean alreadyTakenByMower(Position potentialNextPosition) {
        return unavailablePositions.containsKey(potentialNextPosition) && unavailablePositions.get(potentialNextPosition);
    }

    private boolean outsideLawn(Position potentialNextPosition) {
        return potentialNextPosition.getX() < 0 || potentialNextPosition.getX() >= game.getLawn().getWidth()
                || potentialNextPosition.getY() < 0 || potentialNextPosition.getY() >= game.getLawn().getHeight();
    }

    private void playInstructionOnMower(Mower mower, Instruction instruction) {
        switch (instruction) {
            case TURN_RIGHT:
                mower.turnRight();
                break;
            case TURN_LEFT:
                mower.turnLeft();
                break;
            case MOVE_FORWARD:
            default:
                Position nextPosition = mower.getNextPosition();
                if (isPositionAvailable(nextPosition)) {
                    mower.moveToPosition(nextPosition);
                }
                break;
        }
    }
}
