package peaksoft.dto.response;

/**
 * @author kurstan
 * @created at 13.03.2023 15:53
 */
public record BookResponse(
        Long id,
        String name,
        String author,
        int price,
        boolean isActive
) {
}
