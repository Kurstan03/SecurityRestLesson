package peaksoft.dto.converting;

/**
 * @author kurstan
 * @created at 13.03.2023 15:58
 */
public interface Convert <TO, FROM>{
    TO convert(FROM from);
}
