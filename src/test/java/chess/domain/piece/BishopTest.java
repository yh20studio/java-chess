package chess.domain.piece;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import chess.domain.board.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BishopTest {
	
	@ParameterizedTest
	@CsvSource(value = {"8, 8", "3, 5", "3, 3", "5, 3"})
	void validateMovement(int targetRow, int targetCol) {
		Position source = Position.of(4, 4);
		Piece sourceBishop = new Bishop(Team.BLACK);
		Position target = Position.of(targetRow, targetCol);
		Piece targetBishop = new Bishop(Team.WHITE);

		assertDoesNotThrow(() -> sourceBishop.validateMovement(source, target, targetBishop));
	}

	@Test
	void validateDirectionException() {
		Position source = Position.of(1, 1);
		Piece bishop = new Bishop(Team.BLACK);
		Position target = Position.of(1, 2);
		Piece blank = new Blank();

		assertThatThrownBy(() -> bishop.validateMovement(source, target, blank))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("해당 기물이 움직일 수 있는 위치가 아닙니다.");
	}

	@Test
	void validateCatchAllyException() {
		Position source = Position.of(4, 4);
		Piece sourceBishop = new Bishop(Team.BLACK);
		Position target = Position.of(3, 5);
		Piece targetBishop = new Bishop(Team.BLACK);

		assertThatThrownBy(() -> sourceBishop.validateMovement(source, target, targetBishop))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("같은 팀의 기물을 잡을 수 없습니다.");
	}
}
