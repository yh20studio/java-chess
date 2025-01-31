package chess.domain.state;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.Team;
import chess.domain.score.ScoreResult;

public final class Ready implements State {

	private static final String GAME_START_ERROR = "게임 시작을 먼저 해야 합니다.";

	@Override
	public State start(Board board) {
		return new WhiteTurn(board);
	}

	@Override
	public State move(final Position source, final Position target) {
		throw new IllegalStateException(GAME_START_ERROR);
	}

	@Override
	public ScoreResult createStatus() {
		throw new IllegalStateException(GAME_START_ERROR);
	}

	@Override
	public State finish() {
		throw new IllegalStateException(GAME_START_ERROR);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public Team judgeWinner() {
		throw new IllegalStateException(GAME_START_ERROR);
	}

	@Override
	public Board getBoard() {
		throw new IllegalStateException(GAME_START_ERROR);
	}
}
