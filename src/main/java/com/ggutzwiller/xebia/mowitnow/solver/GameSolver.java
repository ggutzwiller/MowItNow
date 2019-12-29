package com.ggutzwiller.xebia.mowitnow.solver;

import com.ggutzwiller.xebia.mowitnow.model.*;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
@AllArgsConstructor
public class GameSolver {
    private Game game;

    /**
     * Solve the "game" by moving mowers according the instructions and game rules
     */
    public void solve() {
        List<Mower> mowers = game.getMowers();

        for (Mower mower : mowers) {
            for (Instruction instruction : mower.getInstructions()) {
                if (this.isAuthorizedInstruction(mower, instruction)) {
                    this.playInstructionOnMower(mower, instruction);
                }
            }
        }
    }

    private boolean isAuthorizedInstruction(Mower mower, Instruction instruction) {
        if (instruction == Instruction.MOVE_FORWARD) {
            Position currentPosition = mower.getPosition();
            Orientation currentOrientation = mower.getOrientation();

            Position potentialNextPosition = new Position(
                    currentPosition.getX() + currentOrientation.x,
                    currentPosition.getY() + currentOrientation.y
            );

            return !outsideLawn(potentialNextPosition) && !alreadyTakenByMower(potentialNextPosition);
        }
        return true;
    }

    private boolean alreadyTakenByMower(Position potentialNextPosition) {
        return !game.getMowers()
                .stream()
                .noneMatch(m -> m.getPosition().getX() == potentialNextPosition.getX() &&
                        m.getPosition().getY() == potentialNextPosition.getY());
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
                mower.moveForward();
                break;
        }
    }
}
