package peaksoft.dto.request;

/**
 * @author kurstan
 * @created at 13.03.2023 15:50
 */
public record BookRequest(
        String name,
        String author,
        int price
) {
}
